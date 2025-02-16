package net.chris.pedestals.datagen;

import net.chris.pedestals.block.ModBlocks;
import net.chris.pedestals.item.ModItemGroups;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModEnglishLanguageProvider extends FabricLanguageProvider {

    public ModEnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    private static void addText(@NotNull TranslationBuilder builder, @NotNull Text text, @NotNull String value){
        builder.add(((TranslatableTextContent) text.getContent()).getKey(), value);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.STONE_BRICK_PEDESTAL, "Stone Brick Pedestal");
        translationBuilder.add(ModBlocks.MOSSY_STONE_BRICK_PEDESTAL, "Mossy Stone Brick Pedestal");
        translationBuilder.add(ModBlocks.DEEPSLATE_BRICK_PEDESTAL, "Deepslate Brick Pedestal");
        translationBuilder.add(ModBlocks.DEEPSLATE_TILE_PEDESTAL, "Deepslate Tile Pedestal");
        translationBuilder.add(ModBlocks.POLISHED_GRANITE_PEDESTAL, "Polished Granite Pedestal");
        translationBuilder.add(ModBlocks.POLISHED_DIORITE_PEDESTAL, "Polished Diorite Pedestal");
        translationBuilder.add(ModBlocks.POLISHED_ANDESITE_PEDESTAL, "Polished Andesite Pedestal");
        translationBuilder.add(ModBlocks.POLISHED_DEEPSLATE_PEDESTAL, "Polished Deepslate Pedestal");
        translationBuilder.add(ModBlocks.CALCITE_PEDESTAL, "Calcite Pedestal");
        translationBuilder.add(ModBlocks.COPPER_PEDESTAL, "Copper Pedestal");
        translationBuilder.add(ModBlocks.EXPOSED_COPPER_PEDESTAL, "Exposed Copper Pedestal");
        translationBuilder.add(ModBlocks.WEATHERED_COPPER_PEDESTAL, "Weathered Copper Pedestal");
        translationBuilder.add(ModBlocks.OXIDIZED_COPPER_PEDESTAL, "Oxidized Copper Pedestal");
        translationBuilder.add(ModBlocks.WAXED_COPPER_PEDESTAL, "Waxed Copper Pedestal");
        translationBuilder.add(ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL, "Waxed Exposed Copper Pedestal");
        translationBuilder.add(ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL, "Waxed Weathered Copper Pedestal");
        translationBuilder.add(ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL, "Waxed Oxidized Copper Pedestal");
        translationBuilder.add(ModBlocks.CUT_COPPER_PEDESTAL, "Cut Copper Pedestal");
        translationBuilder.add(ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL, "Exposed Cut Copper Pedestal");
        translationBuilder.add(ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL, "Weathered Cut Copper Pedestal");
        translationBuilder.add(ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL, "Oxidized Cut Copper Pedestal");
        translationBuilder.add(ModBlocks.WAXED_CUT_COPPER_PEDESTAL, "Waxed Cut Copper Pedestal");
        translationBuilder.add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL, "Waxed Exposed Cut Copper Pedestal");
        translationBuilder.add(ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL, "Waxed Weathered Cut Copper Pedestal");
        translationBuilder.add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL, "Waxed Oxidized Cut Copper Pedestal");
        translationBuilder.add(ModBlocks.BRICK_PEDESTAL, "Brick Pedestal");
        translationBuilder.add(ModBlocks.END_STONE_BRICK_PEDESTAL, "End Stone Brick Pedestal");
        translationBuilder.add(ModBlocks.MUD_BRICK_PEDESTAL, "Mud Brick Pedestal");
        translationBuilder.add(ModBlocks.NETHER_BRICK_PEDESTAL, "Nether Brick Pedestal");
        translationBuilder.add(ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL, "Polished Blackstone Brick Pedestal");
        translationBuilder.add(ModBlocks.POLISHED_BLACKSTONE_PEDESTAL, "Polished Blackstone Pedestal");
        translationBuilder.add(ModBlocks.DARK_PRISMARINE_PEDESTAL, "Dark Prismarine Pedestal");
        translationBuilder.add(ModBlocks.PRISMARINE_BRICK_PEDESTAL, "Prismarine Brick Pedestal");
        translationBuilder.add(ModBlocks.PURPUR_BLOCK_PEDESTAL, "Purpur Pedestal");
        translationBuilder.add(ModBlocks.QUARTZ_BRICK_PEDESTAL, "Quartz Brick Pedestal");
        translationBuilder.add(ModBlocks.RED_NETHER_BRICK_PEDESTAL, "Red Nether Brick Pedestal");
        translationBuilder.add(ModBlocks.SMOOTH_QUARTZ_PEDESTAL, "Smooth Quartz Pedestal");
        translationBuilder.add(ModBlocks.POLISHED_TUFF_PEDESTAL, "Polished Tuff Pedestal");
        translationBuilder.add(ModBlocks.TUFF_BRICK_PEDESTAL, "Tuff Brick Pedestal");
        translationBuilder.add(ModBlocks.OAK_LOG_PEDESTAL, "Oak Wood Pedestal");
        translationBuilder.add(ModBlocks.BIRCH_LOG_PEDESTAL, "Birch Wood Pedestal");
        translationBuilder.add(ModBlocks.SPRUCE_LOG_PEDESTAL, "Spruce Wood Pedestal");
        translationBuilder.add(ModBlocks.JUNGLE_LOG_PEDESTAL, "Jungle Wood Pedestal");
        translationBuilder.add(ModBlocks.DARK_OAK_LOG_PEDESTAL, "Dark Oak Wood Pedestal");
        translationBuilder.add(ModBlocks.ACACIA_LOG_PEDESTAL, "Acacia Wood Pedestal");
        translationBuilder.add(ModBlocks.MANGROVE_LOG_PEDESTAL, "Mangrove Wood Pedestal");
        translationBuilder.add(ModBlocks.CHERRY_LOG_PEDESTAL, "Cherry Wood Pedestal");
        translationBuilder.add(ModBlocks.BAMBOO_LOG_PEDESTAL, "Bamboo Pedestal");
        translationBuilder.add(ModBlocks.BAMBOO_MOSAIC_PEDESTAL, "Bamboo Mosaic Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_OAK_LOG_PEDESTAL, "Stripped Oak Wood Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL, "Stripped Birch Wood Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL, "Stripped Spruce Wood Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL, "Stripped Jungle Wood Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL, "Stripped Dark Oak Wood Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL, "Stripped Acacia Wood Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL, "Stripped Mangrove Wood Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL, "Stripped Cherry Wood Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL, "Stripped Bamboo Pedestal");

        translationBuilder.add(ModBlocks.STONE_BRICK_PEDESTAL.asItem(), "Stone Brick Pedestal");
        translationBuilder.add(ModBlocks.MOSSY_STONE_BRICK_PEDESTAL.asItem(), "Mossy Stone Brick Pedestal");
        translationBuilder.add(ModBlocks.DEEPSLATE_BRICK_PEDESTAL.asItem(), "Deepslate Brick Pedestal");
        translationBuilder.add(ModBlocks.DEEPSLATE_TILE_PEDESTAL.asItem(), "Deepslate Tile Pedestal");
        translationBuilder.add(ModBlocks.POLISHED_GRANITE_PEDESTAL.asItem(), "Polished Granite Pedestal");
        translationBuilder.add(ModBlocks.POLISHED_DIORITE_PEDESTAL.asItem(), "Polished Diorite Pedestal");
        translationBuilder.add(ModBlocks.POLISHED_ANDESITE_PEDESTAL.asItem(), "Polished Andesite Pedestal");
        translationBuilder.add(ModBlocks.POLISHED_DEEPSLATE_PEDESTAL.asItem(), "Polished Deepslate Pedestal");
        translationBuilder.add(ModBlocks.CALCITE_PEDESTAL.asItem(), "Calcite Pedestal");
        translationBuilder.add(ModBlocks.COPPER_PEDESTAL.asItem(), "Copper Pedestal");
        translationBuilder.add(ModBlocks.EXPOSED_COPPER_PEDESTAL.asItem(), "Exposed Copper Pedestal");
        translationBuilder.add(ModBlocks.WEATHERED_COPPER_PEDESTAL.asItem(), "Weathered Copper Pedestal");
        translationBuilder.add(ModBlocks.OXIDIZED_COPPER_PEDESTAL.asItem(), "Oxidized Copper Pedestal");
        translationBuilder.add(ModBlocks.WAXED_COPPER_PEDESTAL.asItem(), "Waxed Copper Pedestal");
        translationBuilder.add(ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL.asItem(), "Waxed Exposed Copper Pedestal");
        translationBuilder.add(ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL.asItem(), "Waxed Weathered Copper Pedestal");
        translationBuilder.add(ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL.asItem(), "Waxed Oxidized Copper Pedestal");
        translationBuilder.add(ModBlocks.CUT_COPPER_PEDESTAL.asItem(), "Cut Copper Pedestal");
        translationBuilder.add(ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL.asItem(), "Exposed Cut Copper Pedestal");
        translationBuilder.add(ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL.asItem(), "Weathered Cut Copper Pedestal");
        translationBuilder.add(ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL.asItem(), "Oxidized Cut Copper Pedestal");
        translationBuilder.add(ModBlocks.WAXED_CUT_COPPER_PEDESTAL.asItem(), "Waxed Cut Copper Pedestal");
        translationBuilder.add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL.asItem(), "Waxed Exposed Cut Copper Pedestal");
        translationBuilder.add(ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL.asItem(), "Waxed Weathered Cut Copper Pedestal");
        translationBuilder.add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL.asItem(), "Waxed Oxidized Cut Copper Pedestal");
        translationBuilder.add(ModBlocks.BRICK_PEDESTAL.asItem(), "Brick Pedestal");
        translationBuilder.add(ModBlocks.END_STONE_BRICK_PEDESTAL.asItem(), "End Stone Brick Pedestal");
        translationBuilder.add(ModBlocks.MUD_BRICK_PEDESTAL.asItem(), "Mud Brick Pedestal");
        translationBuilder.add(ModBlocks.NETHER_BRICK_PEDESTAL.asItem(), "Nether Brick Pedestal");
        translationBuilder.add(ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL.asItem(), "Polished Blackstone Brick Pedestal");
        translationBuilder.add(ModBlocks.POLISHED_BLACKSTONE_PEDESTAL.asItem(), "Polished Blackstone Pedestal");
        translationBuilder.add(ModBlocks.DARK_PRISMARINE_PEDESTAL.asItem(), "Dark Prismarine Pedestal");
        translationBuilder.add(ModBlocks.PRISMARINE_BRICK_PEDESTAL.asItem(), "Prismarine Brick Pedestal");
        translationBuilder.add(ModBlocks.PURPUR_BLOCK_PEDESTAL.asItem(), "Purpur Pedestal");
        translationBuilder.add(ModBlocks.QUARTZ_BRICK_PEDESTAL.asItem(), "Quartz Brick Pedestal");
        translationBuilder.add(ModBlocks.RED_NETHER_BRICK_PEDESTAL.asItem(), "Red Nether Brick Pedestal");
        translationBuilder.add(ModBlocks.SMOOTH_QUARTZ_PEDESTAL.asItem(), "Smooth Quartz Pedestal");
        translationBuilder.add(ModBlocks.POLISHED_TUFF_PEDESTAL.asItem(), "Polished Tuff Pedestal");
        translationBuilder.add(ModBlocks.TUFF_BRICK_PEDESTAL.asItem(), "Tuff Brick Pedestal");
        translationBuilder.add(ModBlocks.OAK_LOG_PEDESTAL.asItem(), "Oak Wood Pedestal");
        translationBuilder.add(ModBlocks.BIRCH_LOG_PEDESTAL.asItem(), "Birch Wood Pedestal");
        translationBuilder.add(ModBlocks.SPRUCE_LOG_PEDESTAL.asItem(), "Spruce Wood Pedestal");
        translationBuilder.add(ModBlocks.JUNGLE_LOG_PEDESTAL.asItem(), "Jungle Wood Pedestal");
        translationBuilder.add(ModBlocks.DARK_OAK_LOG_PEDESTAL.asItem(), "Dark Oak Wood Pedestal");
        translationBuilder.add(ModBlocks.ACACIA_LOG_PEDESTAL.asItem(), "Acacia Wood Pedestal");
        translationBuilder.add(ModBlocks.MANGROVE_LOG_PEDESTAL.asItem(), "Mangrove Wood Pedestal");
        translationBuilder.add(ModBlocks.CHERRY_LOG_PEDESTAL.asItem(), "Cherry Wood Pedestal");
        translationBuilder.add(ModBlocks.BAMBOO_LOG_PEDESTAL.asItem(), "Bamboo Pedestal");
        translationBuilder.add(ModBlocks.BAMBOO_MOSAIC_PEDESTAL.asItem(), "Bamboo Mosaic Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_OAK_LOG_PEDESTAL.asItem(), "Stripped Oak Wood Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL.asItem(), "Stripped Birch Wood Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL.asItem(), "Stripped Spruce Wood Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL.asItem(), "Stripped Jungle Wood Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL.asItem(), "Stripped Dark Oak Wood Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL.asItem(), "Stripped Acacia Wood Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL.asItem(), "Stripped Mangrove Wood Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL.asItem(), "Stripped Cherry Wood Pedestal");
        translationBuilder.add(ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL.asItem(), "Stripped Bamboo Pedestal");

        addText(translationBuilder, ModItemGroups.PEDESTALS_GROUP.getDisplayName(), "Pedestals");
    }
}
