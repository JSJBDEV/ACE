package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;

public class HwachaSpell extends SpellACE {
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
