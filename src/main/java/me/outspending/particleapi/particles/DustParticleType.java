package me.outspending.particleapi.particles;

import me.outspending.particleapi.CustomParticle;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Dust particle type.
 * <p>
 * Used to render a dust particle using {@link me.outspending.particleapi.renderer.ParticleRenderer}.
 *
 * @see CustomParticle
 * @see me.outspending.particleapi.renderer.Renderer
 * @since 1.0
 */
public class DustParticleType implements CustomParticle {

    private final Particle particle = Particle.REDSTONE;

    private final Particle.DustOptions options;

    public DustParticleType(@NotNull Color color, int size) {
        options = new Particle.DustOptions(color, size);
    }

    public DustParticleType(@NotNull Color color) {
        this(color, 1);
    }

    @Override
    public void spawn(@NotNull Location location, @NotNull Player player) {
        player.spawnParticle(particle, location, 1, 0, 0, 0, 0, options);
    }
}
