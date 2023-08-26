package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Represents a particle type that renders as a triangle.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a triangle-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Double}) - The radius of the triangle</li>
 *     <li>{@code density} ({@link Integer}) - The density of the triangle</li>
 *     <li>{@code height} ({@link Double}) - The height of the triangle</li>
 *     <li>{@code rotation} ({@link Double}) - The rotation of the triangle</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public class TriangleParticleType implements CustomParticleType<TriangleParticleType> {

    private final ParticleOptions<TriangleParticleType> options = new ParticleOptions<TriangleParticleType>()
            .setOption("radius", 1D)
            .setOption("density", 1)
            .setOption("height", 1D)
            .setOption("rotation", 1D);

    @Override
    public void render(@NotNull Location startingLocation) {

    }

    @Override
    public @NotNull ParticleOptions<TriangleParticleType> getOptions() {
        return options;
    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return options.getAllOptions();
    }

}
