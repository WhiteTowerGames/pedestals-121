package net.chris.pedestals;

import net.minecraft.advancement.criterion.Criteria;

public class ModCriteria {

    public static final PlaceEpicItemOnPedestalCriterion PLACE_EPIC_ITEM_ON_PEDESTAL = Criteria.register(
            Pedestals121.MOD_ID+":place_epic_item_on_pedestal", new PlaceEpicItemOnPedestalCriterion());

    public static final PlacePedestalOnPedestalCriterion PLACE_PEDESTAL_ON_PEDESTAL = Criteria.register(
            Pedestals121.MOD_ID+":place_pedestal_on_pedestal", new PlacePedestalOnPedestalCriterion());



    static void init(){
        Pedestals121.LOGGER.info("Registering Pedestals custom criteria!");
    }
}
