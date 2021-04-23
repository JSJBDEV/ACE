package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class OffYouGoSpell extends Spell {
    @Override
    public String spellType() {
        return "touch";
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
