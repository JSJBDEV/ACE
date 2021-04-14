package gd.rf.acro.ace.spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class ConjureDubstep extends Spell {
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
        return 0;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        caster.playSound(SoundEvents.MUSIC_DISC_PIGSTEP,1,1);
    }
}
