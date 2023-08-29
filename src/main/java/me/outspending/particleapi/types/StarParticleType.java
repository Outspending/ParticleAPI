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
 * Represents a particle type that renders as a star.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a star-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Short}) - The radius of the star</li>
 *     <li>{@code density} ({@link Short}) - The density of the star</li>
 *     <li>{@code rotationX} ({@link Short}) - The rotation of the star on the X axis</li>
 *     <li>{@code rotationY} ({@link Short}) - The rotation of the star on the Y axis</li>
 *     <li>{@code rotationZ} ({@link Short}) - The rotation of the star on the Z axis</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
@RequiresType
@RequiresOptions
public class StarParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.RADIUS, (short) 1)
            .setOption(ParticleOption.DENSITY, (short) 1)
            .setOption(ParticleOption.ROTATION_X, (short) 0)
            .setOption(ParticleOption.ROTATION_Y, (short) 0)
            .setOption(ParticleOption.ROTATION_Z, (short) 0);

    @NotNull
    @Override
    public List<Vector> render() {

        short radius = options.getShortOption(ParticleOption.RADIUS);
        short density = options.getShortOption(ParticleOption.HEIGHT);
        short rotationX = options.getShortOption(ParticleOption.ROTATION_X);
        short rotationY = options.getShortOption(ParticleOption.ROTATION_Y);
        short rotationZ = options.getShortOption(ParticleOption.ROTATION_Z);

        int particlePoints = density * 2;
        double angleIncrement = Math.toRadians(360.0 / particlePoints);

        // TODO: Please for the love of god improve this
        List<Vector> points = new ArrayList<>();
        for (int i = 0; i < particlePoints; i++) {
            double angle = i * angleIncrement;

            double x = Math.cos(angle + Math.toRadians(rotationX)) * radius;
            double z = Math.sin(angle + Math.toRadians(rotationZ)) * radius;

            double rotatedX = x * Math.cos(Math.toRadians(rotationY)) + z * Math.sin(Math.toRadians(rotationY));
            double rotatedZ = -x * Math.sin(Math.toRadians(rotationY)) + z * Math.cos(Math.toRadians(rotationY));

            points.add(new Vector(rotatedX, 0, rotatedZ));

            if (i % 2 == 0) {
                double innerRadius = radius / 2.0;
                double innerX = Math.cos(angle + angleIncrement / 2 + Math.toRadians(rotationX)) * innerRadius;
                double innerZ = Math.sin(angle + angleIncrement / 2 + Math.toRadians(rotationZ)) * innerRadius;

                double rotatedInnerX = innerX * Math.cos(Math.toRadians(rotationY)) + innerZ * Math.sin(Math.toRadians(rotationY));
                double rotatedInnerZ = -innerX * Math.sin(Math.toRadians(rotationY)) + innerZ * Math.cos(Math.toRadians(rotationY));

                points.add(new Vector(rotatedInnerX, 0, rotatedInnerZ));
            }
        }

        return points;
    }

    @Override
    public @NotNull ParticleOptions getOptions() {
        return options;
    }

}
