package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public class SolarPoweredSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "snap";
    }

    @Override
    public Element getElement() {
        return "fire";
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public int getManaCost() {
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
