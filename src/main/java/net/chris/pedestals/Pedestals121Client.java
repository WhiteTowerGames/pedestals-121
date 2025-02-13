package net.chris.pedestals;

import net.chris.pedestals.block.ModBlockEntities;
import net.chris.pedestals.block.ModBlockEntityRenderers;
import net.chris.pedestals.block.ModBlocks;
import net.chris.pedestals.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.chris.pedestals.block.entity.PedestalBlockEntityRenderer;

public class Pedestals121Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModBlockEntityRenderers.register();
        BlockEntityRendererRegistry.register(ModBlockEntities.PEDESTAL_BLOCK_ENTITY, PedestalBlockEntityRenderer::new);
        Pedestals121.LOGGER.info("PedestalBlockEntityRenderer registered!");
    }
}
