package me.outspending.particleapi.parser;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOptions;
import me.outspending.particleapi.annotations.Options;
import me.outspending.particleapi.renderer.ParticleRenderer;
import org.checkerframework.checker.units.qual.N;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Annotation;

public class RenderParser {

    public static <T extends ParticleRenderer> void parseClass(@NotNull Class<T> clazz) {

    }

    private static boolean hasAnnotation(@NotNull Class<? extends ParticleRenderer> clazz, @NotNull Class<? extends Annotation> annotation) {
        return clazz.isAnnotationPresent(annotation);
    }

    private static <T extends CustomParticleType> @Nullable ParticleOptions parseOptions(@NotNull Class<? extends ParticleRenderer> clazz) {
        if (!hasAnnotation(clazz, Options.class)) return null;

        Options options = clazz.getAnnotation(Options.class);

        return null;
    }
}
