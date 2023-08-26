package me.outspending.particleapi.renderer;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.CustomRenderer;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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

    /**
     * Gets all points from a particle type using {@link CustomParticleType#render(Location)}.
     *
     * @since 1.0
     * @param startingLocation
     * @param type
     * @return List
     */
    private static List<Vector> getAllPoints(@NotNull Location startingLocation, @NotNull CustomParticleType<?> type) {
        return type.render(startingLocation);
    }

    /**
     * This checks if all required options are present in the {@link ParticleOptions}.
     * <p>
     * This is deprecated and will be removed in the future. Because each {@link CustomParticleType} has its own required options,
     * and no longer needs to be looped though this method, this will automatically be done and doesn't need to be checked.
     *
     * @since 1.0
     * @param type
     * @return boolean
     * @param <T>
     */
    @Deprecated(forRemoval = true)
    private static <T extends CustomParticleType<?>> boolean hasAllRequiredOptions(@NotNull CustomParticleType<T> type) {
        ParticleOptions<T> options = type.getOptions();
        for (String option : type.getRequiredOptions()) {
            if (!options.hasOption(option)) return false;
        }
        return true;
    }

    /**
     * Renders a particle type at the specified location. This will render the particle type with the options given.
     * <p>
     * This will be rendered synchronously. To render asynchronously, use {@link #renderTypeAsync(Location, CustomParticleType, ParticleOptions)}.
     *
     * @since 1.0
     * @param location
     * @param type
     * @param options
     */
    public static void renderType(@NotNull Location location, @NotNull CustomParticleType<?> type, @NotNull ParticleOptions<?> options) {
        if (!hasAllRequiredOptions(type)) return;

        List<Vector> points = getAllPoints(location, type);
        for (Vector point : points)
            type.render(location.add(point));
    }

    /**
     * Renders a particle type at the specified location. This will render the particle type with the options given.
     * <p>
     * This will be rendered asynchronously. To render synchronously, use {@link #renderType(Location, CustomParticleType, ParticleOptions)}.
     * Remember, this will not be rendered on the main thread, so you cannot modify anything with the {@link ParticleRenderer}.
     * This feature is experimental and may not work as expected.
     *
     * @since 1.0
     * @param location
     * @param type
     * @param options
     * @return CompletableFuture
     */
    @ApiStatus.Experimental
    public static CompletableFuture<Void> renderTypeAsync(@NotNull Location location, @NotNull CustomParticleType<?> type, @NotNull ParticleOptions<?> options) {
        return CompletableFuture.runAsync(() -> renderType(location, type, options));
    }

    /**
     * Renders a particle type at the specified location. This will render the particle type with the options given.
     * <p>
     * This will be rendered synchronously. To render asynchronously, use {@link #renderClassAsync(Location, Class)}.
     * <p>
     * This method will parse the class then execute it, this can cause issues, I recommend using
     * {@link #renderType(Location, CustomParticleType, ParticleOptions)} instead. This method is only here for convenience.
     *
     * @since 1.0
     * @param location
     * @param clazz
     */
    public static <T extends ParticleRenderer> void renderClass(@NotNull Location location, @NotNull Class<T> clazz) {

    }

    /**
     * Renders a particle type at the specified location. This will render the particle type with the options given.
     * <p>
     * This method will parse the class then execute it, this can cause issues, I recommend using
     * {@link #renderType(Location, CustomParticleType, ParticleOptions)} instead. This method is only here for convenience.
     * <p>
     * This will be rendered asynchronously. To render synchronously, use {@link #renderClass(Location, Class)}.
     * Remember, this will not be rendered on the main thread, so you cannot modify anything with the {@link ParticleRenderer}.
     * This feature is experimental and may not work as expected.
     *
     * @since 1.0
     * @param location
     * @param clazz
     * @return CompletableFuture
     */
    @ApiStatus.Experimental
    public static <T extends ParticleRenderer> CompletableFuture<Void> renderClassAsync(@NotNull Location location, @NotNull Class<T> clazz) {
        return CompletableFuture.runAsync(() -> renderClass(location, clazz));
    }

    /**
     * Renders a particle type at the specified location. This will render the particle type with the options given.
     * <p>
     * This will be rendered synchronously. To render asynchronously, use {@link #renderCustomAsync(CustomRenderer)}.
     *
     * @since 1.0
     * @param location
     * @param clazz
     * @param options
     */
    public static <T extends ParticleRenderer> void renderClass(@NotNull Location location, @NotNull Class<T> clazz, @NotNull ParticleOptions<?> options) {

    }

    /**
     * Renders a particle type at the specified location. This will render the particle type with the options given.
     * <p>
     * This will be rendered asynchronously. To render synchronously, use {@link #renderCustom(CustomRenderer)}.
     * Remember, this will not be rendered on the main thread, so you cannot modify anything with the {@link ParticleRenderer}.
     * This feature is experimental and may not work as expected.
     *
     * @since 1.0
     * @param location
     * @param clazz
     * @param options
     * @return CompletableFuture
     */
    @ApiStatus.Experimental
    public static <T extends ParticleRenderer> CompletableFuture<Void> renderClassAsync(@NotNull Location location, @NotNull Class<T> clazz, @NotNull ParticleOptions<?> options) {
        return CompletableFuture.runAsync(() -> renderClass(location, clazz, options));
    }

    /**
     * Renders a particle type at the specified location. This will render the particle type with the options given.
     * <p>
     * This will be rendered synchronously. To render asynchronously, use {@link #renderCustomAsync(CustomRenderer)}.
     *
     * @since 1.0
     * @param renderer
     */
    public static void renderCustom(@NotNull CustomRenderer renderer) {

    }

    /**
     * Renders a particle type at the specified location. This will render the particle type with the options given.
     * <p>
     * This will be rendered asynchronously. To render synchronously, use {@link #renderCustom(CustomRenderer)}.
     * Remember, this will not be rendered on the main thread, so you cannot modify anything with the {@link ParticleRenderer}.
     * This feature is experimental and may not work as expected.
     *
     * @since 1.0
     * @param renderer
     * @return CompletableFuture
     */
    @ApiStatus.Experimental
    public static CompletableFuture<Void> renderCustomAsync(@NotNull CustomRenderer renderer) {
        return CompletableFuture.runAsync(() -> renderCustom(renderer));
    }

}
