package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Represents a particle type that renders as a circle.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a circle-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Double}) - The radius of the circle</li>
 *     <li>{@code density} ({@link Integer}) - The density of the circle</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */

public class CircleParticleType implements CustomParticleType<CircleParticleType> {

    private final ParticleOptions<CircleParticleType> options = new ParticleOptions<CircleParticleType>()
            .setOption("radius", 1D)
            .setOption("density", 1);

    @NotNull
    @Override
    public List<Vector> render(@NotNull Location startingLocation) {
        double radius = options.getDoubleOption("radius");
        int density = options.getIntegerOption("density");
        List<Vector> particleOffsets = new ArrayList<>();

        for (int i = 0; i < density; i++) {
            double angle = 2 * Math.PI * i / density;
            double x = radius * Math.cos(angle);
            double z = radius * Math.sin(angle);
            particleOffsets.add(new Vector(x, 0, z));
        }

        return particleOffsets;
    }

    @Override
    public @NotNull ParticleOptions<CircleParticleType> getOptions() {
        return options;
    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return options.getAllOptions();
    }

}
