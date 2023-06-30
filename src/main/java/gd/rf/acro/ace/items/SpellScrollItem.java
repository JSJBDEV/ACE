package gd.rf.acro.ace.items;

import gd.rf.acro.ace.spells.SpellACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SpellScrollItem extends Item {
    SpellACE spell;
    public SpellScrollItem(Settings settings, SpellACE spell) {
        super(settings);
        this.spell =spell;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        spell.onTapBlock(context.getPlayer(),context.getBlockPos());

        return super.useOnBlock(context);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        spell.onTouchCast(user,entity);
        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        spell.snapCast(user);
        return super.use(world, user, hand);
    }
}
