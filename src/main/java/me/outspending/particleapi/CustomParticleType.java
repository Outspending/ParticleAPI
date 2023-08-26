package me.outspending.particleapi;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Represents a custom particle type.
 * <p>
 * This interface is used to create custom particle types that can be rendered using the
 * {@link me.outspending.particleapi.renderer.ParticleRenderer}. Custom particle types are
 * used to define the shape of the particle effect. For example, a spiral particle type
 * would render a spiral-shaped particle effect. Custom particle types are also used to
 * define the required options for the particle effect. For example, a spiral particle
 * type would require the radius, density, height, and rotation options.
 *
 * @param <T>
 * @since 1.0
 */
public interface CustomParticleType<T extends CustomParticleType<?>> {

    void render(@NotNull Location startingLocation);

    @NotNull ParticleOptions<T> getOptions();

    @NotNull List<String> getRequiredOptions();

}
