package com.goggaguys.proceduralTreeGen;

import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TreeNode {
    private final Vec3d position;
    private final List<AttractingPoint> influencingPoints;
    private final boolean rootNode;
    private final TreeNode parentNode;
    private double thickness;
    private double endThickness;
    private final List<TreeNode> children;
    
    public TreeNode(Vec3d position, TreeNode parentNode) {
        this.position = position;
        this.influencingPoints = new ArrayList<>();
        this.parentNode = parentNode;
        if (parentNode != null) {
            parentNode.getChildren().add(this);
            this.thickness = parentNode.endThickness;
            this.endThickness = 0.9 * thickness;
        }
        this.children = new ArrayList<>();

        this.rootNode = parentNode == null;
    }

    public TreeNode(Vec3d position, double thickness) {
        this(position, null);
        this.thickness = thickness;
        this.endThickness = 0.7 * thickness;
    }

    public TreeNode(Vec3d position, double thickness, double thicknessMultiplier) {
        this(position, null);
        this.thickness = thickness;
        this.endThickness = thicknessMultiplier * thickness;
    }
    
    public TreeNode(double x, double y, double z, TreeNode parentNode) {
        this(new Vec3d(x, y, z), parentNode);
    }

    public TreeNode(double x, double y, double z, double thickness) {
        this(new Vec3d(x, y, z), thickness);
    }

    public Vec3d getPosition() {
        return position;
    }

    public List<AttractingPoint> getInfluencingPoints() {
        return influencingPoints;
    }

    public boolean isRootNode() {
        return rootNode;
    }

    public TreeNode getParentNode() {
        return parentNode;
    }

    public double getThickness() {
        return thickness;
    }

    public double getEndThickness() {
        return endThickness;
    }

    public List<TreeNode> getChildren() {
        return children;
    }
}
