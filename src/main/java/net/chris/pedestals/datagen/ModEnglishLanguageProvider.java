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

        addText(translationBuilder, ModItemGroups.PEDESTALS_GROUP.getDisplayName(), "Pedestals");
    }
}
