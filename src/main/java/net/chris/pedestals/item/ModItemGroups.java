package net.chris.pedestals.item;

import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup PEDESTALS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Pedestals121.MOD_ID, "pedestals"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.STONE_BRICK_PEDESTAL))
                    .displayName(Text.translatable("itemgroup.pedestals.pedestals"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.STONE_BRICK_PEDESTAL);
                        entries.add(ModBlocks.MOSSY_STONE_BRICK_PEDESTAL);
                        entries.add(ModBlocks.DEEPSLATE_BRICK_PEDESTAL);
                        entries.add(ModBlocks.DEEPSLATE_TILE_PEDESTAL);
                        entries.add(ModBlocks.POLISHED_GRANITE_PEDESTAL);
                        entries.add(ModBlocks.POLISHED_DIORITE_PEDESTAL);
                        entries.add(ModBlocks.POLISHED_ANDESITE_PEDESTAL);
                        entries.add(ModBlocks.POLISHED_DEEPSLATE_PEDESTAL);
                        entries.add(ModBlocks.CALCITE_PEDESTAL);
                        entries.add(ModBlocks.COPPER_PEDESTAL);
                        entries.add(ModBlocks.EXPOSED_COPPER_PEDESTAL);
                        entries.add(ModBlocks.WEATHERED_COPPER_PEDESTAL);
                        entries.add(ModBlocks.OXIDIZED_COPPER_PEDESTAL);
                        entries.add(ModBlocks.WAXED_COPPER_PEDESTAL);
                        entries.add(ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL);
                        entries.add(ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL);
                        entries.add(ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL);
                        entries.add(ModBlocks.CUT_COPPER_PEDESTAL);
                        entries.add(ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL);
                        entries.add(ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL);
                        entries.add(ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL);
                        entries.add(ModBlocks.WAXED_CUT_COPPER_PEDESTAL);
                        entries.add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL);
                        entries.add(ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL);
                        entries.add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL);
                        entries.add(ModBlocks.BRICK_PEDESTAL);
                        entries.add(ModBlocks.END_STONE_BRICK_PEDESTAL);
                        entries.add(ModBlocks.MUD_BRICK_PEDESTAL);
                        entries.add(ModBlocks.NETHER_BRICK_PEDESTAL);
                        entries.add(ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL);
                        entries.add(ModBlocks.POLISHED_BLACKSTONE_PEDESTAL);
                        entries.add(ModBlocks.DARK_PRISMARINE_PEDESTAL);
                        entries.add(ModBlocks.PRISMARINE_BRICK_PEDESTAL);
                        entries.add(ModBlocks.PURPUR_BLOCK_PEDESTAL);
                        entries.add(ModBlocks.QUARTZ_BRICK_PEDESTAL);
                        entries.add(ModBlocks.RED_NETHER_BRICK_PEDESTAL);
                        entries.add(ModBlocks.SMOOTH_QUARTZ_PEDESTAL);
                        entries.add(ModBlocks.POLISHED_TUFF_PEDESTAL);
                        entries.add(ModBlocks.TUFF_BRICK_PEDESTAL);
                        entries.add(ModBlocks.OAK_LOG_PEDESTAL);
                        entries.add(ModBlocks.BIRCH_LOG_PEDESTAL);
                        entries.add(ModBlocks.SPRUCE_LOG_PEDESTAL);
                        entries.add(ModBlocks.JUNGLE_LOG_PEDESTAL);
                        entries.add(ModBlocks.DARK_OAK_LOG_PEDESTAL);
                        entries.add(ModBlocks.ACACIA_LOG_PEDESTAL);
                        entries.add(ModBlocks.MANGROVE_LOG_PEDESTAL);
                        entries.add(ModBlocks.CHERRY_LOG_PEDESTAL);
                        entries.add(ModBlocks.BAMBOO_LOG_PEDESTAL);
                        entries.add(ModBlocks.BAMBOO_MOSAIC_PEDESTAL);
                        entries.add(ModBlocks.STRIPPED_OAK_LOG_PEDESTAL);
                        entries.add(ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL);
                        entries.add(ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL);
                        entries.add(ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL);
                        entries.add(ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL);
                        entries.add(ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL);
                        entries.add(ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL);
                        entries.add(ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL);
                        entries.add(ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL);

                        
                    }).build());

    public static void registerItemGroups(){
        Pedestals121.LOGGER.info("Registering Item groups for Pedestals (source: "+Pedestals121.MOD_ID+").");
    }
}
