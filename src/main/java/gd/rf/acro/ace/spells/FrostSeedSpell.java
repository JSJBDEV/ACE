package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;

public class FrostSeedSpell extends SpellACE {
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
        return 5;
    }

    @Override
    public void onTapBlock(LivingEntity caster, BlockPos tapped) {
        super.onTapBlock(caster, tapped);
        if(caster.world.getBlockState(tapped).isIn(BlockTags.ICE))
        {
            caster.world.setBlockState(tapped, ACE.SEEPING_ICE_BLOCK.getDefaultState());
        }
    }
}
