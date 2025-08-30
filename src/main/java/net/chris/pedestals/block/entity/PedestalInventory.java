package net.chris.pedestals.block.entity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public interface PedestalInventory extends Inventory {
    DefaultedList<ItemStack> getItems();

    @Override
    default boolean isEmpty() {
        return getItems().getFirst().isEmpty();
    }

    @Deprecated
    default ItemStack getStack() {
        return getItems().getFirst();
    }

    @Deprecated
    default void setStack(ItemStack stack) {
        getItems().set(0, stack);
    }

    @Override
    default void clear() {
        getItems().clear();
    }

    @Override
    default boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    default void markDirty() {
        // Required for compatibility, but doesn't need custom behavior
    }

    @Override
    default void onOpen(PlayerEntity player) {
        // No behavior needed
    }

    @Override
    default void onClose(PlayerEntity player) {
        // No behavior needed
    }
}
