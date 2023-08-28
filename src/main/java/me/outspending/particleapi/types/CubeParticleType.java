package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOption;
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
public class CubeParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.SIZE, 1D)
            .setOption(ParticleOption.ROTATION_X, 0D)
            .setOption(ParticleOption.ROTATION_Y, 0D)
            .setOption(ParticleOption.ROTATION_Z, 0D)
            .setOption(ParticleOption.DENSITY, 1);

    @NotNull
    @Override
    public List<Vector> render(@NotNull Location startingLocation) {

        double size = options.getDoubleOption(ParticleOption.SIZE);
        double rotationX = options.getDoubleOption(ParticleOption.ROTATION_X);
        double rotationY = options.getDoubleOption(ParticleOption.ROTATION_Y);
        double rotationZ = options.getDoubleOption(ParticleOption.ROTATION_Z);
        int density = options.getIntegerOption(ParticleOption.DENSITY);

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

    @Override
    public @NotNull List<ParticleOption> getRequiredOptions() {
        return options.getAllOptions();
    }

}
