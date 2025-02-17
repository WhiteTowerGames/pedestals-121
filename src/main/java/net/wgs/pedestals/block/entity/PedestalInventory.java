package net.wgs.pedestals.block.entity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public interface PedestalInventory extends Inventory {
    DefaultedList<ItemStack> getItems();

    @Override
    default int size() {
        return getItems().size();
    }

    @Override
    default boolean isEmpty() {
        for (ItemStack stack : getItems()) {
            if (!stack.isEmpty()) return false;
        }
        return true;
    }

    @Override
    default ItemStack getStack(int slot) {
        return getItems().get(slot);
    }

    @Override
    default ItemStack removeStack(int slot, int amount) {
        return Inventories.splitStack(getItems(), slot, amount);
    }

    @Override
    default ItemStack removeStack(int slot) {
        return Inventories.removeStack(getItems(), slot);
    }

    @Override
    default void setStack(int slot, ItemStack stack) {
        getItems().set(slot, stack);
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
