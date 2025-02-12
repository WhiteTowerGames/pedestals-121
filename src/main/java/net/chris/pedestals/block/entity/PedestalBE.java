package net.chris.pedestals.block.entity;

import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.block.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class PedestalBE extends BlockEntity {

    public PedestalBE(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PEDESTAL_BLOCK_ENTITY, pos, state);
    }

    private int counter;

    public int getCounter(){
        return this.counter;
    }

    public void incrementCounter(){
        this.counter++;
        markDirty();

        if(this.counter % 10 == 0 && this.world instanceof ServerWorld sWorld){
            EntityType.PIG.spawn(sWorld, pos.up(), SpawnReason.TRIGGERED);
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        nbt.putInt("counter", this.counter);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        this.counter = nbt.contains("counter", NbtElement.INT_TYPE) ? nbt.getInt("counter") : 0;
    }

}
