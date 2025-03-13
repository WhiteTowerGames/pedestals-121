package net.chris.pedestals.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record LockboxDustComponent(int dustLevel) {
    public static final Codec<LockboxDustComponent> LOCKBOX_DUST_COMPONENT = RecordCodecBuilder.create(builder ->{
        return builder.group(
                Codec.intRange(0, 3).fieldOf("dustLevel").forGetter(LockboxDustComponent::dustLevel)
        ).apply(builder, LockboxDustComponent::new);
    });
}
