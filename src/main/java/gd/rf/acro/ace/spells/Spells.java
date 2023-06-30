package gd.rf.acro.ace.spells;

import dev.louis.nebula.Nebula;
import dev.louis.nebula.spell.SpellType;
import gd.rf.acro.ace.spells.SpellACE.Element;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Spells {
    public static void init(){}
    public static SpellType<?> AIR_TRAP = register(AirTrapSpell::new, Element.AIR, SpellACE.CastingType.TAP,10, 0, id("air_trap"));
    public static SpellType<?> ALCHEMY = register(AlchemySpell::new, Element.EARTH, SpellACE.CastingType.TAP,0, 0, id("alchemy"));
    public static SpellType<?> AngelicRebirth = register(AngelicRebirthSpell::new, Element.FIRE, SpellACE.CastingType.TOUCH,50, 2, id("angelic_rebirth"));


    private static SpellTypeACE<?> register(SpellType.SpellFactory<SpellACE> spellFactory, Element element, SpellACE.CastingType castingType,int manaCost, int tier, Identifier id) {
        SpellTypeACE<? extends SpellACE> spellTypeACE = new SpellTypeACE<>(spellFactory, manaCost, element, castingType, tier);
        Registry.register(Nebula.NebulaRegistries.SPELL_TYPE, id, spellTypeACE);
        return spellTypeACE;
    }
    private static Identifier id(String path) {
        return new Identifier("asc", path);
    }
}
