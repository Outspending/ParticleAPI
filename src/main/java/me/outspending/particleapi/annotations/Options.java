package me.outspending.particleapi.annotations;

import me.outspending.particleapi.CustomParticleType;
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

}
