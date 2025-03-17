package net.chris.pedestals.sounds;

import net.chris.pedestals.Pedestals121;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {

    private ModSoundEvents(){}

    @SuppressWarnings("SameParameterValue")
    private static SoundEvent registerSoundEvent(String id) {
        Identifier identifier = Identifier.of(Pedestals121.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static final SoundEvent LOCKPICKING_INCREASE = registerSoundEvent("lockpick_increase");

    public static void initialize(){
        Pedestals121.LOGGER.info("Registering sound events for Pedestals!");
    }

}
