package me.outspending.particleapi.renderer;

import me.outspending.particleapi.annotations.RequiresOptions;
import me.outspending.particleapi.annotations.RequiresType;
import me.outspending.particleapi.custom.CustomParticle;
import me.outspending.particleapi.custom.CustomParticleType;
import me.outspending.particleapi.particles.ParticleHandler;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

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
     * The particle handler. Re
     */
    protected static final ParticleHandler handler = ParticleHandler.of();

    /**
     * Gets all points from a particle type using {@link CustomParticleType#render()}.
     *
     * @since 1.0
     * @param type
     * @return List
     */
    protected List<Vector> getAllPoints(@NotNull CustomParticleType type) {
        return type.render();
    }

    /**
     * Renders a particle type at the specified location. This will render the particle type with the options given.
     * <p>
     * This will be rendered synchronously. To render asynchronously, use {@link #renderTypeAsync(Location, CustomParticleType, CustomParticle, Consumer, Consumer, Consumer)}.
     *
     * @since 1.0
     * @param location
     * @param type
     * @param particle
     */
    @RequiresType
    protected void renderType(@NotNull Location location, @NotNull CustomParticleType type, @NotNull CustomParticle particle,
                              Consumer<CustomParticle> onRender, Consumer<CustomParticle> onRenderStart, Consumer<CustomParticle> onRenderFinish) {
        List<Vector> points = getAllPoints(type);

        for (Vector point : points) {
            Location loc = location.clone().add(point);
            handler.sendParticle(loc, particle);
        }
    }

    /**
     * Renders a particle type at the specified location. This will render the particle type with the options given.
     * <p>
     * This will be rendered asynchronously. To render synchronously, use {@link #renderType(Location, CustomParticleType, CustomParticle, Consumer, Consumer, Consumer)}.
     * Remember, this will not be rendered on the main thread, so you cannot modify anything with the {@link ParticleRenderer}.
     * This feature is experimental and may not work as expected.
     *
     * @since 1.0
     * @param location
     * @param type
     * @param particle
     * @return CompletableFuture
     */
    @RequiresType
    @ApiStatus.Experimental
    protected CompletableFuture<Void> renderTypeAsync(@NotNull Location location, @NotNull CustomParticleType type, @NotNull CustomParticle particle,
                                                      Consumer<CustomParticle> onRender, Consumer<CustomParticle> onRenderStart, Consumer<CustomParticle> onRenderFinish) {
        return CompletableFuture.runAsync(() -> renderType(location, type, particle, onRender, onRenderStart, onRenderFinish));
    }

    /**
     * Renders a particle type at the specified location. This will render the particle type with the options given.
     * <p>
     * This will be rendered synchronously. To render asynchronously, use {@link #renderTypeAsync(Location, CustomParticleType, CustomParticle, Consumer, Consumer, Consumer)}.
     *
     * @since 1.0
     * @param location
     * @param type
     * @param particle
     */
    @RequiresType
    protected void renderTimed(@NotNull Location location, @NotNull CustomParticleType type, @NotNull CustomParticle particle, long delay, @NotNull TimeUnit time,
                               Consumer<CustomParticle> onRender, Consumer<CustomParticle> onRenderStart, Consumer<CustomParticle> onRenderFinish) {
        long start = System.currentTimeMillis();
        long timeMillis = time.toMillis(delay);

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            renderType(location, type, particle, onRender, onRenderStart, onRenderFinish);

            if (System.currentTimeMillis() - start >= timeMillis) executor.shutdown();
        }, 120, 120, TimeUnit.MILLISECONDS);
    }

    /**
     * Renders a particle type at the specified location. This will render the particle type with the options given.
     * <p>
     * This will be rendered asynchronously. To render synchronously, use {@link #renderType(Location, CustomParticleType, CustomParticle, Consumer, Consumer, Consumer)}.
     * Remember, this will not be rendered on the main thread, so you cannot modify anything with the {@link ParticleRenderer}.
     * This feature is experimental and may not work as expected.
     *
     * @since 1.0
     * @param location
     * @param type
     * @param particle
     * @return CompletableFuture
     */
    @RequiresType
    protected CompletableFuture<Void> renderTimedAsync(@NotNull Location location, @NotNull CustomParticleType type, @NotNull CustomParticle particle, long delay, @NotNull TimeUnit time,
                                                        Consumer<CustomParticle> onRender, Consumer<CustomParticle> onRenderStart, Consumer<CustomParticle> onRenderFinish) {
        return CompletableFuture.runAsync(() -> renderTimed(location, type, particle, delay, time, onRender, onRenderStart, onRenderFinish));
    }

}
