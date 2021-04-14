package gd.rf.acro.ace.items;

import gd.rf.acro.ace.spells.ConjureFireSpell;
import gd.rf.acro.ace.spells.FireTrapSpell;
import gd.rf.acro.ace.spells.Spell;
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
    Spell store;
    public SpellScrollItem(Settings settings,Spell spell) {
        super(settings);
        store=spell;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        store.onTapBlock(context.getPlayer(),context.getBlockPos());

        return super.useOnBlock(context);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        store.onTouchCast(user,entity);
        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        store.snapCast(user);
        return super.use(world, user, hand);
    }
}
