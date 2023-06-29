package gd.rf.acro.ace.effects;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class AerialEffect extends StatusEffect {


    public AerialEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {

        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        entity.fallDistance=0;
        entity.setAir(0);
        if(entity.isOnGround())
        {
            entity.removeStatusEffect(ACE.AERIAL_EFFECT);
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,50));
        }
    }
}
