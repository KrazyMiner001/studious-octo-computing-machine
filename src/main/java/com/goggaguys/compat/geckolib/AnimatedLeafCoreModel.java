package com.goggaguys.compat.geckolib;

import com.goggaguys.OctoComputing;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedLeafCoreModel extends GeoModel<AnimatedItem> {
    @Override
    public Identifier getModelResource(AnimatedItem animatable) {
        return new Identifier(OctoComputing.MOD_ID, "geo/animated_leaf_core.geo.json");
    }

    @Override
    public Identifier getTextureResource(AnimatedItem animatable) {
        return new Identifier(OctoComputing.MOD_ID, "textures/item/leaf_core.png");
    }

    @Override
    public Identifier getAnimationResource(AnimatedItem animatable) {
        return new Identifier(OctoComputing.MOD_ID, "animations/animated_leaf_core.animation.json");
    }
}
