package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.Heightmap;

public class AscendSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "snap";
    }

    @Override
    public Element getElement() {
        return Element.AIR;
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public int getManaCost() {
        return 10;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        int y = caster.world.getTopY(Heightmap.Type.WORLD_SURFACE,caster.getBlockPos().getX(),caster.getBlockPos().getZ());
        caster.teleport(caster.getX(),y+5,caster.getZ());
    }
}
