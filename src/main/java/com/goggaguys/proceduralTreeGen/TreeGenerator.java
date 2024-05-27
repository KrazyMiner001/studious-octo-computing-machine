package com.goggaguys.proceduralTreeGen;

import com.goggaguys.shapes.TruncatedCone;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;

import java.util.ArrayList;
import java.util.List;

public class TreeGenerator {
    private final double segmentSize;
    private final List<TreeNode> treeNodes;
    private final List<AttractingPoint> pointCloud;
    private final List<TreeNode> trunkNodes;
    private final List<Vec3d> leafPositions;

    public TreeGenerator(double segmentSize, List<AttractingPoint> pointCloud, double initialThickness) {
        this.segmentSize = segmentSize;
        this.pointCloud = pointCloud;
        this.leafPositions = new ArrayList<>();
        this.treeNodes = new ArrayList<>();
        this.trunkNodes = new ArrayList<>();

        TreeNode rootNode = new TreeNode(0, 0, 0, initialThickness);
        this.treeNodes.add(rootNode);
    }

    public TreeNode getRootNode() {
        if (treeNodes.get(0).isRootNode()) {
            return treeNodes.get(0);
        }
        return treeNodes.stream().filter(TreeNode::isRootNode).findFirst().orElseThrow();
    }

    public void growTree() {
        List<TreeNode> newTreeNodes = new ArrayList<>();
        for (AttractingPoint point : this.pointCloud) {
            for (TreeNode treeNode : this.treeNodes) {
                if (point.getDistance(treeNode.getPosition()) < point.getRadiusOfInfluence() || this.trunkNodes.contains(treeNode)) {
                    if (point.getNearestTreeNode() == null) {
                        point.setNearestTreeNode(treeNode);
                    }
                    if (point.getDistance(treeNode.getPosition()) < point.getTreeNodeDistance().orElseThrow()) {
                        point.setNearestTreeNode(treeNode);
                    }
                }
                if (point.getDistance(treeNode.getPosition()) <= point.getKillDistance()) {
                    point.setReached(true);
                    if (point.isLeafGenerating()) {
                        this.spawnLeaf(point.getPosition());
                    }
                }
            }
        }
        for (AttractingPoint point : this.pointCloud) {
            if (point.getNearestTreeNode() != null) {
                point.getNearestTreeNode().getInfluencingPoints().add(point);
                point.setNearestTreeNode(null);
            }
        }
        for (TreeNode treeNode : this.treeNodes) {
            if (!treeNode.getInfluencingPoints().isEmpty() && (!treeNode.isRootNode() || treeNode.getChildren().isEmpty())) {
                TreeNode newTreeNode = this.addNewTreeNode(treeNode);
                newTreeNodes.add(newTreeNode);
            }
        }
        this.pointCloud.removeIf(AttractingPoint::isReached);
        this.treeNodes.addAll(newTreeNodes);
    }

    private void spawnLeaf(Vec3d position) {
        this.leafPositions.add(position);
    }
    
    private TreeNode addNewTreeNode(TreeNode oldTreeNode) {
        Vec3d growDirection = new Vec3d(0, 5, 0);
        for (AttractingPoint influencingNodes : oldTreeNode.getInfluencingPoints()) {
            growDirection = growDirection.add(influencingNodes.getPosition().subtract(oldTreeNode.getPosition()).normalize());
        }
        growDirection = growDirection.normalize();
        growDirection = growDirection.add(Math.random()-0.5, Math.random()-0.5, Math.random()-0.5);
        return new TreeNode(oldTreeNode.getPosition().add(growDirection.multiply(this.segmentSize * ((double) 3 / (oldTreeNode.getNodeDepth() + 3)))), oldTreeNode, (thickness) -> {
            if (thickness < this.treeNodes.get(0).getThickness() * 0.5) {
                return 0.6*thickness;
            }
            if (thickness < this.treeNodes.get(0).getThickness() * 0.75) {
                return 0.7*thickness;
            }
            return 0.9*thickness;
        });
    }

    public static List<AttractingPoint> pointCloudGenerator(Vec3d center, double diameter, int quantity, double killDistance, boolean leafGenerating, double radiusOfInfluence) {
        List<AttractingPoint> pointCloud = new ArrayList<>();
        Random random = Random.create();
        for (int i = 0; i < quantity; i++) {
            Vec3d point = new Vec3d(0, 0, 0);
            point = point.addRandom(random, (float) diameter);
            point = point.add(center);
            pointCloud.add(new AttractingPoint(point, radiusOfInfluence, killDistance, leafGenerating));
        }
        return pointCloud;
    }

    public static List<AttractingPoint> pointCloudGenerator(Vec3d center, double diameter, int quantity, double killDistance, boolean leafGenerating, double radiusOfInfluence, double distributionMean) {
        List<AttractingPoint> pointCloud = new ArrayList<>();
        Random random = Random.create();
        for (int i = 0; i < quantity; i++) {
            Vec3d point = new Vec3d(0, 0, 0);
            point = point.addRandom(random, (float) diameter);
            // Adjust the y-coordinate of the point according to the Gaussian distribution
            point = point.add(0, random.nextGaussian() * diameter / 2 + distributionMean, 0);
            point = point.add(center);
            pointCloud.add(new AttractingPoint(point, radiusOfInfluence, killDistance, leafGenerating));
        }
        return pointCloud;
    }

    public List<TruncatedCone> treeNodesAsTruncatedCones() {
        List<TruncatedCone> truncatedConeList = new ArrayList<>();
        for (TreeNode treeNode : this.treeNodes) {
            TreeNode parentNode;
            if (treeNode.getParentNode() != null) {
                truncatedConeList.add(new TruncatedCone(treeNode.getParentNode().getPosition(), treeNode.getPosition(), treeNode.getThickness(), treeNode.getEndThickness()));
            }
        }
        return truncatedConeList;
    }

    public static List<AttractingPoint> trunkPointCloudGenerator(Vec3d center, double height, int quantity, double killDistance, boolean leafGenerating, double radiusOfInfluence) {
        List<AttractingPoint> pointCloud = new ArrayList<>();
        Random random = Random.create();
        for (int i = 0; i < quantity; i++) {
            Vec3d point = new Vec3d(0, i * (height / quantity), 0);
            point = point.add(center);
            pointCloud.add(new AttractingPoint(point, radiusOfInfluence, killDistance, leafGenerating));
        }
        return pointCloud;
    }

    public List<Vec3d> getLeafPositions() {
        return leafPositions;
    }
}
