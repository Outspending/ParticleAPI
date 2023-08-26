package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
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
public class LineParticleType implements CustomParticleType<LineParticleType> {

    private final ParticleOptions<LineParticleType> options = new ParticleOptions<LineParticleType>()
            .setOption("length", 1D)
            .setOption("rotationX", 0D)
            .setOption("rotationY", 0D)
            .setOption("rotationZ", 0D);

    @NotNull
    @Override
    public List<Vector> render(@NotNull Location startingLocation) {
        double length = options.getDoubleOption("length");
        double rotationX = options.getDoubleOption("rotationX");
        double rotationY = options.getDoubleOption("rotationY");
        double rotationZ = options.getDoubleOption("rotationZ");

        List<Vector> points = new ArrayList<>();
        Vector direction = new Vector(0, 0, 1).rotateAroundAxis(new Vector(1, 0, 0), rotationX)
                .rotateAroundAxis(new Vector(0, 1, 0), rotationY)
                .rotateAroundAxis(new Vector(0, 0, 1), rotationZ);

        for (double t = 0; t <= length; t += 0.1) {
            Vector point = direction.clone().multiply(t).add(startingLocation.toVector());
            points.add(point);
        }

        return points;
    }

    @Override
    public @NotNull ParticleOptions<LineParticleType> getOptions() {
        return options;
    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return options.getAllOptions();
    }

}
