package net.chris.pedestals.mixin;

import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.chris.pedestals.components.LockboxDustComponent;
import net.chris.pedestals.components.ModComponents;
import net.chris.pedestals.criteria.ModCriteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BrushItem;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(BrushItem.class)
public abstract class BrushMixin {

    @Shadow protected abstract HitResult getHitResult(PlayerEntity user);

    @Inject(method = "usageTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;)V"), cancellable = true)
    public void dustLockbox(World world, LivingEntity user, ItemStack stack, int remainingUseTicks, CallbackInfo ci) {
        BrushItem brushItem = ((BrushItem) (Object) this);
        if (world instanceof ServerWorld serverWorld && user instanceof PlayerEntity player
                && getHitResult(player) instanceof BlockHitResult blockHitResult
                && world.getBlockEntity(blockHitResult.getBlockPos().down()) instanceof PedestalBlockEntity pedestalBlockEntity) {

            int currentDust = getCurrentDust(pedestalBlockEntity);
            int i = brushItem.getMaxUseTime(stack, user) - remainingUseTicks + 1;
            boolean bl = i % 30 == 5;
            BlockPos pos = blockHitResult.getBlockPos();
            if (currentDust > 0) {
                if (bl) {
                    serverWorld.spawnParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5,
                            3, 0.15, 0.15, 0.15, 0.04);
                    pedestalBlockEntity.getStoredLockbox().set(ModComponents.LOCKBOX_DUST_COMPONENT, new LockboxDustComponent(currentDust - 1));
                    ModCriteria.FULLY_CLEAN_LOCKBOX.trigger((ServerPlayerEntity) player, currentDust - 1);
                    if (currentDust - 1 == 0) {
                        serverWorld.spawnParticles(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                                10, 0.15, 0.2, 0.15, 0.02);
                    }
                }
            } else {
                ci.cancel();
            }
        }
    }

    @Unique
    private static int getCurrentDust(PedestalBlockEntity pedestalBlockEntity) {
        return Objects.requireNonNull(pedestalBlockEntity.getStoredLockbox().get(ModComponents.LOCKBOX_DUST_COMPONENT)).dustLevel();
    }

}
