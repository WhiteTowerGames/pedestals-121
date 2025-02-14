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

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.STONE_BRICK_PEDESTAL, Blocks.STONE);

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

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.DEEPSLATE_BRICK_PEDESTAL, Blocks.COBBLED_DEEPSLATE);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.DEEPSLATE_BRICK_PEDESTAL, Blocks.DEEPSLATE);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEEPSLATE_TILE_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.DEEPSLATE_TILES)
                .criterion(hasItem(Blocks.DEEPSLATE_TILES), conditionsFromItem(Blocks.DEEPSLATE_TILES))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.DEEPSLATE_TILE_PEDESTAL, Blocks.DEEPSLATE_TILES);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.DEEPSLATE_TILE_PEDESTAL, Blocks.COBBLED_DEEPSLATE);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.DEEPSLATE_TILE_PEDESTAL, Blocks.DEEPSLATE);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.POLISHED_GRANITE)
                .criterion(hasItem(Blocks.POLISHED_GRANITE), conditionsFromItem(Blocks.POLISHED_GRANITE))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_GRANITE_PEDESTAL, Blocks.POLISHED_GRANITE);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_GRANITE_PEDESTAL, Blocks.GRANITE);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.POLISHED_DIORITE)
                .criterion(hasItem(Blocks.POLISHED_DIORITE), conditionsFromItem(Blocks.POLISHED_DIORITE))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_DIORITE_PEDESTAL, Blocks.POLISHED_DIORITE);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_DIORITE_PEDESTAL, Blocks.DIORITE);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.POLISHED_ANDESITE)
                .criterion(hasItem(Blocks.POLISHED_ANDESITE), conditionsFromItem(Blocks.POLISHED_ANDESITE))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_ANDESITE_PEDESTAL, Blocks.POLISHED_ANDESITE);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_ANDESITE_PEDESTAL, Blocks.ANDESITE);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DEEPSLATE_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.POLISHED_DEEPSLATE)
                .criterion(hasItem(Blocks.POLISHED_DEEPSLATE), conditionsFromItem(Blocks.POLISHED_DEEPSLATE))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_DEEPSLATE_PEDESTAL, Blocks.POLISHED_DEEPSLATE);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_DEEPSLATE_PEDESTAL, Blocks.COBBLED_DEEPSLATE);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_DEEPSLATE_PEDESTAL, Blocks.DEEPSLATE);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.CALCITE)
                .criterion(hasItem(Blocks.CALCITE), conditionsFromItem(Blocks.CALCITE))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.CALCITE_PEDESTAL, Blocks.CALCITE);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COPPER_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.COPPER_BLOCK)
                .criterion(hasItem(Blocks.COPPER_BLOCK), conditionsFromItem(Blocks.COPPER_BLOCK))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.COPPER_PEDESTAL, Blocks.COPPER_BLOCK);
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXPOSED_COPPER_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.EXPOSED_COPPER)
                .criterion(hasItem(Blocks.EXPOSED_COPPER), conditionsFromItem(Blocks.EXPOSED_COPPER))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.EXPOSED_COPPER_PEDESTAL, Blocks.EXPOSED_COPPER);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WEATHERED_COPPER_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.WEATHERED_COPPER)
                .criterion(hasItem(Blocks.WEATHERED_COPPER), conditionsFromItem(Blocks.WEATHERED_COPPER))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.WEATHERED_COPPER_PEDESTAL, Blocks.WEATHERED_COPPER);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OXIDIZED_COPPER_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.OXIDIZED_COPPER)
                .criterion(hasItem(Blocks.OXIDIZED_COPPER), conditionsFromItem(Blocks.OXIDIZED_COPPER))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.OXIDIZED_COPPER_PEDESTAL, Blocks.OXIDIZED_COPPER);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_COPPER_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.WAXED_COPPER_BLOCK)
                .criterion(hasItem(Blocks.WAXED_COPPER_BLOCK), conditionsFromItem(Blocks.WAXED_COPPER_BLOCK))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.WAXED_COPPER_PEDESTAL, Blocks.WAXED_COPPER_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.WAXED_EXPOSED_COPPER)
                .criterion(hasItem(Blocks.WAXED_EXPOSED_COPPER), conditionsFromItem(Blocks.WAXED_EXPOSED_COPPER))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL, Blocks.WAXED_EXPOSED_COPPER);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.WAXED_WEATHERED_COPPER)
                .criterion(hasItem(Blocks.WAXED_WEATHERED_COPPER), conditionsFromItem(Blocks.WAXED_WEATHERED_COPPER))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL, Blocks.WAXED_WEATHERED_COPPER);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.WAXED_OXIDIZED_COPPER)
                .criterion(hasItem(Blocks.WAXED_OXIDIZED_COPPER), conditionsFromItem(Blocks.WAXED_OXIDIZED_COPPER))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL, Blocks.WAXED_OXIDIZED_COPPER);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_COPPER_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.CUT_COPPER)
                .criterion(hasItem(Blocks.CUT_COPPER), conditionsFromItem(Blocks.CUT_COPPER))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.CUT_COPPER_PEDESTAL, Blocks.CUT_COPPER);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.CUT_COPPER_PEDESTAL, Blocks.COPPER_BLOCK, 4);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.EXPOSED_CUT_COPPER)
                .criterion(hasItem(Blocks.EXPOSED_CUT_COPPER), conditionsFromItem(Blocks.EXPOSED_CUT_COPPER))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL, Blocks.EXPOSED_CUT_COPPER);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL, Blocks.EXPOSED_COPPER, 4);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.WEATHERED_CUT_COPPER)
                .criterion(hasItem(Blocks.WEATHERED_CUT_COPPER), conditionsFromItem(Blocks.WEATHERED_CUT_COPPER))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL, Blocks.WEATHERED_CUT_COPPER);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL, Blocks.WEATHERED_COPPER, 4);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.OXIDIZED_CUT_COPPER)
                .criterion(hasItem(Blocks.OXIDIZED_CUT_COPPER), conditionsFromItem(Blocks.OXIDIZED_CUT_COPPER))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL, Blocks.OXIDIZED_CUT_COPPER);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL, Blocks.OXIDIZED_COPPER, 4);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_CUT_COPPER_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.WAXED_CUT_COPPER)
                .criterion(hasItem(Blocks.WAXED_CUT_COPPER), conditionsFromItem(Blocks.WAXED_CUT_COPPER))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.WAXED_CUT_COPPER_PEDESTAL, Blocks.WAXED_CUT_COPPER);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.WAXED_CUT_COPPER_PEDESTAL, Blocks.WAXED_COPPER_BLOCK, 4);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.WAXED_EXPOSED_CUT_COPPER)
                .criterion(hasItem(Blocks.WAXED_EXPOSED_CUT_COPPER), conditionsFromItem(Blocks.WAXED_EXPOSED_CUT_COPPER))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL, Blocks.WAXED_EXPOSED_CUT_COPPER);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL, Blocks.WAXED_EXPOSED_COPPER, 4);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.WAXED_WEATHERED_CUT_COPPER)
                .criterion(hasItem(Blocks.WAXED_WEATHERED_CUT_COPPER), conditionsFromItem(Blocks.WAXED_WEATHERED_CUT_COPPER))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL, Blocks.WAXED_WEATHERED_CUT_COPPER);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL, Blocks.WAXED_WEATHERED_COPPER, 4);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL)
                .pattern("B")
                .pattern("B")
                .input('B', Blocks.WAXED_OXIDIZED_CUT_COPPER)
                .criterion(hasItem(Blocks.WAXED_OXIDIZED_CUT_COPPER), conditionsFromItem(Blocks.WAXED_OXIDIZED_CUT_COPPER))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL, Blocks.WAXED_OXIDIZED_CUT_COPPER);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL, Blocks.WAXED_OXIDIZED_COPPER, 4);
        
    }
}
