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
            .setOption(ParticleOption.DENSITY, 100)
            .setOption(ParticleOption.HEIGHT, 5D)
            .setOption(ParticleOption.ROTATION, 0D);

    @NotNull
    @Override
    public List<Vector> render(@NotNull Location startingLocation) {

        int density = options.getIntegerOption(ParticleOption.DENSITY);
        double height = options.getDoubleOption(ParticleOption.HEIGHT);
        double rotation = options.getDoubleOption(ParticleOption.ROTATION);

        double xRotation = Math.toRadians(rotation);

        List<Vector> points = new ArrayList<>();
        for (double i = 0; i < density; i += 0.1) {
            double angle = Math.sin(i) * height;

            double y = angle * Math.cos(xRotation) - i * Math.sin(xRotation);
            double z = angle * Math.sin(xRotation) + i * Math.cos(xRotation);

            points.add(new Vector(0, y, z));
        }

        return points;
    }

    @Override
    public @NotNull ParticleOptions getOptions() {
        return options;
    }

    @Override
    public @NotNull List<ParticleOption> getRequiredOptions() {
        return options.getAllOptions();
    }
}

