package com.goggaguys.world.gen;

import com.goggaguys.world.ModOrePlacement;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();

    }
}
