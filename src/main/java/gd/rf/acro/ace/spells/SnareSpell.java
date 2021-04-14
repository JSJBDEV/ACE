package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

public class SnareSpell extends Spell {
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
        return 5;
    }

    @Override
    public void onTouchCast(LivingEntity caster, LivingEntity victim) {
        super.onTouchCast(caster, victim);
        victim.addStatusEffect(new StatusEffectInstance(ACE.ENTANGLED_EFFECT,200));
    }
}
