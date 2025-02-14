package net.chris.pedestals.datagen;

import net.chris.pedestals.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.STONE_BRICK_PEDESTAL)
                .add(ModBlocks.MOSSY_STONE_BRICK_PEDESTAL)
                .add(ModBlocks.DEEPSLATE_BRICK_PEDESTAL)
                .add(ModBlocks.DEEPSLATE_TILE_PEDESTAL)
                .add(ModBlocks.POLISHED_GRANITE_PEDESTAL)
                .add(ModBlocks.POLISHED_DIORITE_PEDESTAL)
                .add(ModBlocks.POLISHED_DEEPSLATE_PEDESTAL)
                .add(ModBlocks.CALCITE_PEDESTAL)
                .add(ModBlocks.COPPER_PEDESTAL)
                .add(ModBlocks.EXPOSED_COPPER_PEDESTAL)
                .add(ModBlocks.WEATHERED_COPPER_PEDESTAL)
                .add(ModBlocks.OXIDIZED_COPPER_PEDESTAL)
                .add(ModBlocks.POLISHED_ANDESITE_PEDESTAL)
                .add(ModBlocks.WAXED_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL)
                .add(ModBlocks.CUT_COPPER_PEDESTAL)
                .add(ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.POLISHED_ANDESITE_PEDESTAL)
                .add(ModBlocks.WAXED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.COPPER_PEDESTAL)
                .add(ModBlocks.WEATHERED_COPPER_PEDESTAL)
                .add(ModBlocks.OXIDIZED_COPPER_PEDESTAL)
                .add(ModBlocks.EXPOSED_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL)
                .add(ModBlocks.CUT_COPPER_PEDESTAL)
                .add(ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.POLISHED_ANDESITE_PEDESTAL)
                .add(ModBlocks.WAXED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL);
                

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .add(ModBlocks.COPPER_PEDESTAL)
                .add(ModBlocks.WEATHERED_COPPER_PEDESTAL)
                .add(ModBlocks.OXIDIZED_COPPER_PEDESTAL)
                .add(ModBlocks.EXPOSED_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL)
                .add(ModBlocks.CUT_COPPER_PEDESTAL)
                .add(ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.POLISHED_ANDESITE_PEDESTAL)
                .add(ModBlocks.WAXED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL);
                

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .add(ModBlocks.COPPER_PEDESTAL)
                .add(ModBlocks.WEATHERED_COPPER_PEDESTAL)
                .add(ModBlocks.OXIDIZED_COPPER_PEDESTAL)
                .add(ModBlocks.EXPOSED_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL)
                .add(ModBlocks.CUT_COPPER_PEDESTAL)
                .add(ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.POLISHED_ANDESITE_PEDESTAL)
                .add(ModBlocks.WAXED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL)
                .add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL);
                

    }

}
