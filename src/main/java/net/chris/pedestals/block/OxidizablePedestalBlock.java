package net.chris.pedestals.block;

import net.minecraft.block.Oxidizable;

public class OxidizablePedestalBlock extends PedestalBlock implements Oxidizable {
    public OxidizablePedestalBlock(Settings settings) {
        super(settings);
    }

    @Override
    public OxidationLevel getDegradationLevel() {
        return null;
    }
}
