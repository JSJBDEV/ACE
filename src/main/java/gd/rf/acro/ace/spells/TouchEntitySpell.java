package gd.rf.acro.ace.spells;

import dev.louis.nebula.spell.SpellType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public abstract class TouchEntitySpell extends SpellACE {
    private LivingEntity victim;
    public TouchEntitySpell(SpellType<?> spellType, PlayerEntity caster) {
        super(spellType, caster);
    }


    public LivingEntity getVictim() {
        return victim;
    }

    public void setVictim(LivingEntity victim) {
        this.victim = victim;
    }
}
