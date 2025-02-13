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
                    ModBlocks.PEDESTAL
                    ).build());

    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Pedestals121.MOD_ID, name), type);
    }

    public static void registerModBlockEntities() {
        Pedestals121.LOGGER.info("Registering Block Entities for Pedestals 1.21 (source: " + Pedestals121.MOD_ID + ").");
    }
}
