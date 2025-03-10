package net.chris.pedestals.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Uuids;

import java.util.UUID;

public record UUIDAndBoolComponent(UUID uuid, boolean isMapped, boolean isCopy) {

    public static final Codec<UUIDAndBoolComponent> UUID_BOOL_CODEC = RecordCodecBuilder.create(builder ->{
        return builder.group(
                Uuids.CODEC.fieldOf("uuid").forGetter(UUIDAndBoolComponent::uuid),
                Codec.BOOL.fieldOf("isMapped").forGetter(UUIDAndBoolComponent::isMapped),
                Codec.BOOL.optionalFieldOf("isCopy", false).forGetter(UUIDAndBoolComponent::isCopy)
        ).apply(builder, UUIDAndBoolComponent::new);
    });

}
