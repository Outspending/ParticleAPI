package me.outspending.particleapi;

import me.outspending.particleapi.particles.NormalParticleType;
import me.outspending.particleapi.particles.TransitionParticleType;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
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
     * Returns a new instance of {@link NormalParticleType}.
     *
     * @since 1.0
     * @param particle
     * @param force
     * @return
     */
    static NormalParticleType normal(@NotNull Particle particle, boolean force) {
        return new NormalParticleType(particle, force);
    }

    /**
     * Returns a new instance of {@link TransitionParticleType}.
     *
     * @since 1.0
     * @param force
     * @param options
     * @return
     */
    static TransitionParticleType transition(boolean force, Particle.DustTransition options) {
        return new TransitionParticleType(force, options);
    }

    /**
     * Spawns a particle at the specified location.
     *
     * @param location
     */
    void spawn(@NotNull Location location, @NotNull Player player);

}
