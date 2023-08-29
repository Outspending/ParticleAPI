package org.particleapi.benchmarks;

import me.outspending.particleapi.custom.CustomParticle;
import me.outspending.particleapi.custom.CustomParticleType;
import me.outspending.particleapi.ParticleOption;
import me.outspending.particleapi.renderer.ParticleRenderer;
import me.outspending.particleapi.types.CircleParticleType;
import org.bukkit.Particle;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 1, warmups = 2)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class RenderBenchmark {

    @Param({ "100", "200", "300", "400", "500", "600", "700", "800", "900", "1000" })
    public int num;

    private final ParticleRenderer renderer = CustomParticleType.builder(new CircleParticleType())
            .particleType(CustomParticle.normal(Particle.CLOUD, false))
            .build();

    @Benchmark
    public void builderTest() {
        CustomParticleType.builder(new CircleParticleType())
                .particleType(CustomParticle.normal(Particle.CLOUD, false))
                .build();
    }

    @Benchmark
    public void optionsTest() {
        renderer.editOption(ParticleOption.RADIUS, num);
    }
}
