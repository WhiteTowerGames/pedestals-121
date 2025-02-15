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
        super(dataOutput, registryLookup);
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

        addText(translationBuilder, ModItemGroups.PEDESTALS_GROUP.getDisplayName(), "Pedestals");
    }
}
