package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;

public class ExtractNutrientsSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "tap";
    }

    @Override
    public Element getElement() {
        return EARTH
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public int getManaCost() {
        return 2;
    }

    @Override
    public void onTapBlock(LivingEntity caster, BlockPos tapped) {
        super.onTapBlock(caster, tapped);
        if(caster instanceof PlayerEntity)
        {
            PlayerEntity playerEntity = (PlayerEntity) caster;
            if(caster.world.getBlockState(tapped).isIn(BlockTags.LEAVES))
            {
                playerEntity.getHungerManager().add(1,1);
            }
        }


    }
}
