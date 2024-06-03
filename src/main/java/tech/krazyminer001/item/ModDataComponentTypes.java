package tech.krazyminer001.item;

import tech.krazyminer001.OctoComputing;
import com.mojang.serialization.Codec;
import net.minecraft.component.DataComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes extends DataComponentTypes {
    public static final DataComponentType<Boolean> ACTIVATED = register("activated", (builder) -> builder.codec(Codec.BOOL).packetCodec(PacketCodecs.BOOL).cache());

    private static <T> DataComponentType<T> register(String id, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, new Identifier(OctoComputing.MOD_ID, id), builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register() {
        OctoComputing.LOGGER.info("Registering Components for " + OctoComputing.MOD_ID);
    }
}
