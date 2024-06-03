package tech.krazyminer001.world.customFeatures;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.gen.feature.FeatureConfig;

public record CustomTreeFeatureConfig(int height, int radius, int iterations, Identifier woodBlockId, Identifier leafBlockId) implements FeatureConfig {
    public static final Codec<CustomTreeFeatureConfig> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    Codecs.POSITIVE_INT.fieldOf("height").forGetter(CustomTreeFeatureConfig::height),
                    Codecs.POSITIVE_INT.fieldOf("radius").forGetter(CustomTreeFeatureConfig::radius),
                    Codecs.POSITIVE_INT.fieldOf("iterations").forGetter(CustomTreeFeatureConfig::iterations),
                    Identifier.CODEC.fieldOf("woodBlockId").forGetter(CustomTreeFeatureConfig::woodBlockId),
                    Identifier.CODEC.fieldOf("leafBlockId").forGetter(CustomTreeFeatureConfig::leafBlockId)
            ).apply(instance, CustomTreeFeatureConfig::new)
    );
}
