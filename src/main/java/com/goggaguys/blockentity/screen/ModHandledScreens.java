package com.goggaguys.blockentity.screen;

import com.goggaguys.blockentity.screen.screens.VoidspawnGeneratorScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class ModHandledScreens {
    public static void registerScreenHandlers() {
        HandledScreens.register(ModScreenHandlers.VOIDSPAWN_GENERATOR_SCREEN_HANDLER, VoidspawnGeneratorScreen::new);
    }
}
