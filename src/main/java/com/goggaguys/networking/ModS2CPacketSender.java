package com.goggaguys.networking;

import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModS2CPacketSender {
    public static void sendLeafShrineCraftingInProgressParticlePacket(World world, BlockPos blockPos) {
        for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, blockPos)) {
            ServerPlayNetworking.send(player, new ModS2CPackets.PlayLeafShrineCraftingInProgressParticlePacket(blockPos));
        }
    }

    public static void sendLeafShrineCraftingFinishedParticlePacket(World world, BlockPos blockPos) {
        for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, blockPos)) {
            ServerPlayNetworking.send(player, new ModS2CPackets.PlayLeafShrineCraftingFinishedParticlePacket(blockPos));
        }
    }
}
