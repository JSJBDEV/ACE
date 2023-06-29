package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public abstract class Spell {
    //a spell cast that invokes an effect on the caster, or relating to the caster
    public abstract String spellType();
    public abstract String element();
    public abstract int tier();
    public abstract int cost();
    //LATER: add more spell sounds, and perhaps a default sound?
    //LATER: add better particles for spells, maybe also default cast particles?
    //TODO: add the devotion system
    //Add support for "aether" element?

    public void snapCast(LivingEntity caster)
    {
        if(!caster.hasStatusEffect(ACE.NO_SPELL_EFFECT))
        {
            Utils.modifyDevotionValue(caster,element(),cost());
        }

    }
    //a spell cast on a block
    public void onTapBlock(LivingEntity caster, BlockPos tapped)
    {
        if(!caster.hasStatusEffect(ACE.NO_SPELL_EFFECT))
        {
            Utils.modifyDevotionValue(caster,element(),cost());
        }
    }
    public void onTapBlockFace(LivingEntity caster, BlockPos tapped, Direction direction)
    {
        if(!caster.hasStatusEffect(ACE.NO_SPELL_EFFECT))
        {
            Utils.modifyDevotionValue(caster,element(),cost());
        }
    }

    public void onTouchCast(LivingEntity caster, LivingEntity victim)
    {
        if(!caster.hasStatusEffect(ACE.NO_SPELL_EFFECT))
        {
            Utils.modifyDevotionValue(caster,element(),cost());
        }
    }

    public String name()
    {
        return getClass().getSimpleName();
    }


}
