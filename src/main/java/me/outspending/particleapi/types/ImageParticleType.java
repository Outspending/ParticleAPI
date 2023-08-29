package me.outspending.particleapi.types;

import me.outspending.particleapi.annotations.RequiresOptions;
import me.outspending.particleapi.annotations.RequiresType;
import me.outspending.particleapi.custom.CustomParticleType;
import me.outspending.particleapi.ParticleOption;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.util.Vector;
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
 *     <li>{@code width} ({@link Long}) - The width of the image</li>
 *     <li>{@code height} ({@link Long}) - The height of the image</li>
 *     <li>{@code rotationX} ({@link Short}) - The rotation of the image on the X axis</li>
 *     <li>{@code rotationY} ({@link Short}) - The rotation of the image on the Y axis</li>
 *     <li>{@code rotationZ} ({@link Short}) - The rotation of the image on the Z axis</li>
 *     <li>{@code pixelSize} ({@link Byte}) - The size of the pixel (Particle)</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
@RequiresType
@RequiresOptions
public class ImageParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.IMAGE, "")
            .setOption(ParticleOption.WIDTH, 1L)
            .setOption(ParticleOption.HEIGHT, 1L)
            .setOption(ParticleOption.ROTATION_X, (short) 0)
            .setOption(ParticleOption.ROTATION_Y, (short) 0)
            .setOption(ParticleOption.ROTATION_Z, (short) 0)
            .setOption(ParticleOption.PIXEL_SIZE, (byte) 1);

    @NotNull
    @Override
    public List<Vector> render() {
        return null;
    }

    @Override
    public @NotNull ParticleOptions getOptions() {
        return options;
    }

}
