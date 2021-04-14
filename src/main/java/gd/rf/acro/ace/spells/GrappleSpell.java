package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;

public class GrappleSpell extends Spell {
    @Override
    public String spellType() {
        return "snap";
    }

    @Override
    public String element() {
        return "earth";
    }

    @Override
    public int tier() {
        return 0;
    }

    @Override
    public int cost() {
        return 1;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        LivingEntity victim = Utils.castBeam(caster,caster.world,Utils.getColourForElement("earth"));
        if(victim!=null)
        {
            victim.lookAt(EntityAnchorArgumentType.EntityAnchor.EYES,caster.getPos());
            Vec3d v = victim.getRotationVector();
            victim.addVelocity(v.x,v.y,v.z);
        }
    }
}
