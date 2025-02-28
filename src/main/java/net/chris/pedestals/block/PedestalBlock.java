package net.chris.pedestals.block;

import com.mojang.serialization.MapCodec;
import net.chris.pedestals.ModCriteria;
import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.chris.pedestals.block.entity.TickableBlockEntity;
import net.chris.pedestals.datagen.ModItemTagProvider;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.ModelIds;
import net.minecraft.client.data.TextureKey;
import net.minecraft.client.data.TextureMap;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

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

    public SoundEvent getAddItemSound() {
        return SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM;
    }
    public SoundEvent getRemoveItemSound() {
        return SoundEvents.ENTITY_ITEM_FRAME_REMOVE_ITEM;
    }

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
            //return pedestalBlockEntity.hasStoredItem() ? 15 : 0; //Return a strength of 15 if there is an item; otherwise zero
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

        if (blockEntity instanceof PedestalBlockEntity pedestalBlockEntity && !player.isSneaking()) {
            ItemStack playerHeldItem = player.getStackInHand(Hand.MAIN_HAND);
            ItemStack storedItem = pedestalBlockEntity.getStoredItem();
            ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), storedItem);
            if (storedItem.isEmpty() ) {

                pedestalBlockEntity.setStoredItem(playerHeldItem.split(1)); // Store one item
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

            } else
                world.spawnEntity(itemEntity);
            world.playSound(null, pos, getRemoveItemSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                pedestalBlockEntity.setStoredItem(ItemStack.EMPTY);
                return ActionResult.SUCCESS;
        }
        world.updateNeighborsAlways(pos, this);
        return ActionResult.PASS;
    }

    @Override
    protected int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof PedestalBlockEntity pedestalBlockEntity && direction == Direction.UP){
            ItemStack storedItem = pedestalBlockEntity.getStoredItem();
            if(storedItem.getRarity() == Rarity.EPIC) {
                return 15;
            }
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
            ItemStack storedItem = pedestalBlockEntity.getStoredItem();

            if (!storedItem.isEmpty()) {
                // Manually drop the stored item
                ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), storedItem);
                world.spawnEntity(itemEntity);  // Spawn the item in the world
                pedestalBlockEntity.setStoredItem(ItemStack.EMPTY);  // Clear the stored item after dropping
            }
        }

        return super.onBreak(world, pos, state, player); // Call the superclass method for standard block breaking behavior
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
        return TickableBlockEntity.getTicker(world);
    }

    public static final Model PEDESTAL_MODEL = block("parent_pedestal", TextureKey.ALL);
    public static final Model PEDESTAL_MODEL_MORE = block("parent_pedestal_more", TextureKey.SIDE, TextureKey.TOP);

    private static Model block(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.of(Pedestals121.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);

    }

    public static TextureMap pedestalMap(Block block) {
        return new TextureMap()
                .put(TextureKey.ALL, ModelIds.getBlockSubModelId(block, ""));

    }

    public static TextureMap pedestalMapWood(Block block) {
        return new TextureMap()
                .put(TextureKey.SIDE, ModelIds.getBlockSubModelId(block, ""))
                .put(TextureKey.TOP, ModelIds.getBlockSubModelId(block, "_top"));
    }



}
