package net.chris.pedestals.block;

import net.chris.pedestals.Pedestals121;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OxidizableBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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
            new OxidizablePedestalBlock(AbstractBlock.Settings.copy(COPPER_BLOCK).nonOpaque().requiresTool()));

    public static final Block EXPOSED_COPPER_PEDESTAL = registerBlock( "exposed_copper_pedestal",
            new OxidizablePedestalBlock(AbstractBlock.Settings.copy(EXPOSED_COPPER).nonOpaque().requiresTool()));

    public static final Block WEATHERED_COPPER_PEDESTAL = registerBlock( "weathered_copper_pedestal",
            new OxidizablePedestalBlock(AbstractBlock.Settings.copy(WEATHERED_COPPER).nonOpaque().requiresTool()));

    public static final Block OXIDIZED_COPPER_PEDESTAL = registerBlock( "oxidized_copper_pedestal",
            new OxidizablePedestalBlock(AbstractBlock.Settings.copy(OXIDIZED_COPPER).nonOpaque().requiresTool()));

    public static final Block WAXED_COPPER_PEDESTAL = registerBlock( "waxed_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_COPPER_BLOCK).nonOpaque().requiresTool()));

    public static final Block WAXED_EXPOSED_COPPER_PEDESTAL = registerBlock( "waxed_exposed_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_EXPOSED_COPPER).nonOpaque().requiresTool()));

    public static final Block WAXED_WEATHERED_COPPER_PEDESTAL = registerBlock( "waxed_weathered_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_WEATHERED_COPPER).nonOpaque().requiresTool()));

    public static final Block WAXED_OXIDIZED_COPPER_PEDESTAL = registerBlock( "waxed_oxidized_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_OXIDIZED_COPPER).nonOpaque().requiresTool()));

    public static final Block CUT_COPPER_PEDESTAL = registerBlock( "cut_copper_pedestal",
            new OxidizablePedestalBlock(AbstractBlock.Settings.copy(CUT_COPPER).nonOpaque().requiresTool()));

    public static final Block EXPOSED_CUT_COPPER_PEDESTAL = registerBlock( "exposed_cut_copper_pedestal",
            new OxidizablePedestalBlock(AbstractBlock.Settings.copy(EXPOSED_CUT_COPPER).nonOpaque().requiresTool()));

    public static final Block WEATHERED_CUT_COPPER_PEDESTAL = registerBlock( "weathered_cut_copper_pedestal",
            new OxidizablePedestalBlock(AbstractBlock.Settings.copy(WEATHERED_CUT_COPPER).nonOpaque().requiresTool()));

    public static final Block OXIDIZED_CUT_COPPER_PEDESTAL = registerBlock( "oxidized_cut_copper_pedestal",
            new OxidizablePedestalBlock(AbstractBlock.Settings.copy(OXIDIZED_CUT_COPPER).nonOpaque().requiresTool()));

    public static final Block WAXED_CUT_COPPER_PEDESTAL = registerBlock( "waxed_cut_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_CUT_COPPER).nonOpaque().requiresTool()));

    public static final Block WAXED_EXPOSED_CUT_COPPER_PEDESTAL = registerBlock( "waxed_exposed_cut_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_EXPOSED_CUT_COPPER).nonOpaque().requiresTool()));

    public static final Block WAXED_WEATHERED_CUT_COPPER_PEDESTAL = registerBlock( "waxed_weathered_cut_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_WEATHERED_CUT_COPPER).nonOpaque().requiresTool()));

    public static final Block WAXED_OXIDIZED_CUT_COPPER_PEDESTAL = registerBlock( "waxed_oxidized_cut_copper_pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(WAXED_OXIDIZED_CUT_COPPER).nonOpaque().requiresTool()));
    
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Pedestals121.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Pedestals121.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
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
            
        });
    }
}
