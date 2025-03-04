package net.chris.pedestals;

import net.chris.pedestals.block.entity.ModBlockEntities;
import net.chris.pedestals.block.entity.ModBlockEntityRenderers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.chris.pedestals.block.entity.PedestalBlockEntityRenderer;

public class Pedestals121Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModBlockEntityRenderers.register();
        //noinspection deprecation
        BlockEntityRendererRegistry.register(ModBlockEntities.PEDESTAL_BLOCK_ENTITY, PedestalBlockEntityRenderer::new);
        Pedestals121.LOGGER.info("PedestalBlockEntityRenderer registered!");
    }
}
