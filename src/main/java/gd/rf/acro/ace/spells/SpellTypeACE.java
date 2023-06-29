package gd.rf.acro.ace.spells;

import dev.louis.nebula.spell.Spell;
import dev.louis.nebula.spell.SpellType;
import net.minecraft.entity.player.PlayerEntity;

public class SpellTypeACE<T extends SpellACE> extends dev.louis.nebula.spell.SpellType<T> {
    private final SpellACE.Element element;
    private final SpellACE.CastingType castingType;
    private final int tier;
    public SpellTypeACE(SpellFactory factory, int manaCost, SpellACE.Element element, SpellACE.CastingType castingType, int tier) {
        super(factory, manaCost);
        this.element = element;
        this.castingType = castingType;
        this.tier = tier;
    }

    public SpellACE.Element getElement() {
        return element;
    }

    public SpellACE.CastingType getCastingType() {
        return castingType;
    }

    public int getTier() {
        return tier;
    }
}
