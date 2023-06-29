package gd.rf.acro.ace.spells;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class RaiseSnowGolemSpell extends Spell {
    @Override
    public String spellType() {
        return "tap";
    }

    @Override
    public String element() {
        return "earth";
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
    public void onTapBlock(LivingEntity caster, BlockPos tapped) {
        super.onTapBlock(caster, tapped);
        if(!caster.world.isClient)
        {
            if(caster instanceof PlayerEntity)
            {
                EntityType.SNOW_GOLEM.spawn((ServerWorld) caster.world,null, Text.of(caster.getName()+"'s Golem"), (PlayerEntity) caster,tapped.up(), SpawnReason.EVENT,true,false);
            }
            else
            {
                EntityType.SNOW_GOLEM.spawn((ServerWorld) caster.world,null,null,null,tapped.up(), SpawnReason.EVENT,true,false);

            }
        }

    }
}
