package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BalanceHydrationSpell extends Spell {
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
        return 2;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        caster.clearStatusEffects();
        caster.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,200));

    }
}
