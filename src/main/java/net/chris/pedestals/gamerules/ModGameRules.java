package net.chris.pedestals.gamerules;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class ModGameRules {

    public static final GameRules.Key<GameRules.BooleanRule> INFINITE_KEY_DUPING =
            GameRuleRegistry.register("infiniteKeyDuping", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(false));

    public static final GameRules.Key<GameRules.BooleanRule> ENABLE_LOCKPICKS =
            GameRuleRegistry.register("enableLockpicks", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));

    public static final GameRules.Key<GameRules.IntRule> LOCKPICK_SUCCESS_CHANCE =
            GameRuleRegistry.register("lockpickSuccessChance", GameRules.Category.MISC, GameRuleFactory.createIntRule(15, 0, 100));

    public static final GameRules.Key<GameRules.BooleanRule> LOCKED_PEDESTALS_UNBREAKABLE =
            GameRuleRegistry.register("lockedPedestalsUnbreakable", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(false));

    public static final GameRules.Key<GameRules.BooleanRule> DUSTY_LOCKBOXES =
            GameRuleRegistry.register("dustyLockboxes", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));

    public static void initialize() {}
}
