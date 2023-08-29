package me.outspending.particleapi.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Used to specify that a method requires {@link me.outspending.particleapi.ParticleOptions}.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresOptions {
}
