package net.chris.pedestals;

import net.chris.pedestals.block.entity.ModBlockEntities;
import net.chris.pedestals.block.entity.ModBlockEntityRenderers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.chris.pedestals.block.entity.PedestalBlockEntityRenderer;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;

@SuppressWarnings("deprecation")
public class Pedestals121Client implements ClientModInitializer {

    private static void handleMigrationWarningPayload(MigrationWarningPayload payload, ClientPlayNetworking.Context context) {
        ClientPlayerEntity player = context.client().player;
        assert player != null;
        player.sendMessage(Text.literal("§c§l[Pedestals V3.0] - Warning: §r§cThis update §c§lbreaks the functionality §r§cof" +
                " §c§lpreviously placed §r§cpedestals."), false);
        player.sendMessage(Text.of("§cPlease §c§lbreak §r§cand §c§lreplace §r§cthem."), false);
    }

    @Override
    public void onInitializeClient() {
        ModBlockEntityRenderers.register();
        BlockEntityRendererRegistry.register(ModBlockEntities.PEDESTAL_BLOCK_ENTITY, PedestalBlockEntityRenderer::new);

        ClientPlayNetworking.registerGlobalReceiver(MigrationWarningPayload.ID, Pedestals121Client::handleMigrationWarningPayload);
    }
}
