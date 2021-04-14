package gd.rf.acro.ace.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class FleetingBlock extends Block {
    int fleet;
    public FleetingBlock(Settings settings,int ticks) {
        super(settings);
        fleet=ticks;
    }
    public FleetingBlock(Settings settings) {
        super(settings);
        fleet=10;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.scheduledTick(state, world, pos, random);
        world.setBlockState(pos, Blocks.AIR.getDefaultState());
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        super.onBlockAdded(state, world, pos, oldState, notify);
        world.getBlockTickScheduler().schedule(pos,this,fleet);
    }
}
