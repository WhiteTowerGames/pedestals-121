package net.chris.pedestals.mixin;

import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class BlockHardnessMixin {

    @Mutable
    @Shadow
    @Final
    private float hardness;

    @Inject(method = "getHardness", at = @At("HEAD"), cancellable = true)
    private void modifyHardness(BlockView world, BlockPos pos, CallbackInfoReturnable<Float> cir) {
        if (world != null && pos != null) {
            Block block = ((AbstractBlock.AbstractBlockState) (Object) this).getBlock();

            hardness = block.getHardness();

            BlockEntity blockEntity = world.getBlockEntity(pos);

            if (blockEntity instanceof PedestalBlockEntity pedestalBlockEntity) {
                if (pedestalBlockEntity.hasStoredLockbox()) {
                    cir.setReturnValue(Pedestals121.CONFIG.lockedPedestalsUnbreakable() ? -1f : hardness * 50f);
                }
            }
        }
    }
}
