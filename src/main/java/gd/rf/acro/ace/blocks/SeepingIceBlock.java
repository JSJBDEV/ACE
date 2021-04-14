package gd.rf.acro.ace.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IceBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

public class SeepingIceBlock extends Block {
    public SeepingIceBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);
        if(world.getBlockState(pos.west()).getBlock()== Blocks.WATER && RandomUtils.nextBoolean())
        {
            world.setBlockState(pos.west(),state);
        }
        if(world.getBlockState(pos.east()).getBlock()== Blocks.WATER && RandomUtils.nextBoolean())
        {
            world.setBlockState(pos.east(),state);
        }
        if(world.getBlockState(pos.south()).getBlock()== Blocks.WATER && RandomUtils.nextBoolean())
        {
            world.setBlockState(pos.south(),state);
        }
        if(world.getBlockState(pos.north()).getBlock()== Blocks.WATER && RandomUtils.nextBoolean())
        {
            world.setBlockState(pos.north(),state);
        }
        world.setBlockState(pos,Blocks.PACKED_ICE.getDefaultState());
    }
}
