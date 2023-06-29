package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.Box;

import java.util.List;

public class MagicSenseSpell extends SpellACE {
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
        return 1;
    }

    @Override
    public int getManaCost() {
        return 5;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        List<LivingEntity> entities = caster.world.getEntitiesByClass(LivingEntity.class,new Box(caster.getPos().add(-15,-15,-15),caster.getPos().add(15,15,15)),LivingEntity::isAlive);
        entities.forEach(entity -> entity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING,200)));
    }
}
