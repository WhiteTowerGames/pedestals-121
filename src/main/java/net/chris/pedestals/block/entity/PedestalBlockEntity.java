package net.chris.pedestals.block.entity;

import net.chris.pedestals.Pedestals121;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.Inventories;
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
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PedestalBlockEntity extends BlockEntity implements PedestalInventory, TickableBlockEntity{

    private DefaultedList<ItemStack> item = DefaultedList.ofSize(1, ItemStack.EMPTY);

    private final ModuleContainer carpetInventory = new ModuleContainer();

    private final ModuleContainer lockboxInventory = new ModuleContainer();

    public PedestalBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PEDESTAL_BLOCK_ENTITY, pos, state);
    }


    /// ITEM LOGIC

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.item;
    }


    @Override
    public int size() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return PedestalInventory.super.isEmpty();
    }

    @Override
    public ItemStack getStack(int slot) {
        return null;
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        return null;
    }


    @Override
    public ItemStack removeStack(int slot) {
        ItemStack removedItem = item.getFirst();
        getItems().removeFirst();
        return removedItem;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        getItems().set(0, stack);
    }

    public boolean hasStoredItem() {
        return !getItems().isEmpty();
    }

    public void setStoredItem(ItemStack item) {
        setStack(0, item);
        if (world instanceof ServerWorld) {
            markDirty();// Important to update the state
        }
    }

    public ItemStack removeStoredItem() {
        return removeStack(0);
    }

    public ItemStack getStoredItem() {
        if (!getItems().isEmpty()) {
            return getItems().getFirst();  // Ensure you're returning 'storedItem', not items[0] or other values
        }
        return ItemStack.EMPTY;
    }

    /// CARPET LOGIC

    public ModuleContainer getCarpetInventory() {
        return this.carpetInventory;
    }

    public ItemStack getStoredCarpet() {
        return getCarpetInventory().getStack(0);
    }

    public void setStoredCarpet(ItemStack stack) {
        getCarpetInventory().setStack(0, stack);
        if (world instanceof ServerWorld) {
            markDirty();
        }
    }

    public boolean hasStoredCarpet() {
        return !getCarpetInventory().getStack(0).isEmpty();
    }

    /// LOCKBOX LOGIC

    public ModuleContainer getLockboxInventory() {
        return this.lockboxInventory;
    }

    public ItemStack getStoredLockbox() {
        return getLockboxInventory().getStack(0);
    }

    public void setStoredLockbox(ItemStack stack) {
        getLockboxInventory().setStack(0, stack);
        if (world instanceof ServerWorld){
            markDirty();
        }
    }

    public boolean hasStoredLockbox() {
        return !getLockboxInventory().getStack(0).isEmpty();
    }

    /// REALLY IMPORTANT FOR FUTURE PROOFING!!! GETTING & TRANSFERRING THE INVENTORY!!!

    public ItemStack[] getAllInventories() {
        return new ItemStack[]{getStoredItem(), getStoredCarpet(), getStoredLockbox()};
    }

    public void transferAllInventories(World world, BlockPos pos, Block blockToSet) {
        PedestalBlockEntity oldPedestal = this;
        ItemStack[] ItemsToTransfer = oldPedestal.getAllInventories();
        world.setBlockState(pos, blockToSet.getDefaultState(), 3);
        PedestalBlockEntity newPedestal = (PedestalBlockEntity) world.getBlockEntity(pos);
        assert newPedestal != null;
        newPedestal.setStoredItem(ItemsToTransfer[0]);
        newPedestal.setStoredCarpet(ItemsToTransfer[1]);
        newPedestal.setStoredLockbox(ItemsToTransfer[2]);
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
        Inventories.writeNbt(nbt, getItems(), registryLookup);

        ItemStack.OPTIONAL_CODEC.encodeStart(NbtOps.INSTANCE, getStoredCarpet())
                .result()
                .ifPresent(nbtElement -> {
                    nbt.put("StoredCarpet", nbtElement);
                });

        ItemStack.OPTIONAL_CODEC.encodeStart(NbtOps.INSTANCE, getStoredLockbox())
                .result()
                .ifPresent(nbtElement ->{
                    nbt.put("StoredLockbox", nbtElement);
                });
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);

        this.item = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        Inventories.readNbt(nbt, getItems(), registryLookup);

        //Load carpet from NBT
        ItemStack storedCarpetFromNBT = ItemStack.OPTIONAL_CODEC.parse(NbtOps.INSTANCE, nbt.get("StoredCarpet"))
                .result()
                .orElse(ItemStack.EMPTY);

        setStoredCarpet(storedCarpetFromNBT);
        //Load lockbox from NBT
        ItemStack storedLockboxFromNBT = (ItemStack.OPTIONAL_CODEC.parse(NbtOps.INSTANCE, nbt.get("StoredLockbox"))
                .result()
                .orElse(ItemStack.EMPTY));

        setStoredLockbox(storedLockboxFromNBT);
    }

    int tickCount = 0;

    @Override
    public void tick() {
        if(this.world != null && !this.world.isClient) {
            Pedestals121.LOGGER.info("{}", world.getBlockState(pos).getBlock().getBlastResistance());
            tickCount++;
            if (tickCount % 5 == 0) {
                getStoredItem();
                world.updateListeners(pos, getCachedState(), getCachedState(), 3);
            }
            if (!(hasStoredItem() && !hasStoredCarpet() && !hasStoredLockbox())) {
                markDirty();
            }
        }
    }
}