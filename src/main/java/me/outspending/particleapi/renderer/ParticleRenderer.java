package me.outspending.particleapi.renderer;

import me.outspending.particleapi.Particle;
import me.outspending.particleapi.ParticleOptions;
import me.outspending.particleapi.ParticleType;
import org.bukkit.Location;
import org.jetbrains.annotations.ApiStatus;

import java.util.concurrent.CompletableFuture;

/**
 * Represents a particle renderer.
 * <p>
 * This class is made for rendering advanced particle effects. This class can be extended to create custom particle.
 *
 * @since 1.0
 */
public class ParticleRenderer {

    private Location location;
    private ParticleType type;
    private Particle particle;
    private ParticleOptions<? extends ParticleType> options;

    /**
     * This is deprecated and will be removed in the future.
     * This has been moved to {@link Renderer} class.
     *
     * @deprecated This is deprecated and will be removed in the future.
     */
    @Deprecated(forRemoval = true)
    public void render() {
        type.getType().render(location);
    }

    /**
     * This is deprecated and will be removed in the future.
     * This has been moved to {@link Renderer} class.
     *
     * @deprecated This is deprecated and will be removed in the future.
     * @return
     */
    @Deprecated(forRemoval = true)
    public CompletableFuture<Void> renderAsync() {
        return CompletableFuture.runAsync(this::render);
    }

    /**
     * Gets called when each particle is rendered. This can be used to modify how the particle is rendered / get current particle.
     * This can cause performance issues if used incorrectly, and can cause errors.
     *
     * @see Renderer
     */
    public void onRender() {};

    /**
     * Is called when the render of the {@link ParticleType} begins. Here you can retrieve the {@link ParticleOptions}
     * and the {@link Particle} that is being rendered. This can be used to modify the {@link ParticleOptions} or the
     * {@link Particle} before the render begins.
     *
     * @see Renderer
     */
    public void onRenderStart() {};

    /**
     * Is called when the render of the {@link ParticleType} ends. Here you can retrieve the {@link ParticleOptions}
     * and the {@link Particle} that has been rendered. You cannot modify the {@link ParticleOptions} or the
     * {@link Particle} at this point.
     *
     * @see Renderer
     */
    public void onRenderEnd() {};
}
