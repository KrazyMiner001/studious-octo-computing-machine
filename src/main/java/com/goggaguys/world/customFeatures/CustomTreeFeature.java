package com.goggaguys.world.customFeatures;

import com.goggaguys.OctoComputing;
import com.goggaguys.proceduralTreeGen.AttractingPoint;
import com.goggaguys.proceduralTreeGen.TreeGenerator;
import com.goggaguys.shapes.Sphere;
import com.goggaguys.shapes.TruncatedCone;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CustomTreeFeature extends Feature<CustomTreeFeatureConfig> {
    public CustomTreeFeature(Codec<CustomTreeFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<CustomTreeFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        Random random = context.getRandom();
        CustomTreeFeatureConfig config = context.getConfig();

        int height = config.height();
        int radius = config.radius();
        int iterations = config.iterations();
        Identifier woodBlockId = config.woodBlockId();
        Identifier leafBlockId = config.leafBlockId();

        BlockState woodBlockState = Registries.BLOCK.get(woodBlockId).getDefaultState();
        BlockState leafBlockState = Registries.BLOCK.get(leafBlockId).getDefaultState();
        if (woodBlockState == null) throw new IllegalStateException(woodBlockId + " could not be parsed to a valid block identifier!");
        if (leafBlockId == null) throw new IllegalStateException(leafBlockState + " could not be parsed to a valid block identifier!");

        if (!OctoComputing.CONFIG.fancyTree()) {
            for (BlockPos pos : new Sphere((double) height / 3.5, origin.add(0, (int) (height * 0.80), 0).toCenterPos()).containedBlocks()) {
                world.setBlockState(pos, leafBlockState, 3);
            }
            for (BlockPos pos : new TruncatedCone(origin.toCenterPos(), origin.add(0, height, 0).toCenterPos(), radius, 0).getBlocks()) {
                world.setBlockState(pos, woodBlockState, 3);
            }
            return true;
        }

        // Define the number of points for the trunk and branches
        int trunkPointsCount = 10; // Adjust as needed
        int branchPointsCount = 25; // Adjust as needed

        TreeGenerator treeGenerator;
        do {
            treeGenerator = getTreeGenerator(height, trunkPointsCount, branchPointsCount, radius, iterations);
        } while (treeGenerator.treeNodesAsTruncatedCones().size() < 3); // Ensure that the tree has branches

        /* Place leaves, might reimplement this later
        List<BlockPos> leafBlockPositions = new ArrayList<>();
        for (Vec3d position : treeGenerator.getLeafPositions()) {
            leafBlockPositions.addAll(new Sphere(4, position.add(origin.toCenterPos())).containedBlocks());
        }

        for (BlockPos blockPos : leafBlockPositions) {
            world.setBlockState(blockPos, leafBlockState, 3);
        }
        */

        List<TruncatedCone> truncatedConeList = treeGenerator.treeNodesAsTruncatedCones();
        List<BlockPos> woodBlocks = new ArrayList<>();

        for (int x = (int) Math.round(-0.75*height); x < 0.75*height; x++) {
            for (int y = 0; y < Math.round(height*1.25); y++) {
                for (int z = (int) Math.round(-0.75*height); z < 0.75*height; z++) {
                    BlockPos testPos = new BlockPos(x, y, z);
                    boolean isInCones = false;
                    for (TruncatedCone truncatedCone : truncatedConeList) {
                        if (truncatedCone.containsPoint(testPos.toCenterPos())) {
                            isInCones = true;
                            break;
                        }
                    }
                    if (isInCones) {
                        woodBlocks.add(testPos.add(origin));
                    }
                }
            }
        }

        for (BlockPos pos : woodBlocks) {
            world.setBlockState(pos, woodBlockState, 3);
        }

        return true;
    }

    private static @NotNull TreeGenerator getTreeGenerator(int height, int trunkPointsCount, int branchPointsCount, int radius, int iterations) {
        // Generate points for the trunk
        List<AttractingPoint> trunkPoints = TreeGenerator.trunkPointCloudGenerator(
                new Vec3d(0, 0, 0),
                0.5 * height,
                trunkPointsCount,
                (double) height / 50,
                false, // Trunk points do not have leaves
                (double) height / 10
        );

        // Generate points for the branches
        List<AttractingPoint> branchPoints = TreeGenerator.pointCloudGenerator(
                new Vec3d(0, 0.75 * height, 0),
                0.6 * height,
                branchPointsCount,
                (double) height / 25,
                true, // Branch points have leaves
                (double) height / 12,
                0.75 * height // Mean of the distribution is near the top of the tree
        );

        // Combine the trunk points and branch points
        List<AttractingPoint> attractingPoints = new ArrayList<>();
        attractingPoints.addAll(trunkPoints);
        attractingPoints.addAll(branchPoints);

        TreeGenerator treeGenerator = new TreeGenerator(
                5* radius,
                attractingPoints,
                radius
        );
        for (int i = 0; i < iterations; i++) {
            treeGenerator.growTree();
        }
        return treeGenerator;
    }
}
