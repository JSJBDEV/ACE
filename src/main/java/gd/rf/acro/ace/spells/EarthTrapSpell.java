package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;

public class EarthTrapSpell extends Spell {
    @Override
    public String spellType() {
        return "tap";
    }

    @Override
    public String element() {
        return "earth";
    }

    @Override
    public int tier() {
        return 0;
    }

    @Override
    public int cost() {
        return 10;
    }

    @Override
    public void onTapBlock(LivingEntity caster, BlockPos tapped) {
        if(caster.world.getBlockState(tapped.up()).isAir())
        {
            caster.world.setBlockState(tapped.up(), ACE.EARTH_TRAP_BLOCK.getDefaultState());
        }
    }
}
