package tech.krazyminer001.world.gen;

import tech.krazyminer001.OctoComputing;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();



        OctoComputing.LOGGER.info("Generating World Generation for " + OctoComputing.MOD_ID);
    }
}
