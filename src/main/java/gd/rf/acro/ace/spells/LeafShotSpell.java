package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import gd.rf.acro.ace.entities.BoltEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import org.lwjgl.system.CallbackI;

public class LeafShotSpell extends  Spell {
    @Override
    public String spellType() {
        return "snap";
    }

    @Override
    public String element() {
        return "earth";
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

        BoltEntity boltEntity = new BoltEntity(ACE.BOLT_ENTITY_TYPE,caster.world,caster, Items.ACACIA_LEAVES,1,"");
        boltEntity.setVelocity(caster.getRotationVector());
        boltEntity.teleport(caster.getX(),caster.getY()+1,caster.getZ());
        caster.world.spawnEntity(boltEntity);

    }
}
