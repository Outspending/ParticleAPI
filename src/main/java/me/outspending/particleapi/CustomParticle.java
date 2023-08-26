package me.outspending.particleapi;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a custom particle.
 * <p>
 * This interface is used to create custom particles that can be rendered using the
 * {@link me.outspending.particleapi.renderer.ParticleRenderer}.
 *
 * @since 1.0
 */
public interface CustomParticle {

    /**
     * Spawns a particle at the specified location.
     *
     * @param location
     */
    void spawn(@NotNull Location location);

}
