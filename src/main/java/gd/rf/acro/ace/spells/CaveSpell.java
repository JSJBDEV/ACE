package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;

public class CaveSpell extends Spell {
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
        return 20;
    }

    @Override
    public void onTapBlock(LivingEntity caster, BlockPos tapped) {
        super.onTapBlock(caster, tapped);
        for (int i = -3; i < 3; i++) {
            for (int j = -3; j < 3; j++) {
                for (int k = -3; k < 3; k++) {
                    if(!caster.world.getBlockState(tapped.add(i,j,k)).isIn(BlockTags.DRAGON_IMMUNE))
                    {
                        caster.world.breakBlock(tapped.add(i,j,k),true);
                    }
                }
            }
        }

    }
}
