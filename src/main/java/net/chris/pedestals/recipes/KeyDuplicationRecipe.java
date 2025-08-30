package net.chris.pedestals.recipes;

import net.chris.pedestals.components.ModComponents;
import net.chris.pedestals.components.LockAndKeyDataComponent;
import net.chris.pedestals.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import static net.chris.pedestals.Pedestals121.CONFIG;

public class KeyDuplicationRecipe extends SpecialCraftingRecipe {

    public KeyDuplicationRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingRecipeInput input, World world) {
        ItemStack registeredKey = ItemStack.EMPTY;
        ItemStack blankKey = ItemStack.EMPTY;
        boolean infiniteDupingEnabled = CONFIG.infiniteKeyDuping();

        for (int i = 0; i < input.size(); i++) {
            ItemStack current = input.getStackInSlot(i);
            if (!current.isOf(ModItems.LOCKBOX_KEY) || !current.contains(ModComponents.LOCK_AND_KEY_DATA)) continue;

            LockAndKeyDataComponent data = current.get(ModComponents.LOCK_AND_KEY_DATA);
            assert data != null;
            boolean isMapped = data.isMapped();
            boolean isCopy = data.isCopy();

            if (isMapped) {
                // Accept originals always; accept copies only if infinite duplication enabled.
                if (isCopy && !infiniteDupingEnabled) return false;
                if (!registeredKey.isEmpty()) return false;
                registeredKey = current.copy();
            } else { // unmapped (blank) key
                if (!blankKey.isEmpty()) return false;
                blankKey = current.copy();
            }
        }
        return !registeredKey.isEmpty() && !blankKey.isEmpty();
    }

    @Override
    public ItemStack craft(CraftingRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        ItemStack registeredKey = ItemStack.EMPTY;
        ItemStack blankKey = ItemStack.EMPTY;
        boolean infiniteDupingEnabled = CONFIG.infiniteKeyDuping();

        for (int i = 0; i < input.size(); i++) {
            ItemStack current = input.getStackInSlot(i);
            if (!current.isOf(ModItems.LOCKBOX_KEY) || !current.contains(ModComponents.LOCK_AND_KEY_DATA)) continue;

            LockAndKeyDataComponent data = current.get(ModComponents.LOCK_AND_KEY_DATA);
            assert data != null;
            boolean isMapped = data.isMapped();
            boolean isCopy = data.isCopy();

            if (isMapped) {
                if (isCopy && !infiniteDupingEnabled) return ItemStack.EMPTY;
                if (!registeredKey.isEmpty()) return ItemStack.EMPTY;
                registeredKey = current.copy();
            } else {
                if (!blankKey.isEmpty()) return ItemStack.EMPTY;
                blankKey = current.copy();
            }
        }

        if (registeredKey.isEmpty() || blankKey.isEmpty()) return ItemStack.EMPTY;

        ItemStack newKey = new ItemStack(ModItems.LOCKBOX_KEY);
        LockAndKeyDataComponent sourceData = registeredKey.get(ModComponents.LOCK_AND_KEY_DATA);
        assert sourceData != null;
        // Args: uuid, isCopy(always true for duplication), consumedOnUse = !infinite
        newKey.set(ModComponents.LOCK_AND_KEY_DATA,
                new LockAndKeyDataComponent(sourceData.uuid(), true, !infiniteDupingEnabled));
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
