package me.outspending.particleapi;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public interface CustomParticleType {

    void render(@NotNull Location startingLocation, @NotNull ParticleOptions<?> options);


}
