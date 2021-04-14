package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class ConjureLightSpell extends Spell {
    @Override
    public String spellType() {
        return "tap";
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
        return 2;
    }

    @Override
    public void onTapBlockFace(LivingEntity caster, BlockPos tapped, Direction direction) {
        super.onTapBlockFace(caster, tapped, direction);
        if(caster.world.getBlockState(tapped.add(direction.getVector())).isAir())
        {
            caster.world.setBlockState(tapped.add(direction.getVector()), ACE.LIGHT_BLOCK.getDefaultState());
        }
    }
}
