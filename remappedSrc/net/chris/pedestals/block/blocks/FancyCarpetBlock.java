package net.chris.pedestals.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FancyCarpetBlock extends Block {

    public FancyCarpetBlock(Settings settings) {
        super(settings);
    }

    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);

    private static SoundEvent getChainPlaceSound() {
        return SoundEvents.BLOCK_CHAIN_PLACE;
    }

    private static SoundEvent getChainBreakSound() {
        return SoundEvents.BLOCK_CHAIN_BREAK;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        world.playSound(null, pos, getChainPlaceSound(), SoundCategory.BLOCKS, 0.15F, 1.0F);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        world.playSound(null, pos, getChainBreakSound(), SoundCategory.BLOCKS, 0.15F, 1.0F);
        return super.onBreak(world, pos, state, player); // Call the superclass method for standard block breaking behavior
    }

}
