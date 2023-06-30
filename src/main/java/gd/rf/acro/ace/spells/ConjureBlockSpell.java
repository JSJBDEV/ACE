package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class ConjureBlockSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "tap";
    }

    @Override
    public Element getElement() {
        return Element.EARTH;
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
    public void onTapBlockFace(LivingEntity caster, BlockPos tapped, Direction direction) {
        super.onTapBlockFace(caster, tapped, direction);
        if(caster.world.getBlockState(tapped.add(direction.getVector())).isAir())
        {
            caster.world.setBlockState(tapped.add(direction.getVector()), ACE.MAGIC_BLOCK.getDefaultState());
        }
    }
}
