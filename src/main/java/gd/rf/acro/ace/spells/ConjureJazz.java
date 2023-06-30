package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundEvents;

public class ConjureJazz extends SpellACE {
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
        return 0;
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        caster.playSound(SoundEvents.MUSIC_DISC_STAL,1,1);
    }
}
