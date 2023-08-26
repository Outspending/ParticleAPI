package me.outspending.particleapi.annotations;

import org.jetbrains.annotations.Range;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Options annotation for {@link me.outspending.particleapi.renderer.ParticleRenderer} class.
 * This annotation is used to specify the options for the {@link me.outspending.particleapi.ParticleOptions}.
 *
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Options {

    int maxParticles() default 10000;

    @Range(from = 0, to = 360) int fromAngle() default 0;

    @Range(from = 0, to = 360) int toAngle() default 360;

    @Range(from = 0, to = 25) int particleDistance() default 1;

}
