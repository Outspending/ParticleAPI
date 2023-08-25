package me.outspending.particleapi;

import me.outspending.particleapi.particles.GradientParticleType;
import me.outspending.particleapi.particles.NormalParticleType;
import me.outspending.particleapi.particles.TransitionParticleType;

public enum Particle {
    NORMAL(new NormalParticleType()),
    TRANSITION(new TransitionParticleType()),
    GRADIENT(new GradientParticleType());

    private final CustomParticle particle;

    Particle(CustomParticle particle) {
        this.particle = particle;
    }

    public CustomParticle getParticle() {
        return particle;
    }
}
