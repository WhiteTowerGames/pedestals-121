package net.chris.pedestals.datagen;

import net.chris.pedestals.*;
import net.chris.pedestals.block.ModBlocks;
import net.chris.pedestals.criteria.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.*;
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

import static net.chris.pedestals.block.ModBlocks.*;
import static net.chris.pedestals.item.ModItems.*;
import static net.minecraft.item.Items.BRUSH;
import static net.minecraft.item.Items.TOTEM_OF_UNDYING;

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

    public static final Text get_fancy_carpet_title = Text.translatable("advancement.pedestals.get_fancy_carpet_title");
    public static final Text get_fancy_carpet_desc = Text.translatable("advancement.pedestals.get_fancy_carpet_desc");

    public static final Text get_lockbox_title = Text.translatable("advancement.pedestals.get_lockbox_title");
    public static final Text get_lockbox_desc = Text.translatable("advancement.pedestals.get_lockbox_desc");

    public static final Text use_key_title = Text.translatable("advancement.pedestals.use_key_title");
    public static final Text use_key_desc = Text.translatable("advancement.pedestals.use_key_desc");

    public static final Text break_lockpick_title = Text.translatable("advancement.pedestals.break_lockpick_title");
    public static final Text break_lockpick_desc = Text.translatable("advancement.pedestals.break_lockpick_desc");

    public static final Text pick_lock_title = Text.translatable("advancement.pedestals.pick_lock_title");
    public static final Text pick_lock_desc = Text.translatable("advancement.pedestals.pick_lock_desc");

    public static final Text carpet_lock_artifact_title = Text.translatable("advancement.pedestals.carpet_lock_artifact_title");
    public static final Text carpet_lock_artifact_desc = Text.translatable("advancement.pedestals.carpet_lock_artifact_desc");

    public static final Text all_the_colors_title = Text.translatable("advancement.pedestals.all_the_colors_title");
    public static final Text all_the_colors_desc = Text.translatable("advancement.pedestals.all_the_colors_desc");

    public static final Text fully_clean_lockbox_title = Text.translatable("advancement.pedestals.fully_clean_lockbox_title");
    public static final Text fully_clean_lockbox_desc = Text.translatable("advancement.pedestals.fully_clean_lockbox_desc");

    @SuppressWarnings("unused")
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
        
        ItemPredicate fancyCarpetItemPredicate = ItemPredicate.Builder.create()
                .tag(itemLookup, ModItemTagProvider.FANCY_CARPET_BLOCK_ITEMS)
                .build();

        ItemPredicate lockboxItemPredicate = ItemPredicate.Builder.create()
                .tag(itemLookup, ModItemTagProvider.LOCKBOX_ITEMS)
                .build();

        AdvancementEntry get_pedestal = Advancement.Builder.create()
                .display(
                        STONE_BRICK_PEDESTAL,
                        get_pedestal_title,
                        get_pedestal_desc,
                        Identifier.ofVanilla("gui/advancements/backgrounds/adventure"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_pedestal", InventoryChangedCriterion.Conditions.items(pedestalItemPredicate))
                .build(consumer, Pedestals121.MOD_ID + ":get_pedestal");

        @SuppressWarnings("removal")AdvancementEntry place_epic_item = Advancement.Builder.create()
                .parent(Identifier.of(Pedestals121.MOD_ID, "read_power_of_pedestal"))
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
                .build(consumer, Pedestals121.MOD_ID + ":place_pedestal_on_pedestal");

        /// This advancement uses a separate, new builder so that I could run a for loop in it.
        final Advancement.Builder builder = Advancement.Builder.create().parent(get_pedestal)
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

        PEDESTAL_TO_BLOCK_MAP.keySet().forEach(pedestal -> {
            ItemPredicate allPedestalsItemPredicate = ItemPredicate.Builder.create()
                    .items(itemLookup, pedestal.asItem())
                    .build();
            builder.criterion(
                    Registries.BLOCK.getId(pedestal).getPath(),
                    InventoryChangedCriterion.Conditions.items(allPedestalsItemPredicate)
            );
        });

        builder.build(consumer, Pedestals121.MOD_ID + ":collect_all_pedestals");
        
        AdvancementEntry get_fancy_carpet = Advancement.Builder.create()
                .parent(get_pedestal)
                .display(RED_GILDED_CARPET,
                        get_fancy_carpet_title,
                        get_fancy_carpet_desc,
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false)
                .criterion("get_fancy_carpet", InventoryChangedCriterion.Conditions.items(fancyCarpetItemPredicate))
                .build(consumer, Pedestals121.MOD_ID + ":get_fancy_carpet");

        /// And so does this.
        final Advancement.Builder other_builder = Advancement.Builder.create().parent(get_fancy_carpet)
                .display(
                        YELLOW_GILDED_CARPET,
                        all_the_colors_title,
                        all_the_colors_desc,
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(400));

        GILDED_TO_NORMAL_CARPET_MAP.keySet().forEach(fancyCarpet -> {
            ItemPredicate allCarpetsItemPredicate = ItemPredicate.Builder.create()
                    .items(itemLookup, fancyCarpet.asItem())
                    .build();
            other_builder.criterion(
                    Registries.BLOCK.getId(fancyCarpet).getPath(),
                    InventoryChangedCriterion.Conditions.items(allCarpetsItemPredicate)
            );
        });
        builder.criterion(
                Registries.ITEM.getId(GLASS_LOCKBOX).getPath(),
                InventoryChangedCriterion.Conditions.items(GLASS_LOCKBOX));

        STAINED_LOCKBOX_TO_GLASS_MAP.keySet().forEach(lockbox -> {
            ItemPredicate allLockboxesItemPredicate = ItemPredicate.Builder.create()
                    .items(itemLookup, lockbox)
                    .build();
            other_builder.criterion(
                    Registries.ITEM.getId(lockbox).getPath(),
                    InventoryChangedCriterion.Conditions.items(allLockboxesItemPredicate)
            );
        });

        other_builder.build(consumer, Pedestals121.MOD_ID + ":all_the_colors");

        AdvancementEntry get_lockbox = Advancement.Builder.create()
                .parent(get_pedestal)
                .display(BLUE_LOCKBOX,
                        get_lockbox_title,
                        get_lockbox_desc,
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false)
                .criterion("get_lockbox", InventoryChangedCriterion.Conditions.items(lockboxItemPredicate))
                .build(consumer, Pedestals121.MOD_ID + ":get_lockbox");
        
        AdvancementEntry use_key = Advancement.Builder.create()
                .parent(get_lockbox)
                .display(LOCKBOX_KEY,
                        use_key_title,
                        use_key_desc,
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false)
                .criterion("use_key_on_lockbox", ModCriteria.USE_KEY_ON_LOCKBOX.create(
                        new UseKeyOnLockboxCriterion.Conditions(Optional.empty())
                )).build(consumer, Pedestals121.MOD_ID+":use_key_on_lockbox");

        AdvancementEntry break_lockpick = Advancement.Builder.create()
                .parent(get_lockbox)
                .display(LOCKPICK,
                        break_lockpick_title,
                        break_lockpick_desc,
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false)
                .criterion("break_lockpick", ModCriteria.BREAK_LOCKPICK.create(
                        new BreakLockpickCriterion.Conditions(Optional.empty())
                )).build(consumer, Pedestals121.MOD_ID+":break_lockpick");

        AdvancementEntry pick_lock = Advancement.Builder.create()
                .parent(break_lockpick)
                .display(LOCKPICK,
                        pick_lock_title,
                        pick_lock_desc,
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        true)
                .criterion("pick_lock", ModCriteria.USE_LOCKPICK.create(
                        new UseLockpickCriterion.Conditions(Optional.empty())
                )).build(consumer, Pedestals121.MOD_ID+":pick_lock");

        AdvancementEntry carpet_lock_artifact = Advancement.Builder.create()
                .parent(get_lockbox)
                .display(TOTEM_OF_UNDYING,
                        carpet_lock_artifact_title,
                        carpet_lock_artifact_desc,
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false)
                .rewards(AdvancementRewards.Builder.experience(80).build())
                .criterion("carpet_lock_artifact", ModCriteria.LOCK_ARTIFACT_WITH_CARPET.create(
                        new LockArtifactWithCarpetCriterion.Conditions(Optional.empty())
                )).build(consumer, Pedestals121.MOD_ID+":carpet_lock_artifact");

        AdvancementEntry fully_clean_lockbox = Advancement.Builder.create()
                .parent(get_lockbox)
                .display(BRUSH,
                        fully_clean_lockbox_title,
                        fully_clean_lockbox_desc,
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false)
                .criterion("fully_clean_lockbox", ModCriteria.FULLY_CLEAN_LOCKBOX.create(
                        new FullyCleanLockboxCriterion.Conditions(Optional.empty())
                )).build(consumer, Pedestals121.MOD_ID + ":fully_clean_lockbox");
        
    }
}