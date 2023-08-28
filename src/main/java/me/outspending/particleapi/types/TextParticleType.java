package me.outspending.particleapi.types;

import me.outspending.particleapi.CustomParticleType;
import me.outspending.particleapi.ParticleOption;
import me.outspending.particleapi.ParticleOptions;
import me.outspending.particleapi.TextFont;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Represents a particle type that renders as text.
 * <p>
 * This particle type is used in conjunction with the {@link me.outspending.particleapi.renderer.ParticleRenderer}
 * to display a text-shaped particle effect.
 * <p>
 * Required Particle Options:
 * <ul>
 *     <li>{@code text} ({@link String}) - The text to display</li>
 *     <li>{@code font} ({@link TextFont}) - The font to use</li>
 *     <li>{@code size} ({@link Integer}) - The size of the text</li>
 * </ul>
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public class TextParticleType implements CustomParticleType {

    private final ParticleOptions options = new ParticleOptions()
            .setOption(ParticleOption.TEXT, "Hello, world!")
            .setOption(ParticleOption.FONT, TextFont.MINECRAFT)
            .setOption(ParticleOption.SIZE, 1);

    @NotNull
    @Override
    public List<Vector> render(@NotNull Location startingLocation) {
        return null;
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
