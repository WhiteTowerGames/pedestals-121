package net.chris.pedestals.mixin;

import net.chris.pedestals.block.ModBlocks;
import net.chris.pedestals.block.blocks.OxidizablePedestalBlock;
import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.HoneycombItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HoneycombItem.class)
public class HoneycombItemMixin {

    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    public void waxCopperPedestal(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState oldState = world.getBlockState(pos);
        Block block = oldState.getBlock();
        if (block instanceof OxidizablePedestalBlock) {
            Block newBlock = ModBlocks.UNWAXED_TO_WAXED_COPPER_PEDESTAL_MAP.get(block);

            if (newBlock != null) {
                PedestalBlockEntity pedestalBlockEntity = (PedestalBlockEntity) world.getBlockEntity(pos);
                assert pedestalBlockEntity != null;
                pedestalBlockEntity.transferAllInventories(world, pos, newBlock);
                context.getStack().decrement(1);
                world.playSound(null, pos, SoundEvents.ITEM_HONEYCOMB_WAX_ON, SoundCategory.BLOCKS);
                cir.setReturnValue(ActionResult.SUCCESS);
            }
        }

    }

}
