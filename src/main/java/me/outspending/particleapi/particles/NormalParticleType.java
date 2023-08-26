package me.outspending.particleapi.particles;

import me.outspending.particleapi.CustomParticle;
import org.bukkit.Location;
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

    @Override
    public void spawn(@NotNull Location location) {

    }

}
