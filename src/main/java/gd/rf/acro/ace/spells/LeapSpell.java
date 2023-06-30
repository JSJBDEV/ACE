package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

public class LeapSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "snap";
    }

    @Override
    public Element getElement() {
        return "air";
    }

    @Override
    public int getTier() {
        return 0;
    }

    @Override
    public int getManaCost() {
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
