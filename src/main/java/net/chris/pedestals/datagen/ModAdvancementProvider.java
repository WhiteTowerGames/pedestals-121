package net.chris.pedestals.datagen;

import net.chris.pedestals.*;
import net.chris.pedestals.block.ModBlocks;
import net.chris.pedestals.criteria.ModCriteria;
import net.chris.pedestals.criteria.PlaceEpicItemOnPedestalCriterion;
import net.chris.pedestals.criteria.PlacePedestalOnPedestalCriterion;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider{

    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    public static final Text get_pedestal_title = Text.translatable("advancement.pedestals.get_pedestal_title");
    public static final Text get_pedestal_desc = Text.translatable("advancement.pedestals.get_pedestal_desc");

    public static final Text read_power_of_pedestal_title = Text.translatable("advancement.pedestals.read_power_of_pedestal_title");
    public static final Text read_power_of_pedestal_desc = Text.translatable("advancement.pedestals.read_power_of_pedestal_desc");

    public static final Text place_epic_item_title = Text.translatable("advancement.pedestals.place_epic_item_title");
    public static final Text place_epic_item_desc = Text.translatable("advancement.pedestals.place_epic_item_desc");

    public static final Text place_pedestal_on_pedestal_title = Text.translatable("advancement.pedestals.place_pedestal_on_pedestal_title");
    public static final Text place_pedestal_on_pedestal_desc = Text.translatable("advancement.pedestals.place_pedestal_on_pedestal_desc");

    public static final Text collect_all_pedestals_title = Text.translatable("advancement.pedestals.collect_all_pedestals_title");
    public static final Text collect_all_pedestals_desc = Text.translatable("advancement.pedestals.collect_all_pedestals_desc");

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {

        RegistryEntryLookup<Item> itemLookup = wrapperLookup.getWrapperOrThrow(RegistryKeys.ITEM);
        RegistryEntryLookup<Block> blockLookup = wrapperLookup.getWrapperOrThrow(RegistryKeys.BLOCK);

        BlockPredicate pedestalBlockPredicate = BlockPredicate.Builder.create()
                .tag(ModBlockTagProvider.PEDESTAL_BLOCKS)
                .build();

        ItemPredicate pedestalItemPredicate = ItemPredicate.Builder.create()
                .tag(ModItemTagProvider.PEDESTAL_BLOCK_ITEMS)
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

            @SuppressWarnings("removal") AdvancementEntry place_epic_item = Advancement.Builder.create()
                    .parent(Identifier.of(Pedestals121.MOD_ID,"read_power_of_pedestal"))
                    .display(
                            Items.NETHER_STAR,
                            place_epic_item_title,
                            place_epic_item_desc,
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("place_epic_item", ModCriteria.PLACE_EPIC_ITEM_ON_PEDESTAL.create(
                            new PlaceEpicItemOnPedestalCriterion.Conditions(Optional.empty())))
                    .build(consumer, Pedestals121.MOD_ID + ":place_epic_item_on_pedestal");

            AdvancementEntry place_pedestal_on_pedestal = Advancement.Builder.create()
                    .parent(get_pedestal)
                    .display(
                            ModBlocks.TUFF_BRICK_PEDESTAL,
                            place_pedestal_on_pedestal_title,
                            place_pedestal_on_pedestal_desc,
                            null,
                            AdvancementFrame.CHALLENGE,
                            true,
                            true,
                            true
                    )
                    .criterion("place_pedestal_on_pedestal", ModCriteria.PLACE_PEDESTAL_ON_PEDESTAL.create(
                            new PlacePedestalOnPedestalCriterion.Conditions(Optional.empty())))
                    .build(consumer, Pedestals121.MOD_ID+":place_pedestal_on_pedestal");

            /// This advancement uses a separate, new builder so that I could run a for loop in it.
            Advancement.Builder builder = Advancement.Builder.create().parent(get_pedestal)
                    .display(
                            ModBlocks.END_STONE_BRICK_PEDESTAL,
                            collect_all_pedestals_title,
                            collect_all_pedestals_desc,
                            null,
                            AdvancementFrame.CHALLENGE,
                            true,
                            true,
                            false
                    )
                    .rewards(AdvancementRewards.Builder.experience(250));

        for (Block pedestal : ModBlocks.ALL_PEDESTALS) {

            ItemPredicate allPedestalsItemPredicate = ItemPredicate.Builder.create()
                    .items(pedestal.asItem())
                    .build();

            builder.criterion(
                    Registries.BLOCK.getId(pedestal).getPath(),
                    InventoryChangedCriterion.Conditions.items(allPedestalsItemPredicate)
            );

        }

        builder.build(consumer, Pedestals121.MOD_ID+":collect_all_pedestals");



    }

}

