package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class RocketSpell extends Spell {
    @Override
    public String spellType() {
        return "snap";
    }

    @Override
    public String element() {
        return "fire";
    }

    @Override
    public int tier() {
        return 0;
    }

    @Override
    public int cost() {
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
