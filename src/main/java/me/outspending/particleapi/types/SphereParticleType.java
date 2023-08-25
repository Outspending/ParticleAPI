package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SphereParticleType implements CustomParticleType {

    @Override
    public void render(@NotNull Location startingLocation, @NotNull ParticleOptions<?> options) {

    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return null;
    }

}
