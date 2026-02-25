package net.chris.pedestals.item;

import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.components.*;
import net.chris.pedestals.item.items.CreativeKeyItem;
import net.chris.pedestals.item.items.KeyItem;
import net.chris.pedestals.item.items.LockboxItem;
import net.chris.pedestals.item.items.LockpickItem;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

import static net.chris.pedestals.Pedestals121.CONFIG;
import static net.minecraft.block.Blocks.*;
import static net.minecraft.block.Blocks.PINK_STAINED_GLASS;

public class ModItems {

    public static final Item LOCKBOX_KEY = registerItem("lockbox_key", KeyItem::new, new Item.Settings()
            .maxCount(1).rarity(Rarity.UNCOMMON)
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(null, false, false)));

    public static final Item CREATIVE_KEY = registerItem("creative_key", CreativeKeyItem::new, new Item.Settings()
                    .maxCount(1).rarity(Rarity.EPIC)
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
            .component(ModComponents.UNLOCKS_LOCKBOXES_COMPONENT, new UnlocksLockboxesComponent()));

    public static final Item LOCKPICK = registerItem("lockpick", LockpickItem::new, new Item.Settings()
            .maxDamage(1)
            .rarity(Rarity.UNCOMMON));

    public static final Item DUST_1 = registerItem("dust_1", Item::new, new Item.Settings());
    public static final Item DUST_2 = registerItem("dust_2", Item::new, new Item.Settings());
    public static final Item DUST_3 = registerItem("dust_3", Item::new, new Item.Settings());
    public static final Item DUST_4 = registerItem("dust_4", Item::new, new Item.Settings());

    /// Lockboxes:

    public static final Item GLASS_LOCKBOX = registerItem("glass_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final Item LIGHT_GRAY_LOCKBOX = registerItem("light_gray_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final Item GRAY_LOCKBOX = registerItem("gray_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final Item BLACK_LOCKBOX = registerItem("black_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final Item BROWN_LOCKBOX = registerItem("brown_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final Item RED_LOCKBOX = registerItem("red_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final Item ORANGE_LOCKBOX = registerItem("orange_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final Item YELLOW_LOCKBOX = registerItem("yellow_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final Item LIME_LOCKBOX = registerItem("lime_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final Item GREEN_LOCKBOX = registerItem("green_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final Item CYAN_LOCKBOX = registerItem("cyan_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final Item LIGHT_BLUE_LOCKBOX = registerItem("light_blue_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final Item BLUE_LOCKBOX = registerItem("blue_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final Item WHITE_LOCKBOX = registerItem("white_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final Item PURPLE_LOCKBOX = registerItem("purple_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final Item MAGENTA_LOCKBOX = registerItem("magenta_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final Item PINK_LOCKBOX = registerItem("pink_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1).component(ModComponents.CASE_WAX_STATUS, new WaxedCaseDataComponent())
            .component(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(UUID.randomUUID(), false)).component(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent()));

    public static final HashMap<Item, Block> STAINED_LOCKBOX_TO_GLASS_MAP = new HashMap<>(Map.ofEntries(
            Map.entry(WHITE_LOCKBOX, WHITE_STAINED_GLASS),
            Map.entry(LIGHT_GRAY_LOCKBOX, LIGHT_GRAY_STAINED_GLASS),
            Map.entry(GRAY_LOCKBOX, GRAY_STAINED_GLASS),
            Map.entry(BLACK_LOCKBOX, BLACK_STAINED_GLASS),
            Map.entry(BROWN_LOCKBOX, BROWN_STAINED_GLASS),
            Map.entry(RED_LOCKBOX, RED_STAINED_GLASS),
            Map.entry(ORANGE_LOCKBOX, ORANGE_STAINED_GLASS),
            Map.entry(YELLOW_LOCKBOX, YELLOW_STAINED_GLASS),
            Map.entry(LIME_LOCKBOX, LIME_STAINED_GLASS),
            Map.entry(GREEN_LOCKBOX, GREEN_STAINED_GLASS),
            Map.entry(CYAN_LOCKBOX, CYAN_STAINED_GLASS),
            Map.entry(LIGHT_BLUE_LOCKBOX, LIGHT_BLUE_STAINED_GLASS),
            Map.entry(BLUE_LOCKBOX, BLUE_STAINED_GLASS),
            Map.entry(PURPLE_LOCKBOX, PURPLE_STAINED_GLASS),
            Map.entry(MAGENTA_LOCKBOX, MAGENTA_STAINED_GLASS),
            Map.entry(PINK_LOCKBOX, PINK_STAINED_GLASS)
    ));

    public static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Pedestals121.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    public static void initialize(){
        Pedestals121.LOGGER.info("Registering Mod Items for Pedestals 1.21 (source: "+Pedestals121.MOD_ID+").");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(GLASS_LOCKBOX);
            STAINED_LOCKBOX_TO_GLASS_MAP.keySet().forEach(entries::add);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.SHEARS, LOCKBOX_KEY);
            entries.addAfter(LOCKBOX_KEY, LOCKPICK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(entries -> entries.add(CREATIVE_KEY));

    }

    public static void registerItemTooltips() {
        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.isOf(LOCKBOX_KEY) && itemStack.contains(ModComponents.LOCK_AND_KEY_DATA)) {
                LockAndKeyDataComponent lockAndKeyData = itemStack.get(ModComponents.LOCK_AND_KEY_DATA);
                assert lockAndKeyData != null;
                if (lockAndKeyData.isCopy() && !CONFIG.infiniteKeyDuping()){
                    list.add(Text.translatable("itemtooltip.pedestals.key_clone").formatted(Formatting.BOLD, Formatting.YELLOW));
                }
                if (lockAndKeyData.isMapped()) {
                    list.add(Text.translatable("itemtooltip.pedestals.key_is_mapped"));
                }
                else {
                    list.add(Text.translatable("itemtooltip.pedestals.key_not_mapped.l1"));
                    list.add(Text.translatable("itemtooltip.pedestals.key_not_mapped.l2"));
                }
                if (itemStack.getCustomName() == null || itemStack.getCustomName().getString().isEmpty()) { // Going to check both. Can't be too sure.
                    list.add(Text.translatable("itemtooltip.pedestals.key_unnamed"));
                }
            }
            if (itemStack.isOf(CREATIVE_KEY)){
                list.add(Text.translatable("itemtooltip.pedestals.creative_key"));
            }
            if (itemStack.isOf(LOCKPICK)) {
                if (CONFIG.enableLockpicks()){
                    list.add(Text.translatable("itemtooltip.pedestals.lockpick_enabled.l1"));
                    list.add(Text.translatable("itemtooltip.pedestals.lockpick_enabled.l2"));
                }
                else {
                    list.add(Text.translatable("itemtooltip.pedestals.lockpick_disabled.l1").formatted(Formatting.BOLD, Formatting.RED));
                    list.add(Text.translatable("itemtooltip.pedestals.lockpick_disabled.l2").formatted(Formatting.BOLD, Formatting.RED));
                }
            }
        });
    }
}
