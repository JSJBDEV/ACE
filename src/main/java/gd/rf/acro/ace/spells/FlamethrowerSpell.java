package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class FlamethrowerSpell extends Spell {
    @Override
    public String spellType() {
        return "snap";
    }

    @Override
    public String element() {
        return "fire";
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
        LivingEntity hit =Utils.castBeam(caster,caster.world,new float[]{1,0,0},2);
        if(hit!=null)
        {
            hit.damage(DamageSource.mob(caster),6);
            hit.setOnFireFor(5);
        }

    }
}
