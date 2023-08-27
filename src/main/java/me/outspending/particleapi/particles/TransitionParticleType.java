package me.outspending.particleapi.particles;

import me.outspending.particleapi.CustomParticle;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Transition particle type.
 * <p>
 * Used to render a transition particle using {@link me.outspending.particleapi.renderer.ParticleRenderer}.
 *
 * @see CustomParticle
 * @see me.outspending.particleapi.renderer.Renderer
 * @since 1.0
 */
public class TransitionParticleType implements CustomParticle {

    private final Particle particle = Particle.DUST_COLOR_TRANSITION;

    private final boolean force;
    private final Particle.DustTransition options;

    public TransitionParticleType(boolean force, Particle.DustTransition options) {
        this.force = force;
        this.options = options;
    }

    public TransitionParticleType(boolean force, Color color1, Color color2) {
        this(force, new Particle.DustTransition(color1, color2, 1));
    }

    public TransitionParticleType(boolean force, Color color1, Color color2, int size) {
        this(force, new Particle.DustTransition(color1, color2, size));
    }

    public TransitionParticleType(boolean force) {
        this(force, new Particle.DustTransition(Color.RED, Color.BLUE, 1));
    }

    @Override
    public void spawn(@NotNull Location location, @NotNull Player player) {
        player.spawnParticle(particle, location, 1, 0, 0, 0, (this.force ? 1 : 0), options);
    }

}
