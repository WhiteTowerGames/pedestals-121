package net.chris.pedestals.block;

import net.chris.pedestals.Pedestals121;
import net.chris.strippableblocksapi.StrippableCustomRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Oxidizable;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.*;

public class ModBlocks {

    public static final Block STONE_BRICK_PEDESTAL = registerBlock("stone_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(STONE_BRICKS).nonOpaque().requiresTool()));

    public static final Block DEEPSLATE_BRICK_PEDESTAL = registerBlock("deepslate_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(DEEPSLATE_BRICKS).nonOpaque().requiresTool()));

    public static final Block MOSSY_STONE_BRICK_PEDESTAL = registerBlock("mossy_stone_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(MOSSY_STONE_BRICKS).nonOpaque().requiresTool()));

    public static final Block DEEPSLATE_TILE_PEDESTAL = registerBlock( "deepslate_tile_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(DEEPSLATE_TILES).nonOpaque().requiresTool()));

    public static final Block POLISHED_GRANITE_PEDESTAL = registerBlock( "polished_granite_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(POLISHED_GRANITE).nonOpaque().requiresTool()));

    public static final Block POLISHED_DIORITE_PEDESTAL = registerBlock( "polished_diorite_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(POLISHED_DIORITE).nonOpaque().requiresTool()));

    public static final Block POLISHED_ANDESITE_PEDESTAL = registerBlock( "polished_andesite_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(POLISHED_ANDESITE).nonOpaque().requiresTool()));

    public static final Block POLISHED_DEEPSLATE_PEDESTAL = registerBlock( "polished_deepslate_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(POLISHED_DEEPSLATE).nonOpaque().requiresTool()));

    public static final Block CALCITE_PEDESTAL = registerBlock( "calcite_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(CALCITE).nonOpaque().requiresTool()));

    public static final Block COPPER_PEDESTAL = registerBlock( "copper_pedestal",
            new OxidizablePedestalBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.copy(COPPER_BLOCK).nonOpaque().requiresTool().ticksRandomly()));

    public static final Block EXPOSED_COPPER_PEDESTAL = registerBlock( "exposed_copper_pedestal",
            new OxidizablePedestalBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.copy(EXPOSED_COPPER).nonOpaque().requiresTool().ticksRandomly()));

    public static final Block WEATHERED_COPPER_PEDESTAL = registerBlock( "weathered_copper_pedestal",
            new OxidizablePedestalBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.copy(WEATHERED_COPPER).nonOpaque().requiresTool().ticksRandomly()));

    public static final Block OXIDIZED_COPPER_PEDESTAL = registerBlock( "oxidized_copper_pedestal",
            new OxidizablePedestalBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.copy(OXIDIZED_COPPER).nonOpaque().requiresTool().ticksRandomly()));

    public static final Block WAXED_COPPER_PEDESTAL = registerBlock( "waxed_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_COPPER_BLOCK).nonOpaque().requiresTool()));

    public static final Block WAXED_EXPOSED_COPPER_PEDESTAL = registerBlock( "waxed_exposed_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_EXPOSED_COPPER).nonOpaque().requiresTool()));

    public static final Block WAXED_WEATHERED_COPPER_PEDESTAL = registerBlock( "waxed_weathered_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_WEATHERED_COPPER).nonOpaque().requiresTool()));

    public static final Block WAXED_OXIDIZED_COPPER_PEDESTAL = registerBlock( "waxed_oxidized_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_OXIDIZED_COPPER).nonOpaque().requiresTool()));

    public static final Block CUT_COPPER_PEDESTAL = registerBlock( "cut_copper_pedestal",
            new OxidizablePedestalBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.copy(CUT_COPPER).nonOpaque().requiresTool().ticksRandomly()));

    public static final Block EXPOSED_CUT_COPPER_PEDESTAL = registerBlock( "exposed_cut_copper_pedestal",
            new OxidizablePedestalBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.copy(EXPOSED_CUT_COPPER).nonOpaque().requiresTool().ticksRandomly()));

    public static final Block WEATHERED_CUT_COPPER_PEDESTAL = registerBlock( "weathered_cut_copper_pedestal",
            new OxidizablePedestalBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.copy(WEATHERED_CUT_COPPER).nonOpaque().requiresTool().ticksRandomly()));

    public static final Block OXIDIZED_CUT_COPPER_PEDESTAL = registerBlock( "oxidized_cut_copper_pedestal",
            new OxidizablePedestalBlock(Oxidizable.OxidationLevel.OXIDIZED  , AbstractBlock.Settings.copy(OXIDIZED_CUT_COPPER).nonOpaque().requiresTool().ticksRandomly()));

    public static final Block WAXED_CUT_COPPER_PEDESTAL = registerBlock( "waxed_cut_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_CUT_COPPER).nonOpaque().requiresTool()));

    public static final Block WAXED_EXPOSED_CUT_COPPER_PEDESTAL = registerBlock( "waxed_exposed_cut_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_EXPOSED_CUT_COPPER).nonOpaque().requiresTool()));

    public static final Block WAXED_WEATHERED_CUT_COPPER_PEDESTAL = registerBlock( "waxed_weathered_cut_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_WEATHERED_CUT_COPPER).nonOpaque().requiresTool()));

    public static final Block WAXED_OXIDIZED_CUT_COPPER_PEDESTAL = registerBlock( "waxed_oxidized_cut_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_OXIDIZED_CUT_COPPER).nonOpaque().requiresTool()));

    public static final Block BRICK_PEDESTAL = registerBlock( "brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(BRICKS).nonOpaque().requiresTool()));

    public static final Block END_STONE_BRICK_PEDESTAL = registerBlock( "end_stone_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(END_STONE_BRICKS).nonOpaque().requiresTool()));

    public static final Block MUD_BRICK_PEDESTAL = registerBlock( "mud_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(MUD_BRICKS).nonOpaque().requiresTool()));

    public static final Block NETHER_BRICK_PEDESTAL = registerBlock( "nether_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(NETHER_BRICKS).nonOpaque().requiresTool()));

    public static final Block POLISHED_BLACKSTONE_BRICK_PEDESTAL = registerBlock( "polished_blackstone_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(POLISHED_BLACKSTONE_BRICKS).nonOpaque().requiresTool()));

    public static final Block POLISHED_BLACKSTONE_PEDESTAL = registerBlock( "polished_blackstone_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(POLISHED_BLACKSTONE).nonOpaque().requiresTool()));

    public static final Block DARK_PRISMARINE_PEDESTAL = registerBlock( "dark_prismarine_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(DARK_PRISMARINE).nonOpaque().requiresTool()));

    public static final Block PRISMARINE_BRICK_PEDESTAL = registerBlock( "prismarine_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(PRISMARINE_BRICKS).nonOpaque().requiresTool()));

    public static final Block PURPUR_BLOCK_PEDESTAL = registerBlock( "purpur_block_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(PURPUR_BLOCK).nonOpaque().requiresTool()));

    public static final Block QUARTZ_BRICK_PEDESTAL = registerBlock( "quartz_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(QUARTZ_BRICKS).nonOpaque().requiresTool()));

    public static final Block RED_NETHER_BRICK_PEDESTAL = registerBlock( "red_nether_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(RED_NETHER_BRICKS).nonOpaque().requiresTool()));

    public static final Block SMOOTH_QUARTZ_PEDESTAL = registerBlock( "smooth_quartz_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(SMOOTH_QUARTZ).nonOpaque().requiresTool()));

    public static final Block POLISHED_TUFF_PEDESTAL = registerBlock( "polished_tuff_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(POLISHED_TUFF).nonOpaque().requiresTool()));

    public static final Block TUFF_BRICK_PEDESTAL = registerBlock( "tuff_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(TUFF_BRICKS).nonOpaque().requiresTool()));

    public static final Block CHISELED_TUFF_BRICK_PEDESTAL = registerBlock( "chiseled_tuff_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(CHISELED_TUFF_BRICKS).nonOpaque().requiresTool()));


    public static final Block OAK_LOG_PEDESTAL = registerBlock( "oak_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_OAK_LOG_PEDESTAL = registerBlock( "stripped_oak_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block BIRCH_LOG_PEDESTAL = registerBlock( "birch_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_BIRCH_LOG_PEDESTAL = registerBlock( "stripped_birch_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block SPRUCE_LOG_PEDESTAL = registerBlock( "spruce_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_SPRUCE_LOG_PEDESTAL = registerBlock( "stripped_spruce_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block JUNGLE_LOG_PEDESTAL = registerBlock( "jungle_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_JUNGLE_LOG_PEDESTAL = registerBlock( "stripped_jungle_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block DARK_OAK_LOG_PEDESTAL = registerBlock( "dark_oak_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_DARK_OAK_LOG_PEDESTAL = registerBlock( "stripped_dark_oak_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block ACACIA_LOG_PEDESTAL = registerBlock( "acacia_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_ACACIA_LOG_PEDESTAL = registerBlock( "stripped_acacia_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block MANGROVE_LOG_PEDESTAL = registerBlock( "mangrove_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_MANGROVE_LOG_PEDESTAL = registerBlock( "stripped_mangrove_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block CHERRY_LOG_PEDESTAL = registerBlock( "cherry_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.CHERRY_WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_CHERRY_LOG_PEDESTAL = registerBlock( "stripped_cherry_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.CHERRY_WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block BAMBOO_LOG_PEDESTAL = registerBlock( "bamboo_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_BAMBOO_LOG_PEDESTAL = registerBlock( "stripped_bamboo_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block BAMBOO_MOSAIC_PEDESTAL = registerBlock( "bamboo_mosaic_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .nonOpaque()
                    .burnable()));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Pedestals121.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Pedestals121.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    private static void registerOxidationAndWaxing() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_PEDESTAL, EXPOSED_COPPER_PEDESTAL);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_PEDESTAL, WEATHERED_COPPER_PEDESTAL);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_PEDESTAL, OXIDIZED_COPPER_PEDESTAL);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(CUT_COPPER_PEDESTAL, EXPOSED_CUT_COPPER_PEDESTAL);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_CUT_COPPER_PEDESTAL, WEATHERED_CUT_COPPER_PEDESTAL);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_CUT_COPPER_PEDESTAL, OXIDIZED_CUT_COPPER_PEDESTAL);
        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_PEDESTAL, WAXED_COPPER_PEDESTAL);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_PEDESTAL, WAXED_EXPOSED_COPPER_PEDESTAL);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_PEDESTAL, WAXED_WEATHERED_COPPER_PEDESTAL);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_PEDESTAL, WAXED_OXIDIZED_COPPER_PEDESTAL);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CUT_COPPER_PEDESTAL, WAXED_CUT_COPPER_PEDESTAL);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_CUT_COPPER_PEDESTAL, WAXED_EXPOSED_CUT_COPPER_PEDESTAL);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_CUT_COPPER_PEDESTAL, WAXED_WEATHERED_CUT_COPPER_PEDESTAL);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_CUT_COPPER_PEDESTAL, WAXED_OXIDIZED_CUT_COPPER_PEDESTAL);
    }

    private static void registerFlammableBlocks(){
        FlammableBlockRegistry.getDefaultInstance().add(OAK_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BIRCH_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(SPRUCE_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(JUNGLE_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(DARK_OAK_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ACACIA_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(MANGROVE_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(CHERRY_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BAMBOO_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_OAK_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_BIRCH_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_SPRUCE_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_JUNGLE_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_DARK_OAK_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_ACACIA_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_MANGROVE_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_CHERRY_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_BAMBOO_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BAMBOO_MOSAIC_PEDESTAL, 5, 20);
    }

    private static void registerStrippableBlocks(){
        StrippableCustomRegistry.register(OAK_LOG_PEDESTAL, STRIPPED_OAK_LOG_PEDESTAL);
        StrippableCustomRegistry.register(BIRCH_LOG_PEDESTAL, STRIPPED_BIRCH_LOG_PEDESTAL);
        StrippableCustomRegistry.register(SPRUCE_LOG_PEDESTAL, STRIPPED_SPRUCE_LOG_PEDESTAL);
        StrippableCustomRegistry.register(JUNGLE_LOG_PEDESTAL, STRIPPED_JUNGLE_LOG_PEDESTAL);
        StrippableCustomRegistry.register(DARK_OAK_LOG_PEDESTAL, STRIPPED_DARK_OAK_LOG_PEDESTAL);
        StrippableCustomRegistry.register(ACACIA_LOG_PEDESTAL, STRIPPED_ACACIA_LOG_PEDESTAL);
        StrippableCustomRegistry.register(MANGROVE_LOG_PEDESTAL, STRIPPED_MANGROVE_LOG_PEDESTAL);
        StrippableCustomRegistry.register(CHERRY_LOG_PEDESTAL, STRIPPED_CHERRY_LOG_PEDESTAL);
        StrippableCustomRegistry.register(BAMBOO_LOG_PEDESTAL, STRIPPED_BAMBOO_LOG_PEDESTAL);
    }

    public static void registerModBlocks(){
        Pedestals121.LOGGER.info("Registering Mod Blocks for Pedestals 1.21 (source: "+Pedestals121.MOD_ID+").");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(ModBlocks.STONE_BRICK_PEDESTAL);
            entries.add(ModBlocks.MOSSY_STONE_BRICK_PEDESTAL);
            entries.add(ModBlocks.DEEPSLATE_BRICK_PEDESTAL);
            entries.add(ModBlocks.DEEPSLATE_TILE_PEDESTAL);
            entries.add(ModBlocks.POLISHED_GRANITE_PEDESTAL);
            entries.add(ModBlocks.POLISHED_DIORITE_PEDESTAL);
            entries.add(ModBlocks.POLISHED_ANDESITE_PEDESTAL);
            entries.add(ModBlocks.POLISHED_DEEPSLATE_PEDESTAL);
            entries.add(ModBlocks.CALCITE_PEDESTAL);
            entries.add(ModBlocks.COPPER_PEDESTAL);
            entries.add(ModBlocks.EXPOSED_COPPER_PEDESTAL);
            entries.add(ModBlocks.WEATHERED_COPPER_PEDESTAL);
            entries.add(ModBlocks.OXIDIZED_COPPER_PEDESTAL);
            entries.add(ModBlocks.WAXED_COPPER_PEDESTAL);
            entries.add(ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL);
            entries.add(ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL);
            entries.add(ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL);
            entries.add(ModBlocks.CUT_COPPER_PEDESTAL);
            entries.add(ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL);
            entries.add(ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL);
            entries.add(ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL);
            entries.add(ModBlocks.WAXED_CUT_COPPER_PEDESTAL);
            entries.add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL);
            entries.add(ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL);
            entries.add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL);
            entries.add(ModBlocks.BRICK_PEDESTAL);
            entries.add(ModBlocks.END_STONE_BRICK_PEDESTAL);
            entries.add(ModBlocks.MUD_BRICK_PEDESTAL);
            entries.add(ModBlocks.NETHER_BRICK_PEDESTAL);
            entries.add(ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL);
            entries.add(ModBlocks.POLISHED_BLACKSTONE_PEDESTAL);
            entries.add(ModBlocks.DARK_PRISMARINE_PEDESTAL);
            entries.add(ModBlocks.PRISMARINE_BRICK_PEDESTAL);
            entries.add(ModBlocks.PURPUR_BLOCK_PEDESTAL);
            entries.add(ModBlocks.QUARTZ_BRICK_PEDESTAL);
            entries.add(ModBlocks.RED_NETHER_BRICK_PEDESTAL);
            entries.add(ModBlocks.SMOOTH_QUARTZ_PEDESTAL);
            entries.add(ModBlocks.POLISHED_TUFF_PEDESTAL);
            entries.add(ModBlocks.TUFF_BRICK_PEDESTAL);
            entries.add(ModBlocks.CHISELED_TUFF_BRICK_PEDESTAL);
            entries.add(ModBlocks.OAK_LOG_PEDESTAL);
            entries.add(ModBlocks.BIRCH_LOG_PEDESTAL);
            entries.add(ModBlocks.SPRUCE_LOG_PEDESTAL);
            entries.add(ModBlocks.JUNGLE_LOG_PEDESTAL);
            entries.add(ModBlocks.DARK_OAK_LOG_PEDESTAL);
            entries.add(ModBlocks.ACACIA_LOG_PEDESTAL);
            entries.add(ModBlocks.MANGROVE_LOG_PEDESTAL);
            entries.add(ModBlocks.CHERRY_LOG_PEDESTAL);
            entries.add(ModBlocks.BAMBOO_LOG_PEDESTAL);
            entries.add(ModBlocks.BAMBOO_MOSAIC_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_OAK_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL);
        });
        registerOxidationAndWaxing();
        registerFlammableBlocks();
        registerStrippableBlocks();
    }
}
