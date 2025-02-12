package net.chris.pedestals.block;

import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.block.entity.PedestalBE;
import net.fabricmc.fabric.impl.registry.sync.trackers.vanilla.BlockInitTracker;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<PedestalBE> PEDESTAL_BLOCK_ENTITY = registerBlockEntity("pedestal_block_entity",
            BlockEntityType.Builder.create(PedestalBE::new, ModBlocks.EXAMPLE_BE_PEDESTAL)
                    .build());

    public static BlockEntityType registerBlockEntity(String name, BlockEntityType type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Pedestals121.MOD_ID), type);
    }

    public static void registerModBlockEntities(){
        Pedestals121.LOGGER.info("Registering Mod Block Entities for Pedestals");
    }

}
