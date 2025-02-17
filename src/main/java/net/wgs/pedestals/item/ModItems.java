package net.wgs.pedestals.item;

import net.wgs.pedestals.Pedestals121;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Pedestals121.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Pedestals121.LOGGER.info("Registering Mod Items for Pedestals 1.21 (source: "+Pedestals121.MOD_ID+").");
    }
}
