package me.outspending.particleapi;

import org.jetbrains.annotations.NotNull;

/**
 * Used for {@link me.outspending.particleapi.types.TextParticleType} to specify the font to use.
 * <p>
 * This enum is used to specify the font to use when rendering text particles.
 *
 * @since 1.0
 */
public enum TextFont {

    /**
     * The default Minecraft font.
     *
     * @since 1.0
     * @see me.outspending.particleapi.types.TextParticleType
     */
    MINECRAFT("minecraft");


    private final String fontName;

    TextFont(@NotNull String fontName) {
        this.fontName = fontName;
    }

    public String getFontName() {
        return fontName;
    }
}
