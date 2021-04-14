package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;

public class BurySpell extends Spell {
    @Override
    public String spellType() {
        return "touch";
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
    public void onTouchCast(LivingEntity caster, LivingEntity victim) {
        super.onTouchCast(caster, victim);
        victim.teleport(victim.getX(),victim.getY()-2,victim.getZ());
    }
}
