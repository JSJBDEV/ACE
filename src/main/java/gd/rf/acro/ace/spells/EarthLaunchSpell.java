package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

import java.util.List;

public class EarthLaunchSpell extends Spell {
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
        return 5;
    }

    @Override
    public void onTapBlock(LivingEntity caster, BlockPos tapped) {
        super.onTapBlock(caster, tapped);
        if(caster.world.getBlockState(tapped.up()).isAir())
        {
            if(caster.world.getBlockState(tapped.up(2)).isAir())
            {
                caster.world.setBlockState(tapped.up(), ACE.FLEETING_DIRT.getDefaultState());
                caster.world.setBlockState(tapped.up(2), ACE.FLEETING_DIRT.getDefaultState());
                List<Entity> entities = caster.world.getEntitiesByClass(Entity.class,new Box(tapped.add(-2,-2,-2),tapped.add(2,2,2)),null);
                entities.forEach(entity -> entity.addVelocity(0,2,0));
            }
        }
    }
}
