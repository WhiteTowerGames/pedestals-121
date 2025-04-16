package net.chris.pedestals.recipes;

import net.chris.pedestals.Pedestals121;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeSerializers {

    public static final RecipeSerializer<KeyDuplicationRecipe> KEY_DUPLICATION_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(Pedestals121.MOD_ID, "key_duplication"),
                    new SpecialCraftingRecipe.SpecialRecipeSerializer<>(KeyDuplicationRecipe::new));

    public static final RecipeSerializer<LockboxDuplicationRecipe> LOCKBOX_DUPLICATION_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(Pedestals121.MOD_ID, "lockbox_duplication"),
                    new SpecialCraftingRecipe.SpecialRecipeSerializer<>(LockboxDuplicationRecipe::new));

    public static void initialize(){}

}
