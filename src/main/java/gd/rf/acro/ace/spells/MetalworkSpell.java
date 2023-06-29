package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.tag.BlockTags;

public class MetalworkSpell extends Spell {
    @Override
    public String spellType() {
        return "snap";
    }

    @Override
    public String element() {
        return "fire";
    }

    @Override
    public int tier() {
        return 0;
    }

    @Override
    public int cost() {
        return 5;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        if(caster.getOffHandStack().isIn(ACE.METALWORKABLE))
        {

            caster.getOffHandStack().setDamage(caster.getOffHandStack().getDamage()-5);
        }
    }
}
