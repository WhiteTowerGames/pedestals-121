package net.chris.pedestals;

import net.chris.pedestals.block.ModBlockEntities;
import net.chris.pedestals.block.ModBlocks;
import net.chris.pedestals.item.ModItemGroups;
import net.chris.pedestals.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pedestals121 implements ModInitializer {

	public static final String MOD_ID = "pedestals";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCriteria.init();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModBlockEntities.registerModBlockEntities();
	}
}