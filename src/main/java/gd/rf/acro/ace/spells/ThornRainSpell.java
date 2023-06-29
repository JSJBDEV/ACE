package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import gd.rf.acro.ace.Utils;
import gd.rf.acro.ace.entities.BoltEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;

public class ThornRainSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "touch";
    }

    @Override
    public Element getElement() {
        return EARTH
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

        for (int i = 0; i < 10; i++) {
            BoltEntity boltEntity = new BoltEntity(ACE.BOLT_ENTITY_TYPE,caster.world,caster, Items.ACACIA_LEAVES,1,"");
            boltEntity.setVelocity(0,-1,0);
            boltEntity.teleport(victim.getX()+ Utils.random(-5,5),victim.getY()+50,victim.getZ()+ Utils.random(-5,5));
            caster.world.spawnEntity(boltEntity);
        }
    }
}
