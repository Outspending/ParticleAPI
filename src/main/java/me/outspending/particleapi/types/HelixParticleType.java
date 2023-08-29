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
 * Represents a particle type that renders as a helix.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a helix-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code radius} ({@link Short}) - The radius of the helix</li>
 *     <li>{@code height} ({@link Long}) - The height of the helix</li>
 *     <li>{@code density} ({@link Short}) - The density of the helix</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
@RequiresType
@RequiresOptions
public class HelixParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.RADIUS, (short) 1)
            .setOption(ParticleOption.HEIGHT, 1L)
            .setOption(ParticleOption.DENSITY, (short) 1);

    @NotNull
    @Override
    public List<Vector> render() {

        short radius = options.getShortOption(ParticleOption.RADIUS);
        long height = options.getLongOption(ParticleOption.HEIGHT);
        short density = options.getShortOption(ParticleOption.DENSITY);

        List<Vector> points = new ArrayList<>();
        for (int i = 0; i <= 360 * density; i++) {
            double angle = Math.toRadians(i / (double) density);

            double x = radius * Math.cos(angle);
            double y = angle * height / (2 * Math.PI);
            double z = radius * Math.sin(angle);

            points.add(new Vector(x, y, z));
        }

        return points;
    }

    @Override
    public @NotNull ParticleOptions getOptions() {
        return options;
    }

}
