package net.chris.pedestals.block.entity;

import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class PedestalBlockEntityRenderer implements BlockEntityRenderer<PedestalBlockEntity> {

    public PedestalBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {}


    @Override
    public void render(PedestalBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemStack stack = new ItemStack(Items.DIAMOND);  // Just testing with a diamond

        if (!stack.isEmpty()) {
            matrices.push();

            // Position item above pedestal
            matrices.translate(0.5, 1.0, 0.5);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((System.currentTimeMillis() / 20) % 360)); // Spin

            // Render item
            ItemRenderer itemRenderer = net.minecraft.client.MinecraftClient.getInstance().getItemRenderer();
            itemRenderer.renderItem(stack, ModelTransformationMode.GROUND, light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);

            matrices.pop();
        }
    }
//    @Override
//    public void render(PedestalBlockEntity entity, float tickDelta, MatrixStack matrices,
//                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
//        ItemStack stack = entity.getStoredItem();
//
//        if (!stack.isEmpty()) {
//            matrices.push();
//
//            // Position item slightly higher above the pedestal block
//            matrices.translate(0.5, 1.2, 0.5);  // 1.2 to raise it above the block
//
//            // Bobbing effect: moves up and down with a sine function
//            float bobbingHeight = (float) Math.sin(System.currentTimeMillis() / 500.0) * 0.05f;  // Adjust the 0.05 for height
//            matrices.translate(0.0, bobbingHeight, 0.0);
//
//            // Rotate the item to make it spin
//            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((System.currentTimeMillis() / 20) % 360)); // Spin
//
//            // Render the item
//            ItemRenderer itemRenderer = net.minecraft.client.MinecraftClient.getInstance().getItemRenderer();
//            itemRenderer.renderItem(stack, ModelTransformationMode.GROUND, light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
//
//            matrices.pop();
//        }
//    }
//    @Override
//    public void render(PedestalBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
//        ItemStack itemStack = blockEntity.getStoredItem();
//
//        if (itemStack.isEmpty()) {
//            System.out.println("No item to render");
//            return;
//        }
//
//        // Adjust item position and add bobbing effect
//        matrices.push();
//        matrices.translate(0.5F, 1.2F, 0.5F);  // Adjust Y-axis to raise the item a bit above the pedestal
//        matrices.scale(0.75F, 0.75F, 0.75F);   // Optional: Scale item if needed
//
//        // Add bobbing effect to simulate slight vertical movement
//        float bobbing = MathHelper.sin(tickDelta * 0.1F) * 0.1F;  // Sinusoidal bobbing effect
//        matrices.translate(0.0F, bobbing, 0.0F);
//
//        // Get the ItemRenderer and render the item with the correct method
//        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
//
//        // Use the correct method signature for rendering the item
//        itemRenderer.renderItem(itemStack, ModelTransformationMode.GROUND, false, light, overlay, matrices, vertexConsumers, 0);
//
//        matrices.pop();
//    }

}