package net.chris.pedestals.block.blocks;

import net.chris.pedestals.Pedestals121;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.TextureKey;
import net.minecraft.client.data.TextureMap;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class FancyCarpetBlock extends Block {

    public FancyCarpetBlock(Settings settings) {
        super(settings);
    }

    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);

    private static SoundEvent getChainPlaceSound() {
        return SoundEvents.BLOCK_CHAIN_PLACE;
    }

    private static SoundEvent getChainBreakSound() {
        return SoundEvents.BLOCK_CHAIN_BREAK;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        world.playSound(null, pos, getChainPlaceSound(), SoundCategory.BLOCKS, 0.15F, 1.0F);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        world.playSound(null, pos, getChainBreakSound(), SoundCategory.BLOCKS, 0.15F, 1.0F);
        return super.onBreak(world, pos, state, player); // Call the superclass method for standard block breaking behavior
    }

    public static final TextureKey GOLD = TextureKey.of("gold");

    public static final Model FANCY_CARPET_MODEL = blockCarpet("fancy_carpet", TextureKey.WOOL, GOLD);

    public static Model blockCarpet(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.of(Pedestals121.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    public static TextureMap fancyCarpetMap(String color) {
        TextureMap textureMap = new TextureMap();

        //Map the wool texture to the vanilla wool texture with the specified color
        textureMap.put(TextureKey.WOOL, Identifier.of("minecraft", "block/"+color+"_wool"));

        //Map the gold texture to the gold block texture
        textureMap.put(GOLD, Identifier.of("minecraft", "block/gold_block"));

        return textureMap;

    }

}
