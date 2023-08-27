package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOption;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a particle type that renders a wave effect.
 * <p>
 * Used with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a wave-shaped particle effect.
 *
 * <p>Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Double}) - Radius of the wave.</li>
 *     <li>{@code density} ({@link Integer}) - Density of the wave.</li>
 *     <li>{@code height} ({@link Double}) - Height of the wave.</li>
 *     <li>{@code rotation} ({@link Double}) - Rotation of the wave.</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public class WaveParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.RADIUS, 1D)
            .setOption(ParticleOption.DENSITY, 1)
            .setOption(ParticleOption.HEIGHT, 1D)
            .setOption(ParticleOption.ROTATION, 1D);

    @NotNull
    @Override
    public List<Vector> render(@NotNull Location startingLocation) {
        List<Vector> points = new ArrayList<>();

        double radius = options.getDoubleOption("radius");
        int density = options.getIntegerOption("density");
        double height = options.getDoubleOption("height");
        double rotation = options.getDoubleOption("rotation");

        for (int i = 0; i < density; i++) {
            double angle = (2 * Math.PI * i) / density;
            double x = radius * Math.cos(angle);
            double z = radius * Math.sin(angle);

            Vector point = new Vector(x, height, z);
            points.add(point);
        }

        return points;
    }

    @Override
    public @NotNull ParticleOptions getOptions() {
        return options;
    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return options.getAllOptions();
    }
}

