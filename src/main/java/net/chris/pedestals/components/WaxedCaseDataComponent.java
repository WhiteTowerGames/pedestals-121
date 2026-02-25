package net.chris.pedestals.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record WaxedCaseDataComponent(boolean isWaxed) {
    public static final Codec<WaxedCaseDataComponent> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(Codec.BOOL.fieldOf("is_waxed").forGetter(WaxedCaseDataComponent::isWaxed)).apply(instance, WaxedCaseDataComponent::new));

    public WaxedCaseDataComponent() {
        this(false);
    }
}