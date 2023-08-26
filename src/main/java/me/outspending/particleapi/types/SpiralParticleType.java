package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Represents a particle type that renders as a spiral.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a spiral-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Double}) - The radius of the spiral</li>
 *     <li>{@code density} ({@link Integer}) - The density of the spiral</li>
 *     <li>{@code height} ({@link Double}) - The height of the spiral</li>
 *     <li>{@code rotation} ({@link Double}) - The rotation of the spiral</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public class SpiralParticleType implements CustomParticleType<SpiralParticleType> {

    private final ParticleOptions<SpiralParticleType> options = new ParticleOptions<SpiralParticleType>()
            .setOption("radius", 1D)
            .setOption("density", 1)
            .setOption("height", 1D)
            .setOption("rotation", 1D);

    @Override
    public void render(@NotNull Location startingLocation) {

    }

    @Override
    public @NotNull ParticleOptions<SpiralParticleType> getOptions() {
        return options;
    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return options.getAllOptions();
    }

}
