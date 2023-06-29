package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;

import java.util.List;

public class TornadoSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "snap";
    }

    @Override
    public Element getElement() {
        return "air";
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public int getManaCost() {
        return 20;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        List<Entity> entities = caster.world.getEntitiesByClass(Entity.class,new Box(caster.getPos().add(-10,-10,-10),caster.getPos().add(10,10,10)),e->e!=caster);
        entities.forEach(entity -> entity.addVelocity(Utils.random(-3,3),Utils.random(0,3),Utils.random(-3,3)));
    }
}
