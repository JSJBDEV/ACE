package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;

public class RecoverySpell extends SpellACE {


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
        return 1;
    }

    @Override
    public int getManaCost() {
        return 10;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        caster.heal(5);
    }
}
