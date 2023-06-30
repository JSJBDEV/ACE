package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.Utils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class PoisonBeamSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "snap";
    }

    @Override
    public Element getElement() {
        return EARTH
    }

    @Override
    public int getTier() {
        return 0;
    }

    @Override
    public int getManaCost() {
        return 5;
    }
    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        LivingEntity hit = Utils.castBeam(caster,caster.getWorld(),new float[]{0,1,0},2);
        if(hit!=null) {
            Utils.createAOE(caster.getWorld(),hit.getBlockPos(),Utils.getColourForElement(Element.EARTH),new StatusEffectInstance(StatusEffects.POISON,200));
        }
    }
}
