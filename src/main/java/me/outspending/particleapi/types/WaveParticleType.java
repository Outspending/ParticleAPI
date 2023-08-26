package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

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
public class WaveParticleType implements CustomParticleType<WaveParticleType> {

    private final ParticleOptions<WaveParticleType> options = new ParticleOptions<WaveParticleType>()
            .setOption("radius", 1D)
            .setOption("density", 1)
            .setOption("height", 1D)
            .setOption("rotation", 1D);

    @Override
    public void render(@NotNull Location startingLocation) {
        // Implementation of the rendering logic
    }

    @Override
    public @NotNull ParticleOptions<WaveParticleType> getOptions() {
        return options;
    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return options.getAllOptions();
    }
}

