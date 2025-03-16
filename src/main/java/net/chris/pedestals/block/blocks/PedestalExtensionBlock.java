package net.chris.pedestals.block.blocks;

import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.chris.pedestals.components.ModComponents;
import net.chris.pedestals.datagen.ModBlockTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
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


    private SoundEvent getUnlockSound() {
        return SoundEvents.BLOCK_VAULT_INSERT_ITEM;
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
    protected void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        if (!world.isClient) {
            player.sendMessage(Text.translatable("messages.pedestals.try_break_lockbox"), true);
        }
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

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity blockEntity = world.getBlockEntity(pos.down());
        if (blockEntity instanceof PedestalBlockEntity pedestalBlockEntity) {
            if (stack.contains(ModComponents.UNLOCKS_LOCKBOXES_COMPONENT) && pedestalBlockEntity.hasStoredLockbox()) {
                ItemEntity itemEntity = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.3, pos.getZ() + 0.5, pedestalBlockEntity.getStoredLockbox());
                pedestalBlockEntity.setStoredLockbox(ItemStack.EMPTY);
                world.spawnEntity(itemEntity);
                itemEntity.setVelocity(0.0, 0.13, 0.0);
                world.playSound(null, pos, getUnlockSound(), SoundCategory.BLOCKS, 1.0f, 0.8f);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.FAIL;
    }

    @Override
    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        return world.getBlockState(pos.down()).getPickStack(world, pos.down(), true);
    }
}
