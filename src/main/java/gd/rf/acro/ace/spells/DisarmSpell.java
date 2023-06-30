package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;

public class DisarmSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "touch";
    }

    @Override
    public Element getElement() {
        return "air";
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public int getManaCost() {
        return 10;
    }

    @Override
    public void onTouchCast(LivingEntity caster, LivingEntity victim) {
        super.onTouchCast(caster, victim);
        victim.dropStack(victim.getMainHandStack());
        victim.dropStack(victim.getOffHandStack());
        victim.getMainHandStack().setCount(0);
        victim.getMainHandStack().setCount(0);
    }
}
