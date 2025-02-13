package net.chris.pedestals.block;

import com.mojang.serialization.MapCodec;
import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.chris.pedestals.block.entity.TickableBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PedestalBlock extends Block implements BlockEntityProvider{
    public PedestalBlock(Settings settings) {
        super(settings);
    }

    public SoundEvent getAddItemSound() {
        return SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM;
    }
    public SoundEvent getRemoveItemSound() {
        return SoundEvents.ENTITY_ITEM_FRAME_REMOVE_ITEM;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PedestalBlockEntity(pos, state);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof PedestalBlockEntity pedestalBlockEntity) {
            ItemStack playerHeldItem = player.getStackInHand(Hand.MAIN_HAND);
            ItemStack storedItem = pedestalBlockEntity.getStoredItem();
            ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), storedItem);

            if (storedItem.isEmpty() ) {//&& !playerHeldItem.isEmpty()
                // If pedestal is empty, store the item from the player
                pedestalBlockEntity.setStoredItem(playerHeldItem.split(1)); // Store one item
                world.playSound(null, pos, getAddItemSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                return ActionResult.SUCCESS; // Return success as we stored the item
            } else
                // If pedestal has an item, give it back to the player and clear the pedestal's item
                world.spawnEntity(itemEntity);
                world.playSound(null, pos, getRemoveItemSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                pedestalBlockEntity.setStoredItem(ItemStack.EMPTY); // Remove the item from the pedestal
                return ActionResult.SUCCESS; // Return success as we gave the item back
        }
        return ActionResult.PASS;
    }


    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);

        if (blockEntity instanceof PedestalBlockEntity pedestalBlockEntity) {
            ItemStack storedItem = pedestalBlockEntity.getStoredItem();

            if (!storedItem.isEmpty()) {
                // Manually drop the stored item
                ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), storedItem);
                world.spawnEntity(itemEntity);  // Spawn the item in the world
                pedestalBlockEntity.setStoredItem(ItemStack.EMPTY);  // Clear the stored item after dropping
            }
        }

        return super.onBreak(world, pos, state, player); // Call the superclass method for standard block breaking behavior
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
        return TickableBlockEntity.getTicker(world);
    }
}
