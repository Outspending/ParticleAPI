package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Represents a particle type that renders as a sphere.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a sphere-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Double}) - The radius of the sphere</li>
 *     <li>{@code density} ({@link Integer}) - The density of the sphere</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public class SphereParticleType implements CustomParticleType<SphereParticleType> {

    private final ParticleOptions<SphereParticleType> options = new ParticleOptions<SphereParticleType>()
            .setOption("radius", 1D)
            .setOption("density", 1);

    @Override
    public void render(@NotNull Location startingLocation) {

    }

    @Override
    public @NotNull ParticleOptions<SphereParticleType> getOptions() {
        return options;
    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return options.getAllOptions();
    }

}
