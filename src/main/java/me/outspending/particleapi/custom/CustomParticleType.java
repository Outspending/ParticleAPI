package me.outspending.particleapi.custom;

import com.google.common.base.Preconditions;
import me.outspending.particleapi.ParticleOption;
import me.outspending.particleapi.ParticleOptions;
import me.outspending.particleapi.ParticleType;
import me.outspending.particleapi.renderer.ParticleRenderer;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

/**
 * Represents a custom particle type.
 * <p>
 * This interface is used to create custom particle types that can be rendered using the
 * {@link me.outspending.particleapi.renderer.ParticleRenderer}. Custom particle types are
 * used to define the shape of the particle effect. For example, a spiral particle type
 * would render a spiral-shaped particle effect. Custom particle types are also used to
 * define the required options for the particle effect. For example, a spiral particle
 * type would require the radius, density, height, and rotation options.
 *
 * @since 1.0
 */
public interface CustomParticleType {

    /**
     * Constructs a new {@link Builder} for the specified {@link CustomParticleType}.
     *
     * @since 1.0
     * @param type
     * @return
     */
    static Builder builder(@NotNull ParticleType type) {
        return new Builder(type.getType());
    }

    /**
     * Renders a particle effect at the specified location.
     * <p>
     * This uses vectors to get all points to render an {@link CustomParticleType},
     *
     * @since 1.0
     */
    @NotNull List<Vector> render();

    /**
     * Gets the options for the particle type.
     * <p>
     * This is used to define the required options for the particle type.
     * And add new options if you'd like.
     *
     * @since 1.0
     * @return
     */
    @NotNull ParticleOptions getOptions();

    /**
     * Represents a builder for a custom particle type.
     * <p>
     * This is used to create custom particle types.
     *
     * @since 1.0
     */
    class Builder {

        private final ParticleOptions options;
        private final CustomParticleType type;

        private CustomParticle particle;
        private Consumer<CustomParticle> onRender;
        private Consumer<CustomParticle> onRenderStart;
        private Consumer<CustomParticle> onRenderEnd;

        public Builder(@NotNull CustomParticleType type) {
            this.type = type;
            options = type.getOptions();
        }

        public Builder editOption(@NotNull ParticleOption option, @NotNull Object value) {
            options.editOption(option, value);
            return this;
        }

        public Builder particleType(@NotNull CustomParticle particle) {
            this.particle = particle;
            return this;
        }

        public Builder onRender(@NotNull Consumer<CustomParticle> onRender) {
            this.onRender = onRender;
            return this;
        }

        public Builder onRenderStart(@NotNull Consumer<CustomParticle> onRenderStart) {
            this.onRenderStart = onRenderStart;
            return this;
        }

        public Builder onRenderEnd(@NotNull Consumer<CustomParticle> onRenderEnd) {
            this.onRenderEnd = onRenderEnd;
            return this;
        }

        public ParticleRenderer build() {
            Preconditions.checkNotNull(particle, "Particle type cannot be null");

            return new ParticleRenderer(type, options, particle, onRender, onRenderStart, onRenderEnd);
        }
    }

}
