package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;

public class MagicTowerSpell extends Spell {
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
        return 2;
    }

    @Override
    public int cost() {
        return 10;
    }

    @Override
    public void onTapBlock(LivingEntity caster, BlockPos tapped) {
        super.onTapBlock(caster, tapped);
        for (int i = 0; i < 20; i+=4) {
            if(caster.world.getBlockState(tapped.add(1,i,0)).isAir())
            {
                caster.world.setBlockState(tapped.add(1,i,0), ACE.MAGIC_BLOCK.getDefaultState());
            }
            if(caster.world.getBlockState(tapped.add(1,i+1,1)).isAir())
            {
                caster.world.setBlockState(tapped.add(1,i+1,1), ACE.MAGIC_BLOCK.getDefaultState());
            }
            if(caster.world.getBlockState(tapped.add(0,i+2,1)).isAir())
            {
                caster.world.setBlockState(tapped.add(0,i+2,1), ACE.MAGIC_BLOCK.getDefaultState());
            }
            if(caster.world.getBlockState(tapped.add(0,i+3,0)).isAir())
            {
                caster.world.setBlockState(tapped.add(0,i+3,0), ACE.MAGIC_BLOCK.getDefaultState());
            }
        }
    }
}
