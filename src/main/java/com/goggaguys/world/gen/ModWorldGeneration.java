package com.goggaguys.world.gen;

import com.goggaguys.OctoComputing;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();



        OctoComputing.LOGGER.info("Generating World Generation for " + OctoComputing.MOD_ID);
    }
}
