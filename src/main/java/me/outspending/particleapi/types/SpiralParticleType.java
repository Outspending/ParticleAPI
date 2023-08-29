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
 * Represents a particle type that renders as a spiral.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a spiral-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Short}) - The radius of the spiral</li>
 *     <li>{@code density} ({@link Short}) - The density of the spiral</li>
 *     <li>{@code height} ({@link Long}) - The height of the spiral</li>
 *     <li>{@code rotationX} ({@link Short}) - The rotation of the spiral on the X axis</li>
 *     <li>{@code rotationY} ({@link Short}) - The rotation of the spiral on the Y axis</li>
 *     <li>{@code rotationZ} ({@link Short}) - The rotation of the spiral on the Z axis</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
@RequiresType
@RequiresOptions
public class SpiralParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.RADIUS, (short) 5)
            .setOption(ParticleOption.DENSITY, (short) 360)
            .setOption(ParticleOption.HEIGHT, 25L)
            .setOption(ParticleOption.ROTATION_X, (short) 0)
            .setOption(ParticleOption.ROTATION_Y, (short) 0)
            .setOption(ParticleOption.ROTATION_Z, (short) 0);

    @NotNull
    @Override
    public List<Vector> render() {

        short radius = options.getShortOption(ParticleOption.RADIUS);
        short density = options.getShortOption(ParticleOption.DENSITY);
        long height = options.getLongOption(ParticleOption.HEIGHT);
        short rotationX = options.getShortOption(ParticleOption.ROTATION_X);
        short rotationY = options.getShortOption(ParticleOption.ROTATION_Y);
        short rotationZ = options.getShortOption(ParticleOption.ROTATION_Z);

        double angleIncrement = Math.toRadians(360.0 / density);
        double heightIncrement = (double) height / density;

        List<Vector> points = new ArrayList<>();
        for (int i = 0; i < density; i++) {
            double angle = i * angleIncrement;
            double y = i * heightIncrement / 5;

            double x = Math.cos(angle + Math.toRadians(rotationX)) * radius;
            double z = Math.sin(angle + Math.toRadians(rotationZ)) * radius;

            double rotatedX = x * Math.cos(Math.toRadians(rotationY)) + z * Math.sin(Math.toRadians(rotationY));
            double rotatedZ = -x * Math.sin(Math.toRadians(rotationY)) + z * Math.cos(Math.toRadians(rotationY));

            points.add(new Vector(rotatedX, y, rotatedZ));
        }

        return points;
    }

    @Override
    public @NotNull ParticleOptions getOptions() {
        return options;
    }

}
