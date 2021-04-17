package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.explosion.Explosion;

public class DetobeamSpell extends Spell {
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
        return 1;
    }

    @Override
    public int cost() {
        return 5;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        LivingEntity hit = Utils.castBeam(caster,caster.world,new float[]{1,0,0},5);
        if(hit!=null)
        {
            caster.world.createExplosion(caster,hit.getX(),hit.getY(),hit.getZ(),3, Explosion.DestructionType.BREAK);
        }
    }
}
