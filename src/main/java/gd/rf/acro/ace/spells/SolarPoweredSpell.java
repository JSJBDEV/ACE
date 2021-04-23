package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public class SolarPoweredSpell extends Spell {
    @Override
    public String spellType() {
        return "snap";
    }

    @Override
    public String element() {
        return "fire";
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
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        if(caster.world.isSkyVisible(caster.getBlockPos()) && !caster.world.isRaining())
        {
            if(caster instanceof PlayerEntity)
            {
                ((PlayerEntity) caster).getHungerManager().add(2,2);
            }
        }
    }
}
