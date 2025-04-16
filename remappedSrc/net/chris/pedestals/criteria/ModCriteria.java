package net.chris.pedestals.criteria;

import net.chris.pedestals.Pedestals121;
import net.minecraft.advancement.criterion.Criteria;

public class ModCriteria {

    public static final PlaceEpicItemOnPedestalCriterion PLACE_EPIC_ITEM_ON_PEDESTAL = Criteria.register(
            PlaceEpicItemOnPedestalCriterion.ID.toString(), new PlaceEpicItemOnPedestalCriterion());

    public static final PlacePedestalOnPedestalCriterion PLACE_PEDESTAL_ON_PEDESTAL = Criteria.register(
            PlacePedestalOnPedestalCriterion.ID.toString(), new PlacePedestalOnPedestalCriterion());

    public static final LockArtifactWithCarpetCriterion LOCK_ARTIFACT_WITH_CARPET = Criteria.register(
            LockArtifactWithCarpetCriterion.ID.toString(), new LockArtifactWithCarpetCriterion());

    public static final UseKeyOnLockboxCriterion USE_KEY_ON_LOCKBOX = Criteria.register(
            UseKeyOnLockboxCriterion.ID.toString(), new UseKeyOnLockboxCriterion());

    public static final BreakLockpickCriterion BREAK_LOCKPICK = Criteria.register(
            BreakLockpickCriterion.ID.toString(), new BreakLockpickCriterion());

    public static final UseLockpickCriterion USE_LOCKPICK = Criteria.register(
            UseLockpickCriterion.ID.toString(), new UseLockpickCriterion());

    public static final FullyCleanLockboxCriterion FULLY_CLEAN_LOCKBOX = Criteria.register(
            FullyCleanLockboxCriterion.ID.toString(), new FullyCleanLockboxCriterion());

    public static void initialize(){
        Pedestals121.LOGGER.info("Registering Pedestals custom criteria!");
    }
}
