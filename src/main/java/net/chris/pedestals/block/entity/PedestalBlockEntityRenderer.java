package net.chris.pedestals.block.entity;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;

public class PedestalBlockEntityRenderer implements BlockEntityRenderer<PedestalBlockEntity>{

    public PedestalBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {}

    //TODO LOOK INTO NAMED DISPLAYS

    @Override
    public void render(PedestalBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemStack stack = entity.getStoredItem();

        if (!stack.isEmpty()) {
            matrices.push();
            // Make the item float higher
            double yOffset = 1.55 + 0.05 * Math.sin((entity.getWorld().getTime() + tickDelta) / 8.0);
            matrices.translate(0.5, yOffset, 0.5);
            // Rotate the item
            float rotation = (System.currentTimeMillis() / 20) % 360;
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
            // Render the item
            ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
            matrices.scale(1.2f,1.2f,1.2f);
            itemRenderer.renderItem(stack, net.minecraft.item.ModelTransformationMode.GROUND,
                    light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
            matrices.pop();
        } else {
            ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
            itemRenderer.renderItem(ItemStack.EMPTY, net.minecraft.item.ModelTransformationMode.GROUND,
                    light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
        }
    }
}