package net.chris.pedestals.block.entity;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Colors;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;

@SuppressWarnings({"IntegerDivisionInFloatingPointContext", "DataFlowIssue"})
public class PedestalBlockEntityRenderer implements BlockEntityRenderer<PedestalBlockEntity>{

    private final TextRenderer textRenderer;
    protected final BlockEntityRenderDispatcher dispatcher;

    public PedestalBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.textRenderer = ctx.getTextRenderer();
        this.dispatcher = ctx.getRenderDispatcher();
    }

    //TODO: LOOK INTO ADDING TRANSPARENT BLACK BACKGROUND FOR TEXT
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
        return (!stack.isEmpty() && isLookingAtItem(entity) && MinecraftClient.isHudEnabled());
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
                0, light);

        matrices.pop();
    }


    protected int getItemRarityColor(ItemStack stack){
        switch (stack.getRarity()) {
            case COMMON -> {return Colors.WHITE;}
            case UNCOMMON -> {return  Colors.YELLOW;}
            case RARE -> {return 0x54FCFC;}
            case EPIC -> {return 0xEA55E8;}
            default -> {return Colors.WHITE;}
        }
    }

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
            itemRenderer.renderItem(stack, ModelTransformationMode.GROUND,
                    light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
            matrices.pop();
        } else {
            ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
            itemRenderer.renderItem(ItemStack.EMPTY, ModelTransformationMode.GROUND,
                    light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
        }
        if (shouldRenderName(stack, entity)){
            renderCustomNameIfPresent(stack, matrices, vertexConsumers, light);
        }
    }
}