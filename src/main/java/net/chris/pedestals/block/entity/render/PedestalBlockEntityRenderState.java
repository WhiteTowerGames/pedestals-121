package net.chris.pedestals.block.entity.render;

import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.item.ItemStack;
import java.util.ArrayList;
import java.util.List;

public class PedestalBlockEntityRenderState extends BlockEntityRenderState {
    public ItemStack displayedItem = ItemStack.EMPTY;
    public ItemStack carpetItem = ItemStack.EMPTY;
    public ItemStack lockboxItem = ItemStack.EMPTY;

    public ItemStack dustToRender = ItemStack.EMPTY;

    public boolean hasItem = false;
    public boolean hasCarpet = false;
    public boolean hasLockbox = false;

    public List<ItemRenderState> displayItemStackState = new ArrayList<>(3);

    public float rotationDegrees = 0f;
    public double displayOffset = 0;
}
