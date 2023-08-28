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
 * Represents a particle type that renders as a helix.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a helix-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Double}) - The radius of the helix</li>
 *     <li>{@code height} ({@link Double}) - The height of the helix</li>
 *     <li>{@code density} ({@link Integer}) - The density of the helix</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public class HelixParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.RADIUS, 1D)
            .setOption(ParticleOption.HEIGHT, 1D)
            .setOption(ParticleOption.DENSITY, 1);

    @NotNull
    @Override
    public List<Vector> render(@NotNull Location startingLocation) {

        double radius = options.getDoubleOption(ParticleOption.RADIUS);
        double height = options.getDoubleOption(ParticleOption.HEIGHT);
        int density = options.getIntegerOption(ParticleOption.DENSITY);

        List<Vector> points = new ArrayList<>();
        for (int i = 0; i <= 360 * density; i++) {
            double angle = Math.toRadians(i / (double) density);

            double x = radius * Math.cos(angle);
            double y = angle * height / (2 * Math.PI);
            double z = radius * Math.sin(angle);

            points.add(new Vector(x, y, z));
        }

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
