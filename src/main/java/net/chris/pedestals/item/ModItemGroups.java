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

import static net.chris.pedestals.block.ModBlocks.*;
import static net.chris.pedestals.item.ModItems.*;

public class ModItemGroups {

    public static final ItemGroup PEDESTALS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Pedestals121.MOD_ID, "pedestals"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.STONE_BRICK_PEDESTAL))
                    .displayName(Text.translatable("itemgroup.pedestals.pedestals"))
                    .entries((displayContext, entries) -> ALL_PEDESTALS.forEach(entries::add)).build());

    public static final ItemGroup FANCY_CARPETS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Pedestals121.MOD_ID, "fancy_carpets"),
                    FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.RED_GILDED_CARPET))
                            .displayName(Text.translatable("itemgroup.pedestals.fancycarpets"))
                            .entries((displayContext, entries) -> ALL_FANCY_CARPETS.forEach(entries::add)).build());

    public static final ItemGroup LOCKBOXES_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Pedestals121.MOD_ID, "lockboxes"),
            FabricItemGroup.builder().icon(() -> new ItemStack(GLASS_LOCKBOX))
                    .displayName(Text.translatable("itemgroup.pedestals.lockboxes"))
                    .entries((displayContext, entries) -> {

                        entries.add(GLASS_LOCKBOX);

                        STAINED_LOCKBOX_TO_GLASS_MAP.keySet().forEach(entries::add);
                        
                        entries.add(LOCKBOX_KEY);

                        entries.add(LOCKPICK);

                    }).build());

    public static void initialize(){
        Pedestals121.LOGGER.info("Registering Item groups for Pedestals (source: "+Pedestals121.MOD_ID+").");
    }
}
