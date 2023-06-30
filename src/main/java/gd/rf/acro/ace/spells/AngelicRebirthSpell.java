package gd.rf.acro.ace.spells;

import dev.louis.nebula.spell.SpellType;
import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class AngelicRebirthSpell extends TouchEntitySpell {
    public AngelicRebirthSpell(SpellType<?> spellType, PlayerEntity caster) {
        super(spellType, caster);
    }

    @Override
    public void cast() {

    }

    @Override
    public void onTouchCast(LivingEntity caster, LivingEntity victim) {
        super.onTouchCast(caster, victim);
        victim.addStatusEffect(new StatusEffectInstance(ACE.SECOND_CHANCE_EFFECT,99999));
        victim.addStatusEffect(new StatusEffectInstance(ACE.WIND_CALL_EFFECT,99999));
        victim.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,99999));
    }
}
