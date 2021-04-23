package gd.rf.acro.ace.mixin;

import gd.rf.acro.ace.ACE;
import gd.rf.acro.ace.items.IRenderableCastingDevice;
import gd.rf.acro.ace.items.SimpleCastingItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(PlayerInventory.class)
public abstract class PlayerInventoryMixin {
    @Shadow @Final public DefaultedList<ItemStack> main;

    @Shadow public int selectedSlot;

    @Shadow public abstract boolean insertStack(ItemStack stack);

    @Inject(at = @At("HEAD"), method = "scrollInHotbar", cancellable = true)
    private void scroll(double scrollAmount, CallbackInfo info) {
        if (scrollAmount > 0.0D) {
            scrollAmount = 1.0D;
        }

        if (scrollAmount < 0.0D) {
            scrollAmount = -1.0D;
        }
        if(this.main.get(this.selectedSlot).getItem() instanceof IRenderableCastingDevice)
        {
            PacketByteBuf packetByteBuf = PacketByteBufs.create();
            packetByteBuf.writeInt((int) scrollAmount);
            ClientPlayNetworking.send(ACE.SCROLL_PACKET,packetByteBuf);
            info.cancel();
        }
    }
}
