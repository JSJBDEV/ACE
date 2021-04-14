package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import gd.rf.acro.ace.entities.BoltEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;

public class SonicBoomSpell extends  Spell {
    @Override
    public String spellType() {
        return "snap";
    }

    @Override
    public String element() {
        return "air";
    }

    @Override
    public int tier() {
        return 0;
    }

    @Override
    public int cost() {
        return 1;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        BoltEntity boltEntity = new BoltEntity(ACE.BOLT_ENTITY_TYPE,caster.world,caster, Items.FEATHER,1,"force");
        boltEntity.setVelocity(caster.getRotationVector().multiply(3));
        boltEntity.teleport(caster.getX(),caster.getY()+1,caster.getZ());
        caster.world.spawnEntity(boltEntity);
    }
}
