package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;

public class CreateIceSpikeSpell extends Spell {
    @Override
    public String spellType() {
        return "tap";
    }

    @Override
    public String element() {
        return "water";
    }

    @Override
    public int tier() {
        return 1;
    }

    @Override
    public int cost() {
        return 10;
    }

    @Override
    public void onTapBlock(LivingEntity caster, BlockPos tapped) {
        super.onTapBlock(caster, tapped);
        if(caster.world.getBlockState(tapped).isIn(BlockTags.ICE))
        {
            caster.dropStack(new ItemStack(ACE.ICE_SPIKE_SWORD));
            caster.world.breakBlock(tapped,false);
        }
    }
}
