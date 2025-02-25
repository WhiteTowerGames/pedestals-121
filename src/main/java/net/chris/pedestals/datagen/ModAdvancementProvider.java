package net.chris.pedestals.datagen;

import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {

    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    public static final Text get_pedestal_title = Text.translatable("advancement.pedestals.get_pedestal_title");
    public static final Text get_pedestal_desc = Text.translatable("advancement.pedestals.get_pedestal_desc");

    public static final Text read_power_of_pedestal_title = Text.translatable("advancement.pedestals.read_power_of_pedestal_title");
    public static final Text read_power_of_pedestal_desc = Text.translatable("advancement.pedestals.read_power_of_pedestal_desc");

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {

        RegistryEntryLookup<Item> itemLookup = wrapperLookup.getOrThrow(RegistryKeys.ITEM);
        RegistryEntryLookup<Block> blockLookup = wrapperLookup.getOrThrow(RegistryKeys.BLOCK);

        BlockPredicate pedestalBlockPredicate = BlockPredicate.Builder.create()
                .tag(blockLookup, ModBlockTagProvider.PEDESTAL_BLOCKS)
                .build();

        ItemPredicate pedestalItemPredicate = ItemPredicate.Builder.create()
                .tag(itemLookup, ModItemTagProvider.PEDESTAL_BLOCK_ITEMS)
                .build();




            AdvancementEntry get_pedestal = Advancement.Builder.create()
                    .display(
                            ModBlocks.STONE_BRICK_PEDESTAL,
                            get_pedestal_title,
                            get_pedestal_desc,
                            Identifier.ofVanilla("textures/gui/advancements/backgrounds/stone.png"),
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )
                    .criterion("got_pedestal", InventoryChangedCriterion.Conditions.items(pedestalItemPredicate))
                    .build(consumer, Pedestals121.MOD_ID + ":get_pedestal");

//            AdvancementEntry read_power_of_pedestal.json = Advancement.Builder.create()
//                    .parent(get_pedestal)
//                    .display(
//                            Blocks.COMPARATOR,
//                            read_power_of_pedestal_title,
//                            read_power_of_pedestal_desc,
//                            null,
//                            AdvancementFrame.GOAL,
//                            true,
//                            true,
//                            false
//                    )
//                    .criterion("read_power_of_pedestal.json", )

    }
}
