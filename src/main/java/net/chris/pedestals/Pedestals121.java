package net.chris.pedestals;

import net.chris.pedestals.block.entity.ModBlockEntities;
import net.chris.pedestals.block.ModBlocks;
import net.chris.pedestals.components.ModComponents;
import net.chris.pedestals.criteria.ModCriteria;
import net.chris.pedestals.item.ModItemGroups;
import net.chris.pedestals.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pedestals121 implements ModInitializer {
	public static final String MOD_ID = "pedestals";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final GameRules.Key<GameRules.BooleanRule> LOCKBOX_MAKES_PEDESTAL_UNBREAKABLE =
			GameRuleRegistry.register("lockedPedestalsUnminable", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));

	@Override
	public void onInitialize() {
		ModCriteria.init();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModBlockEntities.registerModBlockEntities();
		ModComponents.initialize();

	}
}