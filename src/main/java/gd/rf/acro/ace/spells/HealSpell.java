package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;

public class HealSpell extends SpellACE {


    @Override
    public String getCastingType() {
        return "snap";
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
        return 5;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        caster.heal(2);
    }
}
