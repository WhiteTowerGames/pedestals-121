package net.chris.pedestals.datagen;

import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {

    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry getPedestal = Advancement.Builder.create()
                .display(
                        ModBlocks.STONE_BRICK_PEDESTAL,
                        Text.literal("Your first Pedestal"),
                        Text.literal("Now display your trophies in it"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_pedestal", InventoryChangedCriterion.Conditions.items(ModBlocks.STONE_BRICK_PEDESTAL.asItem()))
                .build(consumer, Pedestals121.MOD_ID + ":get_pedestal");
    }
}
