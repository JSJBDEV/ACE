package gd.rf.acro.ace.spells;

import dev.louis.nebula.spell.SpellType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public abstract class TapBlockSpell extends SpellACE {
    private BlockPos blockPos;
    private Direction direction;
    public TapBlockSpell(SpellType<?> spellType, PlayerEntity caster) {
        super(spellType, caster);
    }

    public BlockPos getBlockPos() {
        return blockPos;
    }

    public void setBlockPos(BlockPos blockPos) {
        this.blockPos = blockPos;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
