package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOption;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Represents a particle type that renders as a sphere.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a sphere-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Double}) - The radius of the sphere</li>
 *     <li>{@code density} ({@link Integer}) - The density of the sphere</li>
 *     <li>{@code hollow} ({@link Boolean}) - Whether or not the sphere is hollow</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public class SphereParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.RADIUS, 1D)
            .setOption(ParticleOption.DENSITY, 1)
            .setOption(ParticleOption.HOLLOW, true);

    @NotNull
    @Override
    public List<Vector> render(@NotNull Location startingLocation) {
        List<Vector> particlePoints = new ArrayList<>();

        double radius = options.getDoubleOption("radius");
        int density = options.getIntegerOption("density");
        boolean hollow = options.getBooleanOption("hollow");

        int points = (int) (4 * Math.PI * radius * radius * density);
        double phiIncrement = Math.PI * (3 - Math.sqrt(5));

        for (int i = 0; i < points; i++) {
            double y = 1 - (i / (double) (points - 1)) * 2;
            double radiusAtY = Math.sqrt(1 - y * y) * radius;

            double theta = i * phiIncrement;

            double x = Math.cos(theta) * radiusAtY;
            double z = Math.sin(theta) * radiusAtY;

            if (hollow || y > 0) {
                Vector particlePoint = new Vector(x, y * radius, z).add(startingLocation.toVector());
                particlePoints.add(particlePoint);
            }
        }

        return particlePoints;
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
