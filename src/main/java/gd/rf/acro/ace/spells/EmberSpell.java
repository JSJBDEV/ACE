package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import gd.rf.acro.ace.entities.BoltEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;

public class EmberSpell extends SpellACE {
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
        return 1;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        BoltEntity boltEntity = new BoltEntity(ACE.BOLT_ENTITY_TYPE,caster.world,caster, Items.FIRE_CHARGE,1,"burn");
        boltEntity.setVelocity(caster.getRotationVector());
        boltEntity.teleport(caster.getX(),caster.getY()+1,caster.getZ());
        caster.world.spawnEntity(boltEntity);

    }
}
