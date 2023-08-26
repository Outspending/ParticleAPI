package me.outspending.particleapi;

public enum ParticleOption {

    /**
     * Represents the radius of a particle.
     *
     * @see me.outspending.particleapi.types.CircleParticleType
     * @since 1.0
     */
    RADIUS("radius"),

    /**
     * Represents the size of a particle.
     *
     * @see me.outspending.particleapi.types.CircleParticleType
     * @since 1.0
     */
    SIZE("size"),

    /**
     * Represents the density of a particle.
     *
     * @see me.outspending.particleapi.types.CircleParticleType
     * @since 1.0
     */
    DENSITY("density"),

    /**
     * Represents the height of a particle.
     *
     * @see me.outspending.particleapi.types.HelixParticleType
     * @since 1.0
     */
    HEIGHT("height"),

    /**
     * Represents the rotation of a particle.
     *
     * @see me.outspending.particleapi.types.HelixParticleType
     * @since 1.0
     */
    ROTATION("rotation"),

    /**
     * Represents whether or not a particle is hollow.
     *
     * @see me.outspending.particleapi.types.HelixParticleType
     * @since 1.0
     */
    HOLLOW("hollow"),

    /**
     * Represents the rotation of a particle on the X axis.
     *
     * @see me.outspending.particleapi.types.ImageParticleType
     * @since 1.0
     */
    ROTATION_X("rotationX"),

    /**
     * Represents the rotation of a particle on the Y axis.
     *
     * @see me.outspending.particleapi.types.ImageParticleType
     * @since 1.0
     */
    ROTATION_Y("rotationY"),

    /**
     * Represents the rotation of a particle on the Z axis.
     *
     * @see me.outspending.particleapi.types.ImageParticleType
     * @since 1.0
     */
    ROTATION_Z("rotationZ"),

    /**
     * Represents the image of a particle.
     *
     * @see me.outspending.particleapi.types.ImageParticleType
     * @since 1.0
     */
    IMAGE("image"),

    /**
     * Represents the width of a particle.
     *
     * @see me.outspending.particleapi.types.ImageParticleType
     * @since 1.0
     */
    WIDTH("width"),

    /**
     * Represents the height of a particle.
     *
     * @see me.outspending.particleapi.types.ImageParticleType
     * @since 1.0
     */
    PIXEL_SIZE("pixelSize"),

    /**
     * Represents the display text of a particle.
     *
     * @see me.outspending.particleapi.types.TextParticleType
     * @since 1.0
     */
    TEXT("text"),

    /**
     * Represents the display font of a particle.
     *
     * @see me.outspending.particleapi.types.TextParticleType
     * @since 1.0
     */
    FONT("font"),

    /**
     * Represents the display font size of a particle.
     *
     * @see me.outspending.particleapi.types.TextParticleType
     * @since 1.0
     */
    LENGTH("length");

    private final String optionName;

    ParticleOption(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionName() {
        return optionName;
    }
}
