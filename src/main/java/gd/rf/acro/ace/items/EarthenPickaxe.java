package gd.rf.acro.ace.items;

import gd.rf.acro.ace.Calendar;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class EarthenPickaxe extends PickaxeItem {

    //A conjurable Iron Pickaxe that lasts for 1 day.
    public EarthenPickaxe(int attackDamage, float attackSpeed, Settings settings) {
        super(ToolMaterials.IRON, attackDamage, attackSpeed, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if(!stack.hasNbt()) {
            stack.setNbt(new NbtCompound());
        }
        if(!stack.getNbt().contains("fleeting")) {
            stack.getNbt().putLong("fleeting",world.getLunarTime()+24000L);

        }
        if(world.getLunarTime()>=stack.getNbt().getLong("fleeting")) {
            stack.decrement(1);
        }
        if(world.getLunarTime()<(stack.getNbt().getLong("fleeting")-24000L)) {
            //this will occur if the time becomes less than its initial time:
            //e.g when /time set day is ran
            stack.decrement(1);
        }

    }


    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if(stack.hasNbt()) {
            tooltip.add(Text.of("Expires: Tomorrow "+ Calendar.getDayPeriod(stack.getNbt().getLong("fleeting"))));
        }
    }


}
