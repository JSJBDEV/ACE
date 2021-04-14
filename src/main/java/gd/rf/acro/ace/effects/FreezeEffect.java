package gd.rf.acro.ace.effects;

import gd.rf.acro.ace.ACE;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class FreezeEffect extends StatusEffect {
    public FreezeEffect(StatusEffectType type, int color) {
        super(type, color);
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        entity.setVelocity(0,0,0);
        entity.world.setBlockState(entity.getBlockPos(), ACE.FLEETING_ICE.getDefaultState());
        entity.world.setBlockState(entity.getBlockPos().up(), ACE.FLEETING_ICE.getDefaultState());
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier);

    }
}
