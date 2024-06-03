package tech.krazyminer001.config;

import tech.krazyminer001.OctoComputing;
import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;

@Modmenu(modId = OctoComputing.MOD_ID)
@Config(name = "octo-computing-config", wrapperName = "OctoComputingConfig")
public class OctoComputingConfigModel {
    public boolean fancyTree = true;
}
