package net.chris.pedestals.datagen;

import net.chris.pedestals.block.ModBlocks;
import net.chris.pedestals.block.PedestalBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import static net.chris.pedestals.block.PedestalBlock.PEDESTAL_MODEL;
import static net.chris.pedestals.block.PedestalBlock.PEDESTAL_MODEL_MORE;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        registerPedestal(blockStateModelGenerator, ModBlocks.STONE_BRICK_PEDESTAL, PedestalBlock.pedestalMap(Blocks.STONE_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.MOSSY_STONE_BRICK_PEDESTAL, PedestalBlock.pedestalMap(Blocks.MOSSY_STONE_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.DEEPSLATE_BRICK_PEDESTAL, PedestalBlock.pedestalMap(Blocks.DEEPSLATE_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.DEEPSLATE_TILE_PEDESTAL, PedestalBlock.pedestalMap(Blocks.DEEPSLATE_TILES));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_GRANITE_PEDESTAL, PedestalBlock.pedestalMap(Blocks.POLISHED_GRANITE));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_DIORITE_PEDESTAL, PedestalBlock.pedestalMap(Blocks.POLISHED_DIORITE));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_ANDESITE_PEDESTAL, PedestalBlock.pedestalMap(Blocks.POLISHED_ANDESITE));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_DEEPSLATE_PEDESTAL, PedestalBlock.pedestalMap(Blocks.POLISHED_DEEPSLATE));
        registerPedestal(blockStateModelGenerator, ModBlocks.CALCITE_PEDESTAL, PedestalBlock.pedestalMap(Blocks.CALCITE));
        registerPedestal(blockStateModelGenerator, ModBlocks.COPPER_PEDESTAL, PedestalBlock.pedestalMap(Blocks.COPPER_BLOCK));
        registerPedestal(blockStateModelGenerator, ModBlocks.EXPOSED_COPPER_PEDESTAL, PedestalBlock.pedestalMap(Blocks.EXPOSED_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WEATHERED_COPPER_PEDESTAL, PedestalBlock.pedestalMap(Blocks.WEATHERED_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.OXIDIZED_COPPER_PEDESTAL, PedestalBlock.pedestalMap(Blocks.OXIDIZED_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_COPPER_PEDESTAL, PedestalBlock.pedestalMap(Blocks.COPPER_BLOCK));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL, PedestalBlock.pedestalMap(Blocks.EXPOSED_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL, PedestalBlock.pedestalMap(Blocks.WEATHERED_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL, PedestalBlock.pedestalMap(Blocks.OXIDIZED_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.CUT_COPPER_PEDESTAL, PedestalBlock.pedestalMap(Blocks.CUT_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL, PedestalBlock.pedestalMap(Blocks.EXPOSED_CUT_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL, PedestalBlock.pedestalMap(Blocks.WEATHERED_CUT_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL, PedestalBlock.pedestalMap(Blocks.OXIDIZED_CUT_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_CUT_COPPER_PEDESTAL, PedestalBlock.pedestalMap(Blocks.CUT_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL, PedestalBlock.pedestalMap(Blocks.EXPOSED_CUT_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL, PedestalBlock.pedestalMap(Blocks.WEATHERED_CUT_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL, PedestalBlock.pedestalMap(Blocks.OXIDIZED_CUT_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.BRICK_PEDESTAL, PedestalBlock.pedestalMap(Blocks.BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.END_STONE_BRICK_PEDESTAL, PedestalBlock.pedestalMap(Blocks.END_STONE_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.MUD_BRICK_PEDESTAL, PedestalBlock.pedestalMap(Blocks.MUD_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.NETHER_BRICK_PEDESTAL, PedestalBlock.pedestalMap(Blocks.NETHER_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL, PedestalBlock.pedestalMap(Blocks.POLISHED_BLACKSTONE_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_BLACKSTONE_PEDESTAL, PedestalBlock.pedestalMap(Blocks.POLISHED_BLACKSTONE));
        registerPedestal(blockStateModelGenerator, ModBlocks.DARK_PRISMARINE_PEDESTAL, PedestalBlock.pedestalMap(Blocks.DARK_PRISMARINE));
        registerPedestal(blockStateModelGenerator, ModBlocks.PRISMARINE_BRICK_PEDESTAL, PedestalBlock.pedestalMap(Blocks.PRISMARINE_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.PURPUR_BLOCK_PEDESTAL, PedestalBlock.pedestalMap(Blocks.PURPUR_BLOCK));
        registerPedestal(blockStateModelGenerator, ModBlocks.QUARTZ_BRICK_PEDESTAL, PedestalBlock.pedestalMap(Blocks.QUARTZ_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.RED_NETHER_BRICK_PEDESTAL, PedestalBlock.pedestalMap(Blocks.RED_NETHER_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.SMOOTH_QUARTZ_PEDESTAL, PedestalBlock.pedestalMap(Blocks.SMOOTH_QUARTZ));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_TUFF_PEDESTAL, PedestalBlock.pedestalMap(Blocks.POLISHED_TUFF));
        registerPedestal(blockStateModelGenerator, ModBlocks.TUFF_BRICK_PEDESTAL, PedestalBlock.pedestalMap(Blocks.TUFF_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.BAMBOO_MOSAIC_PEDESTAL, PedestalBlock.pedestalMap(Blocks.BAMBOO_MOSAIC));


        registerPedestalWood(blockStateModelGenerator, ModBlocks.OAK_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.OAK_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.BIRCH_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.BIRCH_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.SPRUCE_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.SPRUCE_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.JUNGLE_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.JUNGLE_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.DARK_OAK_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.DARK_OAK_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.ACACIA_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.ACACIA_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.MANGROVE_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.MANGROVE_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.CHERRY_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.CHERRY_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.BAMBOO_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.BAMBOO_BLOCK));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_OAK_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.STRIPPED_OAK_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.STRIPPED_BIRCH_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.STRIPPED_SPRUCE_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.STRIPPED_JUNGLE_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.STRIPPED_DARK_OAK_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.STRIPPED_ACACIA_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.STRIPPED_MANGROVE_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.STRIPPED_CHERRY_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.STRIPPED_BAMBOO_BLOCK));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.CHISELED_TUFF_BRICK_PEDESTAL, PedestalBlock.pedestalMapWood(Blocks.CHISELED_TUFF_BRICKS));


    }

    public static void registerPedestal(BlockStateModelGenerator generator, Block pedestalBlock, TextureMap textures){
        Identifier pedestalModel = PEDESTAL_MODEL.upload(pedestalBlock, textures, generator.modelCollector);

        generator.registerParentedItemModel(pedestalBlock, pedestalModel);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(pedestalBlock, pedestalModel));
        //textures.put(TextureKey.PARTICLE, textures.getTexture(TextureKey.ALL));
    }

    public static  void registerPedestalWood(BlockStateModelGenerator generator, Block pedestalBlock, TextureMap textures){
        Identifier pedestalModel = PEDESTAL_MODEL_MORE.upload(pedestalBlock, textures, generator.modelCollector);

        generator.registerParentedItemModel(pedestalBlock, pedestalModel);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(pedestalBlock, pedestalModel));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }


    @Override
    public String getName() {
        return "Mod Model Provider";
    }



}
