package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;

public class DeadlockSpell extends Spell {
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
        return 2;
    }

    @Override
    public int cost() {
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
