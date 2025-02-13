package net.chris.pedestals;

import net.chris.pedestals.block.ModBlockEntities;
import net.chris.pedestals.block.ModBlocks;
import net.chris.pedestals.block.entity.PedestalBlockEntityRenderer;
import net.chris.pedestals.item.ModItemGroups;
import net.chris.pedestals.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pedestals121 implements ModInitializer {
	public static final String MOD_ID = "pedestals";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModBlockEntities.registerModBlockEntities();
		//BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BLOCK_ENTITY, PedestalBlockEntityRenderer::new);
	}
}