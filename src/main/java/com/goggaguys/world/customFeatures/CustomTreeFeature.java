package com.goggaguys.world.customFeatures;

import com.goggaguys.proceduralTreeGen.AttractingPoint;
import com.goggaguys.proceduralTreeGen.TreeGenerator;
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

        // Define the number of points for the trunk and branches
        int trunkPointsCount = 10; // Adjust as needed
        int branchPointsCount = 25; // Adjust as needed

        // Generate points for the trunk
        List<AttractingPoint> trunkPoints = new ArrayList<>();
        for (int i = 0; i < trunkPointsCount; i++) {
            trunkPoints.add(new AttractingPoint(
                    new Vec3d(0, i * ((double) height / 20), 0).addRandom(random, (float) height / 40),
                    (double) height / 10,
                    (double) height / 50,
                    false // Trunk points do not have leaves
            ));
        }

        // Generate points for the branches
        List<AttractingPoint> branchPoints = TreeGenerator.pointCloudGenerator(
                new Vec3d(0, 0.75 * height, 0),
                0.6 * height,
                branchPointsCount,
                (double) height / 25,
                true, // Branch points have leaves
                (double) height / 12
        );

        // Combine the trunk points and branch points
        List<AttractingPoint> attractingPoints = new ArrayList<>();
        attractingPoints.addAll(trunkPoints);
        attractingPoints.addAll(branchPoints);

        TreeGenerator treeGenerator = new TreeGenerator(
                5*radius,
                attractingPoints,
                radius
        );
        for (int i = 0; i < iterations; i++) {
            treeGenerator.growTree();
        }

        List<BlockPos> leafBlockPositions = new ArrayList<>();
        for (Vec3d position : treeGenerator.getLeafPositions()) {
            BlockPos initialPos = new BlockPos(
                    (int) (Math.round(position.x) + origin.getX()),
                    (int) (Math.round(position.y) + origin.getY()),
                    (int) (Math.round(position.z) + origin.getZ()));
            leafBlockPositions.add(initialPos);
            leafBlockPositions.add(initialPos.up());
            leafBlockPositions.add(initialPos.down());
            leafBlockPositions.add(initialPos.east());
            leafBlockPositions.add(initialPos.west());
            leafBlockPositions.add(initialPos.south());
            leafBlockPositions.add(initialPos.north());
        }

        for (BlockPos blockPos : leafBlockPositions) {
            world.setBlockState(blockPos, leafBlockState, 3);
        }

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
}
