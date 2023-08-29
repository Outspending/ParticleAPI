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
 * Represents a particle type that renders as a cube.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a cube-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code size} ({@link Byte}) - The size of the cube</li>
 *     <li>{@code rotationX} ({@link Short}) - The rotation of the cube on the X axis</li>
 *     <li>{@code rotationY} ({@link Short}) - The rotation of the cube on the Y axis</li>
 *     <li>{@code rotationZ} ({@link Short}) - The rotation of the cube on the Z axis</li>
 *     <li>{@code density} ({@link Short}) - The density of the cube</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
@RequiresType
@RequiresOptions
public class CubeParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.SIZE, (byte) 1)
            .setOption(ParticleOption.ROTATION_X, (short) 0)
            .setOption(ParticleOption.ROTATION_Y, (short) 0)
            .setOption(ParticleOption.ROTATION_Z, (short) 0)
            .setOption(ParticleOption.DENSITY, (short) 1);

    @NotNull
    @Override
    public List<Vector> render() {

        byte size = options.getByteOption(ParticleOption.SIZE);
        short rotationX = options.getShortOption(ParticleOption.ROTATION_X);
        short rotationY = options.getShortOption(ParticleOption.ROTATION_Y);
        short rotationZ = options.getShortOption(ParticleOption.ROTATION_Z);
        short density = options.getShortOption(ParticleOption.DENSITY);

        List<Vector> offsets = new ArrayList<>();
        for (int i = 0; i < density; i++) {
            double xOffset = Math.cos(rotationY + (i * 2 * Math.PI / density)) * size;
            double yOffset = Math.sin(rotationX + (i * 2 * Math.PI / density)) * size;
            double zOffset = Math.sin(rotationY + (i * 2 * Math.PI / density)) * size;

            offsets.add(new Vector(xOffset, yOffset, zOffset));
        }

        return offsets;
    }

    @Override
    public @NotNull ParticleOptions getOptions() {
        return options;
    }

}
