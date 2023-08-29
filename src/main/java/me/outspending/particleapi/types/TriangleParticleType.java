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
 * Represents a particle type that renders as a triangle.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a triangle-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Short}) - The radius of the triangle</li>
 *     <li>{@code density} ({@link Short}) - The density of the triangle</li>
 *     <li>{@code height} ({@link Long}) - The height of the triangle</li>
 *     <li>{@code rotationX} ({@link Short}) - The rotation of the triangle on the X axis</li>
 *     <li>{@code rotationY} ({@link Short}) - The rotation of the triangle on the Y axis</li>
 *     <li>{@code rotationZ} ({@link Short}) - The rotation of the triangle on the Z axis</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
@RequiresType
@RequiresOptions
public class TriangleParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.RADIUS, (short) 1)
            .setOption(ParticleOption.DENSITY, (short) 1)
            .setOption(ParticleOption.HEIGHT, 1L)
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

        List<Vector> points = new ArrayList<>();

        double angleIncrement = Math.toRadians(360.0 / density);

        // TODO: CHATGPT CMON WHAT IS THIS DO BETTER
        for (int i = 0; i < density; i++) {
            double angle = i * angleIncrement;

            double rotatedX = Math.cos(angle + rotationY) * (Math.cos(rotationZ) * radius);
            double rotatedY = Math.sin(rotationX) * (Math.sin(angle + rotationY) * (Math.cos(rotationZ) * radius))
                    + Math.cos(rotationX) * (height)
                    - Math.sin(rotationX) * (Math.cos(angle + rotationY) * (Math.sin(rotationZ) * radius));
            double rotatedZ = Math.cos(rotationX) * (Math.sin(angle + rotationY) * (Math.cos(rotationZ) * radius))
                    - Math.sin(rotationX) * (height)
                    + Math.cos(rotationX) * (Math.cos(angle + rotationY) * (Math.sin(rotationZ) * radius));

            points.add(new Vector(rotatedX, rotatedY, rotatedZ));
        }

        return points;
    }

    @Override
    public @NotNull ParticleOptions getOptions() {
        return options;
    }

}
