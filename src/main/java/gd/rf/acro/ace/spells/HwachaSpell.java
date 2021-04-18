package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;

public class HwachaSpell extends Spell {
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
        return 1;
    }

    @Override
    public int cost() {
        return 5;
    }


    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        for (int i = 0; i < 5; i++) {

            FireworkRocketEntity entity = new FireworkRocketEntity(
                    caster.world,
                    Utils.createRocketStack(),
                    caster,
                    caster.getX()+Utils.randomNoZero(-30,30)/10F,
                    caster.getEyeY()+Utils.randomNoZero(0,30)/10F,
                    caster.getZ()+Utils.randomNoZero(-30,30)/10F,true);
            entity.setVelocity(caster.getRotationVector());
            caster.world.spawnEntity(entity);
        }

    }
}
