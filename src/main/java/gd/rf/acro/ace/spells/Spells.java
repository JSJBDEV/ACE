package gd.rf.acro.ace.spells;

import java.util.ArrayList;
import java.util.List;

public class Spells {
    public static final AirTrapSpell AIR_TRAP_SPELL = new AirTrapSpell();
    public static final AlchemySpell ALCHEMY_SPELL = new AlchemySpell();
    public static final BalanceHydrationSpell BALANCE_HYDRATION_SPELL = new BalanceHydrationSpell();
    public static final BurySpell BURY_SPELL = new BurySpell();
    public static final ConjureFireSpell CONJURE_FIRE_SPELL = new ConjureFireSpell();
    public static final DodgeSpell DODGE_SPELL = new DodgeSpell();
    public static final EarthLaunchSpell EARTH_LAUNCH_SPELL = new EarthLaunchSpell();
    public static final EarthTrapSpell EARTH_TRAP_SPELL = new EarthTrapSpell();
    public static final EmberSpell EMBER_SPELL = new EmberSpell();
    public static final FireTrapSpell FIRE_TRAP_SPELL = new FireTrapSpell();
    public static final GrappleSpell GRAPPLE_SPELL = new GrappleSpell();
    public static final HeroSpell HERO_SPELL = new HeroSpell();
    public static final IceShardSpell ICE_SHARD_SPELL = new IceShardSpell();
    public static final LeafShotSpell LEAF_SHOT_SPELL = new LeafShotSpell();
    public static final MineSpell MINE_SPELL = new MineSpell();
    public static final PushSpell PUSH_SPELL = new PushSpell(1);
    public static final PushSpell THROW_SPELL = new PushSpell(3);
    public static final ReformSpell REFORM_SPELL = new ReformSpell();
    public static final ResonantFlameSpell RESONANT_FLAME_SPELL = new ResonantFlameSpell();
    public static final SnareSpell SNARE_SPELL = new SnareSpell();
    public static final SonicBoomSpell SONIC_BOOM_SPELL = new SonicBoomSpell();
    public static final SqueezeSpell SQUEEZE_SPELL = new SqueezeSpell();
    public static final SummonRainSpell SUMMON_RAIN_SPELL = new SummonRainSpell();
    public static final WaterTrapSpell WATER_TRAP_SPELL = new WaterTrapSpell();
    public static final WindCallSpell WIND_CALL_SPELL = new WindCallSpell(100);
    public static final ChainLightningSpell CHAIN_LIGHTNING_SPELL = new ChainLightningSpell();
    public static final SlowFallSpell SLOW_FALL_SPELL = new SlowFallSpell();
    public static final ExtractNutrientsSpell EXTRACT_NUTRIENTS_SPELL = new ExtractNutrientsSpell();
    public static final CreateIceSpikeSpell CREATE_ICE_SPIKE_SPELL = new CreateIceSpikeSpell();
    public static final CreatePickaxeSpell CREATE_PICKAXE_SPELL = new CreatePickaxeSpell();
    public static final HealingTouchSpell HEALING_TOUCH_SPELL = new HealingTouchSpell();
    public static final HealingHandSpell HEALING_HAND_SPELL = new HealingHandSpell();
    public static final SandAttackSpell SAND_ATTACK_SPELL = new SandAttackSpell();
    public static final HydroBeamSpell HYDRO_BEAM_SPELL = new HydroBeamSpell();
    public static final EntrappingBeamSpell ENTRAPPING_BEAM_SPELL = new EntrappingBeamSpell();
    public static final MagicPhaseSpell MAGIC_PHASE_SPELL = new MagicPhaseSpell();
    public static final TryAgainSpell TRY_AGAIN_SPELL = new TryAgainSpell();
    public static final AngelicRebirthSpell ANGELIC_REBIRTH_SPELL = new AngelicRebirthSpell();
    public static final SmiteSpell SMITE_SPELL = new SmiteSpell();
    public static final BlinkSpell BLINK_SPELL = new BlinkSpell();
    public static final QuickenSpell QUICKEN_SPELL = new QuickenSpell();
    public static final CaveSpell CAVE_SPELL = new CaveSpell();
    public static final HealSpell HEAL_SPELL = new HealSpell();
    public static final RecoverySpell RECOVERY_SPELL = new RecoverySpell();
    public static final SwitchBeamSpell SWITCH_BEAM_SPELL = new SwitchBeamSpell();
    public static final DeadlockSpell DEADLOCK_SPELL = new DeadlockSpell();
    public static final NoCastingSpell NO_CASTING_SPELL = new NoCastingSpell();
    public static final IncinerateSpell INCINERATE_SPELL =new IncinerateSpell();
    public static final RaiseIronGolemSpell RAISE_IRON_GOLEM_SPELL = new RaiseIronGolemSpell();
    public static final RaiseSnowGolemSpell RAISE_SNOW_GOLEM_SPELL = new RaiseSnowGolemSpell();
    public static final BedwardsSpell BEDWARDS_SPELL = new BedwardsSpell();
    public static final PilgrimageSpell PILGRIMAGE_SPELL =new PilgrimageSpell();
    public static final AscendSpell ASCEND_SPELL = new AscendSpell();
    public static final ConjureBlockSpell CONJURE_BLOCK_SPELL = new ConjureBlockSpell();
    public static final ConjureLightSpell CONJURE_LIGHT_SPELL = new ConjureLightSpell();
    public static final MagicTowerSpell MAGIC_TOWER_SPELL =new MagicTowerSpell();
    public static final DisarmSpell DISARM_SPELL = new DisarmSpell();
    public static final FlamethrowerSpell FLAMETHROWER_SPELL = new FlamethrowerSpell();
    public static final TornadoSpell TORNADO_SPELL =new TornadoSpell();
    public static final WitherSpell WITHER_SPELL = new WitherSpell();
    public static final ConjureJazz CONJURE_JAZZ = new ConjureJazz();
    public static final ConjureDubstep CONJURE_DUBSTEP =new ConjureDubstep();
    public static final RingOfFireSpell RING_OF_FIRE_SPELL = new RingOfFireSpell();
    public static final FreezeSpell FREEZE_SPELL = new FreezeSpell();
    public static final FrostSeedSpell FROST_SEED_SPELL = new FrostSeedSpell();
    public static final DisableRedstoneSpell DISABLE_REDSTONE_SPELL = new DisableRedstoneSpell();
    public static final SabotageRedstoneSpell SABOTAGE_REDSTONE_SPELL = new SabotageRedstoneSpell();
    public static final DrainSpell DRAIN_SPELL = new DrainSpell();
    public static final HeatResistSpell HEAT_RESIST_SPELL =new HeatResistSpell();
    public static final ShotgunSpell SHOTGUN_SPELL =new ShotgunSpell();
    public static final MagicSenseSpell MAGIC_SENSE_SPELL = new MagicSenseSpell();
    public static final DetobeamSpell DETOBEAM_SPELL = new DetobeamSpell();
    public static final UndeadCurseSpell UNDEAD_CURSE_SPELL = new UndeadCurseSpell();
    public static final LetThemBurnSpell LET_THEM_BURN_SPELL = new LetThemBurnSpell();
    public static final RefuseToDieSpell REFUSE_TO_DIE_SPELL = new RefuseToDieSpell();
    public static final RollSpell ROLL_SPELL = new RollSpell();
    public static final LeapSpell LEAP_SPELL = new LeapSpell();
    public static final VanishingActSpell VANISHING_ACT_SPELL = new VanishingActSpell();
    public static final UpdraftSpell UPDRAFT_SPELL = new UpdraftSpell();
    public static final PoisonBeamSpell POISON_BEAM_SPELL = new PoisonBeamSpell();
    public static final ThornRainSpell THORN_RAIN_SPELL = new ThornRainSpell();
    public static final SummonDoomedWolfSpell SUMMON_DOOMED_WOLF_SPELL = new SummonDoomedWolfSpell();
    public static final SummonDoomedCatSpell SUMMON_DOOMED_CAT_SPELL = new SummonDoomedCatSpell();
    public static final TouchOfDoomSpell TOUCH_OF_DOOM_SPELL = new TouchOfDoomSpell();
    public static final MementoSpell MEMENTO_SPELL = new MementoSpell();
    public static final SpiritWalkSpell SPIRIT_WALK_SPELL = new SpiritWalkSpell();
    public static final GillsSpell GILLS_SPELL = new GillsSpell();
    public static final PauseTimeSpell PAUSE_TIME_SPELL = new PauseTimeSpell();
    public static final RideSpell RIDE_SPELL = new RideSpell();
    public static final DisableMagicSpell DISABLE_MAGIC_SPELL = new DisableMagicSpell();
    public static final EscapeSpell ESCAPE_SPELL = new EscapeSpell();
    public static final HealosphereSpell HEALOSPHERE_SPELL = new HealosphereSpell();
    public static final MagicCoatSpell MAGIC_COAT_SPELL = new MagicCoatSpell();
    public static final MagicArmourSpell MAGIC_ARMOUR_SPELL = new MagicArmourSpell();
    public static final MetalworkSpell METALWORK_SPELL = new MetalworkSpell();
    public static final PartyTrickSpell PARTY_TRICK_SPELL = new PartyTrickSpell();
    public static final RocketSpell ROCKET_SPELL = new RocketSpell();


    public static ArrayList<Spell> REGISTRY = new ArrayList<>();

    static
    {
        REGISTRY.add(AIR_TRAP_SPELL);
        REGISTRY.add(ALCHEMY_SPELL);
        REGISTRY.add(BALANCE_HYDRATION_SPELL);
        REGISTRY.add(BURY_SPELL);
        REGISTRY.add(CONJURE_FIRE_SPELL);
        REGISTRY.add(DODGE_SPELL);
        REGISTRY.add(EARTH_LAUNCH_SPELL);
        REGISTRY.add(EARTH_TRAP_SPELL);
        REGISTRY.add(EMBER_SPELL);
        REGISTRY.add(FIRE_TRAP_SPELL);
        REGISTRY.add(GRAPPLE_SPELL);
        REGISTRY.add(HERO_SPELL);
        REGISTRY.add(ICE_SHARD_SPELL);
        REGISTRY.add(LEAF_SHOT_SPELL);
        REGISTRY.add(MINE_SPELL);
        REGISTRY.add(PUSH_SPELL);
        REGISTRY.add(REFORM_SPELL);
        REGISTRY.add(RESONANT_FLAME_SPELL);
        REGISTRY.add(SNARE_SPELL);
        REGISTRY.add(SONIC_BOOM_SPELL);
        REGISTRY.add(SQUEEZE_SPELL);
        REGISTRY.add(SUMMON_RAIN_SPELL);
        REGISTRY.add(WATER_TRAP_SPELL);
        REGISTRY.add(WIND_CALL_SPELL);
        REGISTRY.add(CHAIN_LIGHTNING_SPELL);
        REGISTRY.add(SLOW_FALL_SPELL);
        REGISTRY.add(EXTRACT_NUTRIENTS_SPELL);
        REGISTRY.add(CREATE_ICE_SPIKE_SPELL);
        REGISTRY.add(CREATE_PICKAXE_SPELL);
        REGISTRY.add(HEALING_HAND_SPELL);
        REGISTRY.add(SAND_ATTACK_SPELL);
        REGISTRY.add(HYDRO_BEAM_SPELL);
        REGISTRY.add(ENTRAPPING_BEAM_SPELL);
        REGISTRY.add(MAGIC_PHASE_SPELL);
        REGISTRY.add(TRY_AGAIN_SPELL);
        REGISTRY.add(ANGELIC_REBIRTH_SPELL);
        REGISTRY.add(SMITE_SPELL);
        REGISTRY.add(THROW_SPELL);
        REGISTRY.add(BLINK_SPELL);
        REGISTRY.add(QUICKEN_SPELL);
        REGISTRY.add(CAVE_SPELL);
        REGISTRY.add(HEAL_SPELL);
        REGISTRY.add(SWITCH_BEAM_SPELL);
        REGISTRY.add(HEALING_TOUCH_SPELL);
        REGISTRY.add(RECOVERY_SPELL);
        REGISTRY.add(DEADLOCK_SPELL);
        REGISTRY.add(NO_CASTING_SPELL);
        REGISTRY.add(INCINERATE_SPELL);
        REGISTRY.add(RAISE_IRON_GOLEM_SPELL);
        REGISTRY.add(RAISE_SNOW_GOLEM_SPELL);
        REGISTRY.add(BEDWARDS_SPELL);
        REGISTRY.add(PILGRIMAGE_SPELL);
        REGISTRY.add(ASCEND_SPELL);
        REGISTRY.add(CONJURE_BLOCK_SPELL);
        REGISTRY.add(CONJURE_LIGHT_SPELL);
        REGISTRY.add(MAGIC_TOWER_SPELL);
        REGISTRY.add(DISARM_SPELL);
        REGISTRY.add(FLAMETHROWER_SPELL);
        REGISTRY.add(TORNADO_SPELL);
        REGISTRY.add(WITHER_SPELL);
        REGISTRY.add(CONJURE_JAZZ);
        REGISTRY.add(CONJURE_DUBSTEP);
        REGISTRY.add(RING_OF_FIRE_SPELL);
        REGISTRY.add(FREEZE_SPELL);
        REGISTRY.add(FROST_SEED_SPELL);
        REGISTRY.add(DISABLE_REDSTONE_SPELL);
        REGISTRY.add(SABOTAGE_REDSTONE_SPELL);
        REGISTRY.add(DRAIN_SPELL);
        REGISTRY.add(HEAT_RESIST_SPELL);
        REGISTRY.add(SHOTGUN_SPELL);
        REGISTRY.add(MAGIC_SENSE_SPELL);
        REGISTRY.add(DETOBEAM_SPELL);
        REGISTRY.add(UNDEAD_CURSE_SPELL);
        REGISTRY.add(LET_THEM_BURN_SPELL);
        REGISTRY.add(REFUSE_TO_DIE_SPELL);
        REGISTRY.add(LEAP_SPELL);
        REGISTRY.add(ROLL_SPELL);
        REGISTRY.add(VANISHING_ACT_SPELL);
        REGISTRY.add(UPDRAFT_SPELL);
        REGISTRY.add(POISON_BEAM_SPELL);
        REGISTRY.add(THORN_RAIN_SPELL);
        REGISTRY.add(SUMMON_DOOMED_CAT_SPELL);
        REGISTRY.add(SUMMON_DOOMED_WOLF_SPELL);
        REGISTRY.add(TOUCH_OF_DOOM_SPELL);
        REGISTRY.add(MEMENTO_SPELL);
        REGISTRY.add(SPIRIT_WALK_SPELL);
        REGISTRY.add(GILLS_SPELL);
        REGISTRY.add(PAUSE_TIME_SPELL);
        REGISTRY.add(RIDE_SPELL);
        REGISTRY.add(DISABLE_MAGIC_SPELL);
        REGISTRY.add(ESCAPE_SPELL);
        REGISTRY.add(HEALOSPHERE_SPELL);
        REGISTRY.add(MAGIC_COAT_SPELL);
        REGISTRY.add(MAGIC_ARMOUR_SPELL);
        REGISTRY.add(METALWORK_SPELL);
        REGISTRY.add(PARTY_TRICK_SPELL);
        REGISTRY.add(ROCKET_SPELL);

    }

    public static Spell getSpellByName(String name)
    {
        for (Spell spell : REGISTRY) {
            if (spell.name().equals(name)) {
                return spell;
            }
        }
        return null;
    }
    public static List<Spell> getSpellsByElement(String element)
    {
        List<Spell> spells = new ArrayList<>();
        REGISTRY.forEach(spell ->
        {
            if(spell.element().equals(element))
            {
                spells.add(spell);
            }
        });
        return spells;
    }
    public static List<Spell> getSpellsByTier(int tier)
    {
        List<Spell> spells = new ArrayList<>();
        REGISTRY.forEach(spell ->
        {
            if(spell.tier()==tier)
            {
                spells.add(spell);
            }
        });
        return spells;
    }
    public static List<Spell> getSpellsByStyle(String style)
    {
        List<Spell> spells = new ArrayList<>();
        REGISTRY.forEach(spell ->
        {
            if(spell.spellType().equals(style))
            {
                spells.add(spell);
            }
        });
        return spells;
    }

    public static String getNerdStats()
    {
        return "\nSnap spells: " + getSpellsByStyle("snap").size() +
                "\nTap spells: " + getSpellsByStyle("tap").size() +
                "\nTouch spells: " + getSpellsByStyle("touch").size() +
                "\n\nAir spells: " + getSpellsByElement("air").size() +
                "\nEarth spells: " + getSpellsByElement("earth").size() +
                "\nFire spells: " + getSpellsByElement("fire").size() +
                "\nWater spells: " + getSpellsByElement("water").size() +
                "\n\nTier 0 spells: " + getSpellsByTier(0).size() +
                "\nTier 1 spells: " + getSpellsByTier(1).size() +
                "\nTier 2 spells: " + getSpellsByTier(2).size();
    }


}
