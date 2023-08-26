package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Represents a particle type that renders as a cylinder.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a cylinder-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Double}) - The radius of the cylinder</li>
 *     <li>{@code height} ({@link Double}) - The height of the cylinder</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public class CylinderParticleType implements CustomParticleType<CylinderParticleType> {

    private final ParticleOptions<CylinderParticleType> options = new ParticleOptions<CylinderParticleType>()
            .setOption("radius", 1D)
            .setOption("height", 1D);

    @Override
    public void render(@NotNull Location startingLocation) {

    }

    @Override
    public @NotNull ParticleOptions<CylinderParticleType> getOptions() {
        return options;
    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return options.getAllOptions();
    }

}
