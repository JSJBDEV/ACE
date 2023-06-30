package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.Box;

import java.util.List;

public class DisableMagicSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "snap";
    }

    @Override
    public Element getElement() {
        return Element.FIRE;
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public int getManaCost() {
        return 10;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        List<LivingEntity> entities = caster.world.getEntitiesByClass(LivingEntity.class,new Box(caster.getPos().add(-10,-10,-10),caster.getPos().add(10,10,10)),LivingEntity::isAlive);
        entities.forEach(entity -> entity.addStatusEffect(new StatusEffectInstance(ACE.NO_SPELL_EFFECT,1000)));
    }
}
