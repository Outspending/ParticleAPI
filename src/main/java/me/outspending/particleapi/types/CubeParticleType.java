package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOptions;
import org.bukkit.Location;
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
 *     <li>{@code size} ({@link Double}) - The size of the cube</li>
 *     <li>{@code rotationX} ({@link Double}) - The rotation of the cube on the X axis</li>
 *     <li>{@code rotationY} ({@link Double}) - The rotation of the cube on the Y axis</li>
 *     <li>{@code rotationZ} ({@link Double}) - The rotation of the cube on the Z axis</li>
 *     <li>{@code density} ({@link Integer}) - The density of the cube</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public class CubeParticleType implements CustomParticleType<CubeParticleType> {

    private final ParticleOptions<CubeParticleType> options = new ParticleOptions<CubeParticleType>()
            .setOption("size", 1D)
            .setOption("rotationX", 0D)
            .setOption("rotationY", 0D)
            .setOption("rotationZ", 0D)
            .setOption("density", 1);

    @NotNull
    @Override
    public List<Vector> render(@NotNull Location startingLocation) {
        double size = options.getDoubleOption("size");
        double rotationX = options.getDoubleOption("rotationX");
        double rotationY = options.getDoubleOption("rotationY");
        double rotationZ = options.getDoubleOption("rotationZ");
        int density = options.getIntegerOption("density");

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
    public @NotNull ParticleOptions<CubeParticleType> getOptions() {
        return options;
    }

    @Override
    public @NotNull List<String> getRequiredOptions() {
        return options.getAllOptions();
    }

}
