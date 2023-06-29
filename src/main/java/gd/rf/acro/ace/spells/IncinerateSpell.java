package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import gd.rf.acro.ace.Utils;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;

public class IncinerateSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "snap";
    }

    @Override
    public Element getElement() {
        return "fire";
    }

    @Override
    public int getTier() {
        return 2;
    }

    @Override
    public int getManaCost() {
        return 20;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        for (int i = -10; i < 10; i++) {
            for (int j = -10; j < 10; j++) {
                for (int k = -10; k < 10; k++) {
                    BlockState state = caster.world.getBlockState(caster.getBlockPos().add(i,j,k));
                    if(state.isIn(ACE.INCINERATABLE))
                    {
                        Utils.castBeamToPos(caster,caster.getBlockPos().add(i,j,k),caster.world,new float[]{1,0,0},1);
                        caster.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH,1,1);
                        caster.world.setBlockState(caster.getBlockPos().add(i,j,k), Blocks.AIR.getDefaultState());

                    }

                }
            }
        }
    }
}
