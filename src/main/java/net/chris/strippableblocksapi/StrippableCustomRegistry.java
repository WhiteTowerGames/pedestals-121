package net.chris.strippableblocksapi;

import net.minecraft.block.Block;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.HashMap;
import java.util.Map;

public class StrippableCustomRegistry {

    private static final Map<Block, Block> STRIPPABLES = new HashMap<>();

    //public SoundEvent getStripSound() {return SoundEvents.ITEM_AXE_STRIP;}

    public static void register(Block input, Block output){
        STRIPPABLES.put(input, output);
    }

    public static Block getStripppedResult(Block input){
        return STRIPPABLES.get(input);
    }

}
