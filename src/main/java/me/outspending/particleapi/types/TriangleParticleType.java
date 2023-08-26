package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a particle type that renders as a triangle.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a triangle-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Double}) - The radius of the triangle</li>
 *     <li>{@code density} ({@link Integer}) - The density of the triangle</li>
 *     <li>{@code height} ({@link Double}) - The height of the triangle</li>
 *     <li>{@code rotation} ({@link Double}) - The rotation of the triangle</li>
 *     <li>{@code hollow} ({@link Boolean}) - Whether or not the triangle is hollow</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public class TriangleParticleType implements CustomParticleType<TriangleParticleType> {

    private final ParticleOptions<TriangleParticleType> options = new ParticleOptions<TriangleParticleType>()
            .setOption("radius", 1D)
            .setOption("density", 1)
            .setOption("height", 1D)
            .setOption("rotation", 1D)
            .setOption("hollow", false);

    @NotNull
    @Override
    public List<Vector> render(@NotNull Location startingLocation) {
        List<Vector> points = new ArrayList<>();

        double radius = options.getDoubleOption("radius");
        int density = options.getIntegerOption("density");
        double height = options.getDoubleOption("height");
        double rotation = options.getDoubleOption("rotation");
        boolean hollow = options.getBooleanOption("hollow");

        int particlePoints = density * 3;
        double angleIncrement = Math.toRadians(360.0 / particlePoints);

        for (int i = 0; i < particlePoints; i++) {
            double angle = i * angleIncrement;
            double x = Math.cos(angle + rotation) * radius;
            double z = Math.sin(angle + rotation) * radius;

            double y = startingLocation.getY() + height;

            Vector particlePoint = new Vector(x, y, z).add(startingLocation.toVector());
            points.add(particlePoint);

            if (!hollow || i % 3 != 0) {
                Vector nextPoint;
                if (i == particlePoints - 1) {
                    nextPoint = points.get(0);
                } else {
                    nextPoint = points.get(i + 1);
                }
                Vector midPoint = particlePoint.clone().midpoint(nextPoint);
                points.add(midPoint);
            }
        }

        return points;

    }

    @Override
    public @NotNull ParticleOptions<TriangleParticleType> getOptions() {
        return options;
    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return options.getAllOptions();
    }

}
