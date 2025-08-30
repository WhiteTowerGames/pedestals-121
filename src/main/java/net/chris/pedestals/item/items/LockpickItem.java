package net.chris.pedestals.item.items;

import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.chris.pedestals.criteria.ModCriteria;
import net.chris.pedestals.sounds.ModSoundEvents;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.consume.UseAction;
import net.minecraft.network.packet.s2c.play.SubtitleS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleFadeS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.chris.pedestals.Pedestals121.CONFIG;
import static net.chris.pedestals.block.ModBlocks.PEDESTAL_EXTENSION;

public class LockpickItem extends Item{

    public LockpickItem(Settings settings) {
        super(settings);
    }

    private SoundEvent getUnlockSound() {return SoundEvents.BLOCK_VAULT_INSERT_ITEM;}

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BRUSH;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 120;
    }

    private final SoundEvent[] GET_LOCKPICKING_SOUNDS = {SoundEvents.BLOCK_VAULT_INSERT_ITEM, SoundEvents.BLOCK_VAULT_INSERT_ITEM_FAIL, SoundEvents.BLOCK_VAULT_REJECT_REWARDED_PLAYER};

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity playerEntity = context.getPlayer();
        if (playerEntity != null && this.getHitResult(playerEntity).getType() == HitResult.Type.BLOCK && context.getWorld().getBlockState(context.getBlockPos()).isOf(PEDESTAL_EXTENSION)) {
            playerEntity.setCurrentHand(context.getHand());
            return ActionResult.CONSUME;
        }
        return ActionResult.FAIL;
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (user instanceof PlayerEntity player && CONFIG.enableLockpicks()) {

            HitResult hitResult = this.getHitResult(player);

            boolean lookingAtExtension = hitResult instanceof BlockHitResult blockHitResult &&
                    blockHitResult.getType() == HitResult.Type.BLOCK &&
                    world.getBlockState(blockHitResult.getBlockPos()).isOf(PEDESTAL_EXTENSION);

            if (!lookingAtExtension || player.timeUntilRegen > 0) {
                player.stopUsingItem();
                return;
            }

            if (remainingUseTicks > 1) {

                if (hitResult instanceof BlockHitResult blockHitResult && blockHitResult.getType() == HitResult.Type.BLOCK) {
                    BlockPos pos = blockHitResult.getBlockPos();
                    PedestalBlockEntity pedestalBlockEntity = (PedestalBlockEntity) world.getBlockEntity(pos.down());
                    assert pedestalBlockEntity != null;
                    int soundTime = this.getMaxUseTime(stack, user) - remainingUseTicks + 1;
                    boolean shouldPlaySound = soundTime % 30 == 5;
                    if (world.getBlockState(pos).isOf(PEDESTAL_EXTENSION) && pedestalBlockEntity.hasStoredLockbox()) {
                        if (shouldPlaySound) {
                            world.playSound(player, pos, GET_LOCKPICKING_SOUNDS[world.getRandom().nextInt(3)], SoundCategory.PLAYERS, 0.05f, world.getRandom().nextFloat() + 3.0f);
                        }
                    }
                }
            } else {
                if (!world.isClient) {
                    finishUsing(stack, world, user);
                }
            }
        }
    }

    @Override
    public boolean onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity player && !world.isClient) {
            breakLockpick(stack, player, world);
        }
        return true;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity player && this.getHitResult(player) instanceof BlockHitResult blockHitResult){
            BlockEntity blockEntity = world.getBlockEntity(blockHitResult.getBlockPos().down());
            if (blockEntity instanceof PedestalBlockEntity pedestalBlockEntity) {
                return tryLockpick(world, player, pedestalBlockEntity, stack, blockHitResult.getBlockPos()) ? stack : ItemStack.EMPTY;
            }
        }
        return stack;
    }

    private HitResult getHitResult(PlayerEntity user) {
        return ProjectileUtil.getCollision(user, EntityPredicates.CAN_HIT, user.getBlockInteractionRange());
    }

    private boolean tryLockpick(World world, PlayerEntity player, PedestalBlockEntity pedestalBlockEntity, ItemStack stack, BlockPos pos){
        boolean lockpickResult = false;
        int easterEggChance = world.getRandom().nextInt(50);
        int roll = world.getRandom().nextInt(100);
        if (roll < CONFIG.percentLockpickSuccessChance()) { //Lockpicking succeeded
            ItemEntity itemEntity = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.3, pos.getZ() + 0.5,
                    pedestalBlockEntity.getStoredLockbox(), 0.0, 0.2, 0.0);
            pedestalBlockEntity.setStoredLockbox(ItemStack.EMPTY);
            lockpickResult = true;
            if (!world.isClient && player instanceof ServerPlayerEntity serverPlayer) {
                if (easterEggChance >= 1) { //Normal lockpicking response
                    serverPlayer.sendMessage(Text.translatable("messages.pedestals.lockpicking_success"), true);
                } else { //Play the Easter egg!
                    playEasterEgg(player, world.getRandom().nextBetween(25, 70), world, pos);
                }
                ModCriteria.USE_LOCKPICK.trigger(serverPlayer);
            }
            world.spawnEntity(itemEntity);
            world.playSound(null, pos, getUnlockSound(), SoundCategory.BLOCKS, 1.0f, 0.8f);
        } else {
            assert player != null;
            breakLockpick(stack, player, world);
            if (easterEggChance >= 1 && player instanceof ServerPlayerEntity serverPlayer) {
                serverPlayer.sendMessage(Text.translatable("messages.pedestals.lockpicking_failed"), true);
            } else {
                playEasterEgg(player, world.getRandom().nextBetween(20, 55), world, pos);
            }
            if (player instanceof ServerPlayerEntity serverPlayer) {
                ModCriteria.BREAK_LOCKPICK.trigger(serverPlayer);
            }
        }
        return lockpickResult;
    }

    private void playEasterEgg(PlayerEntity player, int skillLevel, World world, BlockPos pos){

        if (!world.isClient && player instanceof ServerPlayerEntity serverPlayer) {
            world.playSound(null, pos, ModSoundEvents.LOCKPICKING_INCREASE, SoundCategory.PLAYERS, 1f, 1f);
            serverPlayer.networkHandler.sendPacket(new TitleFadeS2CPacket(20, 25, 15));
            serverPlayer.networkHandler.sendPacket(new TitleS2CPacket(Text.literal("")));
            serverPlayer.networkHandler.sendPacket(new SubtitleS2CPacket(Text.literal("LOCKPICKING INCREASED TO " + skillLevel).formatted(Formatting.BOLD)));
        }
    }

    private void breakLockpick(ItemStack stack, PlayerEntity player, World world) {
        if (world instanceof ServerWorld && !player.isCreative()) {
            EquipmentSlot equipmentSlot = stack.equals(player.getEquippedStack(EquipmentSlot.OFFHAND)) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
            stack.damage(1, player, equipmentSlot);
        }
    }


}
