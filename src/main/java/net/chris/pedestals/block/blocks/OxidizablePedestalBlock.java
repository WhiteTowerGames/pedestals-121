package net.chris.pedestals.block.blocks;

import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

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
                PedestalBlockEntity pedestalBlockEntity = (PedestalBlockEntity) world.getBlockEntity(pos);
                assert pedestalBlockEntity != null;
                pedestalBlockEntity.transferAllInventories(world, pos, nextBlock);
            });
        }
    }

    private Optional<Block> getNextOxidationLevel(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock());
    }

    private Block getPreviousOxidationBlock(BlockState state){
        if (Oxidizable.getDecreasedOxidationBlock(state.getBlock()).isPresent()) {
            return Oxidizable.getDecreasedOxidationBlock(state.getBlock()).get();
        }
        return this;
    }

}
