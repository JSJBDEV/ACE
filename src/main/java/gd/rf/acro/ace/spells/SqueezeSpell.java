package gd.rf.acro.ace.spells;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;

public class SqueezeSpell extends SpellACE {
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
        return 0;
    }

    @Override
    public int getManaCost() {
        return 5;
    }

    @Override
    public void onTapBlock(LivingEntity caster, BlockPos tapped) {
        super.onTapBlock(caster, tapped);
        if(caster.world.getBlockState(tapped).getBlock()== Blocks.WET_SPONGE)
        {
            caster.world.setBlockState(tapped,Blocks.SPONGE.getDefaultState());
        }
        if(caster.world.getBlockState(tapped).getBlock()== Blocks.MAGMA_BLOCK)
        {
            caster.world.setBlockState(tapped,Blocks.LAVA.getDefaultState());
        }
        if(caster.world.getBlockState(tapped).getBlock()== Blocks.KELP_PLANT)
        {
            caster.world.setBlockState(tapped,Blocks.AIR.getDefaultState());
            caster.dropStack(new ItemStack(Items.DRIED_KELP));
        }
    }
}
