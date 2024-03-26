package com.goggaguys.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class ModAnimations {

    public static final Animation LEAF_GOD_OUTER_LEAVES_SPIN = Animation.Builder.create(3f).looping()
            .addBoneAnimation("outer_leaf_group_1",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.5f, AnimationHelper.createRotationalVector(180f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(3f, AnimationHelper.createRotationalVector(360f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("outer_leaf_group_2",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(360f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.5f, AnimationHelper.createRotationalVector(180f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(3f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();

    public static final Animation CORE_SPIN = Animation.Builder.create(1.5f).looping()
            .addBoneAnimation("core",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(360f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(180f, 180f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.5f, AnimationHelper.createRotationalVector(0f, 360f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("orbit1",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(180f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.5f, AnimationHelper.createRotationalVector(360f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("orbit2",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 180f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.5f, AnimationHelper.createRotationalVector(0f, 0f, 360f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("orbit3",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 180f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.5f, AnimationHelper.createRotationalVector(0f, 360f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();
}
