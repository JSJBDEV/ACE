package gd.rf.acro.ace.mixin;

import gd.rf.acro.ace.Utils;
import gd.rf.acro.ace.items.IRenderableCastingDevice;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//https://github.com/gbl/WorldTime/blob/fabric_1_16/src/main/java/de/guntram/mcmod/worldtime/mixin/PotionEffectsMixin.java
@Mixin(InGameHud.class)
public abstract class SpellRendererMixin {
    @Inject(method="render", at=@At(
            value="FIELD",
            target="Lnet/minecraft/client/option/GameOptions;debugEnabled:Z",
            opcode = Opcodes.GETFIELD, args = {"log=false"}))
    private void beforeRenderDebugScreen(DrawContext context, float tickDelta, CallbackInfo ci) {
        final PlayerEntity player = MinecraftClient.getInstance().player;
        if(player.getMainHandStack().getItem() instanceof IRenderableCastingDevice) {
            ItemStack stack1 = player.getMainHandStack();
            IRenderableCastingDevice spellBook = (IRenderableCastingDevice) stack1.getItem();
            if(spellBook.getEquipped(stack1)!=null) {
                //TODO: Update
                //client.textRenderer.draw(stack, Utils.getSpellDisplay(spellBook.getEquipped(stack1)),10,scaledHeight-21, 0);
               //client.textRenderer.draw(stack,getManaString(stack1),10,scaledHeight-10,0);
            }
        }
    }


    private Text getManaString(ItemStack stack) {

        NbtCompound tag = stack.getNbt();
        if( tag==null || !tag.contains("maxMana")) return Text.empty();
        int manaPerBar = tag.getInt("maxMana")/10;
        if(manaPerBar==0) return Text.empty();
        int mana = tag.getInt("mana");
        MutableText text = (MutableText) Text.of("Mana:");
        for (int i = 0; i < mana/manaPerBar; i++) {
            text.append("█");
        }
        text.setStyle(Style.EMPTY.withColor(Formatting.AQUA));
        return text;
    }

}
