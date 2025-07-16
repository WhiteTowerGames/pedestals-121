package net.chris.pedestals.block;

import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.Optional;

public class OxidizablePedestalBlock extends PedestalBlock implements Oxidizable {
    private final OxidationLevel oxidationLevel;

    public OxidizablePedestalBlock(OxidationLevel oxidationLevel, Settings settings) {
        super(settings);
        this.oxidationLevel = oxidationLevel;
    }

    @Override
    public OxidationLevel getDegradationLevel() {
        return oxidationLevel;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.random.nextFloat() < 0.1F) { // Adjust chance of oxidation
            getNextOxidationLevel(state).ifPresent(nextBlock -> {
                // Transfer inventory before changing oxidation level
                transferInventoryToNewState(world, pos, nextBlock.getDefaultState());
            });
        }
    }

    private Optional<Block> getNextOxidationLevel(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock());
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        // For oxidizable pedestals, we need to handle inventory transfer even when it's the same base block type
        // but different oxidation level
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            
            if (blockEntity instanceof PedestalBlockEntity pedestalBlockEntity) {
                ItemStack storedItem = pedestalBlockEntity.getStoredItem();
                
                if (!storedItem.isEmpty()) {
                    // If both blocks are pedestals, we should try to transfer the inventory
                    // Otherwise, drop the item
                    if (newState.getBlock() instanceof PedestalBlock) {
                        // The new block entity will be created after this method, so we'll store the item temporarily
                        // This will be handled by the block placement logic
                    } else {
                        // Different block type, drop the item
                        ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), storedItem);
                        world.spawnEntity(itemEntity);
                        pedestalBlockEntity.setStoredItem(ItemStack.EMPTY);
                    }
                }
            }
        }
        
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    private void transferInventoryToNewState(World world, BlockPos pos, BlockState newState) {
        BlockEntity oldEntity = world.getBlockEntity(pos);
        ItemStack storedItem = ItemStack.EMPTY;
        
        if (oldEntity instanceof PedestalBlockEntity pedestalBlockEntity) {
            storedItem = pedestalBlockEntity.getStoredItem();
            pedestalBlockEntity.setStoredItem(ItemStack.EMPTY);
        }
        
        // Change the block state
        world.setBlockState(pos, newState);
        
        // Transfer the item to the new block entity
        if (!storedItem.isEmpty()) {
            BlockEntity newEntity = world.getBlockEntity(pos);
            if (newEntity instanceof PedestalBlockEntity newPedestalEntity) {
                newPedestalEntity.setStoredItem(storedItem);
            }
        }
    }
}
