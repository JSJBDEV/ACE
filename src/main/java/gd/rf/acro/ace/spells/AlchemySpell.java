package gd.rf.acro.ace.spells;

import dev.louis.nebula.spell.SpellType;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

public class AlchemySpell extends TapBlockSpell {
    public AlchemySpell(SpellType<?> spellType, PlayerEntity caster) {
        super(spellType, caster);
    }

    @Override
    public void cast() {
        final var world = getCaster().getWorld();
        if(world.getBlockState(getBlockPos()).getBlock()== Blocks.GLOWSTONE) {
            world.setBlockState(getBlockPos(),Blocks.GOLD_BLOCK.getDefaultState());
        }
    }
}
