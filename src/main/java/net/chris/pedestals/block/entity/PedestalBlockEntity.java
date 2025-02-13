package net.chris.pedestals.block.entity;

import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.block.ModBlockEntities;
import net.minecraft.block.BlockState;
import com.mojang.serialization.DynamicOps;
import net.minecraft.nbt.NbtOps;
import net.minecraft.inventory.Inventories;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PedestalBlockEntity extends BlockEntity implements ImplementedInventory, TickableBlockEntity{
    private ItemStack storedItem = ItemStack.EMPTY;
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public PedestalBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PEDESTAL_BLOCK_ENTITY, pos, state);
    }

    int tickCount = 0;

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        // Save item to NBT
        ItemStack.CODEC.encodeStart(NbtOps.INSTANCE, storedItem)
                .result()
                .ifPresent(nbtElement -> {
                    nbt.put("StoredItem", nbtElement);
                    System.out.println("Item saved to NBT: " + storedItem.getItem().getName(storedItem));  // Debugging line
                });
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        // Load item from NBT
        storedItem = ItemStack.CODEC.parse(NbtOps.INSTANCE, nbt.get("StoredItem"))
                .result()
                .orElse(ItemStack.EMPTY);
        System.out.println("Item loaded from NBT: " + (storedItem.isEmpty() ? "None" : storedItem.getItem().getName(storedItem)));  // Debugging line
    }


    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    public boolean hasStoredItem() {
        return !storedItem.isEmpty();
    }

    public void setStoredItem(ItemStack item) {
        if (!ItemStack.areEqual(storedItem, item)) {
            Pedestals121.LOGGER.info("Updating stored item: " + item);
        }
        storedItem = item;
        markDirty();  // Important to update the state
    }

//    public void setStoredItem(ItemStack item) {
//        storedItem = item;
//        markDirty(); // Marks the block entity as dirty, forcing an update
//        if (world != null) {
//            world.updateListeners(pos, getCachedState(), getCachedState(), 3); // Notifies clients
//        }
//    }

    public ItemStack removeStoredItem() {
        ItemStack item = storedItem;
        storedItem = ItemStack.EMPTY;
        markDirty();
        return item;
    }


    public ItemStack getStoredItem() {
        return storedItem;  // Ensure you're returning 'storedItem', not items[0] or other values
    }


    @Override
    public void tick() {
        if(this.world != null && !this.world.isClient) {
            tickCount++;
            if (tickCount % 5 == 0) {
                getStoredItem();
                world.updateListeners(pos, getCachedState(), getCachedState(), 3);
                //Pedestals121.LOGGER.info("Tick!");
            }
            if (!storedItem.isEmpty()){
                markDirty();
            }
        }
    }
    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
}


