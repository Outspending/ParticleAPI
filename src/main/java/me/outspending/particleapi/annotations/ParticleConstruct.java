package me.outspending.particleapi.annotations;

import me.outspending.particleapi.Particle;
import me.outspending.particleapi.ParticleOptions;
import me.outspending.particleapi.ParticleType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ParticleConstruct {

    ParticleType type();

    Particle particle();
}
