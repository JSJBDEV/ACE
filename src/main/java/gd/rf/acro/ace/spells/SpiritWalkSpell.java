package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;

public class SpiritWalkSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "tap";
    }

    @Override
    public Element getElement() {
        return "air";
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
    public void onTapBlock(LivingEntity caster, BlockPos tapped) {
        super.onTapBlock(caster, tapped);
        caster.teleport(tapped.getX()+0.5,tapped.getY(),tapped.getZ()+0.5);
    }
}
