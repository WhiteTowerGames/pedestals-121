package net.chris.pedestals;

import net.chris.pedestals.block.entity.render.ModBlockEntityRenderers;
import net.chris.pedestals.item.ModItems;
import net.fabricmc.api.ClientModInitializer;

public class Pedestals121Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModItems.registerItemTooltips();
        ModBlockEntityRenderers.register();
    }
}
