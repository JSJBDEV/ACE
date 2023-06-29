package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;

import java.util.List;

public class ResonantFlameSpell extends Spell {
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
        return 2;
    }

    @Override
    public int cost() {
        return 10;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        List<Entity> entities = caster.world.getEntitiesByClass(Entity.class,new Box(caster.getPos().add(-10,-10,-10),caster.getPos().add(10,10,10)),Entity::isLiving);
        entities.forEach(entity ->
        {
            if(!entity.isTeammate(caster) && entity!=caster)
            {
                if(entity instanceof LivingEntity)
                {
                    Utils.castConnection(caster,(LivingEntity) entity,caster.world,new float[]{1,0,0},3);
                }
                entity.setOnFireFor(20);
            }
        });
    }
}
