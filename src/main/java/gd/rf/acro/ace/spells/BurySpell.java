package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;

public class BurySpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "touch";
    }

    @Override
    public Element getElement() {
        return Element.EARTH;

    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public int getManaCost() {
        return 5;
    }

    @Override
    public void onTouchCast(LivingEntity caster, LivingEntity victim) {
        super.onTouchCast(caster, victim);
        victim.teleport(victim.getX(),victim.getY()-2,victim.getZ());
    }
}
