package net.chris.pedestals.datagen;

import com.nemonotfound.nemos.woodcutter.datagen.WoodcutterRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.chris.pedestals.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class WoodcuttingProvider extends FabricRecipeProvider {

    public WoodcuttingProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

/// Woodcutting compatibility recipe data generator - courtesy of Nemo himself. Thanks Nemo and pnku!

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        RecipeExporter exporterWithCondition = withConditions(recipeExporter, ResourceConditions.allModsLoaded("nemos_woodcutter"));
            return new WoodcutterRecipeProvider(wrapperLookup, exporterWithCondition) {
                @Override
                public void generate() {
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.OAK_LOG, ModBlocks.OAK_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.OAK_LOG, ModBlocks.STRIPPED_OAK_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_OAK_LOG, ModBlocks.STRIPPED_OAK_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_OAK_WOOD, ModBlocks.STRIPPED_OAK_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.OAK_WOOD, ModBlocks.STRIPPED_OAK_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.OAK_WOOD, ModBlocks.OAK_LOG_PEDESTAL.asItem(), 1);

                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.BIRCH_LOG, ModBlocks.BIRCH_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.BIRCH_LOG, ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_BIRCH_LOG, ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_BIRCH_WOOD, ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.BIRCH_WOOD, ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.BIRCH_WOOD, ModBlocks.BIRCH_LOG_PEDESTAL.asItem(), 1);
                    
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.SPRUCE_LOG, ModBlocks.SPRUCE_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.SPRUCE_LOG, ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_SPRUCE_LOG, ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_SPRUCE_WOOD, ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.SPRUCE_WOOD, ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.SPRUCE_WOOD, ModBlocks.SPRUCE_LOG_PEDESTAL.asItem(), 1);
                    

                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.DARK_OAK_LOG, ModBlocks.DARK_OAK_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.DARK_OAK_LOG, ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_DARK_OAK_LOG, ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_DARK_OAK_WOOD, ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.DARK_OAK_WOOD, ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.DARK_OAK_WOOD, ModBlocks.DARK_OAK_LOG_PEDESTAL.asItem(), 1); 
                    
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.ACACIA_LOG, ModBlocks.ACACIA_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.ACACIA_LOG, ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_ACACIA_LOG, ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_ACACIA_WOOD, ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.ACACIA_WOOD, ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.ACACIA_WOOD, ModBlocks.ACACIA_LOG_PEDESTAL.asItem(), 1);

                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.MANGROVE_LOG, ModBlocks.MANGROVE_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.MANGROVE_LOG, ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_MANGROVE_LOG, ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_MANGROVE_WOOD, ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.MANGROVE_WOOD, ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.MANGROVE_WOOD, ModBlocks.MANGROVE_LOG_PEDESTAL.asItem(), 1);

                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.CHERRY_LOG, ModBlocks.CHERRY_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.CHERRY_LOG, ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_CHERRY_LOG, ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_CHERRY_WOOD, ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.CHERRY_WOOD, ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.CHERRY_WOOD, ModBlocks.CHERRY_LOG_PEDESTAL.asItem(), 1);

                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.PALE_OAK_LOG, ModBlocks.PALE_OAK_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.PALE_OAK_LOG, ModBlocks.STRIPPED_PALE_OAK_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_PALE_OAK_LOG, ModBlocks.STRIPPED_PALE_OAK_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_PALE_OAK_WOOD, ModBlocks.STRIPPED_PALE_OAK_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.PALE_OAK_WOOD, ModBlocks.STRIPPED_PALE_OAK_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.PALE_OAK_WOOD, ModBlocks.PALE_OAK_LOG_PEDESTAL.asItem(), 1);

                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.CRIMSON_STEM, ModBlocks.CRIMSON_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.CRIMSON_STEM, ModBlocks.STRIPPED_CRIMSON_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_CRIMSON_STEM, ModBlocks.STRIPPED_CRIMSON_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_CRIMSON_HYPHAE, ModBlocks.STRIPPED_CRIMSON_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.CRIMSON_HYPHAE, ModBlocks.STRIPPED_CRIMSON_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.CRIMSON_HYPHAE, ModBlocks.CRIMSON_LOG_PEDESTAL.asItem(), 1);

                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.WARPED_STEM, ModBlocks.WARPED_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.WARPED_STEM, ModBlocks.STRIPPED_WARPED_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_WARPED_STEM, ModBlocks.STRIPPED_WARPED_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_WARPED_HYPHAE, ModBlocks.STRIPPED_WARPED_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.WARPED_HYPHAE, ModBlocks.STRIPPED_WARPED_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.WARPED_HYPHAE, ModBlocks.WARPED_LOG_PEDESTAL.asItem(), 1);

                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.BAMBOO_BLOCK, ModBlocks.BAMBOO_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.BAMBOO_BLOCK, ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_BAMBOO_BLOCK, ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.BAMBOO_BLOCK, ModBlocks.BAMBOO_MOSAIC_PEDESTAL.asItem(), 1);
                    createWoodcuttingRecipe(RecipeCategory.DECORATIONS, Blocks.STRIPPED_BAMBOO_BLOCK, ModBlocks.BAMBOO_MOSAIC_PEDESTAL.asItem(), 1);



                }
            };
    }

    @Override
    public String getName() {
        return "Nemo's Woodcutter Compatibility Recipe Provider (That's a mouthful!)";
    }
}
