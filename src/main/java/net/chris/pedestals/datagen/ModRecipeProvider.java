package net.chris.pedestals.datagen;

import net.chris.pedestals.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_BRICK_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.STONE_BRICKS)
                .criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.STONE_BRICK_PEDESTAL, Blocks.STONE_BRICKS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_STONE_BRICK_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.MOSSY_STONE_BRICKS)
                .criterion(hasItem(Blocks.MOSSY_STONE_BRICKS), conditionsFromItem(Blocks.MOSSY_STONE_BRICKS))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.MOSSY_STONE_BRICK_PEDESTAL, Blocks.MOSSY_STONE_BRICKS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEEPSLATE_BRICK_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.DEEPSLATE_BRICKS)
                .criterion(hasItem(Blocks.DEEPSLATE_BRICKS), conditionsFromItem(Blocks.DEEPSLATE_BRICKS))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.DEEPSLATE_BRICK_PEDESTAL, Blocks.DEEPSLATE_BRICKS);



    }
}
