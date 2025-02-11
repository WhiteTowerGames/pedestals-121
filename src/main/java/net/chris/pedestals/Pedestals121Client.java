package net.chris.pedestals;

import net.chris.pedestals.block.ModBlocks;
import net.chris.pedestals.item.ModItems;
import net.fabricmc.api.ClientModInitializer;

public class Pedestals121Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
    }
}
