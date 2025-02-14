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
        
        
    }
}
