package net.chris.pedestals.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Uuids;

import java.util.UUID;

public record LockAndKeyDataComponent(UUID uuid, boolean isMapped, boolean isCopy) {

    public static final Codec<LockAndKeyDataComponent> UUID_BOOL_CODEC = RecordCodecBuilder.create(builder ->{
        return builder.group(
                Uuids.CODEC.fieldOf("uuid").forGetter(LockAndKeyDataComponent::uuid),
                Codec.BOOL.fieldOf("isMapped").forGetter(LockAndKeyDataComponent::isMapped),
                Codec.BOOL.optionalFieldOf("isCopy", false).forGetter(LockAndKeyDataComponent::isCopy)
        ).apply(builder, LockAndKeyDataComponent::new);
    });

    public LockAndKeyDataComponent(UUID uuid, boolean isMapped) {
        this(uuid, isMapped, false);
    }

}
