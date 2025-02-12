package net.chris.pedestals.block;

import net.chris.pedestals.block.entity.PedestalBE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PedestalBlockEntity extends Block implements BlockEntityProvider {
    public PedestalBlockEntity(Settings settings) {
        super(settings);
    }

//    @Override
//    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
//    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient){
           BlockEntity blockEntity = world.getBlockEntity(pos);
           if(blockEntity instanceof PedestalBE pedestalBE && player != null){
               if(player.isSneaking()){
                   player.sendMessage(Text.of(pedestalBE.getCounter() + ""), true);
               } else {
                    pedestalBE.incrementCounter();
               }
           }
        }

        return ActionResult.success(world.isClient);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntities.PEDESTAL_BLOCK_ENTITY.instantiate(pos, state);
    }
}