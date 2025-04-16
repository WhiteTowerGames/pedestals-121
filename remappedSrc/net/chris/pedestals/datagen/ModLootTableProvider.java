package net.chris.pedestals.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static net.chris.pedestals.block.ModBlocks.ALL_FANCY_CARPETS;
import static net.chris.pedestals.block.ModBlocks.ALL_PEDESTALS;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        ALL_PEDESTALS.forEach(this::addDrop);

        ALL_FANCY_CARPETS.forEach(this::addDrop);
    }
}
