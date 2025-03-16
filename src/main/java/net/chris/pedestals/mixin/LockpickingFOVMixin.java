package net.chris.pedestals.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.chris.pedestals.item.ModItems.LOCKPICK;

@Mixin(AbstractClientPlayerEntity.class)
public class LockpickingFOVMixin {

    @Inject(method = "getFovMultiplier", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;isUsingItem()Z"), cancellable = true)
    public void lockpickingZoom(boolean firstPerson, float fovEffectScale, CallbackInfoReturnable<Float> cir) {
        AbstractClientPlayerEntity abstractClientPlayerEntity = ((AbstractClientPlayerEntity) (Object) this);

        // Check if the player is using the lockpicking item
        if (abstractClientPlayerEntity.isUsingItem() && abstractClientPlayerEntity.getActiveItem().isOf(LOCKPICK)) {  // Replace with your custom item
            // Calculate how long the item has been used (similar to bow charging)
            float progress = Math.min((float) abstractClientPlayerEntity.getItemUseTime() / 80.0F, 1.0F);
            // Apply the zoom effect (square for gradual effect)
            float zoom = 1.0F - MathHelper.square(progress) * 0.5F; // Adjust 0.3F initial value for more or less zoom
            // Apply the zoom factor to the FOV multiplier
            cir.setReturnValue(MathHelper.lerp(fovEffectScale, 1.0F, zoom));
        }
    }
}
