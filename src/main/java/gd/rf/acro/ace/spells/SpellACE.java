package gd.rf.acro.ace.spells;

import dev.louis.nebula.spell.Spell;
import dev.louis.nebula.spell.SpellType;
import gd.rf.acro.ace.ACE;
import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public abstract class SpellACE extends dev.louis.nebula.spell.Spell {
    public SpellACE(SpellType<?> spellType, PlayerEntity caster) {
        super(spellType, caster);
    }

    //a spell cast that invokes an effect on the caster, or relating to the caster
    public CastingType getCastingType() {
        return this.getType().getCastingType();
    };
    public Element getElement() {
        return this.getType().getElement();
    }

    public int getTier() {
        return this.getType().getTier();
    }

    public int getManaCost() {
        return this.getType().getManaCost();
    }

    @Override
    public SpellTypeACE<? extends Spell> getType() {
        return (SpellTypeACE<?>) super.getType();
    }
    //LATER: add more spell sounds, and perhaps a default sound?
    //LATER: add better particles for spells, maybe also default cast particles?
    //TODO: add the devotion system
    //Add support for "aether" element?

    public void snapCast(LivingEntity caster)
    {
        if(!caster.hasStatusEffect(ACE.NO_SPELL_EFFECT))
        {
            Utils.modifyDevotionValue(caster, getElement(), getManaCost());
        }

    }
    //a spell cast on a block
    public void onTapBlock(LivingEntity caster, BlockPos tapped)
    {
        if(!caster.hasStatusEffect(ACE.NO_SPELL_EFFECT))
        {
            Utils.modifyDevotionValue(caster, getElement(), getManaCost());
        }
    }
    public void onTapBlockFace(LivingEntity caster, BlockPos tapped, Direction direction)
    {
        if(!caster.hasStatusEffect(ACE.NO_SPELL_EFFECT))
        {
            Utils.modifyDevotionValue(caster, getElement(), getManaCost());
        }
    }

    public void onTouchCast(LivingEntity caster, LivingEntity victim)
    {
        if(!caster.hasStatusEffect(ACE.NO_SPELL_EFFECT))
        {
            Utils.modifyDevotionValue(caster, getElement(), getManaCost());
        }
    }

    public String name()
    {
        return getClass().getSimpleName();
    }

    public enum Element {
        AIR,
        EARTH,
        WATER,
        FIRE
    }
    public enum CastingType {
        NORMAL,
        TOUCH,
        TAP
    }
}
