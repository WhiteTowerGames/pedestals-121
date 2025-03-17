package net.chris.pedestals.datagen;

import net.chris.pedestals.Pedestals121;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static net.chris.pedestals.block.ModBlocks.*;
import static net.chris.pedestals.item.ModItems.*;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    public static final TagKey<Item> PEDESTAL_BLOCK_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(Pedestals121.MOD_ID, "pedestal_block_items"));

    public static final TagKey<Item> FANCY_CARPET_BLOCK_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(Pedestals121.MOD_ID, "fancy_carpet_block_items"));

    public static final TagKey<Item> LOCKBOX_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(Pedestals121.MOD_ID, "lockbox_block_items"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        ALL_PEDESTALS.forEach(block -> getOrCreateTagBuilder(PEDESTAL_BLOCK_ITEMS).add(block.asItem()));

        GILDED_TO_NORMAL_CARPET_MAP.keySet().forEach(block -> getOrCreateTagBuilder(FANCY_CARPET_BLOCK_ITEMS).add(block.asItem()));

        STAINED_LOCKBOX_TO_GLASS_MAP.keySet().forEach(item -> getOrCreateTagBuilder(LOCKBOX_ITEMS).add(item));

        getOrCreateTagBuilder(LOCKBOX_ITEMS)
                .add(GLASS_LOCKBOX);

    }
}
