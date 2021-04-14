package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class HydroBeamSpell extends Spell {
    @Override
    public String spellType() {
        return "snap";
    }

    @Override
    public String element() {
        return "water";
    }

    @Override
    public int tier() {
        return 0;
    }

    @Override
    public int cost() {
        return 5;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        LivingEntity hit =Utils.castBeam(caster,caster.world,new float[]{0,0,1},2);
        if(hit!=null)
        {
            hit.damage(DamageSource.mob(caster),5);
        }

    }
}
