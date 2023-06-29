package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;

public class DeadlockSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "touch";
    }

    @Override
    public Element getElement() {
        return Element.EARTH
    }

    @Override
    public int getTier() {
        return 2;
    }

    @Override
    public int getManaCost() {
        return 30;
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
                            caster.world.setBlockState(victim.getBlockPos().add(i,j,k), ACE.MAGIC_BLOCK.getDefaultState());
                        }
                    }
                }
            }
        }
    }
}
