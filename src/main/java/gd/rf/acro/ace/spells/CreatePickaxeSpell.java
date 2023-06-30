package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;

public class CreatePickaxeSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "tap";
    }

    @Override
    public Element getElement() {
        return Element.EARTH
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
        if(caster.world.getBlockState(tapped).isIn(BlockTags.BAMBOO_PLANTABLE_ON))
        {
            caster.dropStack(new ItemStack(ACE.EARTHEN_PICKAXE));
            caster.world.breakBlock(tapped,false);
        }
    }
}
