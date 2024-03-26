package com.goggaguys.entity.client;

import com.goggaguys.entity.animation.ModAnimations;
import com.goggaguys.entity.custom.LeafGodEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class LeafGodEntityModel<T extends LeafGodEntity> extends SinglePartEntityModel<T> {
	private final ModelPart leaf_god;
	private final ModelPart core;
	public LeafGodEntityModel(ModelPart root) {
		this.leaf_god = root.getChild("leaf_god");
		this.core = leaf_god.getChild("central_core");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData leaf_god = modelPartData.addChild("leaf_god", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData central_core = leaf_god.addChild("central_core", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData core = central_core.addChild("core", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -48.0F, 0.0F));

		ModelPartData cube_r1 = core.addChild("cube_r1", ModelPartBuilder.create().uv(14, 44).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.5F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		ModelPartData orbits = central_core.addChild("orbits", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, -30.0F, 8.0F));

		ModelPartData orbit1 = orbits.addChild("orbit1", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, -18.0F, -8.0F));

		ModelPartData bottom1 = orbit1.addChild("bottom1", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, 18.0F, 8.0F));

		ModelPartData right_r1 = bottom1.addChild("right_r1", ModelPartBuilder.create().uv(38, 44).cuboid(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -13.5F, -6.0F, 0.3927F, 0.0F, 0.0F));

		ModelPartData left_r1 = bottom1.addChild("left_r1", ModelPartBuilder.create().uv(44, 40).cuboid(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -13.5F, -10.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData left1 = orbit1.addChild("left1", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, 18.0F, 8.0F));

		ModelPartData bottom_r1 = left1.addChild("bottom_r1", ModelPartBuilder.create().uv(36, 38).cuboid(-0.5F, -0.329F, -1.1921F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -17.9619F, -12.0F, 0.3927F, 0.0F, 0.0F));

		ModelPartData top_r1 = left1.addChild("top_r1", ModelPartBuilder.create().uv(43, 12).cuboid(-0.5F, -3.671F, -1.1921F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -17.9619F, -12.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData top1 = orbit1.addChild("top1", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, 18.0F, 8.0F));

		ModelPartData left_r2 = top1.addChild("left_r2", ModelPartBuilder.create().uv(44, 24).cuboid(-0.5F, -1.1921F, -3.671F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -21.9619F, -8.0F, 0.3927F, 0.0F, 0.0F));

		ModelPartData right_r2 = top1.addChild("right_r2", ModelPartBuilder.create().uv(28, 44).cuboid(-0.5F, -1.1921F, -0.329F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -21.9619F, -8.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData right1 = orbit1.addChild("right1", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, 18.0F, 8.0F));

		ModelPartData top_r2 = right1.addChild("top_r2", ModelPartBuilder.create().uv(29, 11).cuboid(-0.5F, -3.671F, 0.1921F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -17.9619F, -4.0F, 0.3927F, 0.0F, 0.0F));

		ModelPartData bottom_r2 = right1.addChild("bottom_r2", ModelPartBuilder.create().uv(36, 11).cuboid(-0.5F, -0.329F, 0.1921F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -17.9619F, -4.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData orbit2 = orbits.addChild("orbit2", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, -18.0F, -8.0F));

		ModelPartData bottom2 = orbit2.addChild("bottom2", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, 18.0F, 8.0F));

		ModelPartData back_r1 = bottom2.addChild("back_r1", ModelPartBuilder.create().uv(20, 20).cuboid(-1.8598F, 3.8877F, -0.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -17.9619F, -8.0F, 0.0F, 0.0F, 0.3927F));

		ModelPartData front_r1 = bottom2.addChild("front_r1", ModelPartBuilder.create().uv(30, 20).cuboid(-2.1402F, 3.8877F, -0.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -17.9619F, -8.0F, 0.0F, 0.0F, -0.3927F));

		ModelPartData back2 = orbit2.addChild("back2", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, 18.0F, 8.0F));

		ModelPartData bottom_r3 = back2.addChild("bottom_r3", ModelPartBuilder.create().uv(14, 0).cuboid(-4.8877F, -1.8598F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -17.9619F, -8.0F, 0.0F, 0.0F, -0.3927F));

		ModelPartData top_r3 = back2.addChild("top_r3", ModelPartBuilder.create().uv(22, 11).cuboid(-4.8877F, -2.1402F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -17.9619F, -8.0F, 0.0F, 0.0F, 0.3927F));

		ModelPartData top2 = orbit2.addChild("top2", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, 18.0F, 8.0F));

		ModelPartData front_r2 = top2.addChild("front_r2", ModelPartBuilder.create().uv(0, 20).cuboid(-2.1402F, -4.8877F, -0.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -17.9619F, -8.0F, 0.0F, 0.0F, 0.3927F));

		ModelPartData back_r2 = top2.addChild("back_r2", ModelPartBuilder.create().uv(10, 20).cuboid(-1.8598F, -4.8877F, -0.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -17.9619F, -8.0F, 0.0F, 0.0F, -0.3927F));

		ModelPartData front2 = orbit2.addChild("front2", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, 18.0F, 8.0F));

		ModelPartData bottom_r4 = front2.addChild("bottom_r4", ModelPartBuilder.create().uv(0, 0).cuboid(3.8877F, -2.1402F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -17.9619F, -8.0F, 0.0F, 0.0F, 0.3927F));

		ModelPartData top_r4 = front2.addChild("top_r4", ModelPartBuilder.create().uv(7, 0).cuboid(3.8877F, -1.8598F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -17.9619F, -8.0F, 0.0F, 0.0F, -0.3927F));

		ModelPartData orbit3 = orbits.addChild("orbit3", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, -18.0F, -8.0F));

		ModelPartData right3 = orbit3.addChild("right3", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, 18.0F, 8.0F));

		ModelPartData back_r3 = right3.addChild("back_r3", ModelPartBuilder.create().uv(0, 16).cuboid(-1.9093F, -0.5F, 3.9082F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0537F, -17.9619F, -8.0F, 0.0F, -0.3927F, 0.0F));

		ModelPartData front_r3 = right3.addChild("front_r3", ModelPartBuilder.create().uv(44, 29).cuboid(-2.1898F, -0.5F, 3.8671F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0537F, -17.9619F, -8.0F, 0.0F, 0.3927F, 0.0F));

		ModelPartData back3 = orbit3.addChild("back3", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, 18.0F, 8.0F));

		ModelPartData left_r3 = back3.addChild("left_r3", ModelPartBuilder.create().uv(18, 44).cuboid(-4.9372F, -0.5F, -1.8803F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(8.0537F, -17.9619F, -8.0F, 0.0F, -0.3927F, 0.0F));

		ModelPartData right_r3 = back3.addChild("right_r3", ModelPartBuilder.create().uv(44, 19).cuboid(-4.9372F, -0.5F, -2.1197F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(8.0537F, -17.9619F, -8.0F, 0.0F, 0.3927F, 0.0F));

		ModelPartData left3 = orbit3.addChild("left3", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, 18.0F, 8.0F));

		ModelPartData back_r4 = left3.addChild("back_r4", ModelPartBuilder.create().uv(0, 7).cuboid(-2.1898F, -0.5F, -4.8671F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0537F, -17.9619F, -8.0F, 0.0F, 0.3927F, 0.0F));

		ModelPartData front_r4 = left3.addChild("front_r4", ModelPartBuilder.create().uv(9, 8).cuboid(-1.9093F, -0.5F, -4.9082F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0537F, -17.9619F, -8.0F, 0.0F, -0.3927F, 0.0F));

		ModelPartData front3 = orbit3.addChild("front3", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, 18.0F, 8.0F));

		ModelPartData left_r4 = front3.addChild("left_r4", ModelPartBuilder.create().uv(44, 0).cuboid(3.8381F, -0.5F, -2.1197F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(8.0537F, -17.9619F, -8.0F, 0.0F, 0.3927F, 0.0F));

		ModelPartData right_r4 = front3.addChild("right_r4", ModelPartBuilder.create().uv(8, 44).cuboid(3.8381F, -0.5F, -1.8803F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(8.0537F, -17.9619F, -8.0F, 0.0F, -0.3927F, 0.0F));

		ModelPartData outer_leaf_group_1 = leaf_god.addChild("outer_leaf_group_1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -48.0F, 0.0F));

		ModelPartData outer_leaf_1 = outer_leaf_group_1.addChild("outer_leaf_1", ModelPartBuilder.create(), ModelTransform.of(0.0F, 10.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		ModelPartData body = outer_leaf_1.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaf = body.addChild("leaf", ModelPartBuilder.create().uv(0, 4).cuboid(0.0F, -7.0F, -5.0F, 0.0F, 2.0F, 10.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaf_6_r1 = leaf.addChild("leaf_6_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0271F, -8.4502F, -5.0F, 0.0F, 4.0F, 10.0F, new Dilation(0.1F))
				.uv(0, 20).cuboid(-1.0271F, -4.4502F, -9.0F, 0.0F, 6.0F, 18.0F, new Dilation(0.1F))
				.uv(0, 0).cuboid(-0.9729F, 0.9502F, -11.0F, 0.0F, 11.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(3.8507F, -25.4139F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData leaf_3_r1 = leaf.addChild("leaf_3_r1", ModelPartBuilder.create().uv(0, 11).cuboid(0.75F, -2.5F, -11.0F, 0.0F, 5.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -11.5F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData leaf_2_r1 = leaf.addChild("leaf_2_r1", ModelPartBuilder.create().uv(0, 0).cuboid(0.25F, -1.0F, -9.0F, 0.0F, 2.0F, 18.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData stem = body.addChild("stem", ModelPartBuilder.create().uv(0, 44).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData inner_stem_3_r1 = stem.addChild("inner_stem_3_r1", ModelPartBuilder.create().uv(20, 0).cuboid(0.25F, -13.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F))
				.uv(28, 0).cuboid(0.25F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -18.5F, -0.5F, 0.0F, 0.0F, 0.2182F));

		ModelPartData inner_stem_1_r1 = stem.addChild("inner_stem_1_r1", ModelPartBuilder.create().uv(36, 0).cuboid(-1.5F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.8922F, -9.4829F, -0.5F, 0.0F, 0.0F, 0.0873F));

		ModelPartData veins = body.addChild("veins", ModelPartBuilder.create(), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData right_1 = veins.addChild("right_1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -0.25F));

		ModelPartData part_2_r1 = right_1.addChild("part_2_r1", ModelPartBuilder.create().uv(39, 6).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -8.5822F, 8.3815F, 0.5236F, 0.0F, 0.0F));

		ModelPartData part_1_r1 = right_1.addChild("part_1_r1", ModelPartBuilder.create().uv(43, 13).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -7.5F, 3.5F, 0.2182F, 0.0F, 0.0F));

		ModelPartData right_2 = veins.addChild("right_2", ModelPartBuilder.create(), ModelTransform.of(1.5F, -17.7901F, 5.2123F, 0.0F, 0.0F, 0.1745F));

		ModelPartData part_3_r1 = right_2.addChild("part_3_r1", ModelPartBuilder.create().uv(36, 12).cuboid(-1.0F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.1721F, 2.4023F, 1.2678F, -0.0393F, -0.1249F));

		ModelPartData part_2_r2 = right_2.addChild("part_2_r2", ModelPartBuilder.create().uv(7, 1).cuboid(-0.5F, -3.0F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 2.5442F, 1.0472F, 0.0F, 0.0F));

		ModelPartData part_1_r2 = right_2.addChild("part_1_r2", ModelPartBuilder.create().uv(36, 38).cuboid(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, -1.9623F, 0.6109F, 0.0F, 0.0F));

		ModelPartData left_1 = veins.addChild("left_1", ModelPartBuilder.create(), ModelTransform.of(0.25F, -10.3659F, -4.4968F, 0.0F, 3.1416F, 0.0F));

		ModelPartData part_2_r3 = left_1.addChild("part_2_r3", ModelPartBuilder.create().uv(22, 12).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.2163F, 2.6282F, 0.5236F, 0.0F, 0.0F));

		ModelPartData part_1_r3 = left_1.addChild("part_1_r3", ModelPartBuilder.create().uv(29, 11).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.8659F, -2.2532F, 0.2182F, 0.0F, 0.0F));

		ModelPartData left_2 = veins.addChild("left_2", ModelPartBuilder.create(), ModelTransform.of(1.5F, -20.7901F, -4.7877F, 0.0F, 3.1416F, 0.1745F));

		ModelPartData part_3_r2 = left_2.addChild("part_3_r2", ModelPartBuilder.create().uv(43, 33).cuboid(-0.5F, -10.5372F, -5.5071F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0217F, 12.8791F, 1.2654F, 0.0F, 0.0F));

		ModelPartData part_2_r4 = left_2.addChild("part_2_r4", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -11.6603F, -7.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 12.5442F, 1.0472F, 0.0F, 0.0F));

		ModelPartData part_1_r4 = left_2.addChild("part_1_r4", ModelPartBuilder.create().uv(15, 11).cuboid(-0.5F, -6.2358F, -11.6915F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, 8.0377F, 0.6109F, 0.0F, 0.0F));

		ModelPartData outer_leaf_2 = outer_leaf_group_1.addChild("outer_leaf_2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, -10.0F, 1.5708F, 0.0F, 0.0F));

		ModelPartData body2 = outer_leaf_2.addChild("body2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaf2 = body2.addChild("leaf2", ModelPartBuilder.create().uv(0, 4).cuboid(0.0F, -7.0F, -5.0F, 0.0F, 2.0F, 10.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaf_6_r2 = leaf2.addChild("leaf_6_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0271F, -8.4502F, -5.0F, 0.0F, 4.0F, 10.0F, new Dilation(0.1F))
				.uv(0, 20).cuboid(-1.0271F, -4.4502F, -9.0F, 0.0F, 6.0F, 18.0F, new Dilation(0.1F))
				.uv(0, 0).cuboid(-0.9729F, 0.9502F, -11.0F, 0.0F, 11.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(3.8507F, -25.4139F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData leaf_3_r2 = leaf2.addChild("leaf_3_r2", ModelPartBuilder.create().uv(0, 11).cuboid(0.75F, -2.5F, -11.0F, 0.0F, 5.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -11.5F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData leaf_2_r2 = leaf2.addChild("leaf_2_r2", ModelPartBuilder.create().uv(0, 0).cuboid(0.25F, -1.0F, -9.0F, 0.0F, 2.0F, 18.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData stem2 = body2.addChild("stem2", ModelPartBuilder.create().uv(0, 44).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData inner_stem_3_r2 = stem2.addChild("inner_stem_3_r2", ModelPartBuilder.create().uv(20, 0).cuboid(0.25F, -13.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F))
				.uv(28, 0).cuboid(0.25F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -18.5F, -0.5F, 0.0F, 0.0F, 0.2182F));

		ModelPartData inner_stem_1_r2 = stem2.addChild("inner_stem_1_r2", ModelPartBuilder.create().uv(36, 0).cuboid(-1.5F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.8922F, -9.4829F, -0.5F, 0.0F, 0.0F, 0.0873F));

		ModelPartData veins2 = body2.addChild("veins2", ModelPartBuilder.create(), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData right_3 = veins2.addChild("right_3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -0.25F));

		ModelPartData part_2_r5 = right_3.addChild("part_2_r5", ModelPartBuilder.create().uv(39, 6).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -8.5822F, 8.3815F, 0.5236F, 0.0F, 0.0F));

		ModelPartData part_1_r5 = right_3.addChild("part_1_r5", ModelPartBuilder.create().uv(43, 13).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -7.5F, 3.5F, 0.2182F, 0.0F, 0.0F));

		ModelPartData right_4 = veins2.addChild("right_4", ModelPartBuilder.create(), ModelTransform.of(1.5F, -17.7901F, 5.2123F, 0.0F, 0.0F, 0.1745F));

		ModelPartData part_3_r3 = right_4.addChild("part_3_r3", ModelPartBuilder.create().uv(36, 12).cuboid(-1.0F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.1721F, 2.4023F, 1.2678F, -0.0393F, -0.1249F));

		ModelPartData part_2_r6 = right_4.addChild("part_2_r6", ModelPartBuilder.create().uv(7, 1).cuboid(-0.5F, -3.0F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 2.5442F, 1.0472F, 0.0F, 0.0F));

		ModelPartData part_1_r6 = right_4.addChild("part_1_r6", ModelPartBuilder.create().uv(36, 38).cuboid(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, -1.9623F, 0.6109F, 0.0F, 0.0F));

		ModelPartData left_3 = veins2.addChild("left_3", ModelPartBuilder.create(), ModelTransform.of(0.25F, -10.3659F, -4.4968F, 0.0F, 3.1416F, 0.0F));

		ModelPartData part_2_r7 = left_3.addChild("part_2_r7", ModelPartBuilder.create().uv(22, 12).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.2163F, 2.6282F, 0.5236F, 0.0F, 0.0F));

		ModelPartData part_1_r7 = left_3.addChild("part_1_r7", ModelPartBuilder.create().uv(29, 11).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.8659F, -2.2532F, 0.2182F, 0.0F, 0.0F));

		ModelPartData left_4 = veins2.addChild("left_4", ModelPartBuilder.create(), ModelTransform.of(1.5F, -20.7901F, -4.7877F, 0.0F, 3.1416F, 0.1745F));

		ModelPartData part_3_r4 = left_4.addChild("part_3_r4", ModelPartBuilder.create().uv(43, 33).cuboid(-0.5F, -10.5372F, -5.5071F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0217F, 12.8791F, 1.2654F, 0.0F, 0.0F));

		ModelPartData part_2_r8 = left_4.addChild("part_2_r8", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -11.6603F, -7.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 12.5442F, 1.0472F, 0.0F, 0.0F));

		ModelPartData part_1_r8 = left_4.addChild("part_1_r8", ModelPartBuilder.create().uv(15, 11).cuboid(-0.5F, -6.2358F, -11.6915F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, 8.0377F, 0.6109F, 0.0F, 0.0F));

		ModelPartData outer_leaf_3 = outer_leaf_group_1.addChild("outer_leaf_3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -11.0F, 0.0F));

		ModelPartData body3 = outer_leaf_3.addChild("body3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaf3 = body3.addChild("leaf3", ModelPartBuilder.create().uv(0, 4).cuboid(0.0F, -7.0F, -5.0F, 0.0F, 2.0F, 10.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaf_6_r3 = leaf3.addChild("leaf_6_r3", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0271F, -8.4502F, -5.0F, 0.0F, 4.0F, 10.0F, new Dilation(0.1F))
				.uv(0, 20).cuboid(-1.0271F, -4.4502F, -9.0F, 0.0F, 6.0F, 18.0F, new Dilation(0.1F))
				.uv(0, 0).cuboid(-0.9729F, 0.9502F, -11.0F, 0.0F, 11.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(3.8507F, -25.4139F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData leaf_3_r3 = leaf3.addChild("leaf_3_r3", ModelPartBuilder.create().uv(0, 11).cuboid(0.75F, -2.5F, -11.0F, 0.0F, 5.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -11.5F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData leaf_2_r3 = leaf3.addChild("leaf_2_r3", ModelPartBuilder.create().uv(0, 0).cuboid(0.25F, -1.0F, -9.0F, 0.0F, 2.0F, 18.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData stem3 = body3.addChild("stem3", ModelPartBuilder.create().uv(0, 44).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData inner_stem_3_r3 = stem3.addChild("inner_stem_3_r3", ModelPartBuilder.create().uv(20, 0).cuboid(0.25F, -13.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F))
				.uv(28, 0).cuboid(0.25F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -18.5F, -0.5F, 0.0F, 0.0F, 0.2182F));

		ModelPartData inner_stem_1_r3 = stem3.addChild("inner_stem_1_r3", ModelPartBuilder.create().uv(36, 0).cuboid(-1.5F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.8922F, -9.4829F, -0.5F, 0.0F, 0.0F, 0.0873F));

		ModelPartData veins3 = body3.addChild("veins3", ModelPartBuilder.create(), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData right_5 = veins3.addChild("right_5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -0.25F));

		ModelPartData part_2_r9 = right_5.addChild("part_2_r9", ModelPartBuilder.create().uv(39, 6).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -8.5822F, 8.3815F, 0.5236F, 0.0F, 0.0F));

		ModelPartData part_1_r9 = right_5.addChild("part_1_r9", ModelPartBuilder.create().uv(43, 13).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -7.5F, 3.5F, 0.2182F, 0.0F, 0.0F));

		ModelPartData right_6 = veins3.addChild("right_6", ModelPartBuilder.create(), ModelTransform.of(1.5F, -17.7901F, 5.2123F, 0.0F, 0.0F, 0.1745F));

		ModelPartData part_3_r5 = right_6.addChild("part_3_r5", ModelPartBuilder.create().uv(36, 12).cuboid(-1.0F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.1721F, 2.4023F, 1.2678F, -0.0393F, -0.1249F));

		ModelPartData part_2_r10 = right_6.addChild("part_2_r10", ModelPartBuilder.create().uv(7, 1).cuboid(-0.5F, -3.0F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 2.5442F, 1.0472F, 0.0F, 0.0F));

		ModelPartData part_1_r10 = right_6.addChild("part_1_r10", ModelPartBuilder.create().uv(36, 38).cuboid(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, -1.9623F, 0.6109F, 0.0F, 0.0F));

		ModelPartData left_5 = veins3.addChild("left_5", ModelPartBuilder.create(), ModelTransform.of(0.25F, -10.3659F, -4.4968F, 0.0F, 3.1416F, 0.0F));

		ModelPartData part_2_r11 = left_5.addChild("part_2_r11", ModelPartBuilder.create().uv(22, 12).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.2163F, 2.6282F, 0.5236F, 0.0F, 0.0F));

		ModelPartData part_1_r11 = left_5.addChild("part_1_r11", ModelPartBuilder.create().uv(29, 11).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.8659F, -2.2532F, 0.2182F, 0.0F, 0.0F));

		ModelPartData left_6 = veins3.addChild("left_6", ModelPartBuilder.create(), ModelTransform.of(1.5F, -20.7901F, -4.7877F, 0.0F, 3.1416F, 0.1745F));

		ModelPartData part_3_r6 = left_6.addChild("part_3_r6", ModelPartBuilder.create().uv(43, 33).cuboid(-0.5F, -10.5372F, -5.5071F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0217F, 12.8791F, 1.2654F, 0.0F, 0.0F));

		ModelPartData part_2_r12 = left_6.addChild("part_2_r12", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -11.6603F, -7.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 12.5442F, 1.0472F, 0.0F, 0.0F));

		ModelPartData part_1_r12 = left_6.addChild("part_1_r12", ModelPartBuilder.create().uv(15, 11).cuboid(-0.5F, -6.2358F, -11.6915F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, 8.0377F, 0.6109F, 0.0F, 0.0F));

		ModelPartData outer_leaf_4 = outer_leaf_group_1.addChild("outer_leaf_4", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, -1.5708F, 0.0F, 0.0F));

		ModelPartData body4 = outer_leaf_4.addChild("body4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaf4 = body4.addChild("leaf4", ModelPartBuilder.create().uv(0, 4).cuboid(0.0F, -7.0F, -5.0F, 0.0F, 2.0F, 10.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaf_6_r4 = leaf4.addChild("leaf_6_r4", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0271F, -8.4502F, -5.0F, 0.0F, 4.0F, 10.0F, new Dilation(0.1F))
				.uv(0, 20).cuboid(-1.0271F, -4.4502F, -9.0F, 0.0F, 6.0F, 18.0F, new Dilation(0.1F))
				.uv(0, 0).cuboid(-0.9729F, 0.9502F, -11.0F, 0.0F, 11.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(3.8507F, -25.4139F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData leaf_3_r4 = leaf4.addChild("leaf_3_r4", ModelPartBuilder.create().uv(0, 11).cuboid(0.75F, -2.5F, -11.0F, 0.0F, 5.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -11.5F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData leaf_2_r4 = leaf4.addChild("leaf_2_r4", ModelPartBuilder.create().uv(0, 0).cuboid(0.25F, -1.0F, -9.0F, 0.0F, 2.0F, 18.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData stem4 = body4.addChild("stem4", ModelPartBuilder.create().uv(0, 44).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData inner_stem_3_r4 = stem4.addChild("inner_stem_3_r4", ModelPartBuilder.create().uv(20, 0).cuboid(0.25F, -13.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F))
				.uv(28, 0).cuboid(0.25F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -18.5F, -0.5F, 0.0F, 0.0F, 0.2182F));

		ModelPartData inner_stem_1_r4 = stem4.addChild("inner_stem_1_r4", ModelPartBuilder.create().uv(36, 0).cuboid(-1.5F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.8922F, -9.4829F, -0.5F, 0.0F, 0.0F, 0.0873F));

		ModelPartData veins4 = body4.addChild("veins4", ModelPartBuilder.create(), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData right_7 = veins4.addChild("right_7", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -0.25F));

		ModelPartData part_2_r13 = right_7.addChild("part_2_r13", ModelPartBuilder.create().uv(39, 6).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -8.5822F, 8.3815F, 0.5236F, 0.0F, 0.0F));

		ModelPartData part_1_r13 = right_7.addChild("part_1_r13", ModelPartBuilder.create().uv(43, 13).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -7.5F, 3.5F, 0.2182F, 0.0F, 0.0F));

		ModelPartData right_8 = veins4.addChild("right_8", ModelPartBuilder.create(), ModelTransform.of(1.5F, -17.7901F, 5.2123F, 0.0F, 0.0F, 0.1745F));

		ModelPartData part_3_r7 = right_8.addChild("part_3_r7", ModelPartBuilder.create().uv(36, 12).cuboid(-1.0F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.1721F, 2.4023F, 1.2678F, -0.0393F, -0.1249F));

		ModelPartData part_2_r14 = right_8.addChild("part_2_r14", ModelPartBuilder.create().uv(7, 1).cuboid(-0.5F, -3.0F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 2.5442F, 1.0472F, 0.0F, 0.0F));

		ModelPartData part_1_r14 = right_8.addChild("part_1_r14", ModelPartBuilder.create().uv(36, 38).cuboid(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, -1.9623F, 0.6109F, 0.0F, 0.0F));

		ModelPartData left_7 = veins4.addChild("left_7", ModelPartBuilder.create(), ModelTransform.of(0.25F, -10.3659F, -4.4968F, 0.0F, 3.1416F, 0.0F));

		ModelPartData part_2_r15 = left_7.addChild("part_2_r15", ModelPartBuilder.create().uv(22, 12).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.2163F, 2.6282F, 0.5236F, 0.0F, 0.0F));

		ModelPartData part_1_r15 = left_7.addChild("part_1_r15", ModelPartBuilder.create().uv(29, 11).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.8659F, -2.2532F, 0.2182F, 0.0F, 0.0F));

		ModelPartData left_8 = veins4.addChild("left_8", ModelPartBuilder.create(), ModelTransform.of(1.5F, -20.7901F, -4.7877F, 0.0F, 3.1416F, 0.1745F));

		ModelPartData part_3_r8 = left_8.addChild("part_3_r8", ModelPartBuilder.create().uv(43, 33).cuboid(-0.5F, -10.5372F, -5.5071F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0217F, 12.8791F, 1.2654F, 0.0F, 0.0F));

		ModelPartData part_2_r16 = left_8.addChild("part_2_r16", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -11.6603F, -7.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 12.5442F, 1.0472F, 0.0F, 0.0F));

		ModelPartData part_1_r16 = left_8.addChild("part_1_r16", ModelPartBuilder.create().uv(15, 11).cuboid(-0.5F, -6.2358F, -11.6915F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, 8.0377F, 0.6109F, 0.0F, 0.0F));

		ModelPartData outer_leaf_group_2 = leaf_god.addChild("outer_leaf_group_2", ModelPartBuilder.create(), ModelTransform.of(-4.0F, -48.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		ModelPartData outer_leaf_5 = outer_leaf_group_2.addChild("outer_leaf_5", ModelPartBuilder.create(), ModelTransform.of(0.0F, 10.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		ModelPartData body5 = outer_leaf_5.addChild("body5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaf5 = body5.addChild("leaf5", ModelPartBuilder.create().uv(0, 4).cuboid(0.0F, -7.0F, -5.0F, 0.0F, 2.0F, 10.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaf_6_r5 = leaf5.addChild("leaf_6_r5", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0271F, -8.4502F, -5.0F, 0.0F, 4.0F, 10.0F, new Dilation(0.1F))
				.uv(0, 20).cuboid(-1.0271F, -4.4502F, -9.0F, 0.0F, 6.0F, 18.0F, new Dilation(0.1F))
				.uv(0, 0).cuboid(-0.9729F, 0.9502F, -11.0F, 0.0F, 11.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(3.8507F, -25.4139F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData leaf_3_r5 = leaf5.addChild("leaf_3_r5", ModelPartBuilder.create().uv(0, 11).cuboid(0.75F, -2.5F, -11.0F, 0.0F, 5.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -11.5F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData leaf_2_r5 = leaf5.addChild("leaf_2_r5", ModelPartBuilder.create().uv(0, 0).cuboid(0.25F, -1.0F, -9.0F, 0.0F, 2.0F, 18.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData stem5 = body5.addChild("stem5", ModelPartBuilder.create().uv(0, 44).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData inner_stem_3_r5 = stem5.addChild("inner_stem_3_r5", ModelPartBuilder.create().uv(20, 0).cuboid(0.25F, -13.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F))
				.uv(28, 0).cuboid(0.25F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -18.5F, -0.5F, 0.0F, 0.0F, 0.2182F));

		ModelPartData inner_stem_1_r5 = stem5.addChild("inner_stem_1_r5", ModelPartBuilder.create().uv(36, 0).cuboid(-1.5F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.8922F, -9.4829F, -0.5F, 0.0F, 0.0F, 0.0873F));

		ModelPartData veins5 = body5.addChild("veins5", ModelPartBuilder.create(), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData right_9 = veins5.addChild("right_9", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -0.25F));

		ModelPartData part_2_r17 = right_9.addChild("part_2_r17", ModelPartBuilder.create().uv(39, 6).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -8.5822F, 8.3815F, 0.5236F, 0.0F, 0.0F));

		ModelPartData part_1_r17 = right_9.addChild("part_1_r17", ModelPartBuilder.create().uv(43, 13).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -7.5F, 3.5F, 0.2182F, 0.0F, 0.0F));

		ModelPartData right_10 = veins5.addChild("right_10", ModelPartBuilder.create(), ModelTransform.of(1.5F, -17.7901F, 5.2123F, 0.0F, 0.0F, 0.1745F));

		ModelPartData part_3_r9 = right_10.addChild("part_3_r9", ModelPartBuilder.create().uv(36, 12).cuboid(-1.0F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.1721F, 2.4023F, 1.2678F, -0.0393F, -0.1249F));

		ModelPartData part_2_r18 = right_10.addChild("part_2_r18", ModelPartBuilder.create().uv(7, 1).cuboid(-0.5F, -3.0F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 2.5442F, 1.0472F, 0.0F, 0.0F));

		ModelPartData part_1_r18 = right_10.addChild("part_1_r18", ModelPartBuilder.create().uv(36, 38).cuboid(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, -1.9623F, 0.6109F, 0.0F, 0.0F));

		ModelPartData left_9 = veins5.addChild("left_9", ModelPartBuilder.create(), ModelTransform.of(0.25F, -10.3659F, -4.4968F, 0.0F, 3.1416F, 0.0F));

		ModelPartData part_2_r19 = left_9.addChild("part_2_r19", ModelPartBuilder.create().uv(22, 12).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.2163F, 2.6282F, 0.5236F, 0.0F, 0.0F));

		ModelPartData part_1_r19 = left_9.addChild("part_1_r19", ModelPartBuilder.create().uv(29, 11).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.8659F, -2.2532F, 0.2182F, 0.0F, 0.0F));

		ModelPartData left_10 = veins5.addChild("left_10", ModelPartBuilder.create(), ModelTransform.of(1.5F, -20.7901F, -4.7877F, 0.0F, 3.1416F, 0.1745F));

		ModelPartData part_3_r10 = left_10.addChild("part_3_r10", ModelPartBuilder.create().uv(43, 33).cuboid(-0.5F, -10.5372F, -5.5071F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0217F, 12.8791F, 1.2654F, 0.0F, 0.0F));

		ModelPartData part_2_r20 = left_10.addChild("part_2_r20", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -11.6603F, -7.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 12.5442F, 1.0472F, 0.0F, 0.0F));

		ModelPartData part_1_r20 = left_10.addChild("part_1_r20", ModelPartBuilder.create().uv(15, 11).cuboid(-0.5F, -6.2358F, -11.6915F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, 8.0377F, 0.6109F, 0.0F, 0.0F));

		ModelPartData outer_leaf_6 = outer_leaf_group_2.addChild("outer_leaf_6", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, -10.0F, 1.5708F, 0.0F, 0.0F));

		ModelPartData body6 = outer_leaf_6.addChild("body6", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaf6 = body6.addChild("leaf6", ModelPartBuilder.create().uv(0, 4).cuboid(0.0F, -7.0F, -5.0F, 0.0F, 2.0F, 10.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaf_6_r6 = leaf6.addChild("leaf_6_r6", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0271F, -8.4502F, -5.0F, 0.0F, 4.0F, 10.0F, new Dilation(0.1F))
				.uv(0, 20).cuboid(-1.0271F, -4.4502F, -9.0F, 0.0F, 6.0F, 18.0F, new Dilation(0.1F))
				.uv(0, 0).cuboid(-0.9729F, 0.9502F, -11.0F, 0.0F, 11.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(3.8507F, -25.4139F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData leaf_3_r6 = leaf6.addChild("leaf_3_r6", ModelPartBuilder.create().uv(0, 11).cuboid(0.75F, -2.5F, -11.0F, 0.0F, 5.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -11.5F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData leaf_2_r6 = leaf6.addChild("leaf_2_r6", ModelPartBuilder.create().uv(0, 0).cuboid(0.25F, -1.0F, -9.0F, 0.0F, 2.0F, 18.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData stem6 = body6.addChild("stem6", ModelPartBuilder.create().uv(0, 44).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData inner_stem_3_r6 = stem6.addChild("inner_stem_3_r6", ModelPartBuilder.create().uv(20, 0).cuboid(0.25F, -13.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F))
				.uv(28, 0).cuboid(0.25F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -18.5F, -0.5F, 0.0F, 0.0F, 0.2182F));

		ModelPartData inner_stem_1_r6 = stem6.addChild("inner_stem_1_r6", ModelPartBuilder.create().uv(36, 0).cuboid(-1.5F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.8922F, -9.4829F, -0.5F, 0.0F, 0.0F, 0.0873F));

		ModelPartData veins6 = body6.addChild("veins6", ModelPartBuilder.create(), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData right_11 = veins6.addChild("right_11", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -0.25F));

		ModelPartData part_2_r21 = right_11.addChild("part_2_r21", ModelPartBuilder.create().uv(39, 6).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -8.5822F, 8.3815F, 0.5236F, 0.0F, 0.0F));

		ModelPartData part_1_r21 = right_11.addChild("part_1_r21", ModelPartBuilder.create().uv(43, 13).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -7.5F, 3.5F, 0.2182F, 0.0F, 0.0F));

		ModelPartData right_12 = veins6.addChild("right_12", ModelPartBuilder.create(), ModelTransform.of(1.5F, -17.7901F, 5.2123F, 0.0F, 0.0F, 0.1745F));

		ModelPartData part_3_r11 = right_12.addChild("part_3_r11", ModelPartBuilder.create().uv(36, 12).cuboid(-1.0F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.1721F, 2.4023F, 1.2678F, -0.0393F, -0.1249F));

		ModelPartData part_2_r22 = right_12.addChild("part_2_r22", ModelPartBuilder.create().uv(7, 1).cuboid(-0.5F, -3.0F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 2.5442F, 1.0472F, 0.0F, 0.0F));

		ModelPartData part_1_r22 = right_12.addChild("part_1_r22", ModelPartBuilder.create().uv(36, 38).cuboid(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, -1.9623F, 0.6109F, 0.0F, 0.0F));

		ModelPartData left_11 = veins6.addChild("left_11", ModelPartBuilder.create(), ModelTransform.of(0.25F, -10.3659F, -4.4968F, 0.0F, 3.1416F, 0.0F));

		ModelPartData part_2_r23 = left_11.addChild("part_2_r23", ModelPartBuilder.create().uv(22, 12).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.2163F, 2.6282F, 0.5236F, 0.0F, 0.0F));

		ModelPartData part_1_r23 = left_11.addChild("part_1_r23", ModelPartBuilder.create().uv(29, 11).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.8659F, -2.2532F, 0.2182F, 0.0F, 0.0F));

		ModelPartData left_12 = veins6.addChild("left_12", ModelPartBuilder.create(), ModelTransform.of(1.5F, -20.7901F, -4.7877F, 0.0F, 3.1416F, 0.1745F));

		ModelPartData part_3_r12 = left_12.addChild("part_3_r12", ModelPartBuilder.create().uv(43, 33).cuboid(-0.5F, -10.5372F, -5.5071F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0217F, 12.8791F, 1.2654F, 0.0F, 0.0F));

		ModelPartData part_2_r24 = left_12.addChild("part_2_r24", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -11.6603F, -7.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 12.5442F, 1.0472F, 0.0F, 0.0F));

		ModelPartData part_1_r24 = left_12.addChild("part_1_r24", ModelPartBuilder.create().uv(15, 11).cuboid(-0.5F, -6.2358F, -11.6915F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, 8.0377F, 0.6109F, 0.0F, 0.0F));

		ModelPartData outer_leaf_7 = outer_leaf_group_2.addChild("outer_leaf_7", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -11.0F, 0.0F));

		ModelPartData body7 = outer_leaf_7.addChild("body7", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaf7 = body7.addChild("leaf7", ModelPartBuilder.create().uv(0, 4).cuboid(0.0F, -7.0F, -5.0F, 0.0F, 2.0F, 10.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaf_6_r7 = leaf7.addChild("leaf_6_r7", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0271F, -8.4502F, -5.0F, 0.0F, 4.0F, 10.0F, new Dilation(0.1F))
				.uv(0, 20).cuboid(-1.0271F, -4.4502F, -9.0F, 0.0F, 6.0F, 18.0F, new Dilation(0.1F))
				.uv(0, 0).cuboid(-0.9729F, 0.9502F, -11.0F, 0.0F, 11.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(3.8507F, -25.4139F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData leaf_3_r7 = leaf7.addChild("leaf_3_r7", ModelPartBuilder.create().uv(0, 11).cuboid(0.75F, -2.5F, -11.0F, 0.0F, 5.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -11.5F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData leaf_2_r7 = leaf7.addChild("leaf_2_r7", ModelPartBuilder.create().uv(0, 0).cuboid(0.25F, -1.0F, -9.0F, 0.0F, 2.0F, 18.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData stem7 = body7.addChild("stem7", ModelPartBuilder.create().uv(0, 44).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData inner_stem_3_r7 = stem7.addChild("inner_stem_3_r7", ModelPartBuilder.create().uv(20, 0).cuboid(0.25F, -13.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F))
				.uv(28, 0).cuboid(0.25F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -18.5F, -0.5F, 0.0F, 0.0F, 0.2182F));

		ModelPartData inner_stem_1_r7 = stem7.addChild("inner_stem_1_r7", ModelPartBuilder.create().uv(36, 0).cuboid(-1.5F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.8922F, -9.4829F, -0.5F, 0.0F, 0.0F, 0.0873F));

		ModelPartData veins7 = body7.addChild("veins7", ModelPartBuilder.create(), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData right_13 = veins7.addChild("right_13", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -0.25F));

		ModelPartData part_2_r25 = right_13.addChild("part_2_r25", ModelPartBuilder.create().uv(39, 6).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -8.5822F, 8.3815F, 0.5236F, 0.0F, 0.0F));

		ModelPartData part_1_r25 = right_13.addChild("part_1_r25", ModelPartBuilder.create().uv(43, 13).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -7.5F, 3.5F, 0.2182F, 0.0F, 0.0F));

		ModelPartData right_14 = veins7.addChild("right_14", ModelPartBuilder.create(), ModelTransform.of(1.5F, -17.7901F, 5.2123F, 0.0F, 0.0F, 0.1745F));

		ModelPartData part_3_r13 = right_14.addChild("part_3_r13", ModelPartBuilder.create().uv(36, 12).cuboid(-1.0F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.1721F, 2.4023F, 1.2678F, -0.0393F, -0.1249F));

		ModelPartData part_2_r26 = right_14.addChild("part_2_r26", ModelPartBuilder.create().uv(7, 1).cuboid(-0.5F, -3.0F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 2.5442F, 1.0472F, 0.0F, 0.0F));

		ModelPartData part_1_r26 = right_14.addChild("part_1_r26", ModelPartBuilder.create().uv(36, 38).cuboid(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, -1.9623F, 0.6109F, 0.0F, 0.0F));

		ModelPartData left_13 = veins7.addChild("left_13", ModelPartBuilder.create(), ModelTransform.of(0.25F, -10.3659F, -4.4968F, 0.0F, 3.1416F, 0.0F));

		ModelPartData part_2_r27 = left_13.addChild("part_2_r27", ModelPartBuilder.create().uv(22, 12).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.2163F, 2.6282F, 0.5236F, 0.0F, 0.0F));

		ModelPartData part_1_r27 = left_13.addChild("part_1_r27", ModelPartBuilder.create().uv(29, 11).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.8659F, -2.2532F, 0.2182F, 0.0F, 0.0F));

		ModelPartData left_14 = veins7.addChild("left_14", ModelPartBuilder.create(), ModelTransform.of(1.5F, -20.7901F, -4.7877F, 0.0F, 3.1416F, 0.1745F));

		ModelPartData part_3_r14 = left_14.addChild("part_3_r14", ModelPartBuilder.create().uv(43, 33).cuboid(-0.5F, -10.5372F, -5.5071F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0217F, 12.8791F, 1.2654F, 0.0F, 0.0F));

		ModelPartData part_2_r28 = left_14.addChild("part_2_r28", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -11.6603F, -7.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 12.5442F, 1.0472F, 0.0F, 0.0F));

		ModelPartData part_1_r28 = left_14.addChild("part_1_r28", ModelPartBuilder.create().uv(15, 11).cuboid(-0.5F, -6.2358F, -11.6915F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, 8.0377F, 0.6109F, 0.0F, 0.0F));

		ModelPartData outer_leaf_8 = outer_leaf_group_2.addChild("outer_leaf_8", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, -1.5708F, 0.0F, 0.0F));

		ModelPartData body8 = outer_leaf_8.addChild("body8", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaf8 = body8.addChild("leaf8", ModelPartBuilder.create().uv(0, 4).cuboid(0.0F, -7.0F, -5.0F, 0.0F, 2.0F, 10.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaf_6_r8 = leaf8.addChild("leaf_6_r8", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0271F, -8.4502F, -5.0F, 0.0F, 4.0F, 10.0F, new Dilation(0.1F))
				.uv(0, 20).cuboid(-1.0271F, -4.4502F, -9.0F, 0.0F, 6.0F, 18.0F, new Dilation(0.1F))
				.uv(0, 0).cuboid(-0.9729F, 0.9502F, -11.0F, 0.0F, 11.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(3.8507F, -25.4139F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData leaf_3_r8 = leaf8.addChild("leaf_3_r8", ModelPartBuilder.create().uv(0, 11).cuboid(0.75F, -2.5F, -11.0F, 0.0F, 5.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -11.5F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData leaf_2_r8 = leaf8.addChild("leaf_2_r8", ModelPartBuilder.create().uv(0, 0).cuboid(0.25F, -1.0F, -9.0F, 0.0F, 2.0F, 18.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData stem8 = body8.addChild("stem8", ModelPartBuilder.create().uv(0, 44).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData inner_stem_3_r8 = stem8.addChild("inner_stem_3_r8", ModelPartBuilder.create().uv(20, 0).cuboid(0.25F, -13.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F))
				.uv(28, 0).cuboid(0.25F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -18.5F, -0.5F, 0.0F, 0.0F, 0.2182F));

		ModelPartData inner_stem_1_r8 = stem8.addChild("inner_stem_1_r8", ModelPartBuilder.create().uv(36, 0).cuboid(-1.5F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.8922F, -9.4829F, -0.5F, 0.0F, 0.0F, 0.0873F));

		ModelPartData veins8 = body8.addChild("veins8", ModelPartBuilder.create(), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		ModelPartData right_15 = veins8.addChild("right_15", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -0.25F));

		ModelPartData part_2_r29 = right_15.addChild("part_2_r29", ModelPartBuilder.create().uv(39, 6).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -8.5822F, 8.3815F, 0.5236F, 0.0F, 0.0F));

		ModelPartData part_1_r29 = right_15.addChild("part_1_r29", ModelPartBuilder.create().uv(43, 13).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -7.5F, 3.5F, 0.2182F, 0.0F, 0.0F));

		ModelPartData right_16 = veins8.addChild("right_16", ModelPartBuilder.create(), ModelTransform.of(1.5F, -17.7901F, 5.2123F, 0.0F, 0.0F, 0.1745F));

		ModelPartData part_3_r15 = right_16.addChild("part_3_r15", ModelPartBuilder.create().uv(36, 12).cuboid(-1.0F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.1721F, 2.4023F, 1.2678F, -0.0393F, -0.1249F));

		ModelPartData part_2_r30 = right_16.addChild("part_2_r30", ModelPartBuilder.create().uv(7, 1).cuboid(-0.5F, -3.0F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 2.5442F, 1.0472F, 0.0F, 0.0F));

		ModelPartData part_1_r30 = right_16.addChild("part_1_r30", ModelPartBuilder.create().uv(36, 38).cuboid(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, -1.9623F, 0.6109F, 0.0F, 0.0F));

		ModelPartData left_15 = veins8.addChild("left_15", ModelPartBuilder.create(), ModelTransform.of(0.25F, -10.3659F, -4.4968F, 0.0F, 3.1416F, 0.0F));

		ModelPartData part_2_r31 = left_15.addChild("part_2_r31", ModelPartBuilder.create().uv(22, 12).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.2163F, 2.6282F, 0.5236F, 0.0F, 0.0F));

		ModelPartData part_1_r31 = left_15.addChild("part_1_r31", ModelPartBuilder.create().uv(29, 11).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.8659F, -2.2532F, 0.2182F, 0.0F, 0.0F));

		ModelPartData left_16 = veins8.addChild("left_16", ModelPartBuilder.create(), ModelTransform.of(1.5F, -20.7901F, -4.7877F, 0.0F, 3.1416F, 0.1745F));

		ModelPartData part_3_r16 = left_16.addChild("part_3_r16", ModelPartBuilder.create().uv(43, 33).cuboid(-0.5F, -10.5372F, -5.5071F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0217F, 12.8791F, 1.2654F, 0.0F, 0.0F));

		ModelPartData part_2_r32 = left_16.addChild("part_2_r32", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -11.6603F, -7.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 12.5442F, 1.0472F, 0.0F, 0.0F));

		ModelPartData part_1_r32 = left_16.addChild("part_1_r32", ModelPartBuilder.create().uv(15, 11).cuboid(-0.5F, -6.2358F, -11.6915F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, 8.0377F, 0.6109F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(LeafGodEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.updateAnimation(entity.leafGodCoreSpin, ModAnimations.CORE_SPIN, ageInTicks);
		this.updateAnimation(entity.leafGodAnimationState, ModAnimations.LEAF_GOD_OUTER_LEAVES_SPIN, ageInTicks);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		leaf_god.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return leaf_god;
	}
}