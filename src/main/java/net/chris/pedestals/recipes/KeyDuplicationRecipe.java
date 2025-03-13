package net.chris.pedestals.recipes;

import net.chris.pedestals.components.ModComponents;
import net.chris.pedestals.components.LockAndKeyDataComponent;
import net.chris.pedestals.gamerules.ModGameRuleCache;
import net.chris.pedestals.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class KeyDuplicationRecipe extends SpecialCraftingRecipe {

    public KeyDuplicationRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingRecipeInput input, World world) {
        ItemStack registeredKey = ItemStack.EMPTY;
        ItemStack blankKey = ItemStack.EMPTY;

        for (int i = 0; i< input.size(); i++){
            ItemStack currentSlotStack = input.getStackInSlot(i);

            if (currentSlotStack.isOf(ModItems.LOCKBOX_KEY)) {
                if (currentSlotStack.contains(ModComponents.LOCK_AND_KEY_DATA)) {

                    LockAndKeyDataComponent slotStackComponent = currentSlotStack.get(ModComponents.LOCK_AND_KEY_DATA);
                    assert slotStackComponent != null;
                    boolean isSlotStackMapped = slotStackComponent.isMapped();
                    boolean isSlotStackCopy = slotStackComponent.isCopy();

                    if (isSlotStackMapped && !isSlotStackCopy) {
                        if (!registeredKey.isEmpty()) return false;
                        registeredKey = currentSlotStack.copy();
                    } else {
                        if (!blankKey.isEmpty()) return false;
                        blankKey = currentSlotStack;
                    }
                }
            }
        }
        return (!registeredKey.isEmpty() && !blankKey.isEmpty());
    }

    @Override
    public ItemStack craft(CraftingRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        ItemStack registeredKey = ItemStack.EMPTY;
        ItemStack blankKey = ItemStack.EMPTY;

        for (int i = 0; i < input.size(); i++) {
            ItemStack currentSlotStack = input.getStackInSlot(i);

            if (currentSlotStack.isOf(ModItems.LOCKBOX_KEY)) {
                if (currentSlotStack.contains(ModComponents.LOCK_AND_KEY_DATA)) {

                    LockAndKeyDataComponent slotStackComponent = currentSlotStack.get(ModComponents.LOCK_AND_KEY_DATA);
                    assert slotStackComponent != null;
                    boolean isSlotStackMapped = slotStackComponent.isMapped();
                    boolean isSlotStackCopy = slotStackComponent.isCopy();

                    if (isSlotStackMapped && !isSlotStackCopy) {
                        registeredKey = currentSlotStack.copy();
                    } else if (!isSlotStackMapped) {
                        blankKey = currentSlotStack.copy();
                    }
                }
            }
        }
        if (registeredKey.isEmpty() || blankKey.isEmpty()) return ItemStack.EMPTY;

        ItemStack newKey = new ItemStack(ModItems.LOCKBOX_KEY);
        LockAndKeyDataComponent originalKeyData = registeredKey.get(ModComponents.LOCK_AND_KEY_DATA);

            boolean infiniteDupingEnabled = ModGameRuleCache.isInfiniteKeyDupingEnabled();
            assert originalKeyData != null;
            newKey.set(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(originalKeyData.uuid(), true, !infiniteDupingEnabled));

        return newKey;
    }

    @Override
    public DefaultedList<ItemStack> getRecipeRemainders(CraftingRecipeInput input) {
        DefaultedList<ItemStack> remaining = DefaultedList.ofSize(input.size(), ItemStack.EMPTY);

        for (int i = 0; i < input.size(); i++) {
            ItemStack currentSlotStack = input.getStackInSlot(i);
            // Check if the item is a mapped lockbox key
            if (currentSlotStack.isOf(ModItems.LOCKBOX_KEY) && currentSlotStack.contains(ModComponents.LOCK_AND_KEY_DATA)) {
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

    @Override
    public RecipeSerializer<? extends SpecialCraftingRecipe> getSerializer() {
        return ModRecipeSerializers.KEY_DUPLICATION_SERIALIZER;
    }
}
