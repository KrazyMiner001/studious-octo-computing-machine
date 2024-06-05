package tech.krazyminer001.command;

import tech.krazyminer001.OctoComputing;
import tech.krazyminer001.proceduralTreeGen.AttractingPoint;
import tech.krazyminer001.proceduralTreeGen.TreeGenerator;
import tech.krazyminer001.shapes.TruncatedCone;
import com.mojang.brigadier.arguments.IntegerArgumentType;
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

import static net.minecraft.server.command.CommandManager.literal;

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
                                new AttractingPoint(new Vec3d(0, 5, 0), 10, 3, false),
                                new AttractingPoint(new Vec3d(0, 8, 0), 10, 3, false),
                                new AttractingPoint(new Vec3d(0, 11, 0), 10, 3, false),
                                new AttractingPoint(new Vec3d(0, 17, 0), 10, 3, false),
                                new AttractingPoint(new Vec3d(0, 20, 0), 10, 3, false),
                                new AttractingPoint(new Vec3d(0, 23, 0), 10, 3, false),
                                new AttractingPoint(new Vec3d(0, 26, 0), 10, 3, false),
                                new AttractingPoint(new Vec3d(0, 29, 0), 10, 3, false),
                                new AttractingPoint(new Vec3d(0, 32, 0), 10, 3, false),
                                new AttractingPoint(new Vec3d(0, 35, 0), 10, 3, false),
                                new AttractingPoint(new Vec3d(0, 38, 0), 10, 3, false)
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
                        for (TruncatedCone cone : treeCones) {
                            for (BlockPos blockPos : cone.getBlocks()) {
                                treeBlocks.add(blockPos.add((int) pos.getX(), (int) pos.getY(), (int) pos.getZ()));
                            }
                        }
                        for (BlockPos blockPos : treeBlocks) {
                            world.setBlockState(blockPos, Blocks.GREEN_CONCRETE.getDefaultState());
                        }

                        return 1;

                    }));

            dispatcher.register(literal("test_cone")
                    .requires(source -> source.hasPermissionLevel(2))
                    .then(CommandManager.argument("height", IntegerArgumentType.integer())
                            .then(CommandManager.argument("base_radius", IntegerArgumentType.integer())
                                    .then(CommandManager.argument("top_radius", IntegerArgumentType.integer())
                                        .executes(context -> {
                                            final int height = IntegerArgumentType.getInteger(context, "height");
                                            final int baseRadius = IntegerArgumentType.getInteger(context, "base_radius");
                                            final int topRadius = IntegerArgumentType.getInteger(context, "top_radius");
                                            World world = context.getSource().getWorld();
                                            Position pos = context.getSource().getPosition();
                                            TruncatedCone cone = new TruncatedCone(
                                                    new Vec3d(pos.getX(), pos.getY(), pos.getZ()),
                                                    new Vec3d(pos.getX(), pos.getY() + height, pos.getZ()),
                                                    baseRadius,
                                                    topRadius
                                            );
                                            Set<BlockPos> coneBlocks = cone.getBlocks();
                                            for (BlockPos blockPos : coneBlocks) {
                                                world.setBlockState(blockPos, Blocks.RED_CONCRETE.getDefaultState());
                                            }
                                            return 1;
                                        })))));
        }));
    }
}
