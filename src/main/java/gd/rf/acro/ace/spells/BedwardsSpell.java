package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import java.util.Optional;

public class BedwardsSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "snap";
    }

    @Override
    public Element getElement() {
        return Element.AIR;
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
        //https://github.com/glisco03/things/blob/master/src/main/java/com/glisco/things/items/RecallPotionItem.java
        if(!caster.world.isClient && caster instanceof ServerPlayerEntity)
        {
            ServerPlayerEntity player = (ServerPlayerEntity) caster;
            ServerWorld spawnWorld = player.getServer().getWorld(player.getSpawnPointDimension());
            if(player.getSpawnPointPosition()!=null)
            {
                Optional<Vec3d> posOptional = PlayerEntity.findRespawnPosition(spawnWorld, player.getSpawnPointPosition(), player.getSpawnAngle(), true, false);
                if(posOptional.isPresent())
                {
                    BlockPos pos = new BlockPos(posOptional.get());
                    player.teleport(spawnWorld,pos.getX(),pos.getY(),pos.getZ(),player.getSpawnAngle(),0);
                }
            }
        }


    }
}
