package net.chris.pedestals.block;

import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BLOCK_ENTITY = registerBlockEntity("pedestal",
            FabricBlockEntityTypeBuilder.create(PedestalBlockEntity::new,
                    ModBlocks.STONE_BRICK_PEDESTAL,
                    ModBlocks.DEEPSLATE_BRICK_PEDESTAL,
                    ModBlocks.MOSSY_STONE_BRICK_PEDESTAL,
                    ModBlocks.DEEPSLATE_TILE_PEDESTAL,
                    ModBlocks.POLISHED_GRANITE_PEDESTAL,
                    ModBlocks.POLISHED_DIORITE_PEDESTAL,
                    ModBlocks.POLISHED_ANDESITE_PEDESTAL,
                    ModBlocks.CALCITE_PEDESTAL,
                    ModBlocks.COPPER_PEDESTAL,
                    ModBlocks.EXPOSED_COPPER_PEDESTAL,
                    ModBlocks.WEATHERED_COPPER_PEDESTAL,
                    ModBlocks.OXIDIZED_COPPER_PEDESTAL,
                    ModBlocks.WAXED_COPPER_PEDESTAL,
                    ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL,
                    ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL,
                    ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL,
                    ModBlocks.CUT_COPPER_PEDESTAL,
                    ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL,
                    ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL,
                    ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL,
                    ModBlocks.WAXED_CUT_COPPER_PEDESTAL,
                    ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL,
                    ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL,
                    ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL,
                    ModBlocks.BRICK_PEDESTAL,
                    ModBlocks.END_STONE_BRICK_PEDESTAL,
                    ModBlocks.NETHER_BRICK_PEDESTAL,
                    ModBlocks.MUD_BRICK_PEDESTAL,
                    ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL,
                    ModBlocks.POLISHED_BLACKSTONE_PEDESTAL,
                    ModBlocks.DARK_PRISMARINE_PEDESTAL,
                    ModBlocks.PRISMARINE_BRICK_PEDESTAL,
                    ModBlocks.PURPUR_BLOCK_PEDESTAL,
                    ModBlocks.QUARTZ_BRICK_PEDESTAL,
                    ModBlocks.RED_NETHER_BRICK_PEDESTAL,
                    ModBlocks.SMOOTH_QUARTZ_PEDESTAL,
                    ModBlocks.POLISHED_TUFF_PEDESTAL,
                    ModBlocks.TUFF_BRICK_PEDESTAL,
                    ModBlocks.OAK_LOG_PEDESTAL,
                    ModBlocks.BIRCH_LOG_PEDESTAL,
                    ModBlocks.SPRUCE_LOG_PEDESTAL,
                    ModBlocks.JUNGLE_LOG_PEDESTAL,
                    ModBlocks.DARK_OAK_LOG_PEDESTAL,
                    ModBlocks.ACACIA_LOG_PEDESTAL,
                    ModBlocks.MANGROVE_LOG_PEDESTAL,
                    ModBlocks.CHERRY_LOG_PEDESTAL,
                    ModBlocks.BAMBOO_LOG_PEDESTAL,
                    ModBlocks.BAMBOO_MOSAIC_PEDESTAL,
                    ModBlocks.STRIPPED_OAK_LOG_PEDESTAL,
                    ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL,
                    ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL,
                    ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL,
                    ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL,
                    ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL,
                    ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL,
                    ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL,
                    ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL,
                    ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL,
                    ModBlocks.CHISELED_TUFF_BRICK_PEDESTAL,
                    ModBlocks.CRIMSON_LOG_PEDESTAL,
                    ModBlocks.STRIPPED_CRIMSON_LOG_PEDESTAL,
                    ModBlocks.WARPED_LOG_PEDESTAL,
                    ModBlocks.STRIPPED_WARPED_LOG_PEDESTAL,
                    ModBlocks.SMOOTH_SANDSTONE_PEDESTAL,
                    ModBlocks.SMOOTH_RED_SANDSTONE_PEDESTAL,
                    ModBlocks.POLISHED_DEEPSLATE_PEDESTAL
                    ).build());



    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Pedestals121.MOD_ID, name), type);
    }

    public static void registerModBlockEntities() {
        Pedestals121.LOGGER.info("Registering Block Entities for Pedestals 1.21 (source: " + Pedestals121.MOD_ID + ").");
    }
}
