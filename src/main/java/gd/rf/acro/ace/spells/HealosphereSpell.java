package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class HealosphereSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "tap";
    }

    @Override
    public Element getElement() {
        return "water";
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
    public void onTapBlockFace(LivingEntity caster, BlockPos tapped, Direction direction) {
        super.onTapBlockFace(caster, tapped, direction);
        Utils.createAOE(caster.world,tapped.add(direction.getVector()),
                Utils.getColourForElement("water"),
                new StatusEffectInstance(StatusEffects.REGENERATION,100));
    }
}
