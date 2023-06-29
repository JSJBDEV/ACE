package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;

public class SwitchBeamSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "snap";
    }

    @Override
    public Element getElement() {
        return "fire";
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
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        LivingEntity hit = Utils.castBeam(caster,caster.world,new float[]{1,0,0});
        if(hit!=null)
        {
            BlockPos cast = caster.getBlockPos();
            BlockPos other = hit.getBlockPos();

            caster.teleport(other.getX(),other.getY(),other.getZ(),true);
            hit.teleport(cast.getX(),cast.getY(),cast.getZ(),true);
        }
    }
}
