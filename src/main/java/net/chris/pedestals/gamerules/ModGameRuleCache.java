package net.chris.pedestals.gamerules;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.world.World;

public class ModGameRuleCache {

    private static boolean infiniteKeyDuping = false;
    private static boolean enableLockpicks = true;
    private static boolean lockedPedestalsUnbreakable = false;
    private static int percentLockpickSuccessChance = 15;
    private static boolean dustyLockboxes = true;
    private static boolean displayedItemParticles = true;

    public static boolean isInfiniteKeyDupingEnabled() {
        return infiniteKeyDuping;
    }

    public static boolean areLockpicksEnabled() {
        return enableLockpicks;
    }

    public static int getPercentLockpickSuccessChance() {
        return percentLockpickSuccessChance;
    }

    public static boolean areLockedPedestalsUnbreakable() {
        return lockedPedestalsUnbreakable;
    }

    public static boolean areLockboxesDusty() {
        return dustyLockboxes;
    }

    public static boolean pedestalsDisplayParticles() {return displayedItemParticles;}

    public static void initialize() {
        ServerTickEvents.END_WORLD_TICK.register((world) -> {
            if (world.getRegistryKey() == World.OVERWORLD) {
                infiniteKeyDuping = world.getGameRules().getBoolean(ModGameRules.INFINITE_KEY_DUPING);
                enableLockpicks = world.getGameRules().getBoolean(ModGameRules.ENABLE_LOCKPICKS);
                percentLockpickSuccessChance = world.getGameRules().getInt(ModGameRules.LOCKPICK_SUCCESS_CHANCE);
                lockedPedestalsUnbreakable = world.getGameRules().getBoolean(ModGameRules.LOCKED_PEDESTALS_UNBREAKABLE);
                dustyLockboxes = world.getGameRules().getBoolean(ModGameRules.DUSTY_LOCKBOXES);
                displayedItemParticles = world.getGameRules().getBoolean(ModGameRules.DISPLAY_PARTICLES);
            }
        });
    }
}
