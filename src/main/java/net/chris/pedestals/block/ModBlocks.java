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

    public static final Block PEDESTAL = (PedestalBlock) registerBlock("pedestal",
            new PedestalBlock(AbstractBlock.Settings.copy(AMETHYST_BLOCK).nonOpaque().requiresTool()));


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
        });
    }
}
