package tech.krazyminer001.compat.geckolib;

import tech.krazyminer001.OctoComputing;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedLeafCoreModel extends GeoModel<AnimatedLeafCore> {
    @Override
    public Identifier getModelResource(AnimatedLeafCore animatable) {
        return new Identifier(OctoComputing.MOD_ID, "geo/animated_leaf_core.geo.json");
    }

    @Override
    public Identifier getTextureResource(AnimatedLeafCore animatable) {
        return new Identifier(OctoComputing.MOD_ID, "textures/item/leaf_core.png");
    }

    @Override
    public Identifier getAnimationResource(AnimatedLeafCore animatable) {
        return new Identifier(OctoComputing.MOD_ID, "animations/animated_leaf_core.animation.json");
    }
}
