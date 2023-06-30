package gd.rf.acro.ace.spells;

import dev.louis.nebula.Nebula;
import dev.louis.nebula.spell.SpellType;
import gd.rf.acro.ace.spells.SpellACE.Element;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Spells {
    public static void init(){}
    public static SpellType<?> AIR_TRAP = register(AirTrapSpell::new, 10, Element.AIR, SpellACE.CastingType.TAP, 0, id("air_trap"));
    public static SpellType<?> ALCHEMY = register(AlchemySpell::new, 0, Element.EARTH, SpellACE.CastingType.TAP, 0, id("alchemy"));
    public static SpellType<?> AngelicRebirth = register(AngelicRebirthSpell::new, 50, Element.FIRE, SpellACE.CastingType.TOUCH, 2, id("angelic_rebirth"));


    private static SpellTypeACE<?> register(SpellType.SpellFactory<SpellACE> spellFactory, int manaCost, Element element, SpellACE.CastingType castingType, int tier, Identifier id) {
        SpellTypeACE<? extends SpellACE> spellTypeACE = new SpellTypeACE<>(spellFactory, manaCost, element, castingType, tier);
        Registry.register(Nebula.NebulaRegistries.SPELL_TYPE, id, spellTypeACE);
        return spellTypeACE;
    }
    private static Identifier id(String path) {
        return new Identifier("asc", path);
    }
}
