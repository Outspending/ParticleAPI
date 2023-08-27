package me.outspending.particleapi.renderer;

import me.outspending.particleapi.CustomParticle;
import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.CustomRenderer;
import me.outspending.particleapi.ParticleOptions;
import me.outspending.particleapi.particles.ParticleHandler;
import me.outspending.particleapi.particles.ParticleHandlerImpl;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
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
public sealed class Renderer permits ParticleRenderer {

    /**
     * Gets all points from a particle type using {@link CustomParticleType#render(Location)}.
     *
     * @since 1.0
     * @param startingLocation
     * @param type
     * @return List
     */
    protected List<Vector> getAllPoints(@NotNull Location startingLocation, @NotNull CustomParticleType type) {
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
     */
    @Deprecated(forRemoval = true)
    protected boolean hasAllRequiredOptions(@NotNull CustomParticleType type) {
        ParticleOptions options = type.getOptions();
        for (String option : type.getRequiredOptions()) {
            if (!options.hasOption(option)) return false;
        }
        return true;
    }

    /**
     * Renders a particle type at the specified location. This will render the particle type with the options given.
     * <p>
     * This will be rendered synchronously. To render asynchronously, use {@link #renderTypeAsync(Location, CustomParticleType, CustomParticle)}.
     *
     * @since 1.0
     * @param location
     * @param type
     * @param particle
     */
    protected void renderType(@NotNull Location location, @NotNull CustomParticleType type, @NotNull CustomParticle particle) {
        List<Vector> points = getAllPoints(location, type);
        ParticleHandler handler = ParticleHandler.of();

        for (Vector point : points) {
            Location loc = location.clone().add(point);
            handler.sendParticle(loc, particle);
        }
    }

    /**
     * Renders a particle type at the specified location. This will render the particle type with the options given.
     * <p>
     * This will be rendered asynchronously. To render synchronously, use {@link #renderType(Location, CustomParticleType, CustomParticle)}.
     * Remember, this will not be rendered on the main thread, so you cannot modify anything with the {@link ParticleRenderer}.
     * This feature is experimental and may not work as expected.
     *
     * @since 1.0
     * @param location
     * @param type
     * @param particle
     * @return CompletableFuture
     */
    @ApiStatus.Experimental
    protected CompletableFuture<Void> renderTypeAsync(@NotNull Location location, @NotNull CustomParticleType type, @NotNull CustomParticle particle) {
        return CompletableFuture.runAsync(() -> renderType(location, type, particle));
    }

    /**
     * Renders a particle type at the specified location. This will render the particle type with the options given.
     * <p>
     * This will be rendered synchronously. To render asynchronously, use {@link #renderClassAsync(Location, Class)}.
     * <p>
     * This method will parse the class then execute it, this can cause issues, I recommend using
     * {@link #renderType(Location, CustomParticleType, CustomParticle)} instead. This method is only here for convenience.
     *
     * @since 1.0
     * @param location
     * @param clazz
     */
    protected <T extends ParticleRenderer> void renderClass(@NotNull Location location, @NotNull Class<T> clazz) {

    }

    /**
     * Renders a particle type at the specified location. This will render the particle type with the options given.
     * <p>
     * This method will parse the class then execute it, this can cause issues, I recommend using
     * {@link #renderType(Location, CustomParticleType, CustomParticle)} instead. This method is only here for convenience.
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
    protected <T extends ParticleRenderer> CompletableFuture<Void> renderClassAsync(@NotNull Location location, @NotNull Class<T> clazz) {
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
    protected <T extends ParticleRenderer> void renderClass(@NotNull Location location, @NotNull Class<T> clazz, @NotNull ParticleOptions options) {

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
    protected <T extends ParticleRenderer> CompletableFuture<Void> renderClassAsync(@NotNull Location location, @NotNull Class<T> clazz, @NotNull ParticleOptions options) {
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
    protected void renderCustom(@NotNull CustomRenderer renderer) {

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
    protected CompletableFuture<Void> renderCustomAsync(@NotNull CustomRenderer renderer) {
        return CompletableFuture.runAsync(() -> renderCustom(renderer));
    }

}
