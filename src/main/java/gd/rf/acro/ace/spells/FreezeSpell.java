package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;

public class FreezeSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "tap";
    }

    @Override
    public Element getElement() {
        return "water";
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public int getManaCost() {
        return 10;
    }

    @Override
    public void onTapBlock(LivingEntity caster, BlockPos tapped) {
        super.onTapBlock(caster, tapped);
        for (int i = -5; i < 5; i++) {
            for (int j = -5; j < 5; j++) {
                for (int k = -5; k < 5; k++) {
                    if(caster.world.getBlockState(tapped.add(i,j,k)).getBlock()== Blocks.WATER
                            || caster.world.getBlockState(tapped.add(i,j,k)).isIn(ACE.INCINERATABLE))
                    {
                        caster.world.setBlockState(tapped.add(i,j,k), ACE.FLEETING_ICE.getDefaultState());
                    }
                }
            }
        }
    }
}
