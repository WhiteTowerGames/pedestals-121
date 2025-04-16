package net.chris.pedestals;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record MigrationWarningPayload(Boolean hasWarned) implements CustomPayload {

    public static final Identifier PEDESTAL_MIGRATION_WARNING = Identifier.of(Pedestals121.MOD_ID, "pedestal_migration_warning");
    public static final CustomPayload.Id<MigrationWarningPayload> ID = new Id<>(PEDESTAL_MIGRATION_WARNING);
    public static final PacketCodec<PacketByteBuf, MigrationWarningPayload> CODEC = PacketCodec.tuple(
            PacketCodecs.BOOLEAN, MigrationWarningPayload::hasWarned,
            MigrationWarningPayload::new
    );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
