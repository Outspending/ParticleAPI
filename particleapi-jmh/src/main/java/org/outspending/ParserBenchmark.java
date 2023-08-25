package org.outspending;

import me.outspending.particleapi.Particle;
import me.outspending.particleapi.renderer.ParticleRenderer;
import me.outspending.particleapi.ParticleType;
import me.outspending.particleapi.annotations.Options;
import me.outspending.particleapi.annotations.ParticleConstruct;

@ParticleConstruct(type = ParticleType.CIRCLE, particle = Particle.GRADIENT)
@Options(maxParticles = 10000)
public class ParserBenchmark extends ParticleRenderer {

    @Override
    public void onRender() {
        super.onRender();
    }

    @Override
    public void onRenderEnd() {
        super.onRenderEnd();
    }

}
