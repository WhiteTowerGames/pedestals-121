package net.chris.pedestals;

import net.chris.pedestals.block.entity.ModBlockEntities;
import net.chris.pedestals.block.ModBlocks;
import net.chris.pedestals.components.ModComponents;
import net.chris.pedestals.config.PedestalsConfig;
import net.chris.pedestals.criteria.ModCriteria;
import net.chris.pedestals.item.ModItemGroups;
import net.chris.pedestals.item.ModItems;
import net.chris.pedestals.recipes.ModRecipeSerializers;
import net.chris.pedestals.sounds.ModSoundEvents;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static net.chris.pedestals.item.ModItems.LOCKPICK;
import static net.minecraft.item.Items.EMERALD;
import static net.minecraft.item.Items.IRON_INGOT;

public class Pedestals121 implements ModInitializer {

	public static final String MOD_ID = "pedestals";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final PedestalsConfig CONFIG = PedestalsConfig.createAndLoad();

	@Override
	public void onInitialize() {

		// Initialize all mod elements.
		ModCriteria.initialize();
		ModItemGroups.initialize();
		ModSoundEvents.initialize();
		ModBlocks.initialize();
		ModItems.initialize();
		ModBlockEntities.initialize();
		ModComponents.initialize();
		ModRecipeSerializers.initialize();

        // Register custom villager trade.
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3, factories ->
				factories.add(((world,entity, random) -> new TradeOffer(
                new TradedItem(EMERALD, 10),
                Optional.of(new TradedItem(IRON_INGOT, 2)),
                new ItemStack(LOCKPICK, 1), 6, 10, 4, 0.06f, 2))));

		// Register item tooltips. Can you believe I actually bothered to re-implement them?
		// Leaving this here as a reminder: TOOLTIPS ARE CLIENT SIDE!
		//ModItems.registerItemTooltips();
	}
}