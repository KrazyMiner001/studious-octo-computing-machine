package tech.krazyminer001.compat;

import net.fabricmc.loader.api.FabricLoader;

import java.util.Locale;
import java.util.Optional;
import java.util.function.Supplier;

public enum Mods {
    GECKOLIB;

    public boolean isLoaded() {
        return FabricLoader.getInstance().isModLoaded(asId());
    }

    public String asId() {
        return name().toLowerCase(Locale.ROOT);
    }

    public <T> Optional<T> runIfInstalled(Supplier<Supplier<T>> toRun) {
        if (isLoaded())
            return Optional.of(toRun.get().get());
        return Optional.empty();
    }

    public void executeIfInstalled(Supplier<Runnable> toExecute) {
        if (isLoaded()) {
            toExecute.get().run();
        }
    }
}
