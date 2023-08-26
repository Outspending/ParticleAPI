package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Represents a particle type that renders as a line.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a line-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code length} ({@link Double}) - The length of the line</li>
 *     <li>{@code rotationX} ({@link Double}) - The rotation of the line on the X axis</li>
 *     <li>{@code rotationY} ({@link Double}) - The rotation of the line on the Y axis</li>
 *     <li>{@code rotationZ} ({@link Double}) - The rotation of the line on the Z axis</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public class LineParticleType implements CustomParticleType<LineParticleType> {

    private final ParticleOptions<LineParticleType> options = new ParticleOptions<LineParticleType>()
            .setOption("length", 1D)
            .setOption("rotationX", 0D)
            .setOption("rotationY", 0D)
            .setOption("rotationZ", 0D);

    @Override
    public void render(@NotNull Location startingLocation) {

    }

    @Override
    public @NotNull ParticleOptions<LineParticleType> getOptions() {
        return options;
    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return options.getAllOptions();
    }

}
