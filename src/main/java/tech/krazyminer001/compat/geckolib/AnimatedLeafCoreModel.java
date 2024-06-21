package tech.krazyminer001.compat.geckolib;

import tech.krazyminer001.OctoComputing;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import static tech.krazyminer001.utility.Util.of;

public class AnimatedLeafCoreModel extends GeoModel<AnimatedLeafCore> {
    @Override
    public Identifier getModelResource(AnimatedLeafCore animatable) {
        return of("geo/animated_leaf_core.geo.json");
    }

    @Override
    public Identifier getTextureResource(AnimatedLeafCore animatable) {
        return of("textures/item/leaf_core.png");
    }

    @Override
    public Identifier getAnimationResource(AnimatedLeafCore animatable) {
        return of("animations/animated_leaf_core.animation.json");
    }
}
