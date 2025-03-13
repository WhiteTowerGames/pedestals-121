package net.chris.pedestals.item.items;

import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.chris.pedestals.criteria.ModCriteria;
import net.chris.pedestals.gamerules.ModGameRuleCache;
import net.chris.pedestals.gamerules.ModGameRules;
import net.chris.pedestals.sounds.ModSoundEvents;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.network.packet.s2c.play.SubtitleS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleFadeS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class LockpickItem extends Item {

    public LockpickItem(Settings settings) {
        super(settings);
    }

    private SoundEvent getUnlockSound() {return SoundEvents.BLOCK_VAULT_INSERT_ITEM;}

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();

        if (world.isClient()) {
            return ActionResult.SUCCESS;
        }

        ItemStack stack = context.getStack();
        BlockEntity blockEntity = world.getBlockEntity(pos);
        PlayerEntity player = context.getPlayer();

        ServerWorld serverWorld = ((ServerWorld) world);
        ServerPlayerEntity serverPlayer = (ServerPlayerEntity) context.getPlayer();

        int successChance = serverWorld.getGameRules().getInt(ModGameRules.LOCKPICK_SUCCESS_CHANCE);
        boolean lockpicksEnabled = serverWorld.getGameRules().getBoolean(ModGameRules.ENABLE_LOCKPICKS);
        if (!lockpicksEnabled) {
            return ActionResult.FAIL;
        }
        if (blockEntity instanceof PedestalBlockEntity pedestalBlockEntity) {
            if (pedestalBlockEntity.hasStoredLockbox()) {
                tryLockpick(world, player, pedestalBlockEntity, stack, pos);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    private void tryLockpick(World world, PlayerEntity player, PedestalBlockEntity pedestalBlockEntity, ItemStack stack, BlockPos pos){
        int easterEggChance = world.getRandom().nextInt(50);
        int roll = world.getRandom().nextInt(100);
        if (roll < ModGameRuleCache.getPercentLockpickSuccessChance()) {
            ItemEntity itemEntity = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.3, pos.getZ() + 0.5,
                    pedestalBlockEntity.getStoredLockbox(), 0.0, 0.2, 0.0);
            pedestalBlockEntity.setStoredLockbox(ItemStack.EMPTY);
            if (!world.isClient && player instanceof ServerPlayerEntity serverPlayer) {
                if (easterEggChance >= 1) { //Normal lockpicking response
                    serverPlayer.sendMessage(Text.translatable("messages.pedestals.lockpicking_success"), true);
                } else { //Play the easter egg!
                    playEasterEgg(player, world.getRandom().nextBetween(25, 70), world, pos);
                }
                ModCriteria.USE_LOCKPICK.trigger(serverPlayer);
            }
            world.spawnEntity(itemEntity);
            world.playSound(null, pos, getUnlockSound(), SoundCategory.BLOCKS, 1.0f, 0.8f);
        } else {
            assert player != null;
            if (!player.isCreative()) {
                player.sendEquipmentBreakStatus(stack.getItem(), EquipmentSlot.MAINHAND);
            }
            stack.decrementUnlessCreative(1, player);
            if (easterEggChance >= 1 && player instanceof ServerPlayerEntity serverPlayer) {
                serverPlayer.sendMessage(Text.translatable("messages.pedestals.lockpicking_failed"), true);
            } else {
                playEasterEgg(player, world.getRandom().nextBetween(20, 55), world, pos);
            }
            if (player instanceof ServerPlayerEntity serverPlayer) {
                ModCriteria.BREAK_LOCKPICK.trigger(serverPlayer);
            }
        }
    }

    private void playEasterEgg(PlayerEntity player, int skillLevel, World world, BlockPos pos){
        ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
        if (!world.isClient) {
            world.playSound(null, pos, ModSoundEvents.LOCKPICKING_INCREASE, SoundCategory.PLAYERS, 1f, 1f);
        }
        serverPlayer.networkHandler.sendPacket(new TitleFadeS2CPacket(20, 25, 15));
        serverPlayer.networkHandler.sendPacket(new TitleS2CPacket(Text.literal("")));
        serverPlayer.networkHandler.sendPacket(new SubtitleS2CPacket(Text.literal("LOCKPICKING INCREASED TO " + skillLevel).formatted(Formatting.BOLD)));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {

        boolean isEnabled = ModGameRuleCache.areLockpicksEnabled();
        if (!isEnabled){
            tooltip.add(Text.translatable("itemtooltip.pedestals.lockpick_disabled.l1").formatted(Formatting.RED, Formatting.BOLD));
            tooltip.add(Text.translatable("itemtooltip.pedestals.lockpick_disabled.l2").formatted(Formatting.RED, Formatting.BOLD));
        } else {
            tooltip.add(Text.translatable("itemtooltip.pedestals.lockpick_enabled.l1"));
            tooltip.add(Text.translatable("itemtooltip.pedestals.lockpick_enabled.l2"));
        }
    }
}
