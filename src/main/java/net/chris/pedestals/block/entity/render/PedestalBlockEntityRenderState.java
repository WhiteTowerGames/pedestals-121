package net.chris.pedestals.block.entity.render;

import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.item.ItemStack;

public class PedestalBlockEntityRenderState extends BlockEntityRenderState {
    public final ItemRenderState itemRenderState = new ItemRenderState();
    public final ItemRenderState carpetRenderState = new ItemRenderState();
    public final ItemRenderState lockboxRenderState = new ItemRenderState();
    public final ItemRenderState dustRenderState = new ItemRenderState();

    public ItemStack displayedItem = ItemStack.EMPTY;
    public ItemStack carpetItem = ItemStack.EMPTY;
    public ItemStack lockboxItem = ItemStack.EMPTY;

    public ItemStack dustToRender = ItemStack.EMPTY;

    public boolean hasItem = false;
    public boolean hasCarpet = false;
    public boolean hasLockbox = false;

    public float rotationDegrees = 0f;
    public double displayOffset = 0;
}
