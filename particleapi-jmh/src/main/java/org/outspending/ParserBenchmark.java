package org.outspending;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.Particle;
import me.outspending.particleapi.ParticleOptions;
import me.outspending.particleapi.renderer.ParticleRenderer;
import me.outspending.particleapi.ParticleType;
import me.outspending.particleapi.annotations.Options;
import me.outspending.particleapi.annotations.ParticleConstruct;

@ParticleConstruct(type = ParticleType.CIRCLE, particle = Particle.GRADIENT)
@Options
public class ParserBenchmark extends ParticleRenderer {

    @Override
    public ParticleOptions<? extends CustomParticleType<?>> getOptions() {
        return null;
    }

    @Override
    public void onRender() {
        super.onRender();
    }

    @Override
    public void onRenderStart() {
        super.onRenderStart();
    }

    @Override
    public void onRenderEnd() {
        super.onRenderEnd();
    }

}
