package net.chris.pedestals.mixin;

import net.chris.pedestals.block.ModBlocks;
import net.chris.pedestals.block.blocks.OxidizablePedestalBlock;
import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AxeItem.class)
public class AxeItemMixin {

    @Inject(
            method = {"useOnBlock"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void scrapeCopperPedestal(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState oldState = world.getBlockState(pos);
        Block block = oldState.getBlock();

        if (block instanceof OxidizablePedestalBlock oxidizablePedestalBlock) {
            BlockState newState = oxidizablePedestalBlock.getPreviousOxidationLevel(oldState)
                    .orElse(null);

            if (newState != null) {
                PedestalBlockEntity pedestalBlockEntity = (PedestalBlockEntity) world.getBlockEntity(pos);
                assert pedestalBlockEntity != null;
                pedestalBlockEntity.transferAllInventories(world, pos, newState.getBlock());
                world.playSound(null, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(context.getPlayer(), world.getBlockState(pos)));
                world.syncWorldEvent(context.getPlayer(), WorldEvents.BLOCK_SCRAPED, pos, 0);
                context.getStack().damage(1, context.getPlayer());
                cir.setReturnValue(ActionResult.SUCCESS);
            } else {
                cir.setReturnValue(ActionResult.PASS);
            }
        }

        if (ModBlocks.WAXED_TO_UNWAXED_COPPER_PEDESTAL_MAP.containsKey(block)){
            BlockState newState = ModBlocks.WAXED_TO_UNWAXED_COPPER_PEDESTAL_MAP.get(block).getDefaultState();
            PedestalBlockEntity pedestalBlockEntity = (PedestalBlockEntity) world.getBlockEntity(pos);
            assert pedestalBlockEntity != null;
            pedestalBlockEntity.transferAllInventories(world, pos, newState.getBlock());
            world.playSound(null, pos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(context.getPlayer(), world.getBlockState(pos)));
            world.syncWorldEvent(context.getPlayer(), WorldEvents.WAX_REMOVED, pos, 0);
            context.getStack().damage(1, context.getPlayer());
            cir.setReturnValue(ActionResult.SUCCESS);
        }

        if (ModBlocks.STRIPPABLE_PEDESTALS_MAP.containsKey(block)){
            BlockState newState = ModBlocks.STRIPPABLE_PEDESTALS_MAP.get(block).getDefaultState();
            PedestalBlockEntity pedestalBlockEntity = (PedestalBlockEntity) world.getBlockEntity(pos);
            assert pedestalBlockEntity != null;
            pedestalBlockEntity.transferAllInventories(world, pos, newState.getBlock());
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(context.getPlayer(), world.getBlockState(pos)));
            world.playSound(null, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS);
            context.getStack().damage(1, context.getPlayer());
            cir.setReturnValue(ActionResult.SUCCESS);
        }
    }

}
