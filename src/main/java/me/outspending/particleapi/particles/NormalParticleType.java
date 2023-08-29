package me.outspending.particleapi.particles;

import me.outspending.particleapi.custom.CustomParticle;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Normal particle type.
 * <p>
 * Used to render a normal particle using {@link me.outspending.particleapi.renderer.ParticleRenderer}.
 *
 * @see CustomParticle
 * @see me.outspending.particleapi.renderer.Renderer
 * @since 1.0
 */
public class NormalParticleType implements CustomParticle {

    private final Particle particle;
    private final boolean force;

    public NormalParticleType(Particle particle, boolean force) {
        this.particle = particle;
        this.force = force;
    }

    public NormalParticleType(Particle particle) {
        this(particle, false);
    }

    public Particle getParticle() {
        return particle;
    }

    @Override
    public void spawn(@NotNull Location location, @NotNull Player player) {
        player.spawnParticle(particle, location, 1, 0, 0, 0, (this.force ? 1 : 0), null);
    }

}
