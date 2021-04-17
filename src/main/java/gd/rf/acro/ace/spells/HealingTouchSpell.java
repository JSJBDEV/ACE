package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;

public class HealingTouchSpell extends Spell {

    @Override
    public String spellType() {
        return "touch";
    }

    @Override
    public String element() {
        return "water";
    }

    @Override
    public int tier() {
        return 0;
    }

    @Override
    public int cost() {
        return 3;
    }

    @Override
    public void onTouchCast(LivingEntity caster, LivingEntity victim) {
        super.onTouchCast(caster, victim);
        victim.heal(3);
    }
}
