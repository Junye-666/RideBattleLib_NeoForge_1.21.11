package com.jpigeon.ridebattlelib.common.network.packet;

import com.jpigeon.ridebattlelib.RideBattleLib;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public record CompleteHenshinPacket(UUID playerId) implements CustomPacketPayload {
    public static final Identifier ID =
            Identifier.fromNamespaceAndPath(RideBattleLib.MODID, "complete_henshin");

    public static final StreamCodec<@NotNull RegistryFriendlyByteBuf, @NotNull CompleteHenshinPacket> STREAM_CODEC =
            StreamCodec.composite(
                    UUIDUtil.STREAM_CODEC,
                    CompleteHenshinPacket::playerId,
                    CompleteHenshinPacket::new
            );

    public static final Type<@NotNull CompleteHenshinPacket> TYPE = new Type<>(ID);

    @Override
    public @NotNull Type<?> type() { return TYPE; }
}
