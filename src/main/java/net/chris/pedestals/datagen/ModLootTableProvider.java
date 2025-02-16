package net.chris.pedestals.datagen;

import net.chris.pedestals.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.STONE_BRICK_PEDESTAL);
        addDrop(ModBlocks.MOSSY_STONE_BRICK_PEDESTAL);
        addDrop(ModBlocks.DEEPSLATE_BRICK_PEDESTAL);
        addDrop(ModBlocks.DEEPSLATE_TILE_PEDESTAL);
        addDrop(ModBlocks.POLISHED_GRANITE_PEDESTAL);
        addDrop(ModBlocks.POLISHED_DIORITE_PEDESTAL);
        addDrop(ModBlocks.POLISHED_ANDESITE_PEDESTAL);
        addDrop(ModBlocks.POLISHED_DEEPSLATE_PEDESTAL);
        addDrop(ModBlocks.CALCITE_PEDESTAL);
        addDrop(ModBlocks.COPPER_PEDESTAL);
        addDrop(ModBlocks.EXPOSED_COPPER_PEDESTAL);
        addDrop(ModBlocks.WEATHERED_COPPER_PEDESTAL);
        addDrop(ModBlocks.OXIDIZED_COPPER_PEDESTAL);
        addDrop(ModBlocks.WAXED_COPPER_PEDESTAL);
        addDrop(ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL);
        addDrop(ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL);
        addDrop(ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL);
        addDrop(ModBlocks.CUT_COPPER_PEDESTAL);
        addDrop(ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL);
        addDrop(ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL);
        addDrop(ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL);
        addDrop(ModBlocks.WAXED_CUT_COPPER_PEDESTAL);
        addDrop(ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL);
        addDrop(ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL);
        addDrop(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL);
        addDrop(ModBlocks.BRICK_PEDESTAL);
        addDrop(ModBlocks.END_STONE_BRICK_PEDESTAL);
        addDrop(ModBlocks.MUD_BRICK_PEDESTAL);
        addDrop(ModBlocks.NETHER_BRICK_PEDESTAL);
        addDrop(ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL);
        addDrop(ModBlocks.POLISHED_BLACKSTONE_PEDESTAL);
        addDrop(ModBlocks.DARK_PRISMARINE_PEDESTAL);
        addDrop(ModBlocks.PRISMARINE_BRICK_PEDESTAL);
        addDrop(ModBlocks.PURPUR_BLOCK_PEDESTAL);
        addDrop(ModBlocks.QUARTZ_BRICK_PEDESTAL);
        addDrop(ModBlocks.RED_NETHER_BRICK_PEDESTAL);
        addDrop(ModBlocks.SMOOTH_QUARTZ_PEDESTAL);
        addDrop(ModBlocks.POLISHED_TUFF_PEDESTAL);
        addDrop(ModBlocks.TUFF_BRICK_PEDESTAL);
        addDrop(ModBlocks.OAK_LOG_PEDESTAL);
        addDrop(ModBlocks.BIRCH_LOG_PEDESTAL);
        addDrop(ModBlocks.SPRUCE_LOG_PEDESTAL);
        addDrop(ModBlocks.JUNGLE_LOG_PEDESTAL);
        addDrop(ModBlocks.DARK_OAK_LOG_PEDESTAL);
        addDrop(ModBlocks.ACACIA_LOG_PEDESTAL);
        addDrop(ModBlocks.MANGROVE_LOG_PEDESTAL);
        addDrop(ModBlocks.CHERRY_LOG_PEDESTAL);
        addDrop(ModBlocks.BAMBOO_LOG_PEDESTAL);
        addDrop(ModBlocks.BAMBOO_MOSAIC_PEDESTAL);
        addDrop(ModBlocks.STRIPPED_OAK_LOG_PEDESTAL);
        addDrop(ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL);
        addDrop(ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL);
        addDrop(ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL);
        addDrop(ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL);
        addDrop(ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL);
        addDrop(ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL);
        addDrop(ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL);
        addDrop(ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL);
        addDrop(ModBlocks.CHISELED_TUFF_BRICK_PEDESTAL);

        
    }
}
