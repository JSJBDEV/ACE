package gd.rf.acro.ace.spells;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;

public class ConjureFireSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "tap";
    }

    @Override
    public Element getElement() {
        return Element.FIRE;
    }

    @Override
    public int getTier() {
        return 0;
    }

    @Override
    public int getManaCost() {
        return 2;
    }

    @Override
    public void onTapBlock(LivingEntity caster, BlockPos tapped) {
        if(caster.world.getBlockState(tapped.up()).isAir())
        {
            caster.world.setBlockState(tapped.up(), Blocks.FIRE.getDefaultState());
        }
    }
}
