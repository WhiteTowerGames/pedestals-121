package net.chris.pedestals.block;

import com.strippableblocksapi.StrippableCustomRegistry;
import net.chris.pedestals.Pedestals121;
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
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import java.util.List;

import static net.minecraft.block.Blocks.*;

public class ModBlocks {

    public static final Block STONE_BRICK_PEDESTAL = registerBlock("stone_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(STONE_BRICKS).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "stone_brick_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block DEEPSLATE_BRICK_PEDESTAL = registerBlock("deepslate_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(DEEPSLATE_BRICKS).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "deepslate_brick_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block MOSSY_STONE_BRICK_PEDESTAL = registerBlock("mossy_stone_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(MOSSY_STONE_BRICKS).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "mossy_stone_brick_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block DEEPSLATE_TILE_PEDESTAL = registerBlock( "deepslate_tile_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(DEEPSLATE_TILES).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "deepslate_tile_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block POLISHED_GRANITE_PEDESTAL = registerBlock( "polished_granite_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(POLISHED_GRANITE).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "polished_granite_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block POLISHED_DIORITE_PEDESTAL = registerBlock( "polished_diorite_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(POLISHED_DIORITE).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "polished_diorite_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block POLISHED_ANDESITE_PEDESTAL = registerBlock( "polished_andesite_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(POLISHED_ANDESITE).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "polished_andesite_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block POLISHED_DEEPSLATE_PEDESTAL = registerBlock( "polished_deepslate_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(POLISHED_DEEPSLATE).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "polished_deepslate_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block CALCITE_PEDESTAL = registerBlock( "calcite_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(CALCITE).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "calcite_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block COPPER_PEDESTAL = registerBlock( "copper_pedestal",
            new OxidizablePedestalBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.copy(COPPER_BLOCK).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "copper_pedestal")))
                    .nonOpaque().requiresTool().ticksRandomly()));

    public static final Block EXPOSED_COPPER_PEDESTAL = registerBlock( "exposed_copper_pedestal",
            new OxidizablePedestalBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.copy(EXPOSED_COPPER).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "exposed_copper_pedestal")))
                    .nonOpaque().requiresTool().ticksRandomly()));

    public static final Block WEATHERED_COPPER_PEDESTAL = registerBlock( "weathered_copper_pedestal",
            new OxidizablePedestalBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.copy(WEATHERED_COPPER).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "weathered_copper_pedestal")))
                    .nonOpaque().requiresTool().ticksRandomly()));

    public static final Block OXIDIZED_COPPER_PEDESTAL = registerBlock( "oxidized_copper_pedestal",
            new OxidizablePedestalBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.copy(OXIDIZED_COPPER).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "oxidized_copper_pedestal")))
                    .nonOpaque().requiresTool().ticksRandomly()));

    public static final Block WAXED_COPPER_PEDESTAL = registerBlock( "waxed_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_COPPER_BLOCK).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "waxed_copper_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block WAXED_EXPOSED_COPPER_PEDESTAL = registerBlock( "waxed_exposed_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_EXPOSED_COPPER).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "waxed_exposed_copper_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block WAXED_WEATHERED_COPPER_PEDESTAL = registerBlock( "waxed_weathered_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_WEATHERED_COPPER).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "waxed_weathered_copper_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block WAXED_OXIDIZED_COPPER_PEDESTAL = registerBlock( "waxed_oxidized_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_OXIDIZED_COPPER).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "waxed_oxidized_copper_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block CUT_COPPER_PEDESTAL = registerBlock( "cut_copper_pedestal",
            new OxidizablePedestalBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.copy(CUT_COPPER).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "cut_copper_pedestal")))
                    .nonOpaque().requiresTool().ticksRandomly()));

    public static final Block EXPOSED_CUT_COPPER_PEDESTAL = registerBlock( "exposed_cut_copper_pedestal",
            new OxidizablePedestalBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.copy(EXPOSED_CUT_COPPER).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "exposed_cut_copper_pedestal")))
                    .nonOpaque().requiresTool().ticksRandomly()));

    public static final Block WEATHERED_CUT_COPPER_PEDESTAL = registerBlock( "weathered_cut_copper_pedestal",
            new OxidizablePedestalBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.copy(WEATHERED_CUT_COPPER).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "weathered_cut_copper_pedestal")))
                    .nonOpaque().requiresTool().ticksRandomly()));

    public static final Block OXIDIZED_CUT_COPPER_PEDESTAL = registerBlock( "oxidized_cut_copper_pedestal",
            new OxidizablePedestalBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.copy(OXIDIZED_CUT_COPPER).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "oxidized_cut_copper_pedestal")))
                    .nonOpaque().requiresTool().ticksRandomly()));

    public static final Block WAXED_CUT_COPPER_PEDESTAL = registerBlock( "waxed_cut_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_CUT_COPPER).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "waxed_cut_copper_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block WAXED_EXPOSED_CUT_COPPER_PEDESTAL = registerBlock( "waxed_exposed_cut_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_EXPOSED_CUT_COPPER).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "waxed_exposed_cut_copper_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block WAXED_WEATHERED_CUT_COPPER_PEDESTAL = registerBlock( "waxed_weathered_cut_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_WEATHERED_CUT_COPPER).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "waxed_weathered_cut_copper_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block WAXED_OXIDIZED_CUT_COPPER_PEDESTAL = registerBlock( "waxed_oxidized_cut_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_OXIDIZED_CUT_COPPER).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "waxed_oxidized_cut_copper_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block BRICK_PEDESTAL = registerBlock( "brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(BRICKS).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "brick_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block END_STONE_BRICK_PEDESTAL = registerBlock( "end_stone_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(END_STONE_BRICKS).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "end_stone_brick_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block MUD_BRICK_PEDESTAL = registerBlock( "mud_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(MUD_BRICKS).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "mud_brick_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block NETHER_BRICK_PEDESTAL = registerBlock( "nether_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(NETHER_BRICKS).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "nether_brick_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block POLISHED_BLACKSTONE_BRICK_PEDESTAL = registerBlock( "polished_blackstone_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(POLISHED_BLACKSTONE_BRICKS).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "polished_blackstone_brick_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block POLISHED_BLACKSTONE_PEDESTAL = registerBlock( "polished_blackstone_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(POLISHED_BLACKSTONE).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "polished_blackstone_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block DARK_PRISMARINE_PEDESTAL = registerBlock( "dark_prismarine_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(DARK_PRISMARINE).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "dark_prismarine_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block PRISMARINE_BRICK_PEDESTAL = registerBlock( "prismarine_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(PRISMARINE_BRICKS).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "prismarine_brick_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block PURPUR_BLOCK_PEDESTAL = registerBlock( "purpur_block_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(PURPUR_BLOCK).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "purpur_block_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block QUARTZ_BRICK_PEDESTAL = registerBlock( "quartz_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(QUARTZ_BRICKS).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "quartz_brick_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block RED_NETHER_BRICK_PEDESTAL = registerBlock( "red_nether_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(RED_NETHER_BRICKS).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "red_nether_brick_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block SMOOTH_QUARTZ_PEDESTAL = registerBlock( "smooth_quartz_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(SMOOTH_QUARTZ).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "smooth_quartz_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block POLISHED_TUFF_PEDESTAL = registerBlock( "polished_tuff_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(POLISHED_TUFF).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "polished_tuff_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block TUFF_BRICK_PEDESTAL = registerBlock( "tuff_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(TUFF_BRICKS).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "tuff_brick_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block CHISELED_TUFF_BRICK_PEDESTAL = registerBlock( "chiseled_tuff_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(CHISELED_TUFF_BRICKS).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "chiseled_tuff_brick_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block OAK_LOG_PEDESTAL = registerBlock( "oak_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "oak_log_pedestal")))
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_OAK_LOG_PEDESTAL = registerBlock( "stripped_oak_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "stripped_oak_log_pedestal")))
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block BIRCH_LOG_PEDESTAL = registerBlock( "birch_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "birch_log_pedestal")))
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_BIRCH_LOG_PEDESTAL = registerBlock( "stripped_birch_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "stripped_birch_log_pedestal")))
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block SPRUCE_LOG_PEDESTAL = registerBlock( "spruce_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "spruce_log_pedestal")))
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_SPRUCE_LOG_PEDESTAL = registerBlock( "stripped_spruce_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "stripped_spruce_log_pedestal")))
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block JUNGLE_LOG_PEDESTAL = registerBlock( "jungle_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "jungle_log_pedestal")))
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_JUNGLE_LOG_PEDESTAL = registerBlock( "stripped_jungle_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "stripped_jungle_log_pedestal")))
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block DARK_OAK_LOG_PEDESTAL = registerBlock( "dark_oak_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "dark_oak_log_pedestal")))
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_DARK_OAK_LOG_PEDESTAL = registerBlock( "stripped_dark_oak_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "stripped_dark_oak_log_pedestal")))
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block ACACIA_LOG_PEDESTAL = registerBlock( "acacia_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "acacia_log_pedestal")))
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_ACACIA_LOG_PEDESTAL = registerBlock( "stripped_acacia_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "stripped_acacia_log_pedestal")))
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block MANGROVE_LOG_PEDESTAL = registerBlock( "mangrove_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "mangrove_log_pedestal")))
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_MANGROVE_LOG_PEDESTAL = registerBlock( "stripped_mangrove_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "stripped_mangrove_log_pedestal")))
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block CHERRY_LOG_PEDESTAL = registerBlock( "cherry_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "cherry_log_pedestal")))
                    .sounds(BlockSoundGroup.CHERRY_WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_CHERRY_LOG_PEDESTAL = registerBlock( "stripped_cherry_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "stripped_cherry_log_pedestal")))
                    .sounds(BlockSoundGroup.CHERRY_WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block BAMBOO_LOG_PEDESTAL = registerBlock( "bamboo_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "bamboo_log_pedestal")))
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_BAMBOO_LOG_PEDESTAL = registerBlock( "stripped_bamboo_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "stripped_bamboo_log_pedestal")))
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block BAMBOO_MOSAIC_PEDESTAL = registerBlock( "bamboo_mosaic_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "bamboo_mosaic_pedestal")))
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block CRIMSON_LOG_PEDESTAL = registerBlock( "crimson_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "crimson_log_pedestal")))
                    .sounds(BlockSoundGroup.STEM)
                    .nonOpaque()));

    public static final Block STRIPPED_CRIMSON_LOG_PEDESTAL = registerBlock( "stripped_crimson_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "stripped_crimson_log_pedestal")))
                    .sounds(BlockSoundGroup.STEM)
                    .nonOpaque()));

    public static final Block WARPED_LOG_PEDESTAL = registerBlock( "warped_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "warped_log_pedestal")))
                    .sounds(BlockSoundGroup.STEM)
                    .nonOpaque()));

    public static final Block STRIPPED_WARPED_LOG_PEDESTAL = registerBlock( "stripped_warped_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "stripped_warped_log_pedestal")))
                    .sounds(BlockSoundGroup.STEM)
                    .nonOpaque()));

    public static final Block SMOOTH_SANDSTONE_PEDESTAL = registerBlock( "smooth_sandstone_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(SMOOTH_SANDSTONE).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "smooth_sandstone_pedestal")))
                    .nonOpaque().requiresTool()));

    public static final Block SMOOTH_RED_SANDSTONE_PEDESTAL = registerBlock( "smooth_red_sandstone_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(SMOOTH_RED_SANDSTONE).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "smooth_red_sandstone_pedestal")))
                    .nonOpaque().requiresTool()));

    ///1.21.4 port specific blocks:

    public static final Block PALE_OAK_LOG_PEDESTAL = registerBlock( "pale_oak_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "pale_oak_log_pedestal")))
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block STRIPPED_PALE_OAK_LOG_PEDESTAL = registerBlock( "stripped_pale_oak_log_pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().strength(2.0f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "stripped_pale_oak_log_pedestal")))
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                    .burnable()));

    public static final Block RESIN_BRICK_PEDESTAL = registerBlock( "resin_brick_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(RESIN_BRICKS).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Pedestals121.MOD_ID, "resin_brick_pedestal")))
                    .nonOpaque().requiresTool()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Pedestals121.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Pedestals121.MOD_ID, name),
                new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Pedestals121.MOD_ID, name)))));
    }

    public static final List<Block> ALL_PEDESTALS = List.of(
            ModBlocks.STONE_BRICK_PEDESTAL,
            ModBlocks.MOSSY_STONE_BRICK_PEDESTAL,
            ModBlocks.SMOOTH_SANDSTONE_PEDESTAL,
            ModBlocks.SMOOTH_RED_SANDSTONE_PEDESTAL,
            ModBlocks.DEEPSLATE_BRICK_PEDESTAL,
            ModBlocks.DEEPSLATE_TILE_PEDESTAL,
            ModBlocks.POLISHED_GRANITE_PEDESTAL,
            ModBlocks.POLISHED_DIORITE_PEDESTAL,
            ModBlocks.POLISHED_ANDESITE_PEDESTAL,
            ModBlocks.POLISHED_DEEPSLATE_PEDESTAL,
            ModBlocks.CALCITE_PEDESTAL,
            ModBlocks.COPPER_PEDESTAL,
            ModBlocks.EXPOSED_COPPER_PEDESTAL,
            ModBlocks.WEATHERED_COPPER_PEDESTAL,
            ModBlocks.OXIDIZED_COPPER_PEDESTAL,
            ModBlocks.WAXED_COPPER_PEDESTAL,
            ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL,
            ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL,
            ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL,
            ModBlocks.CUT_COPPER_PEDESTAL,
            ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL,
            ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL,
            ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL,
            ModBlocks.WAXED_CUT_COPPER_PEDESTAL,
            ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL,
            ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL,
            ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL,
            ModBlocks.BRICK_PEDESTAL,
            ModBlocks.END_STONE_BRICK_PEDESTAL,
            ModBlocks.MUD_BRICK_PEDESTAL,
            ModBlocks.NETHER_BRICK_PEDESTAL,
            ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL,
            ModBlocks.POLISHED_BLACKSTONE_PEDESTAL,
            ModBlocks.DARK_PRISMARINE_PEDESTAL,
            ModBlocks.PRISMARINE_BRICK_PEDESTAL,
            ModBlocks.PURPUR_BLOCK_PEDESTAL,
            ModBlocks.QUARTZ_BRICK_PEDESTAL,
            ModBlocks.RED_NETHER_BRICK_PEDESTAL,
            ModBlocks.SMOOTH_QUARTZ_PEDESTAL,
            ModBlocks.POLISHED_TUFF_PEDESTAL,
            ModBlocks.TUFF_BRICK_PEDESTAL,
            ModBlocks.CHISELED_TUFF_BRICK_PEDESTAL,
            ModBlocks.OAK_LOG_PEDESTAL,
            ModBlocks.BIRCH_LOG_PEDESTAL,
            ModBlocks.SPRUCE_LOG_PEDESTAL,
            ModBlocks.JUNGLE_LOG_PEDESTAL,
            ModBlocks.DARK_OAK_LOG_PEDESTAL,
            ModBlocks.ACACIA_LOG_PEDESTAL,
            ModBlocks.CRIMSON_LOG_PEDESTAL,
            ModBlocks.WARPED_LOG_PEDESTAL,
            ModBlocks.MANGROVE_LOG_PEDESTAL,
            ModBlocks.CHERRY_LOG_PEDESTAL,
            ModBlocks.BAMBOO_LOG_PEDESTAL,
            ModBlocks.BAMBOO_MOSAIC_PEDESTAL,
            ModBlocks.PALE_OAK_LOG_PEDESTAL,
            ModBlocks.RESIN_BRICK_PEDESTAL,
            ModBlocks.STRIPPED_OAK_LOG_PEDESTAL,
            ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL,
            ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL,
            ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL,
            ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL,
            ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL,
            ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL,
            ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL,
            ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL,
            ModBlocks.STRIPPED_PALE_OAK_LOG_PEDESTAL,
            ModBlocks.STRIPPED_CRIMSON_LOG_PEDESTAL,
            ModBlocks.STRIPPED_WARPED_LOG_PEDESTAL
    );

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
        FlammableBlockRegistry.getDefaultInstance().add(PALE_OAK_LOG_PEDESTAL, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_PALE_OAK_LOG_PEDESTAL, 5, 5);
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
        StrippableCustomRegistry.register(PALE_OAK_LOG_PEDESTAL, STRIPPED_PALE_OAK_LOG_PEDESTAL);
        StrippableCustomRegistry.register(CRIMSON_LOG_PEDESTAL, STRIPPED_CRIMSON_LOG_PEDESTAL);
        StrippableCustomRegistry.register(WARPED_LOG_PEDESTAL, STRIPPED_WARPED_LOG_PEDESTAL);
    }

    public static void registerModBlocks(){
        Pedestals121.LOGGER.info("Registering Mod Blocks for Pedestals 1.21 (source: "+Pedestals121.MOD_ID+").");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(ModBlocks.STONE_BRICK_PEDESTAL);
            entries.add(ModBlocks.MOSSY_STONE_BRICK_PEDESTAL);
            entries.add(ModBlocks.SMOOTH_SANDSTONE_PEDESTAL);
            entries.add(ModBlocks.SMOOTH_RED_SANDSTONE_PEDESTAL);
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
            entries.add(ModBlocks.CRIMSON_LOG_PEDESTAL);
            entries.add(ModBlocks.WARPED_LOG_PEDESTAL);
            entries.add(ModBlocks.MANGROVE_LOG_PEDESTAL);
            entries.add(ModBlocks.CHERRY_LOG_PEDESTAL);
            entries.add(ModBlocks.BAMBOO_LOG_PEDESTAL);
            entries.add(ModBlocks.BAMBOO_MOSAIC_PEDESTAL);
            entries.add(ModBlocks.PALE_OAK_LOG_PEDESTAL);
            entries.add(ModBlocks.RESIN_BRICK_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_OAK_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_PALE_OAK_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_CRIMSON_LOG_PEDESTAL);
            entries.add(ModBlocks.STRIPPED_WARPED_LOG_PEDESTAL);
        });
        Pedestals121.LOGGER.info(STONE_BRICK_PEDESTAL+"");
        registerOxidationAndWaxing();
        registerFlammableBlocks();
        registerStrippableBlocks();
    }
}
