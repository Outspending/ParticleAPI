package me.outspending.particleapi;

import me.outspending.particleapi.types.*;

/**
 * Represents a particle type.
 * <p>
 * The main class for all the ParticleTypes. This enum is used to get the particle type
 * and render it. This enum is also used to get the required options for the particle type.
 *
 * @see CustomParticleType
 * @see me.outspending.particleapi.renderer.ParticleRenderer
 * @since 1.0
 */
public enum ParticleType {

    /**
     * Used to render a circle-shaped particle effect.
     *
     * @see CircleParticleType
     * @since 1.0
     */
    CIRCLE(new CircleParticleType()),

    /**
     * Used to render a cube-shaped particle effect.
     *
     * @see CubeParticleType
     * @since 1.0
     */
    CUBE(new CubeParticleType()),

    /**
     * Used to render a cylinder-shaped particle effect.
     *
     * @see CylinderParticleType
     * @since 1.0
     */
    CYLINDER(new CylinderParticleType()),

    /**
     * Used to render a helix-shaped particle effect.
     *
     * @see HelixParticleType
     * @since 1.0
     */
    HELIX(new HelixParticleType()),

    /**
     * Used to render a line-shaped particle effect.
     *
     * @see LineParticleType
     * @since 1.0
     */
    LINE(new LineParticleType()),

    /**
     * Used to render a sphere-shaped particle effect.
     *
     * @see SphereParticleType
     * @since 1.0
     */
    SPHERE(new SphereParticleType()),

    /**
     * Used to render a spiral-shaped particle effect.
     *
     * @see SpiralParticleType
     * @since 1.0
     */
    SPIRAL(new SpiralParticleType()),

    /**
     * Used to render a star-shaped particle effect.
     *
     * @see StarParticleType
     * @since 1.0
     */
    STAR(new StarParticleType()),

    /**
     * Used to render a triangle-shaped particle effect.
     *
     * @see TriangleParticleType
     * @since 1.0
     */
    TRIANGLE(new TriangleParticleType()),

    /**
     * Used to render a wave-shaped particle effect.
     *
     * @see WaveParticleType
     * @since 1.0
     */
    WAVE(new WaveParticleType()),

    /**
     * Used to render a text-shaped particle effect.
     *
     * @see TextParticleType
     * @since 1.0
     */
    TEXT(new TextParticleType()),

    /**
     * Used to render an image-shaped particle effect.
     *
     * @see ImageParticleType
     * @since 1.0
     */
    IMAGE(new ImageParticleType());


    private final CustomParticleType type;

    ParticleType(CustomParticleType type) {
        this.type = type;
    }

    public CustomParticleType getType() {
        return type;
    }
}
