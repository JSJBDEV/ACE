package gd.rf.acro.ace.spells;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;

public class RingOfFireSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "touch";
    }

    @Override
    public Element getElement() {
        return "fire";
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
    public void onTouchCast(LivingEntity caster, LivingEntity victim) {
        super.onTouchCast(caster, victim);
        for (int i = -5; i < 5; i++) {
            for (int j = -5; j < 5; j++) {
                for (int k = -5; k < 5; k++) {
                    if(k==4 || j==4 || i==4 || i==-5 || j==-5 || k==-5)
                    {
                        if(caster.world.getBlockState(victim.getBlockPos().add(i,j,k)).isAir())
                        {
                            caster.world.setBlockState(victim.getBlockPos().add(i,j,k), Blocks.FIRE.getDefaultState());
                        }
                    }
                }
            }
        }
    }
}
