package gd.rf.acro.ace.mixin;

import gd.rf.acro.ace.ACE;
import gd.rf.acro.ace.Utils;
import gd.rf.acro.ace.items.IRenderableCastingDevice;
import gd.rf.acro.ace.items.SimpleCastingItem;
import gd.rf.acro.ace.spells.Spell;
import gd.rf.acro.ace.spells.Spells;
import net.minecraft.client.font.FontManager;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.LiteralText;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.objectweb.asm.Opcodes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//https://github.com/gbl/WorldTime/blob/fabric_1_16/src/main/java/de/guntram/mcmod/worldtime/mixin/PotionEffectsMixin.java
@Mixin(InGameHud.class)
public abstract class SpellRendererMixin {
    @Shadow private int scaledHeight;

    @Shadow public abstract TextRenderer getFontRenderer();

    private MinecraftClient client;
    @Inject(method="render", at=@At(
            value="FIELD",
            target="Lnet/minecraft/client/options/GameOptions;debugEnabled:Z",
            opcode = Opcodes.GETFIELD, args = {"log=false"}))

    private void beforeRenderDebugScreen(MatrixStack stack, float f, CallbackInfo ci) {
        if(client==null)
        {
            client=MinecraftClient.getInstance();
        }
        if(client.player.getMainHandStack().getItem() instanceof IRenderableCastingDevice)
        {
            ItemStack stack1 = client.player.getMainHandStack();
            IRenderableCastingDevice spellBook = (IRenderableCastingDevice) stack1.getItem();
            if(spellBook.getEquipped(stack1)!=null)
            {
                client.textRenderer.drawWithShadow(stack, Utils.getSpellDisplay(spellBook.getEquipped(stack1)),10,scaledHeight-21, 0);
                client.textRenderer.drawWithShadow(stack,getManaString(stack1),10,scaledHeight-10,0);


            }


        }

    }


    private Text getManaString(ItemStack stack)
    {

        CompoundTag tag = stack.getTag();
        if( tag==null || !tag.contains("maxMana")) return new LiteralText("");
        int manaPerBar = tag.getInt("maxMana")/10;
        if(manaPerBar==0) return new LiteralText("");
        int mana = tag.getInt("mana");
        LiteralText text = new LiteralText("Mana:");
        for (int i = 0; i < mana/manaPerBar; i++) {
            text.append("█");
        }
        text.setStyle(Style.EMPTY.withColor(Formatting.AQUA));
        return text;
    }

}
