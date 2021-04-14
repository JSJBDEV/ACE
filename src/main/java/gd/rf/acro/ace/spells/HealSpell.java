package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;

public class HealSpell extends Spell {
    float health;

    public HealSpell(float amount)
    {
        health=amount;
    }

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
        return (int) (health/9);
    }

    @Override
    public int cost() {
        return (int) (health/2);
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        caster.heal(health);
    }
}
