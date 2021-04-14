package gd.rf.acro.ace.spells;

import net.minecraft.client.util.math.Vector3d;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;

public class PushSpell extends Spell {
    private double power;
    @Override
    public String spellType() {
        return "touch";
    }

    @Override
    public String element() {
        return "air";
    }

    @Override
    public int tier() {
        return (int) (power/3);
    }

    @Override
    public int cost() {
        return (int) (power/2);
    }

    public PushSpell(double mult)
    {
        power=mult;
    }

    @Override
    public void onTouchCast(LivingEntity caster, LivingEntity victim) {
        super.onTouchCast(caster, victim);
        Vec3d v = caster.getRotationVector().multiply(power);
        victim.addVelocity(v.x,v.y,v.z);
    }
}
