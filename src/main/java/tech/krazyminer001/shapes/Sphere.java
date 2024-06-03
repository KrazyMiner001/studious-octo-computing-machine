package tech.krazyminer001.shapes;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;
import java.util.List;

public class Sphere {
    private final double radius;
    private final Vec3d center;

    public Sphere(double radius, Vec3d center) {
        this.radius = radius;
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public Vec3d getCenter() {
        return center;
    }

    public boolean contains(Vec3d point) {
        return point.squaredDistanceTo(center) <= radius * radius;
    }

    public List<BlockPos> containedBlocks() {
        List<BlockPos> blocks = new ArrayList<>();
        for (int x = (int) (center.x - radius); x <= center.x + radius; x++) {
            for (int y = (int) (center.y - radius); y <= center.y + radius; y++) {
                for (int z = (int) (center.z - radius); z <= center.z + radius; z++) {
                    BlockPos block = new BlockPos(x, y, z);
                    if (contains(new Vec3d(x, y, z))) {
                        blocks.add(block);
                    }
                }
            }
        }
        return blocks;
    }
}
