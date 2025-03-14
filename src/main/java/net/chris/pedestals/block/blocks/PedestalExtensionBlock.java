package net.chris.pedestals.block.blocks;

import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.chris.pedestals.datagen.ModBlockTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

public class PedestalExtensionBlock extends Block {
    public PedestalExtensionBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape LOCKBOX_SHAPE = Block.createCuboidShape(2.5, 5.0, 2.5, 13.5, 19.0, 13.5);
    private static final VoxelShape LOCKBOX_SHAPE_WITH_CARPET = Block.createCuboidShape(2.5, 6.0, 2.5, 13.5, 20.0, 13.5);
    private static final VoxelShape LOCKBOX_SHAPE_COLLISION = Block.createCuboidShape(2.5, 5.0, 2.5, 13.5, 16.0, 13.5);

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        BlockPos down = pos.down();
        BlockEntity blockEntityDown = world.getBlockEntity(down);
        if (blockEntityDown instanceof PedestalBlockEntity pedestalBlockEntity) {
            if (pedestalBlockEntity.hasStoredLockbox()) {
                if (!pedestalBlockEntity.hasStoredCarpet()) {
                    return LOCKBOX_SHAPE;
                } else {
                    return LOCKBOX_SHAPE_WITH_CARPET;
                }
            }
        }
        return VoxelShapes.empty();
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        BlockPos down = pos.down();
        BlockEntity blockEntityDown = world.getBlockEntity(down);
        if (blockEntityDown instanceof PedestalBlockEntity pedestalBlockEntity) {
            if (pedestalBlockEntity.hasStoredLockbox()) {
                return LOCKBOX_SHAPE_COLLISION;
            }
        }
        return VoxelShapes.empty();
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        return !state.canPlaceAt(world, pos)
                ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        world.setBlockState(pos.down(), Blocks.AIR.getDefaultState());
        return super.onBreak(world, pos, state, player); // Call the superclass method for standard block breaking behavior
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isIn(ModBlockTagProvider.PEDESTAL_BLOCKS);
    }
}
