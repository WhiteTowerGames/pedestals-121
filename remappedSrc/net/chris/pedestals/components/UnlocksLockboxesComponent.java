package net.chris.pedestals.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record UnlocksLockboxesComponent(boolean value) {
    public static final Codec<UnlocksLockboxesComponent> UNLOCKS_LOCKBOXES_CODEC = RecordCodecBuilder.create(builder ->{
        return builder.group(
                Codec.BOOL.optionalFieldOf("value", true).forGetter(UnlocksLockboxesComponent::value)
        ).apply(builder, UnlocksLockboxesComponent::new);
    });

    public UnlocksLockboxesComponent() {
        this(true);
    }
}
