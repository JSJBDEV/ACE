package gd.rf.acro.ace.items;

import gd.rf.acro.ace.Calendar;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TestItem extends Item {
    public TestItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.sendMessage(new LiteralText(Calendar.getDate(world.getLunarTime())),false);
        return super.use(world, user, hand);
    }
}
