package net.wgs.pedestals;

import net.wgs.pedestals.block.ModBlockEntities;
import net.wgs.pedestals.block.ModBlockEntityRenderers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.wgs.pedestals.block.entity.PedestalBlockEntityRenderer;

public class Pedestals121Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModBlockEntityRenderers.register();
        BlockEntityRendererRegistry.register(ModBlockEntities.PEDESTAL_BLOCK_ENTITY, PedestalBlockEntityRenderer::new);
        Pedestals121.LOGGER.info("PedestalBlockEntityRenderer registered!");
    }
}
