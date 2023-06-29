package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

public class DisableRedstoneSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "tap";
    }

    @Override
    public Element getElement() {
        return Element.FIRE;
    }

    @Override
    public int getTier() {
        return 0;
    }

    @Override
    public int getManaCost() {
        return 2;
    }

    @Override
    public void onTapBlock(LivingEntity caster, BlockPos tapped) {
        super.onTapBlock(caster, tapped);
        if(caster.world.getBlockState(tapped).getBlock()== Blocks.REDSTONE_WIRE)
        {
            caster.playSound(SoundEvents.BLOCK_REDSTONE_TORCH_BURNOUT,1,1);
            caster.world.setBlockState(tapped, ACE.BURNT_REDSTONE_BLOCK.getDefaultState());
        }
    }
}
