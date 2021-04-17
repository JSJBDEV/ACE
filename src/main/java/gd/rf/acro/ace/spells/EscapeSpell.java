package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;

public class EscapeSpell extends Spell {
    @Override
    public String spellType() {
        return "snap";
    }

    @Override
    public String element() {
        return "air";
    }

    @Override
    public int tier() {
        return 0;
    }

    @Override
    public int cost() {
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
