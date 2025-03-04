package net.chris.pedestals.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class PedestalBlockEntity extends BlockEntity implements PedestalInventory, TickableBlockEntity{

    //TODO: ADD CARPETS/PILLOWS FOR PEDESTALS AND REMOVING THEM WITH SHEARS

    private ItemStack storedItem = ItemStack.EMPTY;
    private ItemStack carpet = ItemStack.EMPTY;
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public PedestalBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PEDESTAL_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void markDirty() {
        super.markDirty();
        if (world != null) {
            //System.out.println("Pedestal block at " + pos + " changed!");
            world.updateNeighborsAlways(pos, this.getCachedState().getBlock());
            world.updateNeighborsAlways(pos.down(), this.getCachedState().getBlock());
        }
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
                });
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        // Load item from NBT
        storedItem = ItemStack.CODEC.parse(NbtOps.INSTANCE, nbt.get("StoredItem"))
                .result()
                .orElse(ItemStack.EMPTY);
    }


    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    public boolean hasStoredItem() {
        return !storedItem.isEmpty();
    }

    public void setStoredItem(ItemStack item) {
        storedItem = item;
        if (world instanceof ServerWorld) {
            markDirty();  // Important to update the state
        }
//        if(world != null){
//            world.updateNeighborsAlways(pos, this.getCachedState().getBlock());
//            world.updateNeighborsAlways(pos.down(), this.getCachedState().getBlock());
//        }
    }

    public ItemStack removeStoredItem() {
        ItemStack item = storedItem;
        storedItem = ItemStack.EMPTY;
        markDirty();
        return item;
    }

    public ItemStack getStoredItem() {
        return storedItem;  // Ensure you're returning 'storedItem', not items[0] or other values
    }

    public boolean hasCarpet() {return carpet.isEmpty();}

    public void setCarpet(ItemStack carpetToSet) {
        carpet = carpetToSet;
        markDirty();
    }

    public ItemStack removeCarpet() {
        ItemStack removedCarpet = carpet;
        carpet = ItemStack.EMPTY;
        markDirty();
        return removedCarpet;
    }

    public ItemStack getCarpet() {
        return carpet;
    }

    @Override
    public void tick() {
        if(this.world != null && !this.world.isClient) {
            tickCount++;
            if (tickCount % 5 == 0) {
                getStoredItem();
                world.updateListeners(pos, getCachedState(), getCachedState(), 3);
                //Pedestals121.LOGGER.info(getStoredItem()+"");
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


