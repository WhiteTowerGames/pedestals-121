package net.chris.pedestals.item;

import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.components.ModComponents;
import net.chris.pedestals.components.UUIDAndBoolComponent;
import net.chris.pedestals.item.ItemClasses.CreativeKeyItem;
import net.chris.pedestals.item.ItemClasses.KeyItem;
import net.chris.pedestals.item.ItemClasses.LockboxItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public class ModItems {

    public static final Item LOCKBOX_KEY = registerItem("lockbox_key", KeyItem::new, new Item.Settings()
            .maxCount(1).rarity(Rarity.UNCOMMON)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(null, false, false)));

    public static final Item CREATIVE_KEY = registerItem("creative_key", CreativeKeyItem::new,
            new Item.Settings()
                    .maxCount(1)
                    .rarity(Rarity.RARE));

    /// Lockboxes:

    public static final Item GLASS_LOCKBOX = registerItem("glass_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));

    public static final Item LIGHT_GRAY_LOCKBOX = registerItem("light_gray_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));

    public static final Item GRAY_LOCKBOX = registerItem("gray_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));

    public static final Item BLACK_LOCKBOX = registerItem("black_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));

    public static final Item BROWN_LOCKBOX = registerItem("brown_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));

    public static final Item RED_LOCKBOX = registerItem("red_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));

    public static final Item ORANGE_LOCKBOX = registerItem("orange_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));

    public static final Item YELLOW_LOCKBOX = registerItem("yellow_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));

    public static final Item LIME_LOCKBOX = registerItem("lime_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));

    public static final Item GREEN_LOCKBOX = registerItem("green_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));

    public static final Item CYAN_LOCKBOX = registerItem("cyan_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));

    public static final Item LIGHT_BLUE_LOCKBOX = registerItem("light_blue_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));

    public static final Item BLUE_LOCKBOX = registerItem("blue_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));

    public static final Item WHITE_LOCKBOX = registerItem("white_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));

    public static final Item PURPLE_LOCKBOX = registerItem("purple_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));

    public static final Item MAGENTA_LOCKBOX = registerItem("magenta_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));

    public static final Item PINK_LOCKBOX = registerItem("pink_lockbox", LockboxItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(UUID.randomUUID(), false, false)));



    public static final List<Item> ALL_COLORED_LOCKBOXES = List.of(
            WHITE_LOCKBOX,
            LIGHT_GRAY_LOCKBOX,
            GRAY_LOCKBOX,
            BLACK_LOCKBOX,
            BROWN_LOCKBOX,
            RED_LOCKBOX,
            ORANGE_LOCKBOX,
            YELLOW_LOCKBOX,
            LIME_LOCKBOX,
            GREEN_LOCKBOX,
            CYAN_LOCKBOX,
            LIGHT_BLUE_LOCKBOX,
            BLUE_LOCKBOX,
            PURPLE_LOCKBOX,
            MAGENTA_LOCKBOX,
            PINK_LOCKBOX
    );

    public static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Pedestals121.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void registerModItems(){
        Pedestals121.LOGGER.info("Registering Mod Items for Pedestals 1.21 (source: "+Pedestals121.MOD_ID+").");
    }
}
