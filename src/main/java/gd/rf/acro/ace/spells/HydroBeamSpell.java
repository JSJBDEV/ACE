package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;

public class HydroBeamSpell extends SpellACE {
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
        LivingEntity hit =Utils.castBeam(caster,caster.world,new float[]{0,0,1},2);
        if(hit!=null)
        {
           Utils.applyMagicModDamage(caster,hit,5);
        }

    }
}
