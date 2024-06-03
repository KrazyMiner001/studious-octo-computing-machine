package tech.krazyminer001.compat.geckolib;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AnimatedLeafCoreRenderer extends GeoItemRenderer<AnimatedLeafCore> {
    public AnimatedLeafCoreRenderer() {
        super(new AnimatedLeafCoreModel());
    }
}
