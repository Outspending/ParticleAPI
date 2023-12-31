package me.outspending.particleapi;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public enum ParticleOption {

    /**
     * Represents the radius of a particle.
     *
     * @see me.outspending.particleapi.types.CircleParticleType
     * @since 1.0
     */
    RADIUS("radius", Short.class),

    /**
     * Represents the size of a particle.
     *
     * @see me.outspending.particleapi.types.CircleParticleType
     * @since 1.0
     */
    SIZE("size", Byte.class),

    /**
     * Represents the density of a particle.
     *
     * @see me.outspending.particleapi.types.CircleParticleType
     * @since 1.0
     */
    DENSITY("density", Short.class),

    /**
     * Represents the height of a particle.
     *
     * @see me.outspending.particleapi.types.HelixParticleType
     * @since 1.0
     */
    HEIGHT("height", Long.class),

    /**
     * Represents whether or not a particle is hollow.
     *
     * @see me.outspending.particleapi.types.HelixParticleType
     * @since 1.0
     */
    HOLLOW("hollow", Boolean.class),

    /**
     * Represents the rotation of a particle on the X axis.
     *
     * @see me.outspending.particleapi.types.ImageParticleType
     * @since 1.0
     */
    ROTATION_X("rotationX", Short.class),

    /**
     * Represents the rotation of a particle on the Y axis.
     *
     * @see me.outspending.particleapi.types.ImageParticleType
     * @since 1.0
     */
    ROTATION_Y("rotationY", Short.class),

    /**
     * Represents the rotation of a particle on the Z axis.
     *
     * @see me.outspending.particleapi.types.ImageParticleType
     * @since 1.0
     */
    ROTATION_Z("rotationZ", Short.class),

    /**
     * Represents the image of a particle.
     *
     * @see me.outspending.particleapi.types.ImageParticleType
     * @since 1.0
     */
    IMAGE("image", String.class),

    /**
     * Represents the width of a particle.
     *
     * @see me.outspending.particleapi.types.ImageParticleType
     * @since 1.0
     */
    WIDTH("width", Long.class),

    /**
     * Represents the size of a particle.
     *
     * @see me.outspending.particleapi.types.ImageParticleType
     * @since 1.0
     */
    PIXEL_SIZE("pixelSize", Byte.class),

    /**
     * Represents the display text of a particle.
     *
     * @see me.outspending.particleapi.types.TextParticleType
     * @since 1.0
     */
    TEXT("text", String.class),

    /**
     * Represents the display font of a particle.
     *
     * @see me.outspending.particleapi.types.TextParticleType
     * @since 1.0
     */
    FONT("font", String.class),

    /**
     * Represents the display font size of a particle.
     *
     * @see me.outspending.particleapi.types.TextParticleType
     * @since 1.0
     */
    LENGTH("length", Short.class);

    private final String optionName;
    private final Class<?> classType;

    ParticleOption(String optionName, Class<?> classType) {
        this.optionName = optionName;
        this.classType = classType;
    }

    public String getOptionName() {
        return optionName;
    }

    public Class<?> getClassType() {
        return classType;
    }
}
