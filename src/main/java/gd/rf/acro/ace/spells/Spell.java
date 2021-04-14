package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public abstract class Spell {
    //a spell cast that invokes an effect on the caster, or relating to the caster
    public abstract String spellType();
    public abstract String element();
    public abstract int tier();
    public abstract int cost();
    //TODO: add more spell sounds, and perhaps a default sound?
    //TODO: add better particles for spells, maybe also default cast particles?


    public void snapCast(LivingEntity caster)
    {

    }
    //a spell cast on a block
    public void onTapBlock(LivingEntity caster, BlockPos tapped)
    {

    }
    public void onTapBlockFace(LivingEntity caster, BlockPos tapped, Direction direction)
    {

    }

    public void onTouchCast(LivingEntity caster, LivingEntity victim)
    {

    }


}
