package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.Heightmap;

public class EscapeSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "snap";
    }

    @Override
    public Element getElement() {
        return "air";
    }

    @Override
    public int getTier() {
        return 0;
    }

    @Override
    public int getManaCost() {
        return 10;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        int x = caster.getBlockPos().getX()+Utils.random(-100,100);
        int z = caster.getBlockPos().getZ()+Utils.random(-100,100);
        caster.teleport(x,caster.world.getTopY(Heightmap.Type.WORLD_SURFACE,x,z)+5,z);
    }
}
