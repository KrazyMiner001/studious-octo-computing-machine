package tech.krazyminer001.statistic;

import tech.krazyminer001.OctoComputing;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.Stat;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import static tech.krazyminer001.utility.Util.of;


public class ModStatistics {
    public static Stat<Identifier> DRAGON_EGGS_SHADOWED = registerStatistic("dragon_eggs_shadowed", StatFormatter.DEFAULT);
    public static Stat<Identifier> SHADOWED_DRAGON_EGGS_PURIFIED = registerStatistic("shadowed_dragon_eggs_purified", StatFormatter.DEFAULT);

    private static Stat<Identifier> registerStatistic(String name, StatFormatter formatter) {
        return Stats.CUSTOM.getOrCreateStat(Registry.register(Registries.CUSTOM_STAT, name, of(name)), formatter);
    }

    public static void registerStatistics() {
    }
}
