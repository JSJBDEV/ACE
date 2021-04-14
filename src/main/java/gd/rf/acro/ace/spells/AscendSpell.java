package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.Heightmap;

public class AscendSpell extends Spell {
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
        return 1;
    }

    @Override
    public int cost() {
        return 10;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        int y = caster.world.getTopY(Heightmap.Type.WORLD_SURFACE,caster.getBlockPos().getX(),caster.getBlockPos().getZ());
        caster.teleport(caster.getX(),y+5,caster.getZ());
    }
}
