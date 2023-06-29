package gd.rf.acro.ace.spells;

import dev.louis.nebula.spell.SpellType;
import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

public class AirTrapSpell extends TapBlockSpell {
    public AirTrapSpell(SpellType<?> spellType, PlayerEntity caster) {
        super(spellType, caster);
    }

    @Override
    public void cast() {
        final var world = getCaster().getWorld();
        if(world.getBlockState(getBlockPos().up()).isAir()) {
            world.setBlockState(getBlockPos().up(), ACE.AIR_TRAP_BLOCK.getDefaultState());
        }
    }
}
