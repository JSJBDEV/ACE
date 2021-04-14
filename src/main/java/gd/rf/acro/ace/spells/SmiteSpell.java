package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class SmiteSpell extends Spell {
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
        return 1;
    }

    @Override
    public int cost() {
        return 10;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        LivingEntity hit = Utils.castBeam(caster,caster.world,new float[]{0,1,1},3);
        if(hit!=null && !caster.world.isClient)
        {
            PlayerEntity isCasterPlayer = null;
            if(caster instanceof PlayerEntity)
            {
                isCasterPlayer = (PlayerEntity) caster;
            }
            EntityType.LIGHTNING_BOLT.spawn((ServerWorld) caster.world, null, null, isCasterPlayer, hit.getBlockPos(), SpawnReason.EVENT, false, false);

        }
    }
}
