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
 *     <li>{@code hollow} ({@link Boolean}) - Whether or not the helix is hollow</li>
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
            .setOption(ParticleOption.DENSITY, 1)
            .setOption(ParticleOption.HOLLOW, true);

    @NotNull
    @Override
    public List<Vector> render(@NotNull Location startingLocation) {
        double radius = options.getDoubleOption("radius");
        double height = options.getDoubleOption("height");
        int density = options.getIntegerOption("density");
        boolean hollow = options.getBooleanOption("hollow");

        List<Vector> points = new ArrayList<>();

        for (int i = 0; i <= 360 * density; i++) {
            double angle = Math.toRadians(i / (double) density);
            double x = radius * Math.cos(angle);
            double z = radius * Math.sin(angle);

            double y = (hollow ? height / 2 : 0) + angle * height / (2 * Math.PI);
            points.add(startingLocation.clone().add(x, y, z).toVector());
        }

        return points;
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
