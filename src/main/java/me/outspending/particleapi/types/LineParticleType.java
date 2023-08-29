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
 * Represents a particle type that renders as a line.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a line-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code length} ({@link Short}) - The length of the line</li>
 *     <li>{@code rotationX} ({@link Short}) - The rotation of the line on the X axis</li>
 *     <li>{@code rotationY} ({@link Short}) - The rotation of the line on the Y axis</li>
 *     <li>{@code rotationZ} ({@link Short}) - The rotation of the line on the Z axis</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
@RequiresType
@RequiresOptions
public class LineParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.LENGTH, (short) 1)
            .setOption(ParticleOption.ROTATION_X, (short) 0)
            .setOption(ParticleOption.ROTATION_Y, (short) 0)
            .setOption(ParticleOption.ROTATION_Z, (short) 0);

    @NotNull
    @Override
    public List<Vector> render() {

        short length = options.getShortOption(ParticleOption.LENGTH);
        short rotationX = options.getShortOption(ParticleOption.ROTATION_X);
        short rotationY = options.getShortOption(ParticleOption.ROTATION_Y);
        short rotationZ = options.getShortOption(ParticleOption.ROTATION_Z);

        List<Vector> points = new ArrayList<>();
        Vector direction = new Vector(0, 0, 1).rotateAroundAxis(new Vector(1, 0, 0), rotationX)
                .rotateAroundAxis(new Vector(0, 1, 0), rotationY)
                .rotateAroundAxis(new Vector(0, 0, 1), rotationZ);

        for (double t = 0; t <= length; t += 0.1)
            points.add(direction.clone().multiply(t));

        return points;
    }

    @Override
    public @NotNull ParticleOptions getOptions() {
        return options;
    }

}
