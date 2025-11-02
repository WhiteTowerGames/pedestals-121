package net.chris.pedestals.config;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.RangeConstraint;

@SuppressWarnings("unused")
@Config(name = "pedestals-config", wrapperName = "PedestalsConfig")
public class PedestalsConfigModel {
    public boolean infiniteKeyDuping = false;
    public boolean enableLockpicks = true;

    @RangeConstraint(min = 1, max = 100)
    public int percentLockpickSuccessChance = 15;
    public boolean lockedPedestalsUnbreakable = false;
    public boolean dustyLockboxes = true;
    public boolean displayedItemParticles = true;
    public boolean pedestalsPowerBlockBelow = true;
}
