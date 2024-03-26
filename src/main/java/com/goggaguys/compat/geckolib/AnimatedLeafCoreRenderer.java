package com.goggaguys.compat.geckolib;

import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AnimatedLeafCoreRenderer extends GeoItemRenderer<AnimatedItem> {
    public AnimatedLeafCoreRenderer() {
        super(new AnimatedLeafCoreModel());
    }
}
