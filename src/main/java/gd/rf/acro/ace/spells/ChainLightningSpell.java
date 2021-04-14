package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

public class ChainLightningSpell extends Spell {
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
        return 2;
    }

    @Override
    public int cost() {
        return 20;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        LivingEntity hit = Utils.castBeam(caster,caster.world,new float[]{1,1,0},1);
        if(hit!=null)
        {
            chain(hit,caster);
        }


    }
    public static void chain(LivingEntity current,LivingEntity caster)
    {
        current.damage(DamageSource.mob(caster),5);
        BlockPos tapped = current.getBlockPos();
        List<LivingEntity> entities = current.world.getEntitiesByClass(LivingEntity.class,new Box(tapped.add(-5,-5,-5),tapped.add(5,5,5)),e-> e!=current&&!e.isTeammate(caster));
        if(entities.size()>0 && RandomUtils.nextBoolean())
        {
            int i =RandomUtils.nextInt(0,entities.size());
            Utils.castConnection(current,entities.get(i),current.world,new float[]{1,1,0},1);
            chain(entities.get(i),caster);
        }
    }
}
