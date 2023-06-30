package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.util.math.BlockPos;

public class OffYouGoSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "touch";
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
        return 5;
    }

    @Override
    public void onTouchCast(LivingEntity caster, LivingEntity victim) {
        super.onTouchCast(caster, victim);
        BlockPos loc = victim.getBlockPos();
        FireworkRocketEntity entity = new FireworkRocketEntity(caster.world,caster,loc.getX(),loc.getY(),loc.getZ(), Utils.createRocketStack());
        caster.world.spawnEntity(entity);
        victim.startRiding(entity,true);
    }
}
