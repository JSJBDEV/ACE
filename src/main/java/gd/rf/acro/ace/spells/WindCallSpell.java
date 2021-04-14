package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import gd.rf.acro.ace.effects.WindCallEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

public class WindCallSpell extends Spell {
    int time;
    @Override
    public String spellType() {
        return "snap";
    }

    @Override
    public String element() {
        return "air";
    }

    @Override
    public int tier() {
        return 2;
    }

    @Override
    public int cost() {
        return 30;
    }

    public WindCallSpell(int duration)
    {
        time=duration;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        caster.addStatusEffect(new StatusEffectInstance(ACE.WIND_CALL_EFFECT,time));
    }
}
