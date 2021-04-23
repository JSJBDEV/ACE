package gd.rf.acro.ace.items;

import gd.rf.acro.ace.Calendar;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
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
        if(MinecraftClient.getInstance().getCameraEntity()!=MinecraftClient.getInstance().player && !user.isSneaking())
        {
            MinecraftClient.getInstance().setCameraEntity(MinecraftClient.getInstance().player);
        }
        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(user.world.isClient  && user.isSneaking())
        {
            MinecraftClient.getInstance().setCameraEntity(entity);

        }
        return super.useOnEntity(stack, user, entity, hand);
    }
}
