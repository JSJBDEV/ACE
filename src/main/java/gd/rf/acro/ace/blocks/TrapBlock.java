package gd.rf.acro.ace.blocks;

import gd.rf.acro.ace.spells.SpellACE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class TrapBlock extends Block {
    SpellACE.Element element;
    public TrapBlock(Settings settings, SpellACE.Element elem) {
        super(settings);
        element=elem;
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {

        return Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D);
    }



    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        switch (element) {
            case FIRE -> {
                entity.setOnFireFor(5);
                entity.playSound(SoundEvents.ITEM_FIRECHARGE_USE, 1, 1);
            }
            case WATER -> {
                if (entity instanceof LivingEntity) {
                    entity.setVelocity(0, 0, 0);
                    ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 3));
                    entity.playSound(SoundEvents.ENTITY_SPLASH_POTION_BREAK, 1, 1);
                }
            }
            case AIR -> {
                entity.addVelocity(0, 2, 0);
                entity.playSound(SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 1, 1);
            }
            case EARTH -> {
                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 3));
                entity.playSound(SoundEvents.BLOCK_BASALT_BREAK, 1, 1);
            }
        }

        world.setBlockState(pos, Blocks.AIR.getDefaultState());
    }
}
