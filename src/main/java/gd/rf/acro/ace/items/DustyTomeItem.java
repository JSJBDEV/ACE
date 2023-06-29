package gd.rf.acro.ace.items;

import gd.rf.acro.ace.Utils;
import gd.rf.acro.ace.spells.SpellACE;
import gd.rf.acro.ace.spells.SpellsOld;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

public class DustyTomeItem extends Item {
    public DustyTomeItem(Settings settings) {
        super(settings);
    }



    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!stack.hasNbt()) {
            NbtCompound tag = new NbtCompound();
            tag.putString("spell", SpellsOld.REGISTRY.get(RandomUtils.nextInt(0, SpellsOld.REGISTRY.size())).getClass().getSimpleName());
            stack.setNbt(tag);

        }
        if(stack.hasNbt() && !stack.hasCustomName())
        {
            if(world.isClient)
            {
                stack.setCustomName(Utils.getSpellDisplay(SpellsOld.getSpellByName(stack.getNbt().getString("spell"))));
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if(stack.hasNbt())
        {
            //TODO: check this and maybe add a way of turning it off - or simply show this information by opening a screen
            SpellACE spell = SpellsOld.getSpellByName(stack.getNbt().getString("spell"));
            tooltip.add(Text.of("Casting Type: "+spell.getCastingType()));
            tooltip.add(Text.of("Element: "+spell.getElement()));
            tooltip.add(Text.of("Mana Cost: "+spell.getManaCost()));
            tooltip.add(Text.of("Tier: "+spell.getTier()));
            tooltip.add(Text.translatable(Utils.getSpellTranslatable(spell)));
        }
        else
        {
            tooltip.add(Text.of("A dusty spell book..."));
            tooltip.add(Text.of("What knowledge will it reveal?"));
        }

    }
}
