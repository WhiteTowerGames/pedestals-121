package net.chris.pedestals;

import com.mojang.datafixers.types.Type;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.PersistentState;
import net.minecraft.world.World;

import java.util.Optional;

public class StateSaverAndLoader extends PersistentState {

    public Optional<Boolean> warned = Optional.of(false);



    public static StateSaverAndLoader createFromNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        StateSaverAndLoader state = new StateSaverAndLoader();
        state.warned = nbt.getBoolean("pedestal_migration_warned");
        return state;
    }

    public static StateSaverAndLoader createNew() {
        StateSaverAndLoader state = new StateSaverAndLoader();
        state.warned = Optional.of(false);
        return state;
    }

//    private static final Type<StateSaverAndLoader> TYPE = new Type<>(
//            StateSaverAndLoader::createNew, // If there's no StateSaverAndLoader yet create one and refresh variables
//            StateSaverAndLoader::createFromNbt, //If there is a StateSaverAndLoader NBT key, parse it with createFromNbt
//            null //Supposed to be a DataFixTypes enum but null is fine
//    );



    public static StateSaverAndLoader getServerState(MinecraftServer server) {
        ServerWorld serverWorld = server.getWorld(World.OVERWORLD);
        assert serverWorld != null;

        /// The first time the following 'getOrCreate' function is called, it creates a brand new 'StateSaverAndLoader' and
        /// stores it inside the 'PersistentStateManager'. The subsequent calls to 'getOrCreate' pass in the saved
        /// 'StateSaverAndLoader' NBT on disk to our function 'StateSaverAndLoader::createFromNbt'.
        StateSaverAndLoader state = serverWorld.getPersistentStateManager().getOrCreate(TYPE, Pedestals121.MOD_ID);

        /// If state is not marked dirty, when Minecraft closes, 'writeNbt' won't be called and therefore nothing will be saved.
        /// Technically it's 'cleaner' if you only mark state as dirty when there was actually a change, but the vast majority
        /// of mod writers are just going to be confused when their data isn't being saved, and so it's best just to 'markDirty' for them.
        /// Besides, it's literally just setting a bool to true, and the only time there's a 'cost' is when the file is written to disk when
        /// there were no actual change to any of the mods state (INCREDIBLY RARE).
        state.markDirty();

        return state;
    }

}
