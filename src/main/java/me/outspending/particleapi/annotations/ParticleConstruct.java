package me.outspending.particleapi.annotations;

import me.outspending.particleapi.Particle;
import me.outspending.particleapi.ParticleOptions;
import me.outspending.particleapi.ParticleType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to specify the {@link ParticleType} and the {@link Particle} for the {@link me.outspending.particleapi.renderer.Renderer}.
 * This annotation is required for a {@link me.outspending.particleapi.renderer.ParticleRenderer} to be parsed.
 *
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ParticleConstruct {

    ParticleType type();

    Particle particle();
}
