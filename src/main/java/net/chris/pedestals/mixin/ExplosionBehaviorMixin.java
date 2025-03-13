package net.chris.pedestals.mixin;

import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.chris.pedestals.gamerules.ModGameRuleCache;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(ExplosionBehavior.class)
public class ExplosionBehaviorMixin {

    @Inject(method = "getBlastResistance", at = @At("HEAD"), cancellable = true)
    private void modifyBlastResistance(Explosion explosion, BlockView world, BlockPos pos, BlockState blockState,
                                       FluidState fluidState, CallbackInfoReturnable<Optional<Float>> cir) {

        if (world.getBlockEntity(pos) instanceof PedestalBlockEntity pedestalBlockEntity) {
            if (pedestalBlockEntity.hasStoredLockbox()) {
                cir.setReturnValue(Optional.of(ModGameRuleCache.areLockedPedestalsUnbreakable() ? 3600000f : blockState.getBlock().getBlastResistance() + 3f));
            }
        }

    }

}
