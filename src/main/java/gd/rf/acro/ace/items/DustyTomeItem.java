package gd.rf.acro.ace.items;

import gd.rf.acro.ace.Utils;
import gd.rf.acro.ace.spells.Spell;
import gd.rf.acro.ace.spells.Spells;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
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
        if (!stack.hasTag()) {
            CompoundTag tag = new CompoundTag();
            tag.putString("spell", Spells.REGISTRY.get(RandomUtils.nextInt(0, Spells.REGISTRY.size())).getClass().getSimpleName());
            stack.setTag(tag);
            stack.setCustomName(Utils.getSpellDisplay(Spells.getSpellBySimpleClassName(tag.getString("spell"))));

        }
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if(stack.hasTag())
        {
            //TODO: check this and maybe add a way of turning it off - or simply show this information by opening a screen
            Spell spell = Spells.getSpellBySimpleClassName(stack.getTag().getString("spell"));
            tooltip.add(new LiteralText("Casting Type: "+spell.spellType()));
            tooltip.add(new LiteralText("Element: "+spell.element()));
            tooltip.add(new LiteralText("Mana Cost:"+spell.cost()));
            tooltip.add(new LiteralText("Tier: "+spell.tier()));
            tooltip.add(new TranslatableText(Utils.getSpellTranslatable(spell)));
        }

    }
}
