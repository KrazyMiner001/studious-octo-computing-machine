package com.goggaguys.networking;

import com.goggaguys.OctoComputing;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModS2CPackets {
    public record PlayLeafShrineCraftingInProgressParticlePacket(BlockPos blockPos) implements CustomPayload {
        public static final CustomPayload.Id<PlayLeafShrineCraftingInProgressParticlePacket> PACKET_ID = new CustomPayload.Id<>(new Identifier(OctoComputing.MOD_ID, "play_leaf_shrine_crafting_in_progress_particle"));
        public static final PacketCodec<RegistryByteBuf, PlayLeafShrineCraftingInProgressParticlePacket> PACKET_CODEC = BlockPos.PACKET_CODEC.xmap(PlayLeafShrineCraftingInProgressParticlePacket::new, PlayLeafShrineCraftingInProgressParticlePacket::blockPos).cast();

        @Override
        public Id<? extends CustomPayload> getId() {
            return PACKET_ID;
        }
    }

    public record PlayLeafShrineCraftingFinishedParticlePacket(BlockPos blockPos) implements CustomPayload {
        public static final CustomPayload.Id<PlayLeafShrineCraftingFinishedParticlePacket> PACKET_ID = new CustomPayload.Id<>(new Identifier(OctoComputing.MOD_ID, "play_leaf_shrine_crafting_finished_particle"));
        public static final PacketCodec<RegistryByteBuf, PlayLeafShrineCraftingFinishedParticlePacket> PACKET_CODEC = BlockPos.PACKET_CODEC.xmap(PlayLeafShrineCraftingFinishedParticlePacket::new, PlayLeafShrineCraftingFinishedParticlePacket::blockPos).cast();

        @Override
        public Id<? extends CustomPayload> getId() {
            return PACKET_ID;
        }
    }
}
