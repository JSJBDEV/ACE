package gd.rf.acro.ace.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;

public class WindCallEffect extends StatusEffect {
    public WindCallEffect(StatusEffectType type, int color) {
        super(type, color);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier);
        if(entity instanceof PlayerEntity)
        {
            PlayerEntity playerEntity = (PlayerEntity) entity;
            playerEntity.abilities.allowFlying=true;
            playerEntity.abilities.flying=true;
            playerEntity.sendAbilitiesUpdate();
        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if(entity instanceof PlayerEntity)
        {
            PlayerEntity playerEntity = (PlayerEntity) entity;
            playerEntity.abilities.allowFlying=false;
            playerEntity.abilities.flying=false;
            playerEntity.sendAbilitiesUpdate();
        }
    }
}
