package com.goggaguys.shapes;

import net.minecraft.util.math.Vec3d;



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
        Vec3d cylinderLineVector = pos1.subtract(pos2).normalize();
        Vec3d shortestLineToCylinder = (point.subtract(pos1)).subtract(cylinderLineVector.multiply((point.subtract(pos1)).dotProduct(cylinderLineVector)));
        double pointDistance = shortestLineToCylinder.length();
        Vec3d pointOnCylinderLine = point.add(shortestLineToCylinder);
        boolean pointIsBetweenCylinderPoints = ((point.x - pos1.x)/(pos2.x-pos1.x) == (point.y - pos1.y)/(pos2.y-pos1.y) && (point.y - pos1.y)/(pos2.y-pos1.y) == (point.z - pos1.z)/(pos2.z-pos1.z));
        if (!pointIsBetweenCylinderPoints) {
            return false;
        }
        double pointPortionUpLine = pointOnCylinderLine.subtract(pos1).length()/pos2.subtract(pos1).length();
        double radiusAtPoint = (endThickness - startThickness) * pointPortionUpLine + startThickness;
        return !(pointDistance > radiusAtPoint);
    }
}
