package com.goggaguys.mixin;

import com.goggaguys.world.biome.ModBiomeTags;
import com.goggaguys.world.biome.ModBiomes;
import com.goggaguys.world.dimension.ModDimensions;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.Saddleable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionTypes;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.Entity;

import java.util.List;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(at = @At(value = "TAIL"), method = "tick()V")
    private void travel(CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        World world = entity.getWorld();
        if (world instanceof ServerWorld serverWorld) {
            if (entity.getY() <= serverWorld.getBottomY() && !entity.hasVehicle() && serverWorld.getBiome(entity.getBlockPos()).isIn(ModBiomeTags.FALL_TO_OVERWORLD)) {
                if (entity instanceof PlayerEntity || entity.hasPassengers() || (entity instanceof Saddleable) && ((Saddleable) entity).isSaddled()) {
                    entityFell(entity);
                } else if (entity instanceof ProjectileEntity projectile && projectile.getOwner() instanceof PlayerEntity) {
                    entityFell(entity);
                } else if (entity instanceof ItemEntity itemEntity) {
                    if (itemEntity.getOwner() instanceof PlayerEntity) {
                        entityFell(entity);
                    }
                }
            }
        }
    }

    @Nullable
    private static Entity entityFell(Entity entity) {
        World serverWorld = entity.getWorld();
        MinecraftServer minecraftServer = serverWorld.getServer();
        if (minecraftServer != null) {
            ServerWorld destination = minecraftServer.getWorld(RegistryKey.of(RegistryKeys.WORLD, new Identifier("overworld")));
            if (destination != null) {
                List<Entity> passengers = entity.getPassengerList();
                serverWorld.getProfiler().push("leafy_fall");
                entity.setPortalCooldown(10);
                Entity target = entity.moveToWorld(destination);
                serverWorld.getProfiler().pop();
                if (target != null) {
                    for (Entity passenger : passengers) {
                        passenger.stopRiding();
                        Entity nextPassenger = entityFell(passenger);
                        if (nextPassenger != null) {
                            nextPassenger.startRiding(target);
                        }
                    }
                }
                return target;
            }
        }
        return null;
    }
}
