package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;

public class RocketSpell extends SpellACE {
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
        return 0;
    }

    @Override
    public int getManaCost() {
        return 2;
    }


    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        FireworkRocketEntity entity = new FireworkRocketEntity(caster.world, Utils.createRocketStack(),caster,caster.getX(),caster.getEyeY(),caster.getZ(),true);
        entity.setVelocity(caster.getRotationVector());
        caster.world.spawnEntity(entity);
    }
}
