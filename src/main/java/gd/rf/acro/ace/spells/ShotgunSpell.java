package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import gd.rf.acro.ace.entities.BoltEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;

public class ShotgunSpell extends SpellACE {
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
        BoltEntity boltEntity = new BoltEntity(ACE.BOLT_ENTITY_TYPE,caster.world,caster, Items.FIRE_CHARGE,1,"burn");
        boltEntity.setVelocity(caster.getRotationVector());

        boltEntity.teleport(caster.getX(),caster.getY()+1,caster.getZ());
        BoltEntity boltEntity1 = new BoltEntity(ACE.BOLT_ENTITY_TYPE,caster.world,caster, Items.FIRE_CHARGE,1,"burn");
        boltEntity1.setVelocity(caster.getRotationVector().rotateY(-0.2f));
        boltEntity1.teleport(caster.getX(),caster.getY()+1,caster.getZ());
        BoltEntity boltEntity2 = new BoltEntity(ACE.BOLT_ENTITY_TYPE,caster.world,caster, Items.FIRE_CHARGE,1,"burn");
        boltEntity2.setVelocity(caster.getRotationVector().rotateY(0.2f));
        boltEntity2.teleport(caster.getX(),caster.getY()+1,caster.getZ());
        caster.world.spawnEntity(boltEntity);
        caster.world.spawnEntity(boltEntity1);
        caster.world.spawnEntity(boltEntity2);

    }
}
