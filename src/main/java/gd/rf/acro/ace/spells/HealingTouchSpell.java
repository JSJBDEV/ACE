package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;

public class HealingTouchSpell extends SpellACE {

    @Override
    public String getCastingType() {
        return "touch";
    }

    @Override
    public Element getElement() {
        return "water";
    }

    @Override
    public int getTier() {
        return 0;
    }

    @Override
    public int getManaCost() {
        return 3;
    }

    @Override
    public void onTouchCast(LivingEntity caster, LivingEntity victim) {
        super.onTouchCast(caster, victim);
        victim.heal(3);
    }
}
