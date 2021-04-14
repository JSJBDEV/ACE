package gd.rf.acro.ace;

import gd.rf.acro.ace.blocks.BurntRedstoneBlock;
import gd.rf.acro.ace.blocks.FleetingBlock;
import gd.rf.acro.ace.blocks.SeepingIceBlock;
import gd.rf.acro.ace.blocks.TrapBlock;
import gd.rf.acro.ace.effects.*;
import gd.rf.acro.ace.entities.BoltEntity;
import gd.rf.acro.ace.items.*;
import gd.rf.acro.ace.spells.AirTrapSpell;
import gd.rf.acro.ace.spells.EarthLaunchSpell;
import gd.rf.acro.ace.spells.PushSpell;
import gd.rf.acro.ace.spells.Spells;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.Tag;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ACE implements ModInitializer {

	public static final Tag<Block> INCINERATABLE = TagRegistry.block(new Identifier("ace","incineratable"));
	public static Logger LOGGER = LogManager.getLogger();
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		registerItems();
		registerBlocks();
		registerEffects();

		ServerPlayNetworking.registerGlobalReceiver(ACE.SCROLL_PACKET,(server,serverPlayerEntity,serverPlayNetworkHandler,packetByteBuf,packetSender)->
		{
			if(serverPlayerEntity.getMainHandStack().getItem() instanceof SimpleCastingItem)
			{
				int scroll = packetByteBuf.readInt();
				SimpleCastingItem spellBook = (SimpleCastingItem) serverPlayerEntity.getMainHandStack().getItem();
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

		LOGGER.log(Level.INFO,Spells.REGISTRY.size()+" spells loaded into ACE, let's go!");
		LOGGER.log(Level.INFO,"Ready to do some good ol' book magic?");

	}


	public static final SpellScrollItem SPELL_SCROLL_ITEM_0 = new SpellScrollItem(new Item.Settings().group(ItemGroup.MISC),new EarthLaunchSpell());
	public static final SpellScrollItem SPELL_SCROLL_ITEM_1 = new SpellScrollItem(new Item.Settings().group(ItemGroup.MISC),new PushSpell(0.5));
	public static final SpellScrollItem SPELL_SCROLL_ITEM_2 = new SpellScrollItem(new Item.Settings().group(ItemGroup.MISC),new AirTrapSpell());
	public static final SimpleCastingItem MASTER_SPELL_BOOK = new SimpleCastingItem(new Item.Settings().group(ItemGroup.MISC),100,100,1);
	public static final SimpleCastingItem BASIC_WAND = new SimpleCastingItem(new Item.Settings().group(ItemGroup.MISC),20,5,1);
	public static final EarthenPickaxe EARTHEN_PICKAXE = new EarthenPickaxe(1,-2.8f,new Item.Settings().group(ItemGroup.MISC));
	public static final IceSpikeSword ICE_SPIKE_SWORD = new IceSpikeSword(3,-2,new Item.Settings().group(ItemGroup.MISC));
	public static final TestItem TEST_ITEM = new TestItem(new Item.Settings().group(ItemGroup.MISC));
	public static final SpellCompendium SPELL_COMPENDIUM = new SpellCompendium(new Item.Settings().group(ItemGroup.MISC));
	public static final DustyTomeItem DUSTY_TOME_ITEM =new DustyTomeItem(new Item.Settings().group(ItemGroup.MISC));

	public void registerItems()
	{
		Registry.register(Registry.ITEM,new Identifier("ace","spell_scroll_0"),SPELL_SCROLL_ITEM_0);
		Registry.register(Registry.ITEM,new Identifier("ace","spell_scroll_1"),SPELL_SCROLL_ITEM_1);
		Registry.register(Registry.ITEM,new Identifier("ace","spell_scroll_2"),SPELL_SCROLL_ITEM_2);
		Registry.register(Registry.ITEM,new Identifier("ace","master_spellbook"),MASTER_SPELL_BOOK);
		Registry.register(Registry.ITEM,new Identifier("ace","earthen_pickaxe"),EARTHEN_PICKAXE);
		Registry.register(Registry.ITEM,new Identifier("ace","ice_spike"),ICE_SPIKE_SWORD);
		Registry.register(Registry.ITEM,new Identifier("ace","test_item"),TEST_ITEM);
		Registry.register(Registry.ITEM,new Identifier("ace","spell_compendium"),SPELL_COMPENDIUM);
		Registry.register(Registry.ITEM,new Identifier("ace","dusty_tome"),DUSTY_TOME_ITEM);
		Registry.register(Registry.ITEM,new Identifier("ace","basic_wand"),BASIC_WAND);
	}

	public static final TrapBlock FIRE_TRAP_BLOCK = new TrapBlock(AbstractBlock.Settings.of(Material.PLANT).luminance((e)->4),"fire");
	public static final TrapBlock AIR_TRAP_BLOCK = new TrapBlock(AbstractBlock.Settings.of(Material.PLANT).luminance((e)->4),"air");
	public static final TrapBlock EARTH_TRAP_BLOCK = new TrapBlock(AbstractBlock.Settings.of(Material.PLANT).luminance((e)->4),"earth");
	public static final TrapBlock WATER_TRAP_BLOCK = new TrapBlock(AbstractBlock.Settings.of(Material.PLANT).luminance((e)->4),"water");
	public static final FleetingBlock FLEETING_DIRT = new FleetingBlock(AbstractBlock.Settings.of(Material.PLANT));
	public static final FleetingBlock FLEETING_ICE = new FleetingBlock(AbstractBlock.Settings.of(Material.GLASS).nonOpaque().solidBlock((a,b,c)->false).suffocates((a,b,c)->false).blockVision((a,b,c)->false));
	public static final FleetingBlock MAGIC_BLOCK = new FleetingBlock(AbstractBlock.Settings.of(Material.GLASS).nonOpaque().solidBlock((a,b,c)->false).suffocates((a,b,c)->false).blockVision((a,b,c)->false).strength(-1,3600000.0F).luminance(i->10),1000);
	//LATER: In 1.17 this should be unnecessary
	public static final Block LIGHT_BLOCK = new Block(AbstractBlock.Settings.of(Material.BARRIER).nonOpaque().noCollision().luminance((a)->15));
	public static final SeepingIceBlock SEEPING_ICE_BLOCK = new SeepingIceBlock(AbstractBlock.Settings.of(Material.ICE));
	public static final BurntRedstoneBlock BURNT_REDSTONE_BLOCK = new BurntRedstoneBlock(AbstractBlock.Settings.of(Material.REDSTONE_LAMP).noCollision().nonOpaque());
	public void registerBlocks()
	{
		Registry.register(Registry.BLOCK,new Identifier("ace","fire_trap"),FIRE_TRAP_BLOCK);
		Registry.register(Registry.BLOCK,new Identifier("ace","air_trap"),AIR_TRAP_BLOCK);
		Registry.register(Registry.BLOCK,new Identifier("ace","water_trap"),WATER_TRAP_BLOCK);
		Registry.register(Registry.BLOCK,new Identifier("ace","earth_trap"),EARTH_TRAP_BLOCK);
		Registry.register(Registry.BLOCK,new Identifier("ace","fleeting_dirt"),FLEETING_DIRT);
		Registry.register(Registry.BLOCK,new Identifier("ace","fleeting_ice"),FLEETING_ICE);
		Registry.register(Registry.BLOCK,new Identifier("ace","magic_block"),MAGIC_BLOCK);
		Registry.register(Registry.BLOCK,new Identifier("ace","light_block"),LIGHT_BLOCK);
		Registry.register(Registry.BLOCK,new Identifier("ace","seeping_ice"),SEEPING_ICE_BLOCK);
		Registry.register(Registry.BLOCK,new Identifier("ace","burnt_redstone"),BURNT_REDSTONE_BLOCK);
	}

	public static final EntangledEffect ENTANGLED_EFFECT = new EntangledEffect(StatusEffectType.HARMFUL, Formatting.GREEN.getColorValue());
	public static final WindCallEffect WIND_CALL_EFFECT = new WindCallEffect(StatusEffectType.BENEFICIAL,Formatting.AQUA.getColorValue());
	public static final SecondChanceEffect SECOND_CHANCE_EFFECT = new SecondChanceEffect(StatusEffectType.BENEFICIAL,Formatting.WHITE.getColorValue());
	public static final FreezeEffect FREEZE_EFFECT = new FreezeEffect(StatusEffectType.HARMFUL,Formatting.BLUE.getColorValue());
	public static final NoSpellEffect NO_SPELL_EFFECT = new NoSpellEffect(StatusEffectType.HARMFUL,Formatting.RED.getColorValue());
	public void registerEffects()
	{
		Registry.register(Registry.STATUS_EFFECT,new Identifier("ace","entangled"),ENTANGLED_EFFECT);
		Registry.register(Registry.STATUS_EFFECT,new Identifier("ace","wind_call"),WIND_CALL_EFFECT);
		Registry.register(Registry.STATUS_EFFECT,new Identifier("ace","second_chance"),SECOND_CHANCE_EFFECT);
		Registry.register(Registry.STATUS_EFFECT,new Identifier("ace","freeze"),FREEZE_EFFECT);
		Registry.register(Registry.STATUS_EFFECT,new Identifier("ace","no_spells"),NO_SPELL_EFFECT);
	}

	public static final EntityType<BoltEntity> BOLT_ENTITY_TYPE =registerEntity("bolt",SpawnGroup.MISC,EntityDimensions.changing(0.5f,0.5f),((type, world) -> new BoltEntity(world)));

	public static <T extends Entity> EntityType<T> registerEntity(String name, SpawnGroup category, EntityDimensions size, EntityType.EntityFactory<T> factory) {
		return Registry.register(Registry.ENTITY_TYPE, new Identifier("ace", name), net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder.create(category, factory).size(size).build());
	}

	public static final Identifier SCROLL_PACKET = new Identifier("ace","scroll_packet");


}
