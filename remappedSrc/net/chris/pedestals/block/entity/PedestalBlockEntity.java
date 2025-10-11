package net.chris.pedestals.block.entity;

import net.chris.pedestals.components.LockboxDustComponent;
import net.chris.pedestals.components.ModComponents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static net.chris.pedestals.Pedestals121.CONFIG;
import static net.minecraft.item.Items.*;

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
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack removedItem = item.getFirst();
        getItems().removeFirst();
        return removedItem;
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

    @Deprecated
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
        return new ItemStack[] {
                getStoredItem() != null ? getStoredItem() : ItemStack.EMPTY,
                getStoredCarpet() != null ? getStoredCarpet() : ItemStack.EMPTY,
                getStoredLockbox() != null ? getStoredLockbox() : ItemStack.EMPTY
        };
    }

    public void transferAllInventories(World world, BlockPos pos, Block blockToSet) {
        System.out.println("[Pedestals] Attempting to transfer inventories at " + pos);

        PedestalBlockEntity oldPedestal = this;
        ItemStack[] itemsToTransfer = oldPedestal.getAllInventories();

        System.out.println("[Pedestals] Items to transfer:");
        for (int i = 0; i < itemsToTransfer.length; i++) {
            System.out.println("  Slot " + i + ": " + itemsToTransfer[i]);
        }

        boolean success = world.setBlockState(pos, blockToSet.getDefaultState(), 3);
        System.out.println("[Pedestals] Block state set to " + blockToSet.getTranslationKey() + "? " + success);

        // Optional: force remove/create the block entity
        world.removeBlockEntity(pos);
        world.addBlockEntity(ModBlockEntities.PEDESTAL_BLOCK_ENTITY.instantiate(pos, blockToSet.getDefaultState()));

        PedestalBlockEntity newPedestal = (PedestalBlockEntity) world.getBlockEntity(pos);
        if (newPedestal == null) {
            System.out.println("[Pedestals] FAILED to retrieve new pedestal block entity at " + pos);
            return;
        }

        System.out.println("[Pedestals] Transferring items to new pedestal");
        newPedestal.setStoredItem(itemsToTransfer[0]);
        newPedestal.setStoredCarpet(itemsToTransfer[1]);
        newPedestal.setStoredLockbox(itemsToTransfer[2]);
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
            world.updateNeighborsAlways(pos, this.getCachedState().getBlock(), null);
            world.updateNeighborsAlways(pos.down(), this.getCachedState().getBlock(), null);
        }
    }

    @Override
    protected void writeData(WriteView view) {
        super.writeData(view);
        Inventories.writeData(view, getItems());
        view.put("StoredCarpet", ItemStack.OPTIONAL_CODEC, getStoredCarpet());
        view.put("StoredLockbox", ItemStack.OPTIONAL_CODEC, getStoredLockbox());
    }


    @Override
    protected void readData(ReadView view) {
        super.readData(view);
        this.item = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        Inventories.readData(view, getItems());

        //Read carpet from NBT
        ItemStack carpetFromNbt = view.read("StoredCarpet", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
        setStoredCarpet(carpetFromNbt);

        //Read lockbox from NBT
        ItemStack lockboxFromNbt = view.read("StoredLockbox", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
        setStoredLockbox(lockboxFromNbt);
    }

    int tickCount = 0;

    private int dustDelay = 2000;
    private int artifactParticleDelay = 10;

    @Override
    public void tick() {
        if(this.world != null && !this.world.isClient) {
            tickCount++;
            if (tickCount % 5 == 0) {
                getStoredItem();
                world.updateListeners(pos, getCachedState(), getCachedState(), 3);
            }
            if (!(hasStoredItem() && !hasStoredCarpet() && !hasStoredLockbox())) {
                markDirty();
            }
            if (hasStoredLockbox() && CONFIG.dustyLockboxes()) {
                tryDust(this.world);
            }
            if (this.world instanceof ServerWorld serverWorld
                    && CONFIG.displayedItemParticles()
                    && ITEM_PARTICLE_MAP.containsKey(getStoredItem().getItem())) {

                displayItemParticles(serverWorld);

            }
        }
    }

    private void tryDust(World world) {
        int currentDust = Objects.requireNonNull(getStoredLockbox().get(ModComponents.LOCKBOX_DUST_COMPONENT)).dustLevel();
        if (currentDust < 4) {
            // If dustDelay is 0, run the random chance
            if (dustDelay == 0) {
                // Only trigger the dust level increment 10% of the time
                if (world.getRandom().nextInt(100) < 10) {
                    // Increase dust level by 1
                    getStoredLockbox().set(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent(currentDust + 1));
                }
                // Reset the dustDelay to run the random check again after a set amount of ticks
                dustDelay = 2400;  //This number of ticks represents the interval at which lockboxes roll to get dustier.
            } else {
                // Decrease the delay counter every tick
                dustDelay--;
            }
        }
    }

    public static final HashMap<Item, SimpleParticleType> ITEM_PARTICLE_MAP = new HashMap<>(Map.of(
            TOTEM_OF_UNDYING, ParticleTypes.TRIAL_SPAWNER_DETECTION,
            TRIDENT, ParticleTypes.FISHING,
            MACE, ParticleTypes.TRIAL_SPAWNER_DETECTION_OMINOUS,
            ENCHANTED_GOLDEN_APPLE, ParticleTypes.ENCHANT,
            WITHER_SKELETON_SKULL, ParticleTypes.SMOKE,
            SCULK_CATALYST, ParticleTypes.SCULK_SOUL,
            DRAGON_EGG, ParticleTypes.DRAGON_BREATH,
            NETHER_STAR, ParticleTypes.END_ROD,
            HEART_OF_THE_SEA, ParticleTypes.NAUTILUS
    ));

    private void displayItemParticles(ServerWorld serverWorld) {
        if (artifactParticleDelay == 0) {
            serverWorld.spawnParticles(ITEM_PARTICLE_MAP.get(getStoredItem().getItem()), pos.getX() + 0.5, pos.getY() + 1.25, pos.getZ() + 0.5,
                    4, 0.5, 0.5, 0.5, 0.03);
            artifactParticleDelay = 10;
        } else {
            artifactParticleDelay--;
        }
    }
}