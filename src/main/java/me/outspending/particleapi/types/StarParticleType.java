package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a particle type that renders as a star.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a star-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Double}) - The radius of the star</li>
 *     <li>{@code density} ({@link Integer}) - The density of the star</li>
 *     <li>{@code rotation} ({@link Double}) - The rotation of the star</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public class StarParticleType implements CustomParticleType<StarParticleType> {

    private final ParticleOptions<StarParticleType> options = new ParticleOptions<StarParticleType>()
            .setOption("radius", 1D)
            .setOption("density", 1)
            .setOption("rotation", 1D);

    @NotNull
    @Override
    public List<Vector> render(@NotNull Location startingLocation) {
        List<Vector> points = new ArrayList<>();

        double radius = options.getDoubleOption("radius");
        int density = options.getIntegerOption("density");
        double rotation = options.getDoubleOption("rotation");

        int particlePoints = density * 2;
        double angleIncrement = Math.toRadians(360.0 / particlePoints);

        for (int i = 0; i < particlePoints; i++) {
            double angle = i * angleIncrement;
            double x = Math.cos(angle + rotation) * radius;
            double z = Math.sin(angle + rotation) * radius;

            Vector particlePoint = new Vector(x, 0, z).add(startingLocation.toVector());
            points.add(particlePoint);

            if (i % 2 == 0) {
                double innerRadius = radius / 2.0;
                double innerX = Math.cos(angle + angleIncrement / 2 + rotation) * innerRadius;
                double innerZ = Math.sin(angle + angleIncrement / 2 + rotation) * innerRadius;

                Vector innerParticlePoint = new Vector(innerX, 0, innerZ).add(startingLocation.toVector());
                points.add(innerParticlePoint);
            }
        }

        return points;
    }

    @Override
    public @NotNull ParticleOptions<StarParticleType> getOptions() {
        return options;
    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return options.getAllOptions();
    }

}
