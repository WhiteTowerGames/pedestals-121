package net.chris.pedestals.datagen;

import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.item.ModItems;
import net.chris.pedestals.recipes.KeyDuplicationRecipe;
import net.chris.pedestals.recipes.LockboxDuplicationRecipe;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static net.chris.pedestals.block.ModBlocks.*;
import static net.chris.pedestals.item.ModItems.*;
import static net.minecraft.block.Blocks.GLASS;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {

                PEDESTAL_TO_BLOCK_MAP.forEach((pedestal, block) -> {
                    createShaped(RecipeCategory.BUILDING_BLOCKS, pedestal)
                            .pattern("B")
                            .pattern("B")
                            .input('B', block)
                            .criterion(hasItem(block), conditionsFromItem(block))
                            .offerTo(recipeExporter);

                    offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                            pedestal, block);
                });

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        STONE_BRICK_PEDESTAL, Blocks.STONE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        DEEPSLATE_BRICK_PEDESTAL, Blocks.COBBLED_DEEPSLATE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        DEEPSLATE_BRICK_PEDESTAL, Blocks.DEEPSLATE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        DEEPSLATE_TILE_PEDESTAL, Blocks.COBBLED_DEEPSLATE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        DEEPSLATE_TILE_PEDESTAL, Blocks.DEEPSLATE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        POLISHED_GRANITE_PEDESTAL, Blocks.GRANITE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        POLISHED_DIORITE_PEDESTAL, Blocks.DIORITE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        POLISHED_ANDESITE_PEDESTAL, Blocks.ANDESITE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        POLISHED_DEEPSLATE_PEDESTAL, Blocks.COBBLED_DEEPSLATE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        POLISHED_DEEPSLATE_PEDESTAL, Blocks.DEEPSLATE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        CUT_COPPER_PEDESTAL, Blocks.COPPER_BLOCK, 4);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        EXPOSED_CUT_COPPER_PEDESTAL, Blocks.EXPOSED_COPPER, 4);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        WEATHERED_CUT_COPPER_PEDESTAL, Blocks.WEATHERED_COPPER, 4);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        OXIDIZED_CUT_COPPER_PEDESTAL, Blocks.OXIDIZED_COPPER, 4);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        WAXED_CUT_COPPER_PEDESTAL, Blocks.WAXED_COPPER_BLOCK, 4);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        WAXED_EXPOSED_CUT_COPPER_PEDESTAL, Blocks.WAXED_EXPOSED_COPPER, 4);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        WAXED_WEATHERED_CUT_COPPER_PEDESTAL, Blocks.WAXED_WEATHERED_COPPER, 4);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        WAXED_OXIDIZED_CUT_COPPER_PEDESTAL, Blocks.WAXED_OXIDIZED_COPPER, 4);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        END_STONE_BRICK_PEDESTAL, Blocks.END_STONE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        POLISHED_BLACKSTONE_BRICK_PEDESTAL, Blocks.POLISHED_BLACKSTONE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        POLISHED_BLACKSTONE_BRICK_PEDESTAL, Blocks.BLACKSTONE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        POLISHED_BLACKSTONE_PEDESTAL, Blocks.BLACKSTONE);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        QUARTZ_BRICK_PEDESTAL, Blocks.QUARTZ_BLOCK);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        SMOOTH_QUARTZ_PEDESTAL, Blocks.QUARTZ_BLOCK);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        POLISHED_TUFF_PEDESTAL, Blocks.TUFF);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        TUFF_BRICK_PEDESTAL, Blocks.TUFF);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        TUFF_BRICK_PEDESTAL, Blocks.POLISHED_TUFF);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        CHISELED_TUFF_BRICK_PEDESTAL, Blocks.TUFF_BRICKS);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        CHISELED_TUFF_BRICK_PEDESTAL, Blocks.TUFF);

                offerStonecuttingRecipe( RecipeCategory.BUILDING_BLOCKS,
                        CHISELED_TUFF_BRICK_PEDESTAL, Blocks.POLISHED_TUFF);

                GILDED_TO_NORMAL_CARPET_MAP.forEach((gilded, normal) -> createShaped(RecipeCategory.DECORATIONS, gilded)
                        .pattern("N N")
                        .pattern(" C ")
                        .pattern("N N")
                        .input('C', normal)
                        .input('N', Items.GOLD_NUGGET)
                        .criterion(hasItem(normal), conditionsFromItem(normal))
                        .offerTo(recipeExporter));

                createShaped(RecipeCategory.DECORATIONS, GLASS_LOCKBOX)
                        .pattern(" R ")
                        .pattern("BGB")
                        .pattern(" B ")
                        .input('R', Items.REDSTONE)
                        .input('B', Items.DIAMOND)
                        .input('G', GLASS)
                        .criterion(hasItem(GLASS), conditionsFromItem(GLASS))
                        .offerTo(recipeExporter);

                STAINED_LOCKBOX_TO_GLASS_MAP.forEach((item, block) -> createShaped(RecipeCategory.DECORATIONS, item)
                        .pattern(" R ")
                        .pattern("BGB")
                        .pattern(" B ")
                        .input('R', Items.REDSTONE)
                        .input('B', Items.DIAMOND)
                        .input('G', block)
                        .criterion(hasItem(block), conditionsFromItem(block))
                        .offerTo(recipeExporter));

                createShaped(RecipeCategory.MISC, ModItems.LOCKBOX_KEY)
                        .pattern("GGG")
                        .pattern(" NN")
                        .input('G', Items.GOLD_INGOT)
                        .input('N', Items.GOLD_NUGGET)
                        .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                        .offerTo(recipeExporter, String.valueOf(Identifier.of(Pedestals121.MOD_ID, "lockbox_key_right")));

                createShaped(RecipeCategory.MISC, ModItems.LOCKBOX_KEY)
                        .pattern("GGG")
                        .pattern("NN ")
                        .input('G', Items.GOLD_INGOT)
                        .input('N', Items.GOLD_NUGGET)
                        .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                        .offerTo(recipeExporter, String.valueOf(Identifier.of(Pedestals121.MOD_ID, "lockbox_key_left")));

                createShaped(RecipeCategory.TOOLS, ModItems.LOCKPICK)
                        .pattern("BI")
                        .pattern(" B")
                        .input('B', Items.IRON_BARS)
                        .input('I', Items.IRON_INGOT)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(recipeExporter, "lockpick_right_down");

                createShaped(RecipeCategory.TOOLS, ModItems.LOCKPICK)
                        .pattern("BI")
                        .pattern("B ")
                        .input('B', Items.IRON_BARS)
                        .input('I', Items.IRON_INGOT)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(recipeExporter, "lockpick_left_down");

                createShaped(RecipeCategory.TOOLS, ModItems.LOCKPICK)
                        .pattern(" B")
                        .pattern("BI")
                        .input('B', Items.IRON_BARS)
                        .input('I', Items.IRON_INGOT)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(recipeExporter, "lockpick_right_up");

                createShaped(RecipeCategory.TOOLS, ModItems.LOCKPICK)
                        .pattern("B ")
                        .pattern("BI")
                        .input('B', Items.IRON_BARS)
                        .input('I', Items.IRON_INGOT)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(recipeExporter, "lockpick_left_up");

                /// Special duping recipes (produce blank json)

                Recipe<?> KeyDuplicationRecipe = new KeyDuplicationRecipe(CraftingRecipeCategory.MISC);
                recipeExporter.accept(RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(Pedestals121.MOD_ID, "key_duplication")), KeyDuplicationRecipe, null);

                Recipe<?> LockboxDuplicationRecipe = new LockboxDuplicationRecipe(CraftingRecipeCategory.MISC);
                recipeExporter.accept(RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(Pedestals121.MOD_ID, "lockbox_duplication")), LockboxDuplicationRecipe, null);
            }
        };
    }

    @Override
    public String getName() {
        return "Mod Recipe Provider";
    }
}
