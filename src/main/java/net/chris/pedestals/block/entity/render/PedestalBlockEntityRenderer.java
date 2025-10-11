package net.chris.pedestals.block.entity.render;

import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.chris.pedestals.components.ModComponents;
import net.chris.pedestals.item.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Colors;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

@SuppressWarnings("ClassCanBeRecord")
@Environment(EnvType.CLIENT)
public class PedestalBlockEntityRenderer implements BlockEntityRenderer<PedestalBlockEntity, PedestalBlockEntityRenderState> {

    private final ItemModelManager itemModelManager;

    public PedestalBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.itemModelManager = ctx.itemModelManager();
    }

    @Override
    public PedestalBlockEntityRenderState createRenderState() {
        return new PedestalBlockEntityRenderState();
    }

    @Override
    public void updateRenderState(PedestalBlockEntity blockEntity,
                                  PedestalBlockEntityRenderState state,
                                  float tickProgress,
                                  Vec3d cameraPos,
                                  @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay
    ) {
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);
        state.displayedItem = blockEntity.getStoredItem();
        state.carpetItem = blockEntity.getStoredCarpet();
        state.lockboxItem = blockEntity.getStoredLockbox();

        state.hasItem = blockEntity.hasStoredItem();
        state.hasCarpet = blockEntity.hasStoredCarpet();
        state.hasLockbox = blockEntity.hasStoredLockbox();

        if (state.hasLockbox) {
            state.dustToRender = switch (Objects.requireNonNull(state.lockboxItem.get(ModComponents.LOCKBOX_DUST_COMPONENT)).dustLevel()){
                case 1 -> new ItemStack(ModItems.DUST_1);
                case 2 -> new ItemStack(ModItems.DUST_2);
                case 3 -> new ItemStack(ModItems.DUST_3);
                case 4 -> new ItemStack(ModItems.DUST_4);
                default -> ItemStack.EMPTY;
            };
        }

        if (state.hasItem) {
            var itemRenderState = new ItemRenderState();
            this.itemModelManager
                    .clearAndUpdate(
                            itemRenderState, state.displayedItem, ItemDisplayContext.GROUND, blockEntity.getWorld(), null, (int) (blockEntity.getPos().asLong())
                    );
            state.displayItemStackState.add(itemRenderState);
        } else state.displayItemStackState.add(new ItemRenderState());

        if (state.hasCarpet) {
            var itemRenderState = new ItemRenderState();
            this.itemModelManager
                    .clearAndUpdate(
                            itemRenderState, state.carpetItem, ItemDisplayContext.GROUND, blockEntity.getWorld(), null, (int) (blockEntity.getPos().asLong() + 1)
                    );
            state.displayItemStackState.add(itemRenderState);
        } else state.displayItemStackState.add(new ItemRenderState());

        if (state.hasLockbox) {
            var itemRenderState = new ItemRenderState();
            this.itemModelManager
                    .clearAndUpdate(
                            itemRenderState, state.lockboxItem, ItemDisplayContext.GROUND, blockEntity.getWorld(), null, (int) (blockEntity.getPos().asLong() + 2)
                    );
            state.displayItemStackState.add(itemRenderState);
        } else state.displayItemStackState.add(new ItemRenderState());

        var dustRenderState = new ItemRenderState();
        this.itemModelManager
                .clearAndUpdate(
                        dustRenderState, state.dustToRender, ItemDisplayContext.GROUND, blockEntity.getWorld(), null, (int) (blockEntity.getPos().asLong() + 3)
                );
        state.displayItemStackState.add(dustRenderState);

        state.rotationDegrees = ((blockEntity.getWorld() != null ? blockEntity.getWorld().getTime()/2f : System.currentTimeMillis() / 50f)
                + tickProgress) * 4.0f % 360f;

        assert blockEntity.getWorld() != null;
        state.displayOffset = 1.55 + 0.05 * Math.sin((blockEntity.getWorld().getTime() + tickProgress) / 8.0);
    }

    @Override
    public void render(PedestalBlockEntityRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        var entity = (PedestalBlockEntity) state.type.get(MinecraftClient.getInstance().world, state.pos);
        if (entity == null) return;
        assert entity.getWorld() != null;

        var item = state.displayedItem;

        if (!state.hasItem && !state.hasCarpet && !state.hasLockbox) return;

        matrices.push();

        var yOffset = state.displayOffset + (state.hasCarpet ? 0.053 : 0);
        matrices.translate(0.5, yOffset, 0.5);

        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.rotationDegrees));

        matrices.scale(1.2f,1.2f,1.2f);

        assert state.displayItemStackState != null;
        state.displayItemStackState.getFirst().render(matrices, queue, state.lightmapCoordinates, OverlayTexture.DEFAULT_UV, 0);

        matrices.pop();

        if (item.getCustomName() != null && isLookingAtItem(entity)) {
            renderCustomNameIfPresent(state.displayedItem, matrices, queue);
        }

        if (state.hasCarpet) {
            matrices.push();

            matrices.translate(0.5f, 1.063f, 0.51f);
            matrices.scale(4f,4f,4f);

            state.displayItemStackState.get(1).render(matrices, queue, state.lightmapCoordinates, OverlayTexture.DEFAULT_UV, 0);

            matrices.pop();
        }

        if (state.hasLockbox) {
            matrices.push();

            matrices.translate(0.5f, 1.563f + (state.hasCarpet ? 0.053 : 0), 0.51f);
            matrices.scale(2.25f,2.25f,2.25f);

            state.displayItemStackState.get(2).render(matrices, queue, state.lightmapCoordinates, OverlayTexture.DEFAULT_UV, 0);

            matrices.scale(1.01f,1.01f,1.01f);
            state.displayItemStackState.get(3).render(matrices, queue, state.lightmapCoordinates, OverlayTexture.DEFAULT_UV, 0);

            matrices.pop();
        }
    }

    private boolean isLookingAtItem(PedestalBlockEntity entity) {
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

        //Does the aforementioned ray actually intersect the floating item's hitbox?
        try {
            return itemBox.raycast(eyePos, endPos).isPresent();
        } catch (Exception e) {
            return false;
        }
    }

    private void renderCustomNameIfPresent(ItemStack stack,
                                           MatrixStack matrices,
                                           OrderedRenderCommandQueue queue) {

        matrices.push();

        matrices.translate(0.5, 2.5,0.5);

        Camera camera = MinecraftClient.getInstance().getEntityRenderDispatcher().camera;

        assert camera != null;
        matrices.multiply(camera.getRotation());
        matrices.scale(0.025F, -0.025F, 0.025F);

        var textRenderer = MinecraftClient.getInstance().textRenderer;

        float textWidth = (float) (-textRenderer.getWidth(stack.getName())) / 2.0F;

        // I'll look into this in a future update - but the API is undocumented for now, so I'll stick with what I know.
        //queue.submitLabel(matrices, nameplatePos, 15, stack.getCustomName(), true, 0, camera.getCameraPos().squaredDistanceTo(nameplatePos), cameraRenderState);

        queue.submitText(matrices, textWidth, 0f, Objects.requireNonNull(stack.getCustomName()).asOrderedText(), false, TextRenderer.TextLayerType.NORMAL, LightmapTextureManager.applyEmission(0, 15), Colors.WHITE, Colors.WHITE, 0xFF000000);

        matrices.pop();
    }

}
