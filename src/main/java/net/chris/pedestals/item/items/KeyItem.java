package net.chris.pedestals.item.items;

import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.chris.pedestals.components.ModComponents;
import net.chris.pedestals.components.LockAndKeyDataComponent;
import net.chris.pedestals.criteria.ModCriteria;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.UUID;

public class KeyItem extends Item {
    public KeyItem(Settings settings) {
        super(settings);
    }

    private SoundEvent getUnlockSound() {return SoundEvents.BLOCK_VAULT_INSERT_ITEM;}
    private SoundEvent getWrongKeySound() {return SoundEvents.BLOCK_VAULT_REJECT_REWARDED_PLAYER;}
    private SoundEvent getRegisterSound() {return SoundEvents.BLOCK_VAULT_INSERT_ITEM_FAIL;}


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        ItemStack stack = context.getStack();
        BlockEntity blockEntity = world.getBlockEntity(pos);
        PlayerEntity player = context.getPlayer();

        LockAndKeyDataComponent stackComponent = stack.get(ModComponents.LOCK_AND_KEY_DATA);

        assert stackComponent != null;
        UUID stackUUID = stackComponent.uuid();
        boolean isStackMapped = stackComponent.isMapped();
        boolean isStackCopy = stackComponent.isCopy();

        if (blockEntity instanceof PedestalBlockEntity pedestalBlockEntity) {

            if (pedestalBlockEntity.hasStoredLockbox()) {

                ItemStack lockboxStack = pedestalBlockEntity.getStoredLockbox();
                LockAndKeyDataComponent lockboxComponent = lockboxStack.get(ModComponents.LOCK_AND_KEY_DATA);
                assert lockboxComponent != null;
                UUID lockboxUUID = lockboxComponent.uuid();
                boolean isLockboxMapped = lockboxComponent.isMapped();

                if (isLockboxMapped && isStackMapped) {
                    if(stackUUID.equals(lockboxUUID)) {
                        pedestalBlockEntity.setStoredLockbox(ItemStack.EMPTY);
                        ItemEntity itemEntity = new ItemEntity(world, pos.getX()+0.5, pos.getY()+1.3, pos.getZ()+0.5,
                                lockboxStack, 0.0, 0.2, 0.0);
                        if (!world.isClient && player instanceof ServerPlayerEntity serverPlayer) {
                            serverPlayer.sendMessage(Text.translatable("messages.pedestals.key_open"), true);
                            ModCriteria.USE_KEY_ON_LOCKBOX.trigger(serverPlayer);
                        }
                        world.spawnEntity(itemEntity);
                        world.playSound(null, pos, getUnlockSound(), SoundCategory.BLOCKS, 1.0f, 0.8f);
                    } else {
                        if (!world.isClient) {
                            assert player != null;
                            player.sendMessage(Text.translatable("messages.pedestals.key_wrong"), true);
                        }
                        world.playSound(null, pos, getWrongKeySound(), SoundCategory.BLOCKS, 1.0f, 0.8f);
                    }
                    return ActionResult.SUCCESS;
                }
                if (!isLockboxMapped && !isStackMapped) {
                    stack.set(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(lockboxUUID, true, isStackCopy));
                    lockboxStack.set(ModComponents.LOCK_AND_KEY_DATA, new LockAndKeyDataComponent(lockboxUUID, true));
                    world.playSound(null, pos, getRegisterSound(), SoundCategory.BLOCKS, 1.0f, 0.8f);
                    if (!world.isClient) {
                        assert player != null;
                        player.sendMessage(Text.translatable("messages.pedestals.key_map"), true);
                    }
                    return ActionResult.SUCCESS;
                }
                if (!world.isClient) {
                    assert player != null;
                    player.sendMessage(Text.translatable("messages.pedestals.key_wrong"), true);
                }
                world.playSound(null, pos, getWrongKeySound(), SoundCategory.BLOCKS, 1.0f, 0.8f);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        LockAndKeyDataComponent stackComponent = stack.get(ModComponents.LOCK_AND_KEY_DATA);
        assert stackComponent != null;
        boolean isStackMapped = stackComponent.isMapped();
        boolean isStackCopy = stackComponent.isCopy();
        if (isStackMapped){
            tooltip.add(Text.translatable("itemtooltip.pedestals.key_is_mapped"));
            if (stack.getCustomName()==null) {
                tooltip.add(Text.translatable("itemtooltip.pedestals.key_unnamed"));
            }
        } else {
            tooltip.add(Text.translatable("itemtooltip.pedestals.key_not_mapped.l1"));
            tooltip.add(Text.translatable("itemtooltip.pedestals.key_not_mapped.l2"));
        }
        if (isStackCopy){
            tooltip.add(Text.translatable("itemtooltip.pedestals.key_clone").formatted(Formatting.BOLD, Formatting.YELLOW));
        }
    }
}
