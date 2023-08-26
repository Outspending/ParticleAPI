package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Represents a particle type that renders as an image.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display an image-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code image} ({@link String}) - The image to render</li>
 *     <li>{@code width} ({@link Double}) - The width of the image</li>
 *     <li>{@code height} ({@link Double}) - The height of the image</li>
 *     <li>{@code rotationX} ({@link Double}) - The rotation of the image on the X axis</li>
 *     <li>{@code rotationY} ({@link Double}) - The rotation of the image on the Y axis</li>
 *     <li>{@code rotationZ} ({@link Double}) - The rotation of the image on the Z axis</li>
 *     <li>{@code pixelSize} ({@link Integer}) - The size of the pixel (Particle)</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public class ImageParticleType implements CustomParticleType<ImageParticleType> {

    private final ParticleOptions<ImageParticleType> options = new ParticleOptions<ImageParticleType>()
            .setOption("image", "")
            .setOption("width", 1D)
            .setOption("height", 1D)
            .setOption("rotationX", 0D)
            .setOption("rotationY", 0D)
            .setOption("rotationZ", 0D)
            .setOption("pixelSize", 1);

    @Override
    public void render(@NotNull Location startingLocation) {

    }

    @Override
    public @NotNull ParticleOptions<ImageParticleType> getOptions() {
        return options;
    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return options.getAllOptions();
    }

}
