package tech.krazyminer001.mixin;

import net.minecraft.world.TeleportTarget;
import org.spongepowered.asm.mixin.Unique;
import tech.krazyminer001.world.biome.ModBiomeTags;
import com.google.common.collect.ImmutableList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.Saddleable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;
import java.util.List;

@Mixin(Entity.class)
public class EntityMixin {
    @Shadow private ImmutableList<Entity> passengerList;

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

    @Unique
    @Nullable
    private static Entity entityFell(Entity entity) {
        World serverWorld = entity.getWorld();
        MinecraftServer minecraftServer = serverWorld.getServer();
        if (minecraftServer != null) {
            ServerWorld destination = minecraftServer.getWorld(RegistryKey.of(RegistryKeys.WORLD, World.OVERWORLD.getValue()));
            if (destination != null) {
                List<Entity> passengers = entity.getPassengerList();
                serverWorld.getProfiler().push("leafy_fall");
                entity.resetPortalCooldown();
                Entity target = entity.teleportTo(new TeleportTarget(destination, entity.getBlockPos().toCenterPos(), entity.getVelocity(), entity.getYaw(), entity.getPitch(), (entity1) -> {}));
                serverWorld.getProfiler().pop();

                if (target != null && !passengers.isEmpty()) {
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
