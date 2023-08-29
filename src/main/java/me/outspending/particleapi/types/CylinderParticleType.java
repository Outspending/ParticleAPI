package me.outspending.particleapi.types;

import me.outspending.particleapi.annotations.RequiresOptions;
import me.outspending.particleapi.annotations.RequiresType;
import me.outspending.particleapi.custom.CustomParticleType;
import me.outspending.particleapi.ParticleOption;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a particle type that renders as a cylinder.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a cylinder-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Short}) - The radius of the cylinder</li>
 *     <li>{@code height} ({@link Long}) - The height of the cylinder</li>
 *     <li>{@code density} ({@link Short}) - The density of the cylinder</li>
 *     <li>{@code hollow} ({@link Boolean}) - Whether or not the cylinder is hollow</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
@RequiresType
@RequiresOptions
public class CylinderParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.RADIUS, (short) 1)
            .setOption(ParticleOption.HEIGHT, 1L)
            .setOption(ParticleOption.DENSITY, (short) 1)
            .setOption(ParticleOption.HOLLOW, true);

    @NotNull
    @Override
    public List<Vector> render() {

        short radius = options.getShortOption(ParticleOption.RADIUS);
        long height = options.getLongOption(ParticleOption.HEIGHT);
        short density = options.getShortOption(ParticleOption.DENSITY);
        boolean hollow = options.getBooleanOption(ParticleOption.HOLLOW);

        List<Vector> particleOffsets = new ArrayList<>();
        for (int i = 0; i < density; i++) {
            double angle = 2 * Math.PI * i / density;
            double x = radius * Math.cos(angle);
            double z = radius * Math.sin(angle);

            if (hollow) {
                particleOffsets.add(new Vector(x, 0, z));
                particleOffsets.add(new Vector(x, height, z));
            } else {
                for (double yOffset = 0; yOffset < height; yOffset += height / density) {
                    particleOffsets.add(new Vector(x, yOffset, z));
                }
            }
        }

        return particleOffsets;
    }

    @Override
    public @NotNull ParticleOptions getOptions() {
        return options;
    }

}
