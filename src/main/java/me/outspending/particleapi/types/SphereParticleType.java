package me.outspending.particleapi.types;

import me.outspending.particleapi.annotations.RequiresOptions;
import me.outspending.particleapi.annotations.RequiresType;
import me.outspending.particleapi.custom.CustomParticleType;
import me.outspending.particleapi.ParticleOption;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a particle type that renders as a sphere.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a sphere-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Short}) - The radius of the sphere</li>
 *     <li>{@code density} ({@link Short}) - The density of the sphere</li>
 *     <li>{@code hollow} ({@link Boolean}) - Whether or not the sphere is hollow</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
@RequiresType
@RequiresOptions
public class SphereParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.RADIUS, (short) 1)
            .setOption(ParticleOption.DENSITY, (short) 1)
            .setOption(ParticleOption.HOLLOW, true);

    @NotNull
    @Override
    public List<Vector> render() {

        short radius = options.getShortOption(ParticleOption.RADIUS);
        short density = options.getShortOption(ParticleOption.DENSITY);
        boolean hollow = options.getBooleanOption(ParticleOption.HOLLOW);

        int points = (int) (4 * Math.PI * radius * radius * density);
        double phiIncrement = Math.PI * (3 - Math.sqrt(5));

        List<Vector> particlePoints = new ArrayList<>();
        for (int i = 0; i < points; i++) {
            double y = 1 - (i / (double) (points - 1)) * 2;
            double radiusAtY = Math.sqrt(1 - y * y) * radius;

            double theta = i * phiIncrement;

            double x = Math.cos(theta) * radiusAtY;
            double z = Math.sin(theta) * radiusAtY;

            if (hollow) {
                particlePoints.add(new Vector(x, y * radius, z));
            } else if (y > 0) {
                particlePoints.add(new Vector(x, y * radius, z));
            }
        }

        return particlePoints;
    }

    @Override
    public @NotNull ParticleOptions getOptions() {
        return options;
    }

}
