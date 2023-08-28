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
 * Represents a particle type that renders as a line.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a line-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code length} ({@link Double}) - The length of the line</li>
 *     <li>{@code rotationX} ({@link Double}) - The rotation of the line on the X axis</li>
 *     <li>{@code rotationY} ({@link Double}) - The rotation of the line on the Y axis</li>
 *     <li>{@code rotationZ} ({@link Double}) - The rotation of the line on the Z axis</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public class LineParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.LENGTH, 1D)
            .setOption(ParticleOption.ROTATION_X, 0D)
            .setOption(ParticleOption.ROTATION_Y, 0D)
            .setOption(ParticleOption.ROTATION_Z, 0D);

    @NotNull
    @Override
    public List<Vector> render(@NotNull Location startingLocation) {

        double length = options.getDoubleOption(ParticleOption.LENGTH);
        double rotationX = options.getDoubleOption(ParticleOption.ROTATION_X);
        double rotationY = options.getDoubleOption(ParticleOption.ROTATION_Y);
        double rotationZ = options.getDoubleOption(ParticleOption.ROTATION_Z);

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

    @Override
    public @NotNull List<ParticleOption> getRequiredOptions() {
        return options.getAllOptions();
    }

}
