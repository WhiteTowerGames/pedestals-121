package net.chris.pedestals;

import net.chris.pedestals.block.ModBlockEntities;
import net.chris.pedestals.block.ModBlockEntityRenderers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.chris.pedestals.block.entity.PedestalBlockEntityRenderer;

@SuppressWarnings("deprecation")
public class Pedestals121Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModBlockEntityRenderers.register();
        BlockEntityRendererRegistry.register(ModBlockEntities.PEDESTAL_BLOCK_ENTITY, PedestalBlockEntityRenderer::new);

    }
}
