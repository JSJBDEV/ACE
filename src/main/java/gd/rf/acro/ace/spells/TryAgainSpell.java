package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

public class TryAgainSpell extends Spell {
    @Override
    public String spellType() {
        return "touch";
    }

    @Override
    public String element() {
        return "fire";
    }

    @Override
    public int tier() {
        return 2;
    }

    @Override
    public int cost() {
        return 30;
    }

    @Override
    public void onTouchCast(LivingEntity caster, LivingEntity victim) {
        super.onTouchCast(caster, victim);
        victim.addStatusEffect(new StatusEffectInstance(ACE.SECOND_CHANCE_EFFECT,200));
    }
}
