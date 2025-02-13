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

                    }).build());

    public static void registerItemGroups(){
        Pedestals121.LOGGER.info("Registering Item groups for Pedestals (source: "+Pedestals121.MOD_ID+").");
    }
}
