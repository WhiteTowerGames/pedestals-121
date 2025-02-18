package net.chris.pedestals.datagen;

import net.chris.pedestals.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_BRICK_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.STONE_BRICKS)
                        .criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.STONE_BRICK_PEDESTAL, Blocks.STONE_BRICKS);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.STONE_BRICK_PEDESTAL, Blocks.STONE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_STONE_BRICK_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.MOSSY_STONE_BRICKS)
                        .criterion(hasItem(Blocks.MOSSY_STONE_BRICKS), conditionsFromItem(Blocks.MOSSY_STONE_BRICKS))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.MOSSY_STONE_BRICK_PEDESTAL, Blocks.MOSSY_STONE_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEEPSLATE_BRICK_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.DEEPSLATE_BRICKS)
                        .criterion(hasItem(Blocks.DEEPSLATE_BRICKS), conditionsFromItem(Blocks.DEEPSLATE_BRICKS))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.DEEPSLATE_BRICK_PEDESTAL, Blocks.DEEPSLATE_BRICKS);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.DEEPSLATE_BRICK_PEDESTAL, Blocks.COBBLED_DEEPSLATE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.DEEPSLATE_BRICK_PEDESTAL, Blocks.DEEPSLATE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEEPSLATE_TILE_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.DEEPSLATE_TILES)
                        .criterion(hasItem(Blocks.DEEPSLATE_TILES), conditionsFromItem(Blocks.DEEPSLATE_TILES))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.DEEPSLATE_TILE_PEDESTAL, Blocks.DEEPSLATE_TILES);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.DEEPSLATE_TILE_PEDESTAL, Blocks.COBBLED_DEEPSLATE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.DEEPSLATE_TILE_PEDESTAL, Blocks.DEEPSLATE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.POLISHED_GRANITE)
                        .criterion(hasItem(Blocks.POLISHED_GRANITE), conditionsFromItem(Blocks.POLISHED_GRANITE))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_GRANITE_PEDESTAL, Blocks.POLISHED_GRANITE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_GRANITE_PEDESTAL, Blocks.GRANITE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.POLISHED_DIORITE)
                        .criterion(hasItem(Blocks.POLISHED_DIORITE), conditionsFromItem(Blocks.POLISHED_DIORITE))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_DIORITE_PEDESTAL, Blocks.POLISHED_DIORITE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_DIORITE_PEDESTAL, Blocks.DIORITE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.POLISHED_ANDESITE)
                        .criterion(hasItem(Blocks.POLISHED_ANDESITE), conditionsFromItem(Blocks.POLISHED_ANDESITE))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_ANDESITE_PEDESTAL, Blocks.POLISHED_ANDESITE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_ANDESITE_PEDESTAL, Blocks.ANDESITE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DEEPSLATE_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.POLISHED_DEEPSLATE)
                        .criterion(hasItem(Blocks.POLISHED_DEEPSLATE), conditionsFromItem(Blocks.POLISHED_DEEPSLATE))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_DEEPSLATE_PEDESTAL, Blocks.POLISHED_DEEPSLATE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_DEEPSLATE_PEDESTAL, Blocks.COBBLED_DEEPSLATE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_DEEPSLATE_PEDESTAL, Blocks.DEEPSLATE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.CALCITE)
                        .criterion(hasItem(Blocks.CALCITE), conditionsFromItem(Blocks.CALCITE))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.CALCITE_PEDESTAL, Blocks.CALCITE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COPPER_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.COPPER_BLOCK)
                        .criterion(hasItem(Blocks.COPPER_BLOCK), conditionsFromItem(Blocks.COPPER_BLOCK))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.COPPER_PEDESTAL, Blocks.COPPER_BLOCK);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXPOSED_COPPER_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.EXPOSED_COPPER)
                        .criterion(hasItem(Blocks.EXPOSED_COPPER), conditionsFromItem(Blocks.EXPOSED_COPPER))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.EXPOSED_COPPER_PEDESTAL, Blocks.EXPOSED_COPPER);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WEATHERED_COPPER_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.WEATHERED_COPPER)
                        .criterion(hasItem(Blocks.WEATHERED_COPPER), conditionsFromItem(Blocks.WEATHERED_COPPER))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.WEATHERED_COPPER_PEDESTAL, Blocks.WEATHERED_COPPER);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OXIDIZED_COPPER_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.OXIDIZED_COPPER)
                        .criterion(hasItem(Blocks.OXIDIZED_COPPER), conditionsFromItem(Blocks.OXIDIZED_COPPER))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.OXIDIZED_COPPER_PEDESTAL, Blocks.OXIDIZED_COPPER);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_COPPER_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.WAXED_COPPER_BLOCK)
                        .criterion(hasItem(Blocks.WAXED_COPPER_BLOCK), conditionsFromItem(Blocks.WAXED_COPPER_BLOCK))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.WAXED_COPPER_PEDESTAL, Blocks.WAXED_COPPER_BLOCK);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.WAXED_EXPOSED_COPPER)
                        .criterion(hasItem(Blocks.WAXED_EXPOSED_COPPER), conditionsFromItem(Blocks.WAXED_EXPOSED_COPPER))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL, Blocks.WAXED_EXPOSED_COPPER);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.WAXED_WEATHERED_COPPER)
                        .criterion(hasItem(Blocks.WAXED_WEATHERED_COPPER), conditionsFromItem(Blocks.WAXED_WEATHERED_COPPER))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL, Blocks.WAXED_WEATHERED_COPPER);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.WAXED_OXIDIZED_COPPER)
                        .criterion(hasItem(Blocks.WAXED_OXIDIZED_COPPER), conditionsFromItem(Blocks.WAXED_OXIDIZED_COPPER))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL, Blocks.WAXED_OXIDIZED_COPPER);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_COPPER_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.CUT_COPPER)
                        .criterion(hasItem(Blocks.CUT_COPPER), conditionsFromItem(Blocks.CUT_COPPER))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.CUT_COPPER_PEDESTAL, Blocks.CUT_COPPER);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.CUT_COPPER_PEDESTAL, Blocks.COPPER_BLOCK, 4);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.EXPOSED_CUT_COPPER)
                        .criterion(hasItem(Blocks.EXPOSED_CUT_COPPER), conditionsFromItem(Blocks.EXPOSED_CUT_COPPER))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL, Blocks.EXPOSED_CUT_COPPER);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL, Blocks.EXPOSED_COPPER, 4);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.WEATHERED_CUT_COPPER)
                        .criterion(hasItem(Blocks.WEATHERED_CUT_COPPER), conditionsFromItem(Blocks.WEATHERED_CUT_COPPER))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL, Blocks.WEATHERED_CUT_COPPER);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL, Blocks.WEATHERED_COPPER, 4);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.OXIDIZED_CUT_COPPER)
                        .criterion(hasItem(Blocks.OXIDIZED_CUT_COPPER), conditionsFromItem(Blocks.OXIDIZED_CUT_COPPER))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL, Blocks.OXIDIZED_CUT_COPPER);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL, Blocks.OXIDIZED_COPPER, 4);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_CUT_COPPER_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.WAXED_CUT_COPPER)
                        .criterion(hasItem(Blocks.WAXED_CUT_COPPER), conditionsFromItem(Blocks.WAXED_CUT_COPPER))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.WAXED_CUT_COPPER_PEDESTAL, Blocks.WAXED_CUT_COPPER);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.WAXED_CUT_COPPER_PEDESTAL, Blocks.WAXED_COPPER_BLOCK, 4);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.WAXED_EXPOSED_CUT_COPPER)
                        .criterion(hasItem(Blocks.WAXED_EXPOSED_CUT_COPPER), conditionsFromItem(Blocks.WAXED_EXPOSED_CUT_COPPER))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL, Blocks.WAXED_EXPOSED_CUT_COPPER);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL, Blocks.WAXED_EXPOSED_COPPER, 4);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.WAXED_WEATHERED_CUT_COPPER)
                        .criterion(hasItem(Blocks.WAXED_WEATHERED_CUT_COPPER), conditionsFromItem(Blocks.WAXED_WEATHERED_CUT_COPPER))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL, Blocks.WAXED_WEATHERED_CUT_COPPER);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL, Blocks.WAXED_WEATHERED_COPPER, 4);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.WAXED_OXIDIZED_CUT_COPPER)
                        .criterion(hasItem(Blocks.WAXED_OXIDIZED_CUT_COPPER), conditionsFromItem(Blocks.WAXED_OXIDIZED_CUT_COPPER))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL, Blocks.WAXED_OXIDIZED_CUT_COPPER);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL, Blocks.WAXED_OXIDIZED_COPPER, 4);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.BRICKS)
                        .criterion(hasItem(Blocks.BRICKS), conditionsFromItem(Blocks.BRICKS))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.BRICK_PEDESTAL, Blocks.BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_STONE_BRICK_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.END_STONE_BRICKS)
                        .criterion(hasItem(Blocks.END_STONE_BRICKS), conditionsFromItem(Blocks.END_STONE_BRICKS))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.END_STONE_BRICK_PEDESTAL, Blocks.END_STONE_BRICKS);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.END_STONE_BRICK_PEDESTAL, Blocks.END_STONE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MUD_BRICK_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.MUD_BRICKS)
                        .criterion(hasItem(Blocks.MUD_BRICKS), conditionsFromItem(Blocks.MUD_BRICKS))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHER_BRICK_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.NETHER_BRICKS)
                        .criterion(hasItem(Blocks.NETHER_BRICKS), conditionsFromItem(Blocks.NETHER_BRICKS))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.NETHER_BRICK_PEDESTAL, Blocks.NETHER_BRICKS);


                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.POLISHED_BLACKSTONE_BRICKS)
                        .criterion(hasItem(Blocks.POLISHED_BLACKSTONE_BRICKS), conditionsFromItem(Blocks.POLISHED_BLACKSTONE_BRICKS))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL, Blocks.POLISHED_BLACKSTONE_BRICKS);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL, Blocks.POLISHED_BLACKSTONE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL, Blocks.BLACKSTONE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_BLACKSTONE_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.POLISHED_BLACKSTONE)
                        .criterion(hasItem(Blocks.POLISHED_BLACKSTONE), conditionsFromItem(Blocks.POLISHED_BLACKSTONE))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_BLACKSTONE_PEDESTAL, Blocks.POLISHED_BLACKSTONE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_BLACKSTONE_PEDESTAL, Blocks.BLACKSTONE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_PRISMARINE_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.DARK_PRISMARINE)
                        .criterion(hasItem(Blocks.DARK_PRISMARINE), conditionsFromItem(Blocks.DARK_PRISMARINE))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.DARK_PRISMARINE_PEDESTAL, Blocks.DARK_PRISMARINE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRISMARINE_BRICK_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.PRISMARINE_BRICKS)
                        .criterion(hasItem(Blocks.PRISMARINE_BRICKS), conditionsFromItem(Blocks.PRISMARINE_BRICKS))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.PRISMARINE_BRICK_PEDESTAL, Blocks.PRISMARINE_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPUR_BLOCK_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.PURPUR_BLOCK)
                        .criterion(hasItem(Blocks.PURPUR_BLOCK), conditionsFromItem(Blocks.PURPUR_BLOCK))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.PURPUR_BLOCK_PEDESTAL, Blocks.PURPUR_BLOCK);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_BRICK_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.QUARTZ_BRICKS)
                        .criterion(hasItem(Blocks.QUARTZ_BRICKS), conditionsFromItem(Blocks.QUARTZ_BRICKS))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.QUARTZ_BRICK_PEDESTAL, Blocks.QUARTZ_BRICKS);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.QUARTZ_BRICK_PEDESTAL, Blocks.QUARTZ_BLOCK);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_NETHER_BRICK_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.RED_NETHER_BRICKS)
                        .criterion(hasItem(Blocks.RED_NETHER_BRICKS), conditionsFromItem(Blocks.RED_NETHER_BRICKS))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.RED_NETHER_BRICK_PEDESTAL, Blocks.RED_NETHER_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_QUARTZ_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.SMOOTH_QUARTZ)
                        .criterion(hasItem(Blocks.SMOOTH_QUARTZ), conditionsFromItem(Blocks.SMOOTH_QUARTZ))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.SMOOTH_QUARTZ_PEDESTAL, Blocks.SMOOTH_QUARTZ);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.SMOOTH_QUARTZ_PEDESTAL, Blocks.QUARTZ_BLOCK);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_TUFF_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.POLISHED_TUFF)
                        .criterion(hasItem(Blocks.POLISHED_TUFF), conditionsFromItem(Blocks.POLISHED_TUFF))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_TUFF_PEDESTAL, Blocks.POLISHED_TUFF);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_TUFF_PEDESTAL, Blocks.TUFF);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TUFF_BRICK_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.TUFF_BRICKS)
                        .criterion(hasItem(Blocks.TUFF_BRICKS), conditionsFromItem(Blocks.TUFF_BRICKS))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.TUFF_BRICK_PEDESTAL, Blocks.TUFF_BRICKS);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.TUFF_BRICK_PEDESTAL, Blocks.TUFF);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.TUFF_BRICK_PEDESTAL, Blocks.POLISHED_TUFF);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_TUFF_BRICK_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.CHISELED_TUFF_BRICKS)
                        .criterion(hasItem(Blocks.CHISELED_TUFF_BRICKS), conditionsFromItem(Blocks.CHISELED_TUFF_BRICKS))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.CHISELED_TUFF_BRICK_PEDESTAL, Blocks.CHISELED_TUFF_BRICKS);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.CHISELED_TUFF_BRICK_PEDESTAL, Blocks.TUFF_BRICKS);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.CHISELED_TUFF_BRICK_PEDESTAL, Blocks.TUFF);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.CHISELED_TUFF_BRICK_PEDESTAL, Blocks.POLISHED_TUFF);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAK_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.OAK_LOG)
                        .criterion(hasItem(Blocks.OAK_LOG), conditionsFromItem(Blocks.OAK_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIRCH_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.BIRCH_LOG)
                        .criterion(hasItem(Blocks.BIRCH_LOG), conditionsFromItem(Blocks.BIRCH_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPRUCE_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.SPRUCE_LOG)
                        .criterion(hasItem(Blocks.SPRUCE_LOG), conditionsFromItem(Blocks.SPRUCE_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JUNGLE_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.JUNGLE_LOG)
                        .criterion(hasItem(Blocks.JUNGLE_LOG), conditionsFromItem(Blocks.JUNGLE_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_OAK_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.DARK_OAK_LOG)
                        .criterion(hasItem(Blocks.DARK_OAK_LOG), conditionsFromItem(Blocks.DARK_OAK_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACACIA_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.ACACIA_LOG)
                        .criterion(hasItem(Blocks.ACACIA_LOG), conditionsFromItem(Blocks.ACACIA_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MANGROVE_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.MANGROVE_LOG)
                        .criterion(hasItem(Blocks.MANGROVE_LOG), conditionsFromItem(Blocks.MANGROVE_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHERRY_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.CHERRY_LOG)
                        .criterion(hasItem(Blocks.CHERRY_LOG), conditionsFromItem(Blocks.CHERRY_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BAMBOO_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.BAMBOO_BLOCK)
                        .criterion(hasItem(Blocks.BAMBOO_BLOCK), conditionsFromItem(Blocks.BAMBOO_BLOCK))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BAMBOO_MOSAIC_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.BAMBOO_MOSAIC)
                        .criterion(hasItem(Blocks.BAMBOO_MOSAIC), conditionsFromItem(Blocks.BAMBOO_MOSAIC))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_OAK_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.STRIPPED_OAK_LOG)
                        .criterion(hasItem(Blocks.STRIPPED_OAK_LOG), conditionsFromItem(Blocks.STRIPPED_OAK_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.STRIPPED_BIRCH_LOG)
                        .criterion(hasItem(Blocks.STRIPPED_BIRCH_LOG), conditionsFromItem(Blocks.STRIPPED_BIRCH_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.STRIPPED_SPRUCE_LOG)
                        .criterion(hasItem(Blocks.STRIPPED_SPRUCE_LOG), conditionsFromItem(Blocks.STRIPPED_SPRUCE_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.STRIPPED_JUNGLE_LOG)
                        .criterion(hasItem(Blocks.STRIPPED_JUNGLE_LOG), conditionsFromItem(Blocks.STRIPPED_JUNGLE_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.STRIPPED_DARK_OAK_LOG)
                        .criterion(hasItem(Blocks.STRIPPED_DARK_OAK_LOG), conditionsFromItem(Blocks.STRIPPED_DARK_OAK_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.STRIPPED_ACACIA_LOG)
                        .criterion(hasItem(Blocks.STRIPPED_ACACIA_LOG), conditionsFromItem(Blocks.STRIPPED_ACACIA_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.STRIPPED_MANGROVE_LOG)
                        .criterion(hasItem(Blocks.STRIPPED_MANGROVE_LOG), conditionsFromItem(Blocks.STRIPPED_MANGROVE_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.STRIPPED_CHERRY_LOG)
                        .criterion(hasItem(Blocks.STRIPPED_CHERRY_LOG), conditionsFromItem(Blocks.STRIPPED_CHERRY_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.STRIPPED_BAMBOO_BLOCK)
                        .criterion(hasItem(Blocks.STRIPPED_BAMBOO_BLOCK), conditionsFromItem(Blocks.STRIPPED_BAMBOO_BLOCK))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_OAK_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.PALE_OAK_LOG)
                        .criterion(hasItem(Blocks.PALE_OAK_LOG), conditionsFromItem(Blocks.PALE_OAK_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_PALE_OAK_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.STRIPPED_PALE_OAK_LOG)
                        .criterion(hasItem(Blocks.STRIPPED_PALE_OAK_LOG), conditionsFromItem(Blocks.STRIPPED_PALE_OAK_LOG))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.CRIMSON_STEM)
                        .criterion(hasItem(Blocks.CRIMSON_STEM), conditionsFromItem(Blocks.CRIMSON_STEM))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_CRIMSON_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.STRIPPED_CRIMSON_STEM)
                        .criterion(hasItem(Blocks.STRIPPED_CRIMSON_STEM), conditionsFromItem(Blocks.STRIPPED_CRIMSON_STEM))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.WARPED_STEM)
                        .criterion(hasItem(Blocks.WARPED_STEM), conditionsFromItem(Blocks.WARPED_STEM))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_WARPED_LOG_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.STRIPPED_WARPED_STEM)
                        .criterion(hasItem(Blocks.STRIPPED_WARPED_STEM), conditionsFromItem(Blocks.STRIPPED_WARPED_STEM))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RESIN_BRICK_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.RESIN_BRICKS)
                        .criterion(hasItem(Blocks.RESIN_BRICKS), conditionsFromItem(Blocks.RESIN_BRICKS))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RESIN_BRICK_PEDESTAL, Blocks.RESIN_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SANDSTONE_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.SMOOTH_SANDSTONE)
                        .criterion(hasItem(Blocks.SMOOTH_SANDSTONE), conditionsFromItem(Blocks.SMOOTH_SANDSTONE))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SANDSTONE_PEDESTAL, Blocks.SMOOTH_SANDSTONE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_RED_SANDSTONE_PEDESTAL)
                        .pattern("B")
                        .pattern("B")
                        .input('B', Blocks.SMOOTH_RED_SANDSTONE)
                        .criterion(hasItem(Blocks.SMOOTH_RED_SANDSTONE), conditionsFromItem(Blocks.SMOOTH_RED_SANDSTONE))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_RED_SANDSTONE_PEDESTAL, Blocks.SMOOTH_RED_SANDSTONE);

            }
        };
    }

    @Override
    public String getName() {
        return "Mod Recipe Provider";
    }
}
