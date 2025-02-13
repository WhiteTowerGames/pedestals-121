package net.chris.pedestals.block;

import com.mojang.serialization.MapCodec;
import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PedestalBlock extends Block implements BlockEntityProvider {
    public PedestalBlock(Settings settings) {
        super(settings);
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
        if (world.isClient) {
            return ActionResult.SUCCESS; // Ignore client-side interactions
        }

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (!(blockEntity instanceof PedestalBlockEntity pedestal)) {
            return ActionResult.PASS; // Not a pedestal, do nothing
        }

        ItemStack heldItem = player.getStackInHand(Hand.MAIN_HAND);

        if (pedestal.hasStoredItem()) {
            // If pedestal has an item, drop it and clear storage
            ItemStack removedItem = pedestal.removeStoredItem();
            if (!player.giveItemStack(removedItem)) {
                player.dropItem(removedItem, false); // Drop if inventory is full
            }
            return ActionResult.SUCCESS;
        } else if (!heldItem.isEmpty()) {
            // If pedestal is empty, store the held item
            pedestal.setStoredItem(heldItem.split(1)); // Take 1 item from stack
            return ActionResult.SUCCESS;
        }
        System.out.println("Pedestal used!");
        return ActionResult.PASS;
    }



}
