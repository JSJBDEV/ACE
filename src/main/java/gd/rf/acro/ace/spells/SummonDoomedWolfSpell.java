package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;

public class SummonDoomedWolfSpell extends Spell {
    @Override
    public String spellType() {
        return "snap";
    }

    @Override
    public String element() {
        return "earth";
    }

    @Override
    public int tier() {
        return 0;
    }

    @Override
    public int cost() {
        return 10;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        WolfEntity entity = new WolfEntity(EntityType.WOLF,caster.world);
        entity.addStatusEffect(new StatusEffectInstance(ACE.DOOMSDAY_EFFECT,500));
        entity.setOwnerUuid(caster.getUuid());
        if(caster instanceof PlayerEntity)
        {
            entity.setOwner((PlayerEntity) caster);
        }
        entity.teleport(caster.getX(),caster.getY(),caster.getZ());
        caster.world.spawnEntity(entity);
    }
}
