package net.wgs.pedestals.datagen;

import com.nemonotfound.nemos.woodcutter.datagen.WoodcutterRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class WoodcuttingProvider extends FabricRecipeProvider {

    public WoodcuttingProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new WoodcutterRecipeProvider(wrapperLookup, recipeExporter) {

        };
    }

    @Override
    public String getName() {
        return "";
    }
}
