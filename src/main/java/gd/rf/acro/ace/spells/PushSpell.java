package gd.rf.acro.ace.spells;

import net.minecraft.client.util.math.Vector3d;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;

public class PushSpell extends SpellACE {
    private double power;
    @Override
    public String getCastingType() {
        return "touch";
    }

    @Override
    public Element getElement() {
        return "air";
    }

    @Override
    public int getTier() {
        return (int) (power/3);
    }

    @Override
    public int getManaCost() {
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
