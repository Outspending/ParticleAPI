package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CircleParticleType implements CustomParticleType<CircleParticleType> {

    @Override
    public void render(@NotNull Location startingLocation) {
        ParticleOptions<CircleParticleType> options = getOptions();

    }

    @Override
    public @NotNull ParticleOptions<CircleParticleType> getOptions() {
        return null;
    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return null;
    }

}
