package net.chris.strippableblocksapi.mixin;

import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.chris.strippableblocksapi.StrippableCustomRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AxeItem.class)
public class AxeItemMixin {

	@Unique
	public SoundEvent getStripSound() {return SoundEvents.ITEM_AXE_STRIP;}


	@Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
	private void onUse(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {

		World world = context.getWorld();
		BlockPos pos = context.getBlockPos();
		Block block = world.getBlockState(pos).getBlock();

		Block strippedBlock = StrippableCustomRegistry.getStrippedResult(block);

		if (strippedBlock != null){
			BlockEntity pedestalEntity = world.getBlockEntity(pos);

			if (pedestalEntity instanceof PedestalBlockEntity) {
				PedestalBlockEntity pedestalBlockEntity = (PedestalBlockEntity) pedestalEntity;

                ItemStack currentItem = pedestalBlockEntity.getStoredItem();

				world.setBlockState(pos, strippedBlock.getDefaultState(), 3);

				PedestalBlockEntity newPedestalBlockEntity = (PedestalBlockEntity) world.getBlockEntity(pos);

                assert newPedestalBlockEntity != null;
                newPedestalBlockEntity.setStoredItem(currentItem);

				world.playSound(null, pos, getStripSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);

				cir.setReturnValue(ActionResult.SUCCESS);

			}


		}

	}

}