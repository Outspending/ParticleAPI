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
 * Represents a particle type that renders as a cylinder.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a cylinder-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Double}) - The radius of the cylinder</li>
 *     <li>{@code height} ({@link Double}) - The height of the cylinder</li>
 *     <li>{@code density} ({@link Integer}) - The density of the cylinder</li>
 *     <li>{@code hollow} ({@link Boolean}) - Whether or not the cylinder is hollow</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public class CylinderParticleType implements CustomParticleType<CylinderParticleType> {

    private final ParticleOptions<CylinderParticleType> options = new ParticleOptions<CylinderParticleType>()
            .setOption("radius", 1D)
            .setOption("height", 1D)
            .setOption("density", 1)
            .setOption("hollow", true);

    @NotNull
    @Override
    public List<Vector> render(@NotNull Location startingLocation) {
        double radius = options.getDoubleOption("radius");
        double height = options.getDoubleOption("height");
        int density = options.getIntegerOption("density");
        boolean hollow = options.getBooleanOption("hollow");

        List<Vector> particleOffsets = new ArrayList<>();

        for (int i = 0; i < density; i++) {
            double angle = 2 * Math.PI * i / density;
            double x = radius * Math.cos(angle);
            double z = radius * Math.sin(angle);

            if (hollow) {
                particleOffsets.add(new Vector(x, 0, z));
                particleOffsets.add(new Vector(x, height, z));
            } else {
                for (double yOffset = 0; yOffset < height; yOffset += height / density) {
                    particleOffsets.add(new Vector(x, yOffset, z));
                }
            }
        }

        List<Vector> particleLocations = new ArrayList<>();
        for (Vector offset : particleOffsets) {
            particleLocations.add(startingLocation.clone().add(offset).toVector());
        }

        return particleLocations;
    }

    @Override
    public @NotNull ParticleOptions<CylinderParticleType> getOptions() {
        return options;
    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return options.getAllOptions();
    }

}
