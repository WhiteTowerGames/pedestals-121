package net.chris.pedestals.datagen;

import net.chris.pedestals.block.ModBlocks;
import net.chris.pedestals.block.PedestalBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.chris.pedestals.block.PedestalBlock;
import net.minecraft.util.math.Direction;

import static net.chris.pedestals.block.PedestalBlock.PEDESTAL_MODEL;
import static net.minecraft.block.Block.createCuboidShape;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        registerPedestal(blockStateModelGenerator, ModBlocks.STONE_BRICK_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.STONE_BRICK_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.MOSSY_STONE_BRICK_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.MOSSY_STONE_BRICK_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.DEEPSLATE_BRICK_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.DEEPSLATE_BRICK_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.DEEPSLATE_TILE_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.DEEPSLATE_TILE_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_GRANITE_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.POLISHED_GRANITE_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_DIORITE_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.POLISHED_DIORITE_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_ANDESITE_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.POLISHED_ANDESITE_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_DEEPSLATE_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.POLISHED_DEEPSLATE_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.CALCITE_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.CALCITE_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.COPPER_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.COPPER_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.EXPOSED_COPPER_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.EXPOSED_COPPER_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.WEATHERED_COPPER_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.WEATHERED_COPPER_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.OXIDIZED_COPPER_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.OXIDIZED_COPPER_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_COPPER_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.COPPER_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.EXPOSED_COPPER_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.WEATHERED_COPPER_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.OXIDIZED_COPPER_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.CUT_COPPER_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.CUT_COPPER_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_CUT_COPPER_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.CUT_COPPER_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.BRICK_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.BRICK_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.END_STONE_BRICK_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.END_STONE_BRICK_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.MUD_BRICK_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.MUD_BRICK_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.NETHER_BRICK_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.NETHER_BRICK_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_BLACKSTONE_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.POLISHED_BLACKSTONE_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.DARK_PRISMARINE_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.DARK_PRISMARINE_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.PRISMARINE_BRICK_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.PRISMARINE_BRICK_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.PURPUR_BLOCK_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.PURPUR_BLOCK_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.QUARTZ_BRICK_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.QUARTZ_BRICK_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.RED_NETHER_BRICK_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.RED_NETHER_BRICK_PEDESTAL));
        registerPedestal(blockStateModelGenerator, ModBlocks.SMOOTH_QUARTZ_PEDESTAL, PedestalBlock.pedestalMap(ModBlocks.SMOOTH_QUARTZ_PEDESTAL));


    }

    public static void registerPedestal(BlockStateModelGenerator generator, Block pedestalBlock, TextureMap textures){
        Identifier pedestalModel = PEDESTAL_MODEL.upload(pedestalBlock, textures, generator.modelCollector);

        generator.registerParentedItemModel(pedestalBlock, pedestalModel);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(pedestalBlock, pedestalModel));
        textures.put(TextureKey.PARTICLE, textures.getTexture(TextureKey.ALL));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }


    @Override
    public String getName() {
        return "Mod Model Provider";
    }



}
