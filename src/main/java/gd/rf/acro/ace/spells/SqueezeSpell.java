package gd.rf.acro.ace.spells;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;

public class SqueezeSpell extends Spell {
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
        return 0;
    }

    @Override
    public int cost() {
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
