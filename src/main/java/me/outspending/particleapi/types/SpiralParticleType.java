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
 * Represents a particle type that renders as a spiral.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a spiral-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Double}) - The radius of the spiral</li>
 *     <li>{@code density} ({@link Integer}) - The density of the spiral</li>
 *     <li>{@code height} ({@link Double}) - The height of the spiral</li>
 *     <li>{@code rotation} ({@link Double}) - The rotation of the spiral</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public class SpiralParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.RADIUS, 1D)
            .setOption(ParticleOption.DENSITY, 1)
            .setOption(ParticleOption.HEIGHT, 1D)
            .setOption(ParticleOption.ROTATION, 1D);

    @NotNull
    @Override
    public List<Vector> render(@NotNull Location startingLocation) {

        double radius = options.getDoubleOption(ParticleOption.RADIUS);
        int density = options.getIntegerOption(ParticleOption.DENSITY);
        double height = options.getDoubleOption(ParticleOption.HEIGHT);
        double rotation = options.getDoubleOption(ParticleOption.ROTATION);

        double angleIncrement = Math.toRadians(360.0 / density);
        double heightIncrement = height / density;

        List<Vector> points = new ArrayList<>();
        for (int i = 0; i < density; i++) {
            double angle = i * angleIncrement;
            double y = i * heightIncrement;

            double x = Math.cos(angle + rotation) * radius;
            double z = Math.sin(angle + rotation) * radius;

            points.add(new Vector(x, y, z));
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
