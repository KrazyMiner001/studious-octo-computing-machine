package tech.krazyminer001.item;

import net.minecraft.component.ComponentType;
import tech.krazyminer001.OctoComputing;
import static tech.krazyminer001.utility.Util.of;
import com.mojang.serialization.Codec;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes extends DataComponentTypes {
    public static final ComponentType<Boolean> ACTIVATED = register("activated", (builder) -> builder.codec(Codec.BOOL).packetCodec(PacketCodecs.BOOL).cache());

    private static <T> ComponentType<T> register(String id, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, of(id), builderOperator.apply(ComponentType.builder()).build());
    }

    public static void register() {
        OctoComputing.LOGGER.info("Registering Components for " + OctoComputing.MOD_ID);
    }
}
