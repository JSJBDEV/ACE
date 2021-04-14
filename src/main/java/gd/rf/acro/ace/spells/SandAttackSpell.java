package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class SandAttackSpell extends Spell {
    @Override
    public String spellType() {
        return "touch";
    }

    @Override
    public String element() {
        return "earth";
    }

    @Override
    public int tier() {
        return 0;
    }

    @Override
    public int cost() {
        return 2;
    }

    @Override
    public void onTouchCast(LivingEntity caster, LivingEntity victim) {
        super.onTouchCast(caster, victim);
        victim.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS,100));
    }
}
