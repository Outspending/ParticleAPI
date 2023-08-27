package me.outspending.particleapi.particles;

import me.outspending.particleapi.CustomParticle;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.function.Predicate;

/**
 * Represents a handler for sending particles to players.
 *
 * @since 1.0
 * @see ParticleHandlerImpl
 * @see me.outspending.particleapi.renderer.Renderer
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 */
public interface ParticleHandler {

    /**
     * Returns a new instance of {@link ParticleHandler}.
     *
     * @since 1.0
     * @see ParticleHandlerImpl
     * @return ParticleHandler
     */
    static ParticleHandler of() {
        return new ParticleHandlerImpl();
    }

    /**
     * Sends a particle to all players.
     *
     * @since 1.0
     * @param location
     * @param particle
     */
    void sendParticle(@NotNull Location location, @NotNull CustomParticle particle);

    /**
     * Sends a particle to a player.
     *
     * @since 1.0
     * @param location
     * @param player
     * @param particle
     */
    void sendParticle(@NotNull Location location, @NotNull Player player, @NotNull CustomParticle particle);

    /**
     * Sends a particle to a set of players.
     *
     * @since 1.0
     * @param location
     * @param players
     * @param particle
     */
    void sendParticle(@NotNull Location location, @NotNull Set<Player> players, @NotNull CustomParticle particle);

    /**
     * Sends a particle to all players that match the predicate.
     *
     * @since 1.0
     * @param location
     * @param particle
     * @param predicate
     */
    void sendParticle(@NotNull Location location, @NotNull CustomParticle particle, @NotNull Predicate<Player> predicate);

}
