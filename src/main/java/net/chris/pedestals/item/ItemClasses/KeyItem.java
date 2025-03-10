package net.chris.pedestals.item.ItemClasses;

import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.chris.pedestals.components.ModComponents;
import net.chris.pedestals.components.UUIDAndBoolComponent;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
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

        UUIDAndBoolComponent stackComponent = stack.get(ModComponents.UUID_BOOL_COMPONENT);

        UUID stackUUID = stackComponent.uuid();
        boolean isStackMapped = stackComponent.isMapped();
        boolean isStackCopy = stackComponent.isCopy();

        Pedestals121.LOGGER.info("Key UUID: {}", stackUUID);
        Pedestals121.LOGGER.info("Is key mapped? {}", isStackMapped);
        Pedestals121.LOGGER.info("Is key a duplicate? {}", isStackCopy);

        if (blockEntity instanceof PedestalBlockEntity pedestalBlockEntity) {

            if (pedestalBlockEntity.hasStoredLockbox()) {

                ItemStack lockboxStack = pedestalBlockEntity.getStoredLockbox();

                UUIDAndBoolComponent lockboxComponent = lockboxStack.get(ModComponents.UUID_BOOL_COMPONENT);
                UUID lockboxUUID = lockboxComponent.uuid();
                boolean isLockboxMapped = lockboxComponent.isMapped();

                if (isLockboxMapped && isStackMapped) {
                    if(stackUUID.equals(lockboxUUID)) {
                        pedestalBlockEntity.setStoredLockbox(ItemStack.EMPTY);
                        ItemEntity itemEntity = new ItemEntity(world, pos.getX()+0.5, pos.getY()+1.3, pos.getZ()+0.5,
                                lockboxStack, 0.0, 0.2, 0.0);
                        if (!world.isClient) {
                            player.sendMessage(Text.of("Case Opened!"), true);
                        }
                        world.spawnEntity(itemEntity);
                        world.playSound(null, pos, getUnlockSound(), SoundCategory.BLOCKS, 1.0f, 0.8f);
                        return ActionResult.SUCCESS;
                    } else {
                        if (!world.isClient) {
                            player.sendMessage(Text.of("Incorrect Key!"), true);
                        }
                        world.playSound(null, pos, getWrongKeySound(), SoundCategory.BLOCKS, 1.0f, 0.8f);
                        return ActionResult.FAIL;
                    }
                }
                if (!isLockboxMapped && !isStackMapped) {
                    stack.set(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(lockboxUUID, true, isStackCopy));
                    lockboxStack.set(ModComponents.UUID_BOOL_COMPONENT, new UUIDAndBoolComponent(lockboxUUID, true, false));
                    world.playSound(null, pos, getRegisterSound(), SoundCategory.BLOCKS, 1.0f, 0.8f);
                    if (!world.isClient) {
                        player.sendMessage(Text.of("Key Registered!"), true);
                    }
                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        UUIDAndBoolComponent stackComponent = stack.get(ModComponents.UUID_BOOL_COMPONENT);
        boolean isStackMapped = stackComponent.isMapped();
        boolean isStackCopy = stackComponent.isCopy();
        if (isStackMapped){
            tooltip.add(Text.of("This key will open a specific lockbox."));
            tooltip.add(Text.of("Consider renaming it to keep track."));
        }
        if (isStackCopy){
            tooltip.add(Text.literal("Duplicate Key").formatted(Formatting.BOLD, Formatting.YELLOW));
        }
    }
}
