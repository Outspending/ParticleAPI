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

    /**
     * Renders a particle effect at the specified location.
     * <p>
     * This uses vectors to get all points to render an {@link CustomParticleType},
     *
     * @param startingLocation
     * @since 1.0
     */
    void render(@NotNull Location startingLocation);

    /**
     * Gets the options for the particle type.
     * <p>
     * This is used to define the required options for the particle type.
     * And add new options if you'd like.
     *
     * @since 1.0
     * @return
     */
    @NotNull ParticleOptions<T> getOptions();

    /**
     * Gets the required options for the particle type.
     * <p>
     * This is used to define the required options for the particle type.
     * If one of the required options is not present, the particle effect
     * will not render. This is used to prevent errors from occurring.
     *
     * @since 1.0
     * @return
     */
    @NotNull List<String> getRequiredOptions();

}
