package gd.rf.acro.ace.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class UndeadenedEffect extends StatusEffect {


    public UndeadenedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        if(entity.getWorld().isSkyVisible(entity.getBlockPos()) && entity.getWorld().isDay()) {
            entity.setOnFireFor(2);
        }
    }
}
