package me.outspending.particleapi.renderer;

import me.outspending.particleapi.*;
import org.bukkit.Location;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
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

    private final Consumer<CustomParticle> onRender;
    private final Consumer<CustomParticle> onRenderComplete;
    private final Consumer<CustomParticle> onRenderFinish;

    /**
     * Constructs a new {@link ParticleRenderer}.
     *
     * @since 1.0
     * @param type
     * @param options
     * @param onRender
     * @param onRenderComplete
     * @param onRenderFinish
     */
    public ParticleRenderer(@NotNull CustomParticleType type, @NotNull ParticleOptions options, Consumer<CustomParticle> onRender,
                            Consumer<CustomParticle> onRenderComplete, Consumer<CustomParticle> onRenderFinish) {
        this.type = type;
        this.options = options;
        this.onRender = onRender;
        this.onRenderComplete = onRenderComplete;
        this.onRenderFinish = onRenderFinish;
    }

    /**
     * Constructs a new {@link ParticleRenderer}.
     *
     * @since 1.0
     * @param type
     * @param startingLocation
     * @param options
     */
    public ParticleRenderer(@NotNull CustomParticleType type, @NotNull ParticleOptions options) {
        this(type, options, null, null, null);
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
    public void render(Location location) {
        renderType(location, type, options);
    }

    /**
     * This is deprecated and will be removed in the future.
     * This has been moved to {@link Renderer} class.
     *
     * @since 1.0
     * @deprecated This is deprecated and will be removed in the future.
     * @return CompletableFuture
     */
    @Deprecated(forRemoval = true)
    public CompletableFuture<Void> renderAsync(Location location) {
        return CompletableFuture.runAsync(() -> renderType(location, type, options));
    }

}
