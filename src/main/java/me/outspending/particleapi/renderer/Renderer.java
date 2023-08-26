package me.outspending.particleapi.renderer;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.CustomRenderer;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * The main renderer class.
 * <p>
 * Used to render {@link CustomParticleType}s. This class is not meant to be used directly.
 * <p>
 * To render a particle, use {@link CustomParticleType#render(Location)}.
 *
 * @since 1.0
 */
public final class Renderer {

    public static void renderType(@NotNull Location location, @NotNull CustomParticleType<?> type, @NotNull ParticleOptions<?> options) {
        if (!hasAllRequiredOptions(type)) return;

        List<Vector> points = getAllPoints(type);
        for (Vector point : points)
            type.render(location.add(point));
    }

    public static <T extends ParticleRenderer> void renderClass(@NotNull Location location, @NotNull Class<T> clazz) {

    }

    public static <T extends ParticleRenderer> void renderClass(@NotNull Location location, @NotNull Class<T> clazz, @NotNull ParticleOptions<?> options) {

    }

    public static void renderCustom(@NotNull CustomRenderer renderer) {

    }

    private static List<Vector> getAllPoints(@NotNull CustomParticleType<?> type) {
        return null;
    }

    private static <T extends CustomParticleType<?>> boolean hasAllRequiredOptions(@NotNull CustomParticleType<T> type) {
        ParticleOptions<T> options = type.getOptions();
        for (String option : type.getRequiredOptions()) {
            if (!options.hasOption(option)) return false;
        }
        return true;
    }


}
