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
                .add(ModBlocks.BRICK_PEDESTAL)
                .add(ModBlocks.END_STONE_BRICK_PEDESTAL)
                .add(ModBlocks.MUD_BRICK_PEDESTAL)
                .add(ModBlocks.NETHER_BRICK_PEDESTAL)
                .add(ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL)
                .add(ModBlocks.POLISHED_BLACKSTONE_PEDESTAL)
                .add(ModBlocks.DARK_PRISMARINE_PEDESTAL)
                .add(ModBlocks.PRISMARINE_BRICK_PEDESTAL)
                .add(ModBlocks.PURPUR_BLOCK_PEDESTAL)
                .add(ModBlocks.QUARTZ_BRICK_PEDESTAL)
                .add(ModBlocks.RED_NETHER_BRICK_PEDESTAL)
                .add(ModBlocks.SMOOTH_QUARTZ_PEDESTAL)
                .add(ModBlocks.POLISHED_TUFF_PEDESTAL)
                .add(ModBlocks.TUFF_BRICK_PEDESTAL)
                .add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL);


        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.BIRCH_LOG_PEDESTAL)
                .add(ModBlocks.SPRUCE_LOG_PEDESTAL)
                .add(ModBlocks.JUNGLE_LOG_PEDESTAL)
                .add(ModBlocks.DARK_OAK_LOG_PEDESTAL)
                .add(ModBlocks.ACACIA_LOG_PEDESTAL)
                .add(ModBlocks.MANGROVE_LOG_PEDESTAL)
                .add(ModBlocks.CHERRY_LOG_PEDESTAL)
                .add(ModBlocks.BAMBOO_LOG_PEDESTAL)
                .add(ModBlocks.BAMBOO_MOSAIC_PEDESTAL)
                .add(ModBlocks.STRIPPED_OAK_LOG_PEDESTAL)
                .add(ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL)
                .add(ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL)
                .add(ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL)
                .add(ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL)
                .add(ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL)
                .add(ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL)
                .add(ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL)
                .add(ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL)
                .add(ModBlocks.OAK_LOG_PEDESTAL);


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
