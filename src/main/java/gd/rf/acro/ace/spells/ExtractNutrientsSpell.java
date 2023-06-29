package gd.rf.acro.ace.spells;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;

public class ExtractNutrientsSpell extends Spell {
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
        return 1;
    }

    @Override
    public int cost() {
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
