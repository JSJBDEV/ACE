package gd.rf.acro.ace.spells;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;

public class AlchemySpell extends Spell {
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
        return 0;
    }

    @Override
    public void onTapBlock(LivingEntity caster, BlockPos tapped) {
        super.onTapBlock(caster, tapped);
        if(caster.world.getBlockState(tapped).getBlock()== Blocks.GLOWSTONE)
        {
            caster.world.setBlockState(tapped,Blocks.GOLD_BLOCK.getDefaultState());
        }
    }
}
