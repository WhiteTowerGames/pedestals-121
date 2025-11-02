package net.chris.pedestals.datagen;

import net.chris.pedestals.block.ModBlocks;
import net.chris.pedestals.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.ModelVariant;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;

import java.util.HashMap;
import java.util.Map;

import static net.chris.pedestals.block.ModBlocks.*;
import static net.chris.pedestals.item.ModItems.*;
import static net.chris.pedestals.models.CustomModels.*;
import static net.minecraft.block.Blocks.*;
import static net.minecraft.block.Blocks.BLACK_WOOL;
import static net.minecraft.block.Blocks.BLUE_WOOL;
import static net.minecraft.block.Blocks.BROWN_WOOL;
import static net.minecraft.block.Blocks.CYAN_WOOL;
import static net.minecraft.block.Blocks.GRAY_WOOL;
import static net.minecraft.block.Blocks.GREEN_WOOL;
import static net.minecraft.block.Blocks.LIGHT_BLUE_WOOL;
import static net.minecraft.block.Blocks.LIME_WOOL;
import static net.minecraft.block.Blocks.MAGENTA_WOOL;
import static net.minecraft.block.Blocks.ORANGE_WOOL;
import static net.minecraft.block.Blocks.PINK_WOOL;
import static net.minecraft.block.Blocks.PURPLE_WOOL;
import static net.minecraft.block.Blocks.RED_WOOL;
import static net.minecraft.block.Blocks.YELLOW_WOOL;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        registerPedestal(blockStateModelGenerator, ModBlocks.STONE_BRICK_PEDESTAL, pedestalMap(Blocks.STONE_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.MOSSY_STONE_BRICK_PEDESTAL, pedestalMap(Blocks.MOSSY_STONE_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.DEEPSLATE_BRICK_PEDESTAL, pedestalMap(Blocks.DEEPSLATE_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.DEEPSLATE_TILE_PEDESTAL, pedestalMap(Blocks.DEEPSLATE_TILES));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_GRANITE_PEDESTAL, pedestalMap(Blocks.POLISHED_GRANITE));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_DIORITE_PEDESTAL, pedestalMap(Blocks.POLISHED_DIORITE));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_ANDESITE_PEDESTAL, pedestalMap(Blocks.POLISHED_ANDESITE));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_DEEPSLATE_PEDESTAL, pedestalMap(Blocks.POLISHED_DEEPSLATE));
        registerPedestal(blockStateModelGenerator, ModBlocks.CALCITE_PEDESTAL, pedestalMap(Blocks.CALCITE));
        registerPedestal(blockStateModelGenerator, ModBlocks.COPPER_PEDESTAL, pedestalMap(Blocks.COPPER_BLOCK));
        registerPedestal(blockStateModelGenerator, ModBlocks.EXPOSED_COPPER_PEDESTAL, pedestalMap(Blocks.EXPOSED_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WEATHERED_COPPER_PEDESTAL, pedestalMap(Blocks.WEATHERED_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.OXIDIZED_COPPER_PEDESTAL, pedestalMap(Blocks.OXIDIZED_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_COPPER_PEDESTAL, pedestalMap(Blocks.COPPER_BLOCK));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL, pedestalMap(Blocks.EXPOSED_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL, pedestalMap(Blocks.WEATHERED_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL, pedestalMap(Blocks.OXIDIZED_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.CUT_COPPER_PEDESTAL, pedestalMap(Blocks.CUT_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL, pedestalMap(Blocks.EXPOSED_CUT_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL, pedestalMap(Blocks.WEATHERED_CUT_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL, pedestalMap(Blocks.OXIDIZED_CUT_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_CUT_COPPER_PEDESTAL, pedestalMap(Blocks.CUT_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL, pedestalMap(Blocks.EXPOSED_CUT_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL, pedestalMap(Blocks.WEATHERED_CUT_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL, pedestalMap(Blocks.OXIDIZED_CUT_COPPER));
        registerPedestal(blockStateModelGenerator, ModBlocks.BRICK_PEDESTAL, pedestalMap(Blocks.BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.END_STONE_BRICK_PEDESTAL, pedestalMap(Blocks.END_STONE_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.MUD_BRICK_PEDESTAL, pedestalMap(Blocks.MUD_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.NETHER_BRICK_PEDESTAL, pedestalMap(Blocks.NETHER_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL, pedestalMap(Blocks.POLISHED_BLACKSTONE_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_BLACKSTONE_PEDESTAL, pedestalMap(Blocks.POLISHED_BLACKSTONE));
        registerPedestal(blockStateModelGenerator, ModBlocks.DARK_PRISMARINE_PEDESTAL, pedestalMap(Blocks.DARK_PRISMARINE));
        registerPedestal(blockStateModelGenerator, ModBlocks.PRISMARINE_BRICK_PEDESTAL, pedestalMap(Blocks.PRISMARINE_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.PURPUR_BLOCK_PEDESTAL, pedestalMap(Blocks.PURPUR_BLOCK));
        registerPedestal(blockStateModelGenerator, ModBlocks.QUARTZ_BRICK_PEDESTAL, pedestalMap(Blocks.QUARTZ_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.RED_NETHER_BRICK_PEDESTAL, pedestalMap(Blocks.RED_NETHER_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.SMOOTH_QUARTZ_PEDESTAL, pedestalMap(Blocks.SMOOTH_QUARTZ));
        registerPedestal(blockStateModelGenerator, ModBlocks.POLISHED_TUFF_PEDESTAL, pedestalMap(Blocks.POLISHED_TUFF));
        registerPedestal(blockStateModelGenerator, ModBlocks.TUFF_BRICK_PEDESTAL, pedestalMap(Blocks.TUFF_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.BAMBOO_MOSAIC_PEDESTAL, pedestalMap(Blocks.BAMBOO_MOSAIC));
        registerPedestal(blockStateModelGenerator, ModBlocks.RESIN_BRICK_PEDESTAL, pedestalMap(Blocks.RESIN_BRICKS));
        registerPedestal(blockStateModelGenerator, ModBlocks.SMOOTH_SANDSTONE_PEDESTAL, pedestalMap(Blocks.SMOOTH_SANDSTONE));
        registerPedestal(blockStateModelGenerator, ModBlocks.SMOOTH_RED_SANDSTONE_PEDESTAL, pedestalMap(Blocks.SMOOTH_RED_SANDSTONE));

        /// Pedestals that use more than one texture (Mostly wooden ones)
        registerPedestalWood(blockStateModelGenerator, ModBlocks.OAK_LOG_PEDESTAL, pedestalMapWood(Blocks.OAK_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.BIRCH_LOG_PEDESTAL, pedestalMapWood(Blocks.BIRCH_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.SPRUCE_LOG_PEDESTAL, pedestalMapWood(Blocks.SPRUCE_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.JUNGLE_LOG_PEDESTAL, pedestalMapWood(Blocks.JUNGLE_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.DARK_OAK_LOG_PEDESTAL, pedestalMapWood(Blocks.DARK_OAK_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.ACACIA_LOG_PEDESTAL, pedestalMapWood(Blocks.ACACIA_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.MANGROVE_LOG_PEDESTAL, pedestalMapWood(Blocks.MANGROVE_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.CHERRY_LOG_PEDESTAL, pedestalMapWood(Blocks.CHERRY_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.BAMBOO_LOG_PEDESTAL, pedestalMapWood(Blocks.BAMBOO_BLOCK));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_OAK_LOG_PEDESTAL, pedestalMapWood(Blocks.STRIPPED_OAK_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL, pedestalMapWood(Blocks.STRIPPED_BIRCH_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL, pedestalMapWood(Blocks.STRIPPED_SPRUCE_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL, pedestalMapWood(Blocks.STRIPPED_JUNGLE_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL, pedestalMapWood(Blocks.STRIPPED_DARK_OAK_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL, pedestalMapWood(Blocks.STRIPPED_ACACIA_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL, pedestalMapWood(Blocks.STRIPPED_MANGROVE_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL, pedestalMapWood(Blocks.STRIPPED_CHERRY_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL, pedestalMapWood(Blocks.STRIPPED_BAMBOO_BLOCK));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.CHISELED_TUFF_BRICK_PEDESTAL, pedestalMapWood(Blocks.CHISELED_TUFF_BRICKS));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.PALE_OAK_LOG_PEDESTAL, pedestalMapWood(Blocks.PALE_OAK_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_PALE_OAK_LOG_PEDESTAL, pedestalMapWood(Blocks.STRIPPED_PALE_OAK_LOG));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.CRIMSON_LOG_PEDESTAL, pedestalMapWood(Blocks.CRIMSON_STEM));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_CRIMSON_LOG_PEDESTAL, pedestalMapWood(Blocks.STRIPPED_CRIMSON_STEM));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.WARPED_LOG_PEDESTAL, pedestalMapWood(Blocks.WARPED_STEM));
        registerPedestalWood(blockStateModelGenerator, ModBlocks.STRIPPED_WARPED_LOG_PEDESTAL, pedestalMapWood(Blocks.STRIPPED_WARPED_STEM));

        /// Pedestal Extension block:

        blockStateModelGenerator.registerSimpleCubeAll(PEDESTAL_EXTENSION);

        /// Gilded Carpet and Lockbox Models:

        registerLockbox(blockStateModelGenerator, GLASS_LOCKBOX, lockboxMap(GLASS));

        registerLockbox(blockStateModelGenerator, DUST_1, dustMap("dust1"));
        registerLockbox(blockStateModelGenerator, DUST_2, dustMap("dust2"));
        registerLockbox(blockStateModelGenerator, DUST_3, dustMap("dust3"));
        registerLockbox(blockStateModelGenerator, DUST_4, dustMap("dust4"));

        GILDED_TO_WOOL_MAP.forEach((gilded, woolEquivalent) -> registerFancyCarpet(blockStateModelGenerator, gilded, fancyCarpetMap(woolEquivalent)));

        STAINED_LOCKBOX_TO_GLASS_MAP.forEach((lockbox, glass) -> registerLockbox(blockStateModelGenerator, lockbox, lockboxMap(glass)));
    }


    public static void registerPedestal(BlockStateModelGenerator generator, Block pedestalBlock, TextureMap textures){
        Identifier pedestalModel = PEDESTAL_MODEL.upload(pedestalBlock, textures, generator.modelCollector);
        WeightedVariant weightedVariant = new WeightedVariant(Pool.of(new ModelVariant(pedestalModel)));

        generator.registerParentedItemModel(pedestalBlock, pedestalModel);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(pedestalBlock, weightedVariant));
    }

    public static void registerPedestalWood(BlockStateModelGenerator generator, Block pedestalBlock, TextureMap textures){
        Identifier pedestalModel = PEDESTAL_MODEL_MORE.upload(pedestalBlock, textures, generator.modelCollector);
        WeightedVariant weightedVariant = new WeightedVariant(Pool.of(new ModelVariant(pedestalModel)));

        generator.registerParentedItemModel(pedestalBlock, pedestalModel);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(pedestalBlock, weightedVariant));
    }

    public static void registerFancyCarpet(BlockStateModelGenerator generator, Block fancyCarpetBlock, TextureMap textures){
        Identifier fancyCarpetModel = FANCY_CARPET_MODEL.upload(fancyCarpetBlock, textures, generator.modelCollector);
        WeightedVariant weightedVariant = new WeightedVariant(Pool.of(new ModelVariant(fancyCarpetModel)));

        generator.registerParentedItemModel(fancyCarpetBlock, fancyCarpetModel);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(fancyCarpetBlock, weightedVariant));
    }

    public static void registerLockbox(BlockStateModelGenerator generator, Item lockboxItem, TextureMap textures) {
        Identifier lockboxModel = LOCKBOX_MODEL.upload(lockboxItem, textures, generator.modelCollector);

        generator.registerItemModel(lockboxItem, lockboxModel);
    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LOCKBOX_KEY, Models.GENERATED);
        itemModelGenerator.register(ModItems.LOCKPICK, Models.GENERATED);
        itemModelGenerator.registerWithTextureSource(ModItems.CREATIVE_KEY, ModItems.LOCKPICK, Models.GENERATED);

    }

    @Override
    public String getName() {
        return "Pedestals Model Provider";
    }

    public static final HashMap<Block, Block> GILDED_TO_WOOL_MAP = new HashMap<>(Map.ofEntries(
            Map.entry(WHITE_GILDED_CARPET, WHITE_WOOL),
            Map.entry(LIGHT_GRAY_GILDED_CARPET, LIGHT_GRAY_WOOL),
            Map.entry(GRAY_GILDED_CARPET, GRAY_WOOL),
            Map.entry(BLACK_GILDED_CARPET, BLACK_WOOL),
            Map.entry(BROWN_GILDED_CARPET, BROWN_WOOL),
            Map.entry(RED_GILDED_CARPET, RED_WOOL),
            Map.entry(ORANGE_GILDED_CARPET, ORANGE_WOOL),
            Map.entry(YELLOW_GILDED_CARPET, YELLOW_WOOL),
            Map.entry(LIME_GILDED_CARPET, LIME_WOOL),
            Map.entry(GREEN_GILDED_CARPET, GREEN_WOOL),
            Map.entry(CYAN_GILDED_CARPET, CYAN_WOOL),
            Map.entry(LIGHT_BLUE_GILDED_CARPET, LIGHT_BLUE_WOOL),
            Map.entry(BLUE_GILDED_CARPET, BLUE_WOOL),
            Map.entry(PURPLE_GILDED_CARPET, PURPLE_WOOL),
            Map.entry(MAGENTA_GILDED_CARPET, MAGENTA_WOOL),
            Map.entry(PINK_GILDED_CARPET, PINK_WOOL)
    ));
}
