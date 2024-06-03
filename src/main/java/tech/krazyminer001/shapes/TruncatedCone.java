package tech.krazyminer001.shapes;

import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import java.util.HashSet;
import java.util.Set;


public class TruncatedCone {
    private Vec3d pos1;
    private Vec3d pos2;
    private double startThickness;
    private double endThickness;
    public TruncatedCone(Vec3d pos1, Vec3d pos2, double startThickness, double endThickness) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.startThickness = startThickness;
        this.endThickness = endThickness;
    }

    public boolean containsPoint(Vec3d point) {
        Vec3d cylinderLineVector = pos2.subtract(pos1).normalize();
        Vec3d pointToPos1 = point.subtract(pos1);
        double pointPortionUpLine = pointToPos1.dotProduct(cylinderLineVector);

        // Check if the point is outside the bounds of the truncated cone
        if (pointPortionUpLine < 0 || pointPortionUpLine > pos2.subtract(pos1).length()) {
            return false;
        }

        Vec3d pointOnCylinderLine = pos1.add(cylinderLineVector.multiply(pointPortionUpLine));
        double pointDistance = point.subtract(pointOnCylinderLine).length();

        // Linearly interpolate the radius at the point on the line
        double radiusAtPoint = startThickness + (endThickness - startThickness) * (pointPortionUpLine / pos2.subtract(pos1).length());

        return pointDistance <= radiusAtPoint;
    }

    public Pair<Vec3d, Vec3d> getBoundingBox() {
        double minX = Math.min(pos1.x - startThickness, pos2.x - endThickness);
        double minY = Math.min(pos1.y - startThickness, pos2.y - endThickness);
        double minZ = Math.min(pos1.z - startThickness, pos2.z - endThickness);
        double maxX = Math.max(pos1.x + startThickness, pos2.x + endThickness);
        double maxY = Math.max(pos1.y + startThickness, pos2.y + endThickness);
        double maxZ = Math.max(pos1.z + startThickness, pos2.z + endThickness);

        return new Pair<>(new Vec3d(minX, minY, minZ), new Vec3d(maxX, maxY, maxZ));
    }

    public Set<BlockPos> getBlocks() {
        Pair<Vec3d, Vec3d> boundingBox = getBoundingBox();
        Set<BlockPos> blocks = new HashSet<>();
        for (double x = boundingBox.getLeft().x; x < boundingBox.getRight().x; x++) {
            for (double y = boundingBox.getLeft().y; y < boundingBox.getRight().y; y++) {
                for (double z = boundingBox.getLeft().z; z < boundingBox.getRight().z; z++) {
                    if (containsPoint(new Vec3d(x, y, z))) {
                        blocks.add(new BlockPos((int) x, (int) y, (int) z));
                    }
                }
            }
        }
        return blocks;
    }
}
