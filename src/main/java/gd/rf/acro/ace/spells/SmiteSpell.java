package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class SmiteSpell extends SpellACE {
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
