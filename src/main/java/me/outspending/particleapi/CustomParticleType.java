package me.outspending.particleapi;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface CustomParticleType<T extends CustomParticleType<?>> {

    void render(@NotNull Location startingLocation);

    @NotNull ParticleOptions<T> getOptions();

    @NotNull List<String> getRequiredOptions();
}
