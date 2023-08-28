package me.outspending.particleapi.renderer;

import me.outspending.particleapi.*;
import org.bukkit.Location;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * Represents a particle renderer.
 * <p>
 * This class is made for rendering advanced particle effects. This class can be extended to create custom particle.
 *
 * @since 1.0
 */
public non-sealed class ParticleRenderer extends Renderer {

    private final CustomParticleType type;
    private final ParticleOptions options;
    private final CustomParticle particle;

    private final Consumer<CustomParticle> onRender;
    private final Consumer<CustomParticle> onRenderStart;
    private final Consumer<CustomParticle> onRenderFinish;

    /**
     * Constructs a new {@link ParticleRenderer}.
     *
     * @since 1.0
     * @param type
     * @param options
     * @param particle
     * @param onRender
     * @param onRenderStart
     * @param onRenderFinish
     */
    public ParticleRenderer(@NotNull CustomParticleType type, @NotNull ParticleOptions options, CustomParticle particle,
                            Consumer<CustomParticle> onRender, Consumer<CustomParticle> onRenderStart, Consumer<CustomParticle> onRenderFinish) {
        this.type = type;
        this.options = options;
        this.particle = particle;
        this.onRender = onRender;
        this.onRenderStart = onRenderStart;
        this.onRenderFinish = onRenderFinish;
    }

    /**
     * Constructs a new {@link ParticleRenderer}.
     *
     * @since 1.0
     * @param type
     * @param options
     * @param particle
     */
    public ParticleRenderer(@NotNull CustomParticleType type, @NotNull ParticleOptions options, @NotNull CustomParticle particle) {
        this(type, options, particle, null, null, null);
    }

    /**
     * Edits an option from {@link ParticleOptions}, this method edits an existing option,
     * if this option doesn't exist this method will do nothing.
     *
     * @since 1.0
     * @param option
     * @param value
     */
    public void editOption(@NotNull ParticleOption option, @NotNull Object value) {
        options.editOption(option, value);
    }

    /**
     * Used to render a {@link CustomParticleType} synchronously.
     * <p>
     * This will render the particle effect synchronously.
     *
     * @since 1.0
     * @see CustomParticleType
     * @see Renderer
     */
    public void render(@NotNull Location location) {
        renderType(location, type, particle, onRender, onRenderStart, onRenderFinish);
    }

    /**
     * This will render the particle effect asynchronously.
     *
     * @since 1.0
     * @return CompletableFuture
     */
    public CompletableFuture<Void> renderAsync(@NotNull Location location) {
        return renderTypeAsync(location, type, particle, onRender, onRenderStart, onRenderFinish);
    }

    /**
     * Renders a {@link CustomParticleType} synchronously.
     * <p>
     * Will render the particle effect for a specified amount of time.
     *
     * @since 1.0
     * @see CustomParticleType
     * @see Renderer
     */
    public void renderTimed(@NotNull Location location, @NotNull TimeUnit time, int delay) {
        renderTimed(location, type, particle, delay, time, onRender, onRenderStart, onRenderFinish);
    }

    /**
     * Renders a {@link CustomParticleType} asynchronously.
     * <p>
     * Will render the particle effect for a specified amount of time.
     *
     * @since 1.0
     * @see CustomParticleType
     * @see Renderer
     */
    public void renderTimedAsync(@NotNull Location location, @NotNull TimeUnit time, int delay) {
        renderTimedAsync(location, type, particle, delay, time, onRender, onRenderStart, onRenderFinish);
    }

    /**
     * Renders multiple {@link CustomParticleType}s synchronously.
     * <p>
     * Be careful with this, this can cause lag to the server / client.
     * This is also experimental, so it may not work as expected / cause bugs.
     *
     * @since 1.0
     * @param location
     * @param rendererSet
     */
    @ApiStatus.Experimental
    public void renderMultiple(@NotNull Location location, Set<ParticleRenderer> rendererSet) {
        for (ParticleRenderer renderer : rendererSet)
            renderer.render(location);
    }

    /**
     * Renders multiple {@link CustomParticleType}s asynchronously.
     * <p>
     * Be careful with this, this can cause lag to the server / client.
     * This is also experimental, so it may not work as expected / cause bugs.
     *
     * @since 1.0
     * @param location
     * @param rendererSet
     * @return CompletableFuture
     */
    @ApiStatus.Experimental
    public void renderMultipleAsync(@NotNull Location location, Set<ParticleRenderer> rendererSet) {
        for (ParticleRenderer renderer : rendererSet)
            renderer.renderAsync(location);
    }

}
