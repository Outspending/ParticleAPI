package me.outspending.particleapi;

import me.outspending.particleapi.particles.GradientParticleType;
import me.outspending.particleapi.particles.NormalParticleType;
import me.outspending.particleapi.particles.TransitionParticleType;

/**
 * Represents a particle type.
 *
 * @see CustomParticle
 * @see me.outspending.particleapi.renderer.Renderer
 * @since 1.0
 */
@Deprecated
public enum Particle {

    /**
     * Represents a normal particle type.
     * <p>
     * This particle type is just a normal bukkit particle type with extra functionality,
     * to allow for more customization.
     *
     * @since 1.0
     */
    NORMAL(new NormalParticleType(null)),

    /**
     * Represents a transition particle type.
     * <p>
     * This particle is used to transition between two colors
     *
     * @since 1.0
     */
    TRANSITION(new TransitionParticleType(false)),

    /**
     * Represents a gradient particle type.
     * <p>
     * This particle type is used to render a gradient of any shape
     *
     * @since 1.0
     */
    GRADIENT(new GradientParticleType());

    private final CustomParticle particle;

    Particle(CustomParticle particle) {
        this.particle = particle;
    }

    public CustomParticle getParticle() {
        return particle;
    }
}
