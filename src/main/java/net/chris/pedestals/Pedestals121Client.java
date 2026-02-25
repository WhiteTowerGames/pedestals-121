package net.chris.pedestals;

import net.chris.pedestals.block.entity.render.ModBlockEntityRenderers;
import net.chris.pedestals.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.impl.client.rendering.BlockRenderLayerMapImpl;

public class Pedestals121Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModItems.registerItemTooltips();
        ModBlockEntityRenderers.register();


    }
}
