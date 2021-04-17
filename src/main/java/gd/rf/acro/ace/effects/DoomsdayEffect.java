package gd.rf.acro.ace.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class DoomsdayEffect extends StatusEffect {
    public DoomsdayEffect(StatusEffectType type, int color) {
        super(type, color);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if(entity instanceof PlayerEntity)
        {
            PlayerEntity player  = (PlayerEntity) entity;
            if(player.inventory.count(Items.DIAMOND)>0)
            {
                for (ItemStack item : player.inventory.main) {
                    if (item.getItem() == Items.DIAMOND) {
                        item.decrement(1);
                        break;
                    }
                }
                return;
            }
        }
        entity.damage(DamageSource.OUT_OF_WORLD,9999);
    }
}
