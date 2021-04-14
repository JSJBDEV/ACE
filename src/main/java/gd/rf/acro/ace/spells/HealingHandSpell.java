package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;

public class HealingHandSpell extends Spell {
    float health;

    public HealingHandSpell(float amount)
    {
        health=amount;
    }
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
        return (int) (health/6);
    }

    @Override
    public int cost() {
        return (int) (health/2);
    }

    @Override
    public void onTouchCast(LivingEntity caster, LivingEntity victim) {
        super.onTouchCast(caster, victim);
        victim.heal(health);
    }
}
