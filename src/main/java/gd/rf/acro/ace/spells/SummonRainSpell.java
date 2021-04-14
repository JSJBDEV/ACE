package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;

public class SummonRainSpell extends Spell {
    @Override
    public String spellType() {
        return "snap";
    }

    @Override
    public String element() {
        return "water";
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
        if(caster.world instanceof ServerWorld)
        {
            ((ServerWorld) caster.world).setWeather(0,200,true,false);
        }
    }
}
