package tech.krazyminer001.proceduralTreeGen;

import net.minecraft.util.math.Vec3d;

import java.util.Optional;

public class AttractingPoint {
    private final Vec3d position;
    private TreeNode nearestTreeNode = null;
    private final double radiusOfInfluence;
    private final double killDistance;
    private final boolean leafGenerating;
    private boolean reached;
    public AttractingPoint(Vec3d position, double radiusOfInfluence, double killDistance, boolean leafGenerating) {
        this.position = position;
        this.radiusOfInfluence = radiusOfInfluence;
        this.killDistance = killDistance;
        this.leafGenerating = leafGenerating;
    }

    public double getKillDistance() {
        return killDistance;
    }

    public double getRadiusOfInfluence() {
        return radiusOfInfluence;
    }

    public TreeNode getNearestTreeNode() {
        return nearestTreeNode;
    }

    public Vec3d getPosition() {
        return position;
    }

    public boolean isLeafGenerating() {
        return leafGenerating;
    }

    public void setNearestTreeNode(TreeNode nearestTreeNode) {
        this.nearestTreeNode = nearestTreeNode;
    }

    public double getDistance(Vec3d otherPoint) {
        return this.position.distanceTo(otherPoint);
    }

    public Optional<Double> getTreeNodeDistance() {
        return this.nearestTreeNode != null ? Optional.of(this.position.distanceTo(this.nearestTreeNode.getPosition())) : Optional.empty();
    }

    public boolean isReached() {
        return reached;
    }

    public void setReached(boolean reached) {
        this.reached = reached;
    }
}
