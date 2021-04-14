package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;

public class DisarmSpell extends Spell {
    @Override
    public String spellType() {
        return "touch";
    }

    @Override
    public String element() {
        return "air";
    }

    @Override
    public int tier() {
        return 1;
    }

    @Override
    public int cost() {
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
