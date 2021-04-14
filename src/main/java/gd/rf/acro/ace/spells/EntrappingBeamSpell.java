package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;

public class EntrappingBeamSpell extends Spell {
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
        return 2;
    }

    @Override
    public int cost() {
        return 50;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        LivingEntity hit = Utils.castBeam(caster,caster.world,new float[]{1,1,0},2);
        if(hit!=null)
        {
            for (int i = -5; i < 5; i++) {
                for (int j = -5; j < 5; j++) {
                    for (int k = -5; k < 5; k++) {
                        if(k==4 || j==4 || i==4 || i==-5 || j==-5 || k==-5)
                        {
                            if(caster.world.getBlockState(hit.getBlockPos().add(i,j,k)).isAir())
                            {
                                caster.world.setBlockState(hit.getBlockPos().add(i,j,k), ACE.MAGIC_BLOCK.getDefaultState());
                            }
                        }
                    }
                }
            }
        }
    }
}
