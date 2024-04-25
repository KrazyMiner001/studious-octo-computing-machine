package com.goggaguys.commands;

import com.goggaguys.OctoComputing;
import com.goggaguys.proceduralTreeGen.AttractingPoint;
import com.goggaguys.proceduralTreeGen.TreeGenerator;
import com.goggaguys.shapes.TruncatedCone;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.block.Blocks;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static net.minecraft.server.command.CommandManager.*;

public class ModCommands {
    public static void register() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> {
            LiteralCommandNode<ServerCommandSource> octocomputingNode = CommandManager.literal(OctoComputing.MOD_ID).build();
            dispatcher.register(literal("debug_tree")
                    .requires(source -> source.hasPermissionLevel(2))
                    .executes(context -> {
                        World world = context.getSource().getWorld();
                        Position pos = context.getSource().getPosition();
                        List<AttractingPoint> pointCloud = TreeGenerator.pointCloudGenerator(
                                new Vec3d(0, 50, 0),
                                20,
                                20,
                                10,
                                false,
                                30
                        );
                        pointCloud.addAll(List.of(
                                new AttractingPoint(new Vec3d(0, 5, 0), 5, 3, false),
                                new AttractingPoint(new Vec3d(0, 8, 0), 5, 3, false),
                                new AttractingPoint(new Vec3d(0, 11, 0), 5, 3, false),
                                new AttractingPoint(new Vec3d(0, 17, 0), 5, 3, false)
                        ));
                        TreeGenerator treeGenerator = new TreeGenerator(
                                7,
                                pointCloud, 5
                        );
                        for (int i = 0; i < 10; i++) {
                            treeGenerator.growTree();
                        }
                        List<TruncatedCone> treeCones = treeGenerator.treeNodesAsTruncatedCones();
                        Set<BlockPos> treeBlocks = new HashSet<>();
                        for (int x = -30; x < 30; x++) {
                            for (int y = 0; y < 60; y++) {
                                for (int z = -30; z < 30; z++) {
                                    Vec3d testPos = new Vec3d(x, y, z);
                                    boolean hasBlock = false;
                                    for (TruncatedCone truncatedCone : treeCones) {
                                        if (truncatedCone.containsPoint(testPos)) {
                                            hasBlock = true;
                                            break;
                                        }
                                    }
                                    if (hasBlock) {
                                        treeBlocks.add(new BlockPos(x, y, z).add((int) pos.getX(), (int) pos.getY(), (int) pos.getZ()));
                                    }
                                }
                            }
                        }
                        for (BlockPos blockPos : treeBlocks) {
                            world.setBlockState(blockPos, Blocks.GREEN_CONCRETE.getDefaultState());
                        }

                        return 1;

                    }));
        }));
    }
}
