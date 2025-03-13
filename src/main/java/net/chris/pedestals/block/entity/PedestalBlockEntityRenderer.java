package net.chris.pedestals.block.entity;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.Colors;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;

@SuppressWarnings({"IntegerDivisionInFloatingPointContext", "DataFlowIssue"})
public class PedestalBlockEntityRenderer implements BlockEntityRenderer<PedestalBlockEntity>{

    private final TextRenderer textRenderer;

    public PedestalBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.textRenderer = ctx.getTextRenderer();
    }

    protected boolean hasCustomName(ItemStack stack) {
        return stack.getCustomName() != null;
    }

    protected boolean isLookingAtItem(PedestalBlockEntity entity) {
        //This method will check if the player is looking at the item (i.e. the space above the block entity)
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return false;

        Vec3d eyePos = client.player.getCameraPosVec(1.0f); // Player's eye position.
        Vec3d lookVec = client.player.getRotationVec(1.0f); // Where the player is looking.


        BlockPos pos = entity.getPos();

        //A small AABB that represents the space inside which the displayed item floats
        Box itemBox = new Box(pos).offset(0.0, 1.1, 0.0).expand(0.03, 0.1, 0.03);

        //Ray tracing from the player's eyes outward (up to 5 blocks).
        double maxDistance = 5.0;
        Vec3d endPos = eyePos.add(lookVec.x * maxDistance, lookVec.y * maxDistance, lookVec.z * maxDistance);

        //Does said ray actually intersect the floating item's hitbox?
        try {
            return itemBox.raycast(eyePos, endPos).isPresent();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean shouldRenderName(ItemStack stack, PedestalBlockEntity entity) {
        //This method checks if the displayed item has a custom name and if the player
        //is looking at it (so that the renderer can go ahead and render it)
        return (hasCustomName(stack) && isLookingAtItem(entity) && MinecraftClient.isHudEnabled());
    }

    public TextRenderer getTextRenderer(){
        return this.textRenderer;
    }

    protected void renderCustomNameIfPresent(ItemStack stack, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {

        matrices.push();

        matrices.translate(0.5, 2.5,0.5);

        Camera camera = MinecraftClient.getInstance().getEntityRenderDispatcher().camera;

        matrices.multiply(camera.getRotation());
        matrices.scale(0.025F, -0.025F, 0.025F);

        Matrix4f matrix4f = matrices.peek().getPositionMatrix();
        TextRenderer textRenderer1 = this.getTextRenderer();

        float textWidth = (float) (-textRenderer1.getWidth(stack.getName())) / 2.0F;

        textRenderer1.draw(stack.getName(), textWidth, 0.0f, getItemRarityColor(stack), false,
                matrix4f, vertexConsumers, TextRenderer.TextLayerType.NORMAL,
                0, LightmapTextureManager.applyEmission(light, 2));

        matrices.pop();
    }

    protected int getItemRarityColor(ItemStack stack){
        switch (stack.getRarity()) {
            case COMMON -> {return Colors.WHITE;}
            case UNCOMMON -> {return  Colors.YELLOW;}
            case RARE -> {return Colors.CYAN;}
            case EPIC -> {return 0xEA55E8;}
            default -> {return Colors.WHITE;}
        }
    }

    protected void renderCarpetIfPresent(PedestalBlockEntity entity, ItemStack carpet, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ItemRenderer itemRenderer, int overlay) {
        matrices.push();

        matrices.translate(0.5f, 1.29f, 0.51f);
        matrices.scale(1f,1f,1f);

        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));

        itemRenderer.renderItem(carpet, ModelTransformationMode.FIXED, light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);

        matrices.pop();

    }

    protected void renderLockboxIfPresent(PedestalBlockEntity entity, ItemStack lockbox, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ItemRenderer itemRenderer, int overlay, double higherIfHasCarpet) {
        matrices.push();

        matrices.translate(0.5f, 1.85f + higherIfHasCarpet, 0.5f);
        matrices.scale(1.1f,1.1f,1.1f);

        itemRenderer.renderItem(lockbox, ModelTransformationMode.FIXED, light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);

        matrices.pop();

    }

    @Override
    public void render(PedestalBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemStack stack = entity.getStoredItem().copy();
        ItemStack carpet = entity.getStoredCarpet().copy();
        ItemStack lockbox = entity.getStoredLockbox().copy();

        if (stack.isEmpty() && carpet.isEmpty() && lockbox.isEmpty()) return;

        matrices.push();
            // Make the item float higher (and even higher if the pedestal has a carpet)
            double yOffset = 1.55 + 0.05 * Math.sin((entity.getWorld().getTime() + tickDelta) / 8.0);
            double higherIfHasCarpet = entity.hasStoredCarpet() ? 0.053 : 0;
            matrices.translate(0.5, yOffset + higherIfHasCarpet, 0.5);
            float rotation = (System.currentTimeMillis() / 20) % 360;
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
            ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
            matrices.scale(1.2f,1.2f,1.2f);
            itemRenderer.renderItem(stack, net.minecraft.item.ModelTransformationMode.GROUND,
                    light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
            matrices.pop();

        if (shouldRenderName(stack, entity)){
            renderCustomNameIfPresent(stack, matrices, vertexConsumers, light);
        }
        if (entity.hasStoredCarpet()) {
            renderCarpetIfPresent(entity, carpet, matrices, vertexConsumers, light, itemRenderer, overlay);
        }
        if (entity.hasStoredLockbox()) {
            renderLockboxIfPresent(entity, lockbox, matrices, vertexConsumers, light, itemRenderer, overlay, higherIfHasCarpet);
        }
    }
}