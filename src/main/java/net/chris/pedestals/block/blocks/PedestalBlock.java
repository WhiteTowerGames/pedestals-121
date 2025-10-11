package net.chris.pedestals.block.blocks;

import com.mojang.serialization.MapCodec;
import com.strippableblocksapi.inventory.InventoryPreservingBlock;
import net.chris.pedestals.block.entity.ModBlockEntities;
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
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.chris.pedestals.block.ModBlocks.PEDESTAL_EXTENSION;
import static net.chris.pedestals.datagen.ModBlockTagProvider.PEDESTAL_BLOCKS;

public class PedestalBlock extends Block implements BlockEntityProvider, InventoryPreservingBlock {

    public PedestalBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape BASE_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0);
    private static final VoxelShape PILLAR_SHAPE = Block.createCuboidShape(2.0, 2.0, 2.0, 14.0, 18.0, 14.0);
    private static final VoxelShape DISPLAY_SHAPE = Block.createCuboidShape(-1.0, 18.0, -1.0, 17.0, 21.0, 17.0);
    private static final VoxelShape SMALLER_DISPLAY_SHAPE = Block.createCuboidShape(0.0, 18.0, 0.0, 16.0, 21.0, 16.0);

    private static final VoxelShape FULL_SHAPE = VoxelShapes.union(BASE_SHAPE, PILLAR_SHAPE, DISPLAY_SHAPE);
    private static final VoxelShape FULL_COLLISION_SHAPE = VoxelShapes.union(BASE_SHAPE, PILLAR_SHAPE, SMALLER_DISPLAY_SHAPE);

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return FULL_SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return FULL_COLLISION_SHAPE;
    }

    @Override
    protected VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return super.getOutlineShape(state, world, pos, context);
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

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PedestalBlockEntity(pos, state);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState aboveState = world.getBlockState(pos.up());
        return aboveState.isAir() || aboveState.isOf(PEDESTAL_EXTENSION);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        return !state.canPlaceAt(world, pos)
                ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    protected int getComparatorOutput(BlockState state, World world, BlockPos pos, Direction direction) {
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

        if (!world.getBlockState(aboveBlock).isOf(PEDESTAL_EXTENSION)){
            return ActionResult.FAIL;
        }

        if (blockEntity instanceof PedestalBlockEntity pedestalBlockEntity) {

            if (player.getStackInHand(Hand.MAIN_HAND).isEmpty() && !pedestalBlockEntity.hasStoredItem() && !pedestalBlockEntity.hasStoredCarpet() && !pedestalBlockEntity.hasStoredLockbox()){
                return ActionResult.FAIL;
            }

            ItemStack playerHeldItem = player.getStackInHand(Hand.MAIN_HAND);
            ItemStack storedItem = pedestalBlockEntity.getStoredItem();

            if(!pedestalBlockEntity.hasStoredCarpet() && playerHeldItem.isIn(ModItemTagProvider.FANCY_CARPET_BLOCK_ITEMS)) {

                return addFancyCarpet(world, pos, player, pedestalBlockEntity, playerHeldItem);

            }
            if(pedestalBlockEntity.hasStoredCarpet() && playerHeldItem.isOf(Items.SHEARS)) {

                return removeFancyCarpet(world, pos, player, pedestalBlockEntity, playerHeldItem);

            }
            if (!pedestalBlockEntity.hasStoredLockbox() && playerHeldItem.isIn(ModItemTagProvider.LOCKBOX_ITEMS)) {

                return addLockbox(world, pos, player, pedestalBlockEntity, playerHeldItem);
            }
            if (!player.isSneaking()) {
                ItemEntity itemEntity = new ItemEntity(world, pos.getX()+0.5, pos.getY()+1.5, pos.getZ()+0.5, storedItem);
                if (!pedestalBlockEntity.hasStoredLockbox()) {
                    if (storedItem.isEmpty() && !playerHeldItem.isEmpty()) {

                        return addItemCheckCriteria(state, world, pos, player, pedestalBlockEntity, playerHeldItem);

                    } else {

                        return removeItem(state, world, pos, pedestalBlockEntity, itemEntity);

                    }
                }
            }
        }
        world.updateNeighborsAlways(pos, this, null);
        return ActionResult.PASS;
    }

    private ActionResult.@NotNull Success removeItem(BlockState state, World world, BlockPos pos, PedestalBlockEntity pedestalBlockEntity, ItemEntity itemEntity) {
        world.spawnEntity(itemEntity);
        itemEntity.setVelocity(0.0, 0.13, 0.0);
        world.playSound(null, pos, getRemoveItemSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
        pedestalBlockEntity.setStoredItem(ItemStack.EMPTY);
        world.updateListeners(pos, state, state, 0);
        if (!world.isClient()) {
            return ActionResult.SUCCESS_SERVER;
        }
        return ActionResult.SUCCESS;
    }

    private ActionResult.@NotNull Success addItemCheckCriteria(BlockState state, World world, BlockPos pos, PlayerEntity player, PedestalBlockEntity pedestalBlockEntity, ItemStack playerHeldItem) {
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
    }

    private ActionResult.@NotNull Success addLockbox(World world, BlockPos pos, PlayerEntity player, PedestalBlockEntity pedestalBlockEntity, ItemStack playerHeldItem) {
        pedestalBlockEntity.setStoredLockbox(playerHeldItem.split(1));
        world.playSound(null, pos, getLockSound(), SoundCategory.BLOCKS, 1.0f, 0.8f);
        if (world instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5, pos.getY() + 1.25, pos.getZ() + 0.5,
                    10, 0.3, 0.2, 0.3, 0.03);
        }
        if (player instanceof ServerPlayerEntity serverPlayer) {
            ModCriteria.LOCK_ARTIFACT_WITH_CARPET.trigger(serverPlayer, pedestalBlockEntity.getStoredItem(), pedestalBlockEntity.getStoredCarpet(), pedestalBlockEntity.getStoredLockbox());
        }
        return ActionResult.SUCCESS;
    }

    private ActionResult.@NotNull Success removeFancyCarpet(World world, BlockPos pos, PlayerEntity player, PedestalBlockEntity pedestalBlockEntity, ItemStack playerHeldItem) {
        ItemEntity itemEntity = new ItemEntity(world, pos.getX()+0.5, pos.getY()+1.5, pos.getZ()+0.5, pedestalBlockEntity.getStoredCarpet());
        pedestalBlockEntity.setStoredCarpet(ItemStack.EMPTY);
        world.playSound(null, pos, getRemoveCarpetSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
        playerHeldItem.damage(1, player);
        world.spawnEntity(itemEntity);
        itemEntity.setVelocity(0.0, 0.13, 0.0);
        return ActionResult.SUCCESS;
    }

    private ActionResult.@NotNull Success addFancyCarpet(World world, BlockPos pos, PlayerEntity player, PedestalBlockEntity pedestalBlockEntity, ItemStack playerHeldItem) {
        pedestalBlockEntity.setStoredCarpet(playerHeldItem.split(1));

        world.playSound(null, pos, getAddCarpetSoundWool(), SoundCategory.BLOCKS, 1.0F, 1.0F);
        world.playSound(null, pos, getAddCarpetSoundChain(), SoundCategory.BLOCKS, 0.15F, 1.0F);
        if (player instanceof ServerPlayerEntity serverPlayer) {
            ModCriteria.LOCK_ARTIFACT_WITH_CARPET.trigger(serverPlayer, pedestalBlockEntity.getStoredItem(), pedestalBlockEntity.getStoredCarpet(), pedestalBlockEntity.getStoredLockbox());
        }
        return ActionResult.SUCCESS;
    }

    @Override
    protected int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof PedestalBlockEntity pedestalBlockEntity && direction == Direction.UP){
            ItemStack storedItem = pedestalBlockEntity.getStoredItem();
            if (PedestalBlockEntity.ITEM_PARTICLE_MAP.containsKey(pedestalBlockEntity.getStoredItem().getItem())) {
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
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        world.setBlockState(pos.up(), PEDESTAL_EXTENSION.getDefaultState());
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
        world.setBlockState(pos.up(), Blocks.AIR.getDefaultState());
        return super.onBreak(world, pos, state, player); // Call the superclass method for standard block breaking behavior
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
        return TickableBlockEntity.getTicker(world);
    }

    @Override
    public void onStripped(World world, BlockPos blockPos, BlockState blockState) {
        System.out.println("PedestalBlock.onStripped called at " + blockPos + " with state: " + blockState);
        if (blockState.isIn(PEDESTAL_BLOCKS)){
            PedestalBlockEntity oldPedestal = world.getBlockEntity(blockPos, ModBlockEntities.PEDESTAL_BLOCK_ENTITY)
                    .orElseThrow(() -> new IllegalStateException("PedestalBlockEntity not found at " + blockPos));

            oldPedestal.transferAllInventories(world, blockPos, blockState.getBlock());
        }
    }
}
