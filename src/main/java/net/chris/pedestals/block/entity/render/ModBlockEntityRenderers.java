package net.chris.pedestals.block.entity.render;

import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.block.entity.ModBlockEntities;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

@Environment(EnvType.CLIENT)
public class ModBlockEntityRenderers {
    public static void register() {
        Pedestals121.LOGGER.info("Registering renderers for Pedestals...");
        BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BLOCK_ENTITY, PedestalBlockEntityRenderer::new);
    }}
