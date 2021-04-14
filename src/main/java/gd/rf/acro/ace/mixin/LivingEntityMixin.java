package gd.rf.acro.ace.mixin;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

    @Shadow public abstract boolean removeStatusEffect(StatusEffect type);

    @Shadow public abstract void setHealth(float health);

    @Inject(method = "tryUseTotem(Lnet/minecraft/entity/damage/DamageSource;)Z", at = @At("HEAD"), cancellable = true)
    private void tryUseTotem(DamageSource source, CallbackInfoReturnable<Boolean> info) {


        if(this.hasStatusEffect(ACE.SECOND_CHANCE_EFFECT))
        {

            this.removeStatusEffect(ACE.SECOND_CHANCE_EFFECT);
            this.setHealth(10);
            info.setReturnValue(true);

        }
    }

}
