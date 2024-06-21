package tech.krazyminer001.blockentity.screen;

import tech.krazyminer001.OctoComputing;
import tech.krazyminer001.blockentity.screen.screenhandlers.VoidspawnGeneratorScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static tech.krazyminer001.utility.Util.of;

public class ModScreenHandlers {
    public static final ScreenHandlerType<VoidspawnGeneratorScreenHandler> VOIDSPAWN_GENERATOR_SCREEN_HANDLER = registerScreenHandlerType("voidspawn_generator",
            new ScreenHandlerType<>(VoidspawnGeneratorScreenHandler::new, FeatureFlags.VANILLA_FEATURES));

    private static <T extends ScreenHandler> ScreenHandlerType<T> registerScreenHandlerType(String name, ScreenHandlerType<T> screenHandlerType) {
        return Registry.register(Registries.SCREEN_HANDLER, of(name), screenHandlerType);
    }

    public static void registerScreenHandlers() {
        OctoComputing.LOGGER.info("Registering screen handlers");
        // ModHandledScreens.registerScreenHandlers();
    }
}
