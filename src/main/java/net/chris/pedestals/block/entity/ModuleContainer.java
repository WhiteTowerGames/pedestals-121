package net.chris.pedestals.block.entity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class ModuleContainer implements Inventory {

    private final DefaultedList<ItemStack> carpetItems = DefaultedList.ofSize(1, ItemStack.EMPTY);



    @Override
    public int size() {
        return carpetItems.size();
    }

    @Override
    public boolean isEmpty() {
        return carpetItems.getFirst().isEmpty();
    }

    @Override
    public ItemStack getStack(int slot) {
        return carpetItems.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        return Inventories.splitStack(carpetItems, slot, amount);
    }

    @Override
    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(carpetItems, slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        carpetItems.set(slot, stack);
    }

    @Override
    public void markDirty() {

    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void clear() {
        carpetItems.clear();
    }
}
