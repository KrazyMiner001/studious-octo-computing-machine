package com.goggaguys.commands;

import com.goggaguys.OctoComputing;
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
                        TreeGenerator treeGenerator = new TreeGenerator(
                                1,
                                TreeGenerator.pointCloudGenerator(
                                        new Vec3d(0, 10, 0),
                                        7.5,
                                        20,
                                        0.5,
                                        false,
                                        8),
                                0.5
                        );
                        for (int i = 0; i < 5; i++) {
                            treeGenerator.growTree();
                        }
                        List<TruncatedCone> treeCones = treeGenerator.treeNodesAsTruncatedCones();
                        Set<BlockPos> treeBlocks = new HashSet<>();
                        for (int x = -10; x < 10; x++) {
                            for (int y = -10; y < 10; y++) {
                                for (int z = -10; z < 10; z++) {
                                    Vec3d testPos = new Vec3d(x, y, z);
                                    boolean hasBlock = false;
                                    for (TruncatedCone truncatedCone : treeCones) {
                                        if (truncatedCone.containsPoint(testPos)) {
                                            hasBlock = true;
                                        }
                                    }
                                    if (hasBlock) {
                                        treeBlocks.add(new BlockPos(x, y, z));
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
