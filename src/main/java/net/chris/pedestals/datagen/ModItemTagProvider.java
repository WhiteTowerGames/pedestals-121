package net.chris.pedestals.datagen;

import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    public static final TagKey<Item> PEDESTAL_BLOCK_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(Pedestals121.MOD_ID, "pedestal_block_items"));

    public static final Item[] PEDESTAL_BLOCK_ITEM_ARRAY = new Item[]{
             ModBlocks.STONE_BRICK_PEDESTAL.asItem(),
             ModBlocks.MOSSY_STONE_BRICK_PEDESTAL.asItem(),
             ModBlocks.DEEPSLATE_BRICK_PEDESTAL.asItem(),
             ModBlocks.DEEPSLATE_TILE_PEDESTAL.asItem(),
             ModBlocks.POLISHED_GRANITE_PEDESTAL.asItem(),
             ModBlocks.POLISHED_DIORITE_PEDESTAL.asItem(),
             ModBlocks.POLISHED_DEEPSLATE_PEDESTAL.asItem(),
             ModBlocks.CALCITE_PEDESTAL.asItem(),
             ModBlocks.COPPER_PEDESTAL.asItem(),
             ModBlocks.EXPOSED_COPPER_PEDESTAL.asItem(),
             ModBlocks.WEATHERED_COPPER_PEDESTAL.asItem(),
             ModBlocks.OXIDIZED_COPPER_PEDESTAL.asItem(),
             ModBlocks.POLISHED_ANDESITE_PEDESTAL.asItem(),
             ModBlocks.WAXED_COPPER_PEDESTAL.asItem(),
             ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL.asItem(),
             ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL.asItem(),
             ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL.asItem(),
             ModBlocks.CUT_COPPER_PEDESTAL.asItem(),
             ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL.asItem(),
             ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL.asItem(),
             ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL.asItem(),
             ModBlocks.POLISHED_ANDESITE_PEDESTAL.asItem(),
             ModBlocks.WAXED_CUT_COPPER_PEDESTAL.asItem(),
             ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL.asItem(),
             ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL.asItem(),
             ModBlocks.BRICK_PEDESTAL.asItem(),
             ModBlocks.END_STONE_BRICK_PEDESTAL.asItem(),
             ModBlocks.MUD_BRICK_PEDESTAL.asItem(),
             ModBlocks.NETHER_BRICK_PEDESTAL.asItem(),
             ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL.asItem(),
             ModBlocks.POLISHED_BLACKSTONE_PEDESTAL.asItem(),
             ModBlocks.DARK_PRISMARINE_PEDESTAL.asItem(),
             ModBlocks.PRISMARINE_BRICK_PEDESTAL.asItem(),
             ModBlocks.PURPUR_BLOCK_PEDESTAL.asItem(),
             ModBlocks.QUARTZ_BRICK_PEDESTAL.asItem(),
             ModBlocks.RED_NETHER_BRICK_PEDESTAL.asItem(),
             ModBlocks.SMOOTH_QUARTZ_PEDESTAL.asItem(),
             ModBlocks.POLISHED_TUFF_PEDESTAL.asItem(),
             ModBlocks.TUFF_BRICK_PEDESTAL.asItem(),
             ModBlocks.CHISELED_TUFF_BRICK_PEDESTAL.asItem(),
             ModBlocks.RESIN_BRICK_PEDESTAL.asItem(),
             ModBlocks.SMOOTH_SANDSTONE_PEDESTAL.asItem(),
             ModBlocks.SMOOTH_RED_SANDSTONE_PEDESTAL.asItem(),
             ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL.asItem(),
             ModBlocks.BIRCH_LOG_PEDESTAL.asItem(),
             ModBlocks.SPRUCE_LOG_PEDESTAL.asItem(),
             ModBlocks.JUNGLE_LOG_PEDESTAL.asItem(),
             ModBlocks.DARK_OAK_LOG_PEDESTAL.asItem(),
             ModBlocks.ACACIA_LOG_PEDESTAL.asItem(),
             ModBlocks.MANGROVE_LOG_PEDESTAL.asItem(),
             ModBlocks.CHERRY_LOG_PEDESTAL.asItem(),
             ModBlocks.BAMBOO_LOG_PEDESTAL.asItem(),
             ModBlocks.BAMBOO_MOSAIC_PEDESTAL.asItem(),
             ModBlocks.STRIPPED_OAK_LOG_PEDESTAL.asItem(),
             ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL.asItem(),
             ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL.asItem(),
             ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL.asItem(),
             ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL.asItem(),
             ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL.asItem(),
             ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL.asItem(),
             ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL.asItem(),
             ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL.asItem(),
             ModBlocks.PALE_OAK_LOG_PEDESTAL.asItem(),
             ModBlocks.STRIPPED_PALE_OAK_LOG_PEDESTAL.asItem(),
             ModBlocks.STRIPPED_CRIMSON_LOG_PEDESTAL.asItem(),
             ModBlocks.STRIPPED_WARPED_LOG_PEDESTAL.asItem(),
             ModBlocks.CRIMSON_LOG_PEDESTAL.asItem(),
             ModBlocks.WARPED_LOG_PEDESTAL.asItem(),
             ModBlocks.OAK_LOG_PEDESTAL.asItem()};

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(PEDESTAL_BLOCK_ITEMS)
                .add(ModBlocks.STONE_BRICK_PEDESTAL.asItem())
                .add(ModBlocks.MOSSY_STONE_BRICK_PEDESTAL.asItem())
                .add(ModBlocks.DEEPSLATE_BRICK_PEDESTAL.asItem())
                .add(ModBlocks.DEEPSLATE_TILE_PEDESTAL.asItem())
                .add(ModBlocks.POLISHED_GRANITE_PEDESTAL.asItem())
                .add(ModBlocks.POLISHED_DIORITE_PEDESTAL.asItem())
                .add(ModBlocks.POLISHED_DEEPSLATE_PEDESTAL.asItem())
                .add(ModBlocks.CALCITE_PEDESTAL.asItem())
                .add(ModBlocks.COPPER_PEDESTAL.asItem())
                .add(ModBlocks.EXPOSED_COPPER_PEDESTAL.asItem())
                .add(ModBlocks.WEATHERED_COPPER_PEDESTAL.asItem())
                .add(ModBlocks.OXIDIZED_COPPER_PEDESTAL.asItem())
                .add(ModBlocks.POLISHED_ANDESITE_PEDESTAL.asItem())
                .add(ModBlocks.WAXED_COPPER_PEDESTAL.asItem())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL.asItem())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL.asItem())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL.asItem())
                .add(ModBlocks.CUT_COPPER_PEDESTAL.asItem())
                .add(ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL.asItem())
                .add(ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL.asItem())
                .add(ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL.asItem())
                .add(ModBlocks.POLISHED_ANDESITE_PEDESTAL.asItem())
                .add(ModBlocks.WAXED_CUT_COPPER_PEDESTAL.asItem())
                .add(ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL.asItem())
                .add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL.asItem())
                .add(ModBlocks.BRICK_PEDESTAL.asItem())
                .add(ModBlocks.END_STONE_BRICK_PEDESTAL.asItem())
                .add(ModBlocks.MUD_BRICK_PEDESTAL.asItem())
                .add(ModBlocks.NETHER_BRICK_PEDESTAL.asItem())
                .add(ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL.asItem())
                .add(ModBlocks.POLISHED_BLACKSTONE_PEDESTAL.asItem())
                .add(ModBlocks.DARK_PRISMARINE_PEDESTAL.asItem())
                .add(ModBlocks.PRISMARINE_BRICK_PEDESTAL.asItem())
                .add(ModBlocks.PURPUR_BLOCK_PEDESTAL.asItem())
                .add(ModBlocks.QUARTZ_BRICK_PEDESTAL.asItem())
                .add(ModBlocks.RED_NETHER_BRICK_PEDESTAL.asItem())
                .add(ModBlocks.SMOOTH_QUARTZ_PEDESTAL.asItem())
                .add(ModBlocks.POLISHED_TUFF_PEDESTAL.asItem())
                .add(ModBlocks.TUFF_BRICK_PEDESTAL.asItem())
                .add(ModBlocks.CHISELED_TUFF_BRICK_PEDESTAL.asItem())
                .add(ModBlocks.RESIN_BRICK_PEDESTAL.asItem())
                .add(ModBlocks.SMOOTH_SANDSTONE_PEDESTAL.asItem())
                .add(ModBlocks.SMOOTH_RED_SANDSTONE_PEDESTAL.asItem())
                .add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL.asItem())
                .add(ModBlocks.BIRCH_LOG_PEDESTAL.asItem())
                .add(ModBlocks.SPRUCE_LOG_PEDESTAL.asItem())
                .add(ModBlocks.JUNGLE_LOG_PEDESTAL.asItem())
                .add(ModBlocks.DARK_OAK_LOG_PEDESTAL.asItem())
                .add(ModBlocks.ACACIA_LOG_PEDESTAL.asItem())
                .add(ModBlocks.MANGROVE_LOG_PEDESTAL.asItem())
                .add(ModBlocks.CHERRY_LOG_PEDESTAL.asItem())
                .add(ModBlocks.BAMBOO_LOG_PEDESTAL.asItem())
                .add(ModBlocks.BAMBOO_MOSAIC_PEDESTAL.asItem())
                .add(ModBlocks.STRIPPED_OAK_LOG_PEDESTAL.asItem())
                .add(ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL.asItem())
                .add(ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL.asItem())
                .add(ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL.asItem())
                .add(ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL.asItem())
                .add(ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL.asItem())
                .add(ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL.asItem())
                .add(ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL.asItem())
                .add(ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL.asItem())
                .add(ModBlocks.PALE_OAK_LOG_PEDESTAL.asItem())
                .add(ModBlocks.STRIPPED_PALE_OAK_LOG_PEDESTAL.asItem())
                .add(ModBlocks.STRIPPED_CRIMSON_LOG_PEDESTAL.asItem())
                .add(ModBlocks.STRIPPED_WARPED_LOG_PEDESTAL.asItem())
                .add(ModBlocks.CRIMSON_LOG_PEDESTAL.asItem())
                .add(ModBlocks.WARPED_LOG_PEDESTAL.asItem())
                .add(ModBlocks.OAK_LOG_PEDESTAL.asItem());
    }
}
