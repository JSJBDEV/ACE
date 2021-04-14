package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;

public class SabotageRedstoneSpell extends Spell {
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
        return 2;
    }

    @Override
    public int cost() {
        return 10;
    }

    @Override
    public void onTapBlock(LivingEntity caster, BlockPos tapped) {
        super.onTapBlock(caster, tapped);
        for (int i = -5; i < 5; i++) {
            for (int j = -5; j < 5; j++) {
                for (int k = -5; k < 5; k++) {
                        if(caster.world.getBlockState(tapped.add(i,j,k)).getBlock()== Blocks.REDSTONE_WIRE)
                        {
                            caster.world.setBlockState(tapped.add(i,j,k), ACE.BURNT_REDSTONE_BLOCK.getDefaultState());
                        }
                }
            }
        }
    }
}
