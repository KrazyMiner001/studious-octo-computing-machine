package com.goggaguys.networking;

import com.goggaguys.blockentity.custom.LeafShrineBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import java.util.Objects;

@Environment(EnvType.CLIENT)
public class ModS2CPacketReciever {
    public static void registerS2CRecievers() {
        ClientPlayNetworking.registerGlobalReceiver(ModS2CPackets.PlayLeafShrineCraftingInProgressParticlePacket.PACKET_ID, (payload, context) -> {
            var world = context.player().getWorld();
            var blockPos = payload.blockPos();

            ((LeafShrineBlockEntity) Objects.requireNonNull(world.getBlockEntity(blockPos))).spawnCraftingProgressParticles();
        });
    }
}
