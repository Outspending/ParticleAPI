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
@RequiresType
@RequiresOptions
public class WaveParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.DENSITY, (short) 100)
            .setOption(ParticleOption.HEIGHT, 5L)
            .setOption(ParticleOption.ROTATION_X, (short) 0)
            .setOption(ParticleOption.ROTATION_Y, (short) 0)
            .setOption(ParticleOption.ROTATION_Z, (short) 0);

    @NotNull
    @Override
    public List<Vector> render() {

        short density = options.getShortOption(ParticleOption.DENSITY);
        long height = options.getLongOption(ParticleOption.HEIGHT);
        short rotationX = options.getShortOption(ParticleOption.ROTATION_X);
        short rotationY = options.getShortOption(ParticleOption.ROTATION_Y);
        short rotationZ = options.getShortOption(ParticleOption.ROTATION_Z);

        List<Vector> points = new ArrayList<>();
        for (double i = 0; i < density; i += 0.1) {
            double angle = Math.sin(i) * height;

            double rotatedY = angle * Math.cos(rotationX) - i * Math.sin(rotationX);
            double rotatedZ = angle * Math.sin(rotationX) + i * Math.cos(rotationX);

            double finalY = rotatedY * Math.cos(rotationZ) - rotatedZ * Math.sin(rotationZ);
            double finalZ = rotatedY * Math.sin(rotationZ) + rotatedZ * Math.cos(rotationZ);

            double rotatedX = finalY * Math.cos(rotationY) - finalZ * Math.sin(rotationY);
            double finalX = finalY * Math.sin(rotationY) + finalZ * Math.cos(rotationY);

            points.add(new Vector(finalX, finalY, finalZ));
        }

        return points;
    }

    @Override
    public @NotNull ParticleOptions getOptions() {
        return options;
    }

}

