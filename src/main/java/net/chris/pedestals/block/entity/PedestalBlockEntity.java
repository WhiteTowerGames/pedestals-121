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

    private ItemStack storedItem = ItemStack.EMPTY;
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

    private final GildedCarpetInventory carpetInventory = new GildedCarpetInventory();

    public PedestalBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PEDESTAL_BLOCK_ENTITY, pos, state);
    }


    /// ITEM LOGIC

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public int size() {
        return PedestalInventory.super.size();
    }

    @Override
    public boolean isEmpty() {
        return PedestalInventory.super.isEmpty();
    }

    @Override
    public ItemStack getStack(int slot) {
        return PedestalInventory.super.getStack(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        return PedestalInventory.super.removeStack(slot, amount);
    }

    public boolean hasStoredItem() {
        return !storedItem.isEmpty();
    }

    public void setStoredItem(ItemStack item) {
        storedItem = item;
        if (world instanceof ServerWorld) {
            markDirty();  // Important to update the state
        }
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

    /// CARPET LOGIC

    public GildedCarpetInventory getCarpetInventory() {
        return this.carpetInventory;
    }

    public ItemStack getStoredCarpet() {
        return getCarpetInventory().getStack(0);
    }

    public void setStoredCarpet(ItemStack stack) {
        getCarpetInventory().setStack(0, stack);
        if (world instanceof ServerWorld) {
            markDirty();  // Important to update the state
        }
    }

    public boolean hasStoredCarpet() {
        return !getCarpetInventory().getStack(0).isEmpty();
    }

    /// Syncing, NBT and other logic.

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
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

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        // Save item to NBT
        ItemStack.OPTIONAL_CODEC.encodeStart(NbtOps.INSTANCE, storedItem)
                .result()
                .ifPresent(nbtElement -> {
                    nbt.put("StoredItem", nbtElement);
                });

        ItemStack.OPTIONAL_CODEC.encodeStart(NbtOps.INSTANCE, getStoredCarpet()) // Assuming carpet is at index 0
                .result()
                .ifPresent(nbtElement -> {
                    nbt.put("StoredCarpet", nbtElement);
                });
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        // Load item from NBT
        storedItem = ItemStack.OPTIONAL_CODEC.parse(NbtOps.INSTANCE, nbt.get("StoredItem"))
                .result()
                .orElse(ItemStack.EMPTY);

        ItemStack storedCarpetFromNBT = (ItemStack.OPTIONAL_CODEC.parse(NbtOps.INSTANCE, nbt.get("StoredCarpet"))
                .result()
                .orElse(ItemStack.EMPTY));

        setStoredCarpet(storedCarpetFromNBT);
    }

    int tickCount = 0;

    @Override
    public void tick() {
        if(this.world != null && !this.world.isClient) {
            tickCount++;
            if (tickCount % 5 == 0) {
                getStoredItem();
                world.updateListeners(pos, getCachedState(), getCachedState(), 3);
            }
            if (!storedItem.isEmpty()){
                markDirty();
            }
        }
    }
}


