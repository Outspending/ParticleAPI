package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Represents a particle type that renders as a circle.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a circle-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Double}) - The radius of the circle</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */

public class CircleParticleType implements CustomParticleType<CircleParticleType> {

    private final ParticleOptions<CircleParticleType> options = new ParticleOptions<CircleParticleType>()
            .setOption("radius", 1D);

    @Override
    public void render(@NotNull Location startingLocation) {
        ParticleOptions<CircleParticleType> options = getOptions();

    }

    @Override
    public @NotNull ParticleOptions<CircleParticleType> getOptions() {
        return options;
    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return options.getAllOptions();
    }

}
