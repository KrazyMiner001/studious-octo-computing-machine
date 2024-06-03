package tech.krazyminer001.datagen;

import tech.krazyminer001.OctoComputing;
import tech.krazyminer001.damagetype.ModDamageTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ModDamageTypeProvider implements DataProvider {
    public ModDamageTypeProvider(FabricDataOutput generator, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        this.path = generator.getResolver(DataOutput.OutputType.DATA_PACK, FILE_PATH+"/");
        try {
            this.registryLookup = registryLookup.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
    public static final String FILE_PATH = "damage_type";
    private final DataOutput.PathResolver path;
    private final RegistryWrapper.WrapperLookup registryLookup;
    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();
        ModDamageTypes.sources().forEach(type ->
                futures.add(DataProvider.writeCodecToPath(writer, registryLookup, DamageType.CODEC, type, path.resolveJson(new Identifier(OctoComputing.MOD_ID, type.msgId())))));
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }


    @Override
    public String getName() {
        return "Damage Types";
    }
}
