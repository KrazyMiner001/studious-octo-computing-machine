package com.goggaguys.world.gen;

import com.goggaguys.OctoComputing;
import com.goggaguys.world.ModOrePlacement;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();



        OctoComputing.LOGGER.info("Generating World Generation for " + OctoComputing.MOD_ID);
    }
}
