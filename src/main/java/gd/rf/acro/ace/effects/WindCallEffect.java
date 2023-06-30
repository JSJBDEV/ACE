package gd.rf.acro.ace.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class WindCallEffect extends StatusEffect {


    public WindCallEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier);
        if(entity instanceof PlayerEntity player) {
            player.getAbilities().allowFlying=true;
            player.getAbilities().flying=true;
            player.sendAbilitiesUpdate();
        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if(entity instanceof PlayerEntity player) {
            player.getAbilities().allowFlying=false;
            player.getAbilities().flying=false;
            player.sendAbilitiesUpdate();
        }
    }
}
