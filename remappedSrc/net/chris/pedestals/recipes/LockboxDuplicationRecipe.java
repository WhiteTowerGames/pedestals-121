package net.chris.pedestals.recipes;

import net.chris.pedestals.components.ModComponents;
import net.chris.pedestals.components.LockAndKeyDataComponent;
import net.chris.pedestals.datagen.ModItemTagProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class LockboxDuplicationRecipe extends SpecialCraftingRecipe {

    public LockboxDuplicationRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingRecipeInput input, World world) {
        ItemStack registeredBox = ItemStack.EMPTY;
        ItemStack blankBox = ItemStack.EMPTY;

        for (int i = 0; i< input.size(); i++){
            ItemStack currentSlotStack = input.getStackInSlot(i);

            if (currentSlotStack.isIn(ModItemTagProvider.LOCKBOX_ITEMS)) {
                if (currentSlotStack.contains(ModComponents.LOCK_AND_KEY_DATA)) {

                    LockAndKeyDataComponent slotStackComponent = currentSlotStack.get(ModComponents.LOCK_AND_KEY_DATA);
                    assert slotStackComponent != null;
                    boolean isSlotStackMapped = slotStackComponent.isMapped();
                    boolean isSlotStackCopy = slotStackComponent.isCopy();

                    if (isSlotStackMapped && !isSlotStackCopy) {
                        if (!registeredBox.isEmpty()) return false;
                        registeredBox = currentSlotStack.copy();
                    } else {
                        if (!blankBox.isEmpty()) return false;
                        blankBox = currentSlotStack;
                    }
                }
            }
        }
        return (!registeredBox.isEmpty() && !blankBox.isEmpty());
    }

    @Override
    public ItemStack craft(CraftingRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        ItemStack registeredBox = ItemStack.EMPTY;
        ItemStack blankBox = ItemStack.EMPTY;

        for (int i = 0; i < input.size(); i++) {
            ItemStack currentSlotStack = input.getStackInSlot(i);

            if (currentSlotStack.isIn(ModItemTagProvider.LOCKBOX_ITEMS)) {
                if (currentSlotStack.contains(ModComponents.LOCK_AND_KEY_DATA)) {

                    LockAndKeyDataComponent slotStackComponent = currentSlotStack.get(ModComponents.LOCK_AND_KEY_DATA);
                    assert slotStackComponent != null;
                    boolean isSlotStackMapped = slotStackComponent.isMapped();
                    boolean isSlotStackCopy = slotStackComponent.isCopy();

                    if (isSlotStackMapped && !isSlotStackCopy) {
                        registeredBox = currentSlotStack.copy();
                    } else if (!isSlotStackMapped) {
                        blankBox = currentSlotStack.copy();
                    }
                }
            }
        }
        if (registeredBox.isEmpty() || blankBox.isEmpty()) return ItemStack.EMPTY;

        ItemStack newBox = new ItemStack(blankBox.getItem());
        LockAndKeyDataComponent originalKeyData = registeredBox.get(ModComponents.LOCK_AND_KEY_DATA);

        assert originalKeyData != null;
        newBox.set(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(originalKeyData.uuid(), true));
        return newBox;
    }

    @Override
    public RecipeSerializer<? extends SpecialCraftingRecipe> getSerializer() {
        return ModRecipeSerializers.LOCKBOX_DUPLICATION_SERIALIZER;
    }

    @Override
    public DefaultedList<ItemStack> getRecipeRemainders(CraftingRecipeInput input) {
        DefaultedList<ItemStack> remaining = DefaultedList.ofSize(input.size(), ItemStack.EMPTY);

        for (int i = 0; i < input.size(); i++) {
            ItemStack currentSlotStack = input.getStackInSlot(i);
            // Check if the item is a mapped lockbox key
            if (currentSlotStack.isIn(ModItemTagProvider.LOCKBOX_ITEMS) && currentSlotStack.contains(ModComponents.LOCK_AND_KEY_DATA)) {
                LockAndKeyDataComponent slotStackComponent = currentSlotStack.get(ModComponents.LOCK_AND_KEY_DATA);
                assert slotStackComponent != null;
                boolean isSlotStackMapped = slotStackComponent.isMapped();
                // If it's the registered key (mapped), we want it to remain.
                if (isSlotStackMapped) {
                    // Make a copy of the original key and put it back in the grid.
                    remaining.set(i, currentSlotStack.copy());
                }
                // Otherwise, leave the slot empty (i.e., the blank key is consumed).
            }
        }
        return remaining;
    }
}
