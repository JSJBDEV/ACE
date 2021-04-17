package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

public class LeapSpell extends Spell {
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
        return 0;
    }

    @Override
    public int cost() {
        return 2;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        if(!caster.hasStatusEffect(ACE.AERIAL_EFFECT))
        {
            caster.addVelocity(caster.getRotationVector().x,caster.getRotationVector().y,caster.getRotationVector().z);
            caster.addStatusEffect(new StatusEffectInstance(ACE.AERIAL_EFFECT,1000));
        }
    }
}
