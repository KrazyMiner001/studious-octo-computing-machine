package com.goggaguys.datagen;

import com.goggaguys.OctoComputing;
import com.goggaguys.damagetype.ModDamageTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModDamageTypeProvider implements DataProvider {
    public ModDamageTypeProvider(FabricDataOutput generator) {
        this.path = generator.getResolver(DataOutput.OutputType.DATA_PACK, FILE_PATH+"/");
    }
    public static final String FILE_PATH = "damage_type";
    private final DataOutput.PathResolver path;
    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();
        ModDamageTypes.sources().forEach(type ->
                futures.add(DataProvider.writeCodecToPath(writer, DamageType.CODEC, type, path.resolveJson(new Identifier(OctoComputing.MOD_ID, type.msgId())))));
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    @Override
    public String getName() {
        return "Damage Types";
    }
}
