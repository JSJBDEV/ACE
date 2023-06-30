package gd.rf.acro.ace;

import gd.rf.acro.ace.blocks.BurntRedstoneBlock;
import gd.rf.acro.ace.blocks.FleetingBlock;
import gd.rf.acro.ace.blocks.SeepingIceBlock;
import gd.rf.acro.ace.blocks.TrapBlock;
import gd.rf.acro.ace.effects.*;
import gd.rf.acro.ace.entities.BoltEntity;
import gd.rf.acro.ace.entities.EvilMageEntity;
import gd.rf.acro.ace.items.*;
import gd.rf.acro.ace.spells.SpellACE;
import gd.rf.acro.ace.spells.Spells;
import gd.rf.acro.ace.spells.SpellsOld;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class ACE implements ModInitializer {

	private static final List<Identifier> tables = Arrays.asList(
			LootTables.BURIED_TREASURE_CHEST,
			LootTables.STRONGHOLD_LIBRARY_CHEST,
			LootTables.HERO_OF_THE_VILLAGE_CLERIC_GIFT_GAMEPLAY,
			LootTables.DESERT_PYRAMID_CHEST,
			LootTables.JUNGLE_TEMPLE_CHEST);

	public static final TagKey<Block> INCINERATABLE = TagKey.of(Registries.BLOCK.getKey(), new Identifier("ace", "incineratable"));
	public static final TagKey<Item> METALWORKABLE =  TagKey.of(Registries.ITEM.getKey(),new Identifier("ace","metalworkable"));
	public static Logger LOGGER = LogManager.getLogger();
	public static final ItemGroup TAB = FabricItemGroup.builder()
			.displayName(Text.of("itemGroup.ace.tab"))
			.icon(()-> new ItemStack(ACE.MASTER_SPELL_BOOK)).build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Spells.init();
		Registry.register(Registries.ITEM_GROUP, new Identifier("ace", "aceitems"), TAB);
		registerItems();
		registerBlocks();
		registerEffects();


		registerEntityThings();
		ServerPlayNetworking.registerGlobalReceiver(ACE.SCROLL_PACKET,(server,serverPlayerEntity,serverPlayNetworkHandler,packetByteBuf,packetSender)->
		{
			if(serverPlayerEntity.getMainHandStack().getItem() instanceof IRenderableCastingDevice)
			{
				int scroll = packetByteBuf.readInt();
				IRenderableCastingDevice spellBook = (IRenderableCastingDevice) serverPlayerEntity.getMainHandStack().getItem();
				serverPlayerEntity.playSound(SoundEvents.BLOCK_DISPENSER_FAIL,1,1);
				if(scroll<0)
				{
					spellBook.scrollMinus(serverPlayerEntity.getMainHandStack());
				}
				else
				{
					spellBook.scrollPlus(serverPlayerEntity.getMainHandStack());
				}

			}
		});

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (tables.contains(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(ACE.DUSTY_TOME_ITEM).weight(10).build())
						.with(ItemEntry.builder(ACE.BASIC_WAND).weight(5).build())
						.with(ItemEntry.builder(ACE.CASTING_ORB).weight(1).build())
						.with(ItemEntry.builder(ACE.GRIMOIRE).weight(1).build())
						.with(ItemEntry.builder(ACE.DEMONS_KATAR).weight(1).build());

				tableBuilder.pool(poolBuilder);
			}
		});

		ItemGroupEvents.modifyEntriesEvent(Registries.ITEM_GROUP.getKey(TAB).get()).register(content -> {
			content.add(MASTER_SPELL_BOOK);
			content.add(BASIC_WAND);
			content.add(CASTING_ORB);
			content.add(GRIMOIRE);
			content.add(DEMONS_KATAR);
			content.add(EARTHEN_PICKAXE);
			content.add(ICE_SPIKE_SWORD);
			content.add(TEST_ITEM);
			content.add(SPELL_COMPENDIUM);
			content.add(DUSTY_TOME_ITEM);
		});

		LOGGER.log(Level.INFO, SpellsOld.REGISTRY.size()+" spells loaded into ACE, let's go!");
		LOGGER.log(Level.INFO, SpellsOld.getNerdStats());
		LOGGER.log(Level.INFO,"Ready to do some good ol' book magic?");

	}



	public static final SimpleCastingItem MASTER_SPELL_BOOK = new SimpleCastingItem(new Item.Settings(),100,100,1);
	public static final SimpleCastingItem BASIC_WAND = new SimpleCastingItem(new Item.Settings(),20,5,1);
	public static final SimpleCastingItem CASTING_ORB = new SimpleCastingItem(new Item.Settings(),30,5,2);
	public static final ManalessCastingItem GRIMOIRE = new ManalessCastingItem(new Item.Settings(),5);
	public static final ManalessCastingItem DEMONS_KATAR = new ManalessCastingItem(new Item.Settings(),5);
	public static final EarthenPickaxe EARTHEN_PICKAXE = new EarthenPickaxe(1,-2.8f,new Item.Settings());
	public static final IceSpikeSword ICE_SPIKE_SWORD = new IceSpikeSword(3,-2,new Item.Settings());
	public static final TestItem TEST_ITEM = new TestItem(new Item.Settings());
	public static final SpellCompendium SPELL_COMPENDIUM = new SpellCompendium(new Item.Settings());
	public static final DustyTomeItem DUSTY_TOME_ITEM =new DustyTomeItem(new Item.Settings());

	public void registerItems() {
		Registry.register(Registries.ITEM,new Identifier("ace","master_spellbook"),MASTER_SPELL_BOOK);
		Registry.register(Registries.ITEM,new Identifier("ace","earthen_pickaxe"),EARTHEN_PICKAXE);
		Registry.register(Registries.ITEM,new Identifier("ace","ice_spike"),ICE_SPIKE_SWORD);
		Registry.register(Registries.ITEM,new Identifier("ace","test_item"),TEST_ITEM);
		Registry.register(Registries.ITEM,new Identifier("ace","spell_compendium"),SPELL_COMPENDIUM);
		Registry.register(Registries.ITEM,new Identifier("ace","dusty_tome"),DUSTY_TOME_ITEM);
		Registry.register(Registries.ITEM,new Identifier("ace","basic_wand"),BASIC_WAND);
		Registry.register(Registries.ITEM,new Identifier("ace","casting_orb"),CASTING_ORB);
		Registry.register(Registries.ITEM,new Identifier("ace","grimoire"),GRIMOIRE);
		Registry.register(Registries.ITEM,new Identifier("ace","demons_katar"),DEMONS_KATAR);
	}

	//TODO: Fix
	public static final TrapBlock FIRE_TRAP_BLOCK = new TrapBlock(AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY).luminance((e)->4), SpellACE.Element.FIRE);
	public static final TrapBlock AIR_TRAP_BLOCK = new TrapBlock(AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY).luminance((e)->4), SpellACE.Element.AIR);
	public static final TrapBlock EARTH_TRAP_BLOCK = new TrapBlock(AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY).luminance((e)->4), SpellACE.Element.EARTH);
	public static final TrapBlock WATER_TRAP_BLOCK = new TrapBlock(AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY).luminance((e)->4), SpellACE.Element.WATER);
	public static final FleetingBlock FLEETING_DIRT = new FleetingBlock(AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY));
	public static final FleetingBlock FLEETING_ICE = new FleetingBlock(AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY).nonOpaque().solidBlock((a,b,c)->false).suffocates((a,b,c)->false).blockVision((a,b,c)->false));
	public static final FleetingBlock MAGIC_BLOCK = new FleetingBlock(AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY).nonOpaque().solidBlock((a,b,c)->false).suffocates((a,b,c)->false).blockVision((a,b,c)->false).strength(-1,3600000.0F).luminance(i->10),1000);
	//LATER: In 1.17 this should be unnecessary NOW: It is
	//public static final Block LIGHT_BLOCK = new Block(AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.IGNORE).nonOpaque().noCollision().luminance((a)->15));
	public static final SeepingIceBlock SEEPING_ICE_BLOCK = new SeepingIceBlock(AbstractBlock.Settings.copy(Blocks.ICE).ticksRandomly());
	public static final BurntRedstoneBlock BURNT_REDSTONE_BLOCK = new BurntRedstoneBlock(AbstractBlock.Settings.copy(Blocks.REDSTONE_BLOCK).noCollision().nonOpaque());
	public void registerBlocks()
	{
		Registry.register(Registries.BLOCK,new Identifier("ace","fire_trap"),FIRE_TRAP_BLOCK);
		Registry.register(Registries.BLOCK,new Identifier("ace","air_trap"),AIR_TRAP_BLOCK);
		Registry.register(Registries.BLOCK,new Identifier("ace","water_trap"),WATER_TRAP_BLOCK);
		Registry.register(Registries.BLOCK,new Identifier("ace","earth_trap"),EARTH_TRAP_BLOCK);
		Registry.register(Registries.BLOCK,new Identifier("ace","fleeting_dirt"),FLEETING_DIRT);
		Registry.register(Registries.BLOCK,new Identifier("ace","fleeting_ice"),FLEETING_ICE);
		Registry.register(Registries.BLOCK,new Identifier("ace","magic_block"),MAGIC_BLOCK);
		//Registry.register(Registries.BLOCK,new Identifier("ace","light_block"),LIGHT_BLOCK);
		Registry.register(Registries.BLOCK,new Identifier("ace","seeping_ice"),SEEPING_ICE_BLOCK);
		Registry.register(Registries.BLOCK,new Identifier("ace","burnt_redstone"),BURNT_REDSTONE_BLOCK);
	}

	public static final EntangledEffect ENTANGLED_EFFECT = new EntangledEffect(StatusEffectCategory.HARMFUL, Formatting.GREEN.getColorValue());
	public static final WindCallEffect WIND_CALL_EFFECT = new WindCallEffect(StatusEffectCategory.BENEFICIAL,Formatting.AQUA.getColorValue());
	public static final SecondChanceEffect SECOND_CHANCE_EFFECT = new SecondChanceEffect(StatusEffectCategory.BENEFICIAL,Formatting.WHITE.getColorValue());
	public static final FreezeEffect FREEZE_EFFECT = new FreezeEffect(StatusEffectCategory.HARMFUL,Formatting.BLUE.getColorValue());
	public static final NoSpellEffect NO_SPELL_EFFECT = new NoSpellEffect(StatusEffectCategory.HARMFUL,Formatting.RED.getColorValue());
	public static final UndeadenedEffect UNDEADENED_EFFECT = new UndeadenedEffect(StatusEffectCategory.HARMFUL,Formatting.RED.getColorValue());
	public static final AerialEffect AERIAL_EFFECT = new AerialEffect(StatusEffectCategory.BENEFICIAL,Formatting.WHITE.getColorValue());
	public static final DoomsdayEffect DOOMSDAY_EFFECT = new DoomsdayEffect(StatusEffectCategory.HARMFUL,Formatting.BLACK.getColorValue());
	public void registerEffects() {
		Registry.register(Registries.STATUS_EFFECT,new Identifier("ace","entangled"),ENTANGLED_EFFECT);
		Registry.register(Registries.STATUS_EFFECT,new Identifier("ace","wind_call"),WIND_CALL_EFFECT);
		Registry.register(Registries.STATUS_EFFECT,new Identifier("ace","second_chance"),SECOND_CHANCE_EFFECT);
		Registry.register(Registries.STATUS_EFFECT,new Identifier("ace","freeze"),FREEZE_EFFECT);
		Registry.register(Registries.STATUS_EFFECT,new Identifier("ace","no_spells"),NO_SPELL_EFFECT);
		Registry.register(Registries.STATUS_EFFECT,new Identifier("ace","undeadened"),UNDEADENED_EFFECT);
		Registry.register(Registries.STATUS_EFFECT,new Identifier("ace","aerial"),AERIAL_EFFECT);
		Registry.register(Registries.STATUS_EFFECT,new Identifier("ace","doomsday"),DOOMSDAY_EFFECT);
	}

	public static final EntityType<BoltEntity> BOLT_ENTITY_TYPE =registerEntity("bolt",SpawnGroup.MISC,EntityDimensions.changing(0.5f,0.5f),((type, world) -> new BoltEntity(world)));
	public static final EntityType<EvilMageEntity> EVIL_MAGE_ENTITY_TYPE = registerEntity("evil_mage",SpawnGroup.MONSTER,EntityDimensions.changing(0.6f,1.7f),((type, world) -> new EvilMageEntity(world)));

	public static <T extends Entity> EntityType<T> registerEntity(String name, SpawnGroup category, EntityDimensions size, EntityType.EntityFactory<T> factory) {
		return Registry.register(Registries.ENTITY_TYPE, new Identifier("ace", name), FabricEntityTypeBuilder.create(category, factory).dimensions(size).build());
	}

	//Things like attributes for alive things and spawning (things)
	public void registerEntityThings() {
		FabricDefaultAttributeRegistry.register(ACE.EVIL_MAGE_ENTITY_TYPE,EvilMageEntity.attributes());
		BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD), SpawnGroup.MONSTER, ACE.EVIL_MAGE_ENTITY_TYPE, 5, 1, 3);

	}

	public static final Identifier SCROLL_PACKET = new Identifier("ace","scroll_packet");



}
