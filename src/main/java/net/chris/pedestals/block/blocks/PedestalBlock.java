package net.chris.pedestals.block.blocks;

import com.mojang.serialization.MapCodec;
import net.chris.pedestals.components.ModComponents;
import net.chris.pedestals.criteria.ModCriteria;
import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.chris.pedestals.block.entity.TickableBlockEntity;
import net.chris.pedestals.datagen.ModItemTagProvider;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.item.Items.TOTEM_OF_UNDYING;

public class PedestalBlock extends Block implements BlockEntityProvider{

    public PedestalBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape BASE_SHAPE = Block.createCuboidShape(0.0,0.0,0.0,16.0,2.0,16.0);
    private static final VoxelShape PILLAR_SHAPE = Block.createCuboidShape(2.0,2.0,2.0,14.0,18.0,14.0);
    private static final VoxelShape DISPLAY_SHAPE = Block.createCuboidShape(-1.0,18.0,-1.0,17.0,21.0,17.0);

    public static final VoxelShape FULL_SHAPE = VoxelShapes.union(BASE_SHAPE, PILLAR_SHAPE, DISPLAY_SHAPE);

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return FULL_SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(BASE_SHAPE, PILLAR_SHAPE); // Exclude DISPLAY_SHAPE from collision
    }

    private SoundEvent getAddItemSound() {
        return SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM;
    }
    private SoundEvent getRemoveItemSound() {
        return SoundEvents.ENTITY_ITEM_FRAME_REMOVE_ITEM;
    }

    private SoundEvent getAddCarpetSoundWool() {return SoundEvents.BLOCK_WOOL_PLACE;}
    private SoundEvent getAddCarpetSoundChain() {return SoundEvents.BLOCK_CHAIN_PLACE;}
    private SoundEvent getRemoveCarpetSound() {return SoundEvents.ENTITY_MOOSHROOM_SHEAR;}

    private SoundEvent getLockSound() {return SoundEvents.BLOCK_VAULT_INSERT_ITEM_FAIL;}
    private SoundEvent getUnlockSound() {return SoundEvents.BLOCK_VAULT_INSERT_ITEM;}

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PedestalBlockEntity(pos, state);
    }

    @Override
    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof PedestalBlockEntity pedestalBlockEntity){
            switch (pedestalBlockEntity.getStoredItem().getRarity()){
                case COMMON -> {
                    return 0;
                }
                case UNCOMMON -> {
                    return 5;
                }
                case RARE -> {
                    return 10;
                }
                case EPIC -> {
                    return 15;
                }
            }
        }
        return 0;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        BlockPos aboveBlock = pos.up();

        if (!world.getBlockState(aboveBlock).isAir()){
            return ActionResult.FAIL;
        }

        if (blockEntity instanceof PedestalBlockEntity pedestalBlockEntity) {

            if (player.getStackInHand(Hand.MAIN_HAND).isEmpty() && !pedestalBlockEntity.hasStoredItem() && !pedestalBlockEntity.hasStoredCarpet() && !pedestalBlockEntity.hasStoredLockbox()){
                return ActionResult.FAIL;
            }

            ItemStack playerHeldItem = player.getStackInHand(Hand.MAIN_HAND);
            ItemStack storedItem = pedestalBlockEntity.getStoredItem();

            if(!pedestalBlockEntity.hasStoredCarpet() && playerHeldItem.isIn(ModItemTagProvider.FANCY_CARPET_BLOCK_ITEMS)) {

                pedestalBlockEntity.setStoredCarpet(playerHeldItem.split(1));

                world.playSound(null, pos, getAddCarpetSoundWool(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.playSound(null, pos, getAddCarpetSoundChain(), SoundCategory.BLOCKS, 0.15F, 1.0F);
                if (player instanceof ServerPlayerEntity serverPlayer) {
                    ModCriteria.LOCK_TOTEM_WITH_CARPET.trigger(serverPlayer, pedestalBlockEntity.getStoredItem(), pedestalBlockEntity.getStoredCarpet(), pedestalBlockEntity.getStoredLockbox());
                }
                return ActionResult.SUCCESS;

            }
            if(pedestalBlockEntity.hasStoredCarpet() && playerHeldItem.isOf(Items.SHEARS)) {
                ItemEntity itemEntity = new ItemEntity(world, pos.getX()+0.5, pos.getY()+1.25, pos.getZ()+0.5, pedestalBlockEntity.getStoredCarpet());
                pedestalBlockEntity.setStoredCarpet(ItemStack.EMPTY);
                world.playSound(null, pos, getRemoveCarpetSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                playerHeldItem.damage(1, player);
                world.spawnEntity(itemEntity);
                itemEntity.setVelocity(0.0, 0.13, 0.0);
                return ActionResult.SUCCESS;

            }
            if (!pedestalBlockEntity.hasStoredLockbox() && playerHeldItem.isIn(ModItemTagProvider.LOCKBOX_ITEMS)) {

                pedestalBlockEntity.setStoredLockbox(playerHeldItem.split(1));
                world.playSound(null, pos, getLockSound(), SoundCategory.BLOCKS, 1.0f, 0.8f);
                if (player instanceof ServerPlayerEntity serverPlayer) {
                    ModCriteria.LOCK_TOTEM_WITH_CARPET.trigger(serverPlayer, pedestalBlockEntity.getStoredItem(), pedestalBlockEntity.getStoredCarpet(), pedestalBlockEntity.getStoredLockbox());
                }
                return ActionResult.SUCCESS;
            }

            if (pedestalBlockEntity.hasStoredLockbox() && playerHeldItem.contains(ModComponents.UNLOCKS_LOCKBOXES_COMPONENT)) {
                ItemEntity itemEntity = new ItemEntity(world, pos.getX()+0.5, pos.getY()+1.3, pos.getZ()+0.5, pedestalBlockEntity.getStoredLockbox());
                pedestalBlockEntity.setStoredLockbox(ItemStack.EMPTY);
                world.spawnEntity(itemEntity);
                itemEntity.setVelocity(0.0, 0.13, 0.0);
                world.playSound(null, pos, getUnlockSound(), SoundCategory.BLOCKS, 1.0f, 0.8f);
                return ActionResult.SUCCESS;
            }
            if (!player.isSneaking()) {
                ItemEntity itemEntity = new ItemEntity(world, pos.getX()+0.5, pos.getY()+1.25, pos.getZ()+0.5, storedItem);
                if (storedItem.isEmpty() && !playerHeldItem.isEmpty() && !pedestalBlockEntity.hasStoredLockbox()) {

                    pedestalBlockEntity.setStoredItem(playerHeldItem.split(1));// Store one item

                    world.updateListeners(pos, state, state, 0);

                    world.playSound(null, pos, getAddItemSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                    if(pedestalBlockEntity.getStoredItem().getRarity()==Rarity.EPIC
                            && player instanceof ServerPlayerEntity serverPlayer){
                        ModCriteria.PLACE_EPIC_ITEM_ON_PEDESTAL.trigger(serverPlayer);
                    }
                    if (pedestalBlockEntity.getStoredItem().isIn(ModItemTagProvider.PEDESTAL_BLOCK_ITEMS)
                            && player instanceof ServerPlayerEntity serverPlayer) {
                        ModCriteria.PLACE_PEDESTAL_ON_PEDESTAL.trigger(serverPlayer);
                    }

                    return ActionResult.SUCCESS;

                } else {
                    if (!pedestalBlockEntity.hasStoredLockbox()) {
                        world.spawnEntity(itemEntity);
                        itemEntity.setVelocity(0.0, 0.13, 0.0);
                        world.playSound(null, pos, getRemoveItemSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                        pedestalBlockEntity.setStoredItem(ItemStack.EMPTY);
                        world.updateListeners(pos, state, state, 0);
                        if (!world.isClient) {
                            return ActionResult.SUCCESS_SERVER;
                        }
                        return ActionResult.SUCCESS;
                    }
                }
            }
        }
        world.updateNeighborsAlways(pos, this);
        return ActionResult.PASS;
    }

    @Override
    protected int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof PedestalBlockEntity pedestalBlockEntity && direction == Direction.UP){
            ItemStack storedItem = pedestalBlockEntity.getStoredItem();
            if (storedItem.isOf(TOTEM_OF_UNDYING)) {
                return 15;
            }
            return storedItem.getRarity()== Rarity.EPIC ? 15 : 0;
        }
        return 0;
    }

    @Override
    protected int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return getStrongRedstonePower(state, world, pos, direction);
    }

    @Override
    protected boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);

        if (blockEntity instanceof PedestalBlockEntity pedestalBlockEntity) {
            for (ItemStack itemStack : pedestalBlockEntity.getAllInventories()) {
                ItemEntity itemEntity = new ItemEntity(world, pos.getX()+0.5, pos.getY()+1.25, pos.getZ()+0.5, itemStack, 0, 0.2, 0);
                world.spawnEntity(itemEntity);
            }
            pedestalBlockEntity.setStoredItem(ItemStack.EMPTY);
            pedestalBlockEntity.setStoredCarpet(ItemStack.EMPTY);
            pedestalBlockEntity.setStoredLockbox(ItemStack.EMPTY);
        }
        world.removeBlockEntity(pos);
        return super.onBreak(world, pos, state, player); // Call the superclass method for standard block breaking behavior
    }

    /// This FINALLY solved my problem with pedestals losing their inventory when scraped/waxed/stripped.
    /// Why did I not find this method sooner?
    ///
    /// <sub>Side note: how does this work? Blocks are quasi-singletons.</sub>
    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        PedestalBlockEntity pedestalBlockEntity = (PedestalBlockEntity) world.getBlockEntity(pos);
        if (state.getBlock() != newState.getBlock() && newState.getBlock() instanceof PedestalBlock) {
            assert pedestalBlockEntity != null;
            pedestalBlockEntity.transferAllInventories(world, pos, newState.getBlock());
        }
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
        return TickableBlockEntity.getTicker(world);
    }

}
