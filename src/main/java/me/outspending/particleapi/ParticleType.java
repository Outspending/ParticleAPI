package me.outspending.particleapi;

import me.outspending.particleapi.types.*;

public enum ParticleType {
    CIRCLE(new CircleParticleType()),
    CUBE(new CubeParticleType()),
    CYLINDER(new CylinderParticleType()),
    HELIX(new HelixParticleType()),
    LINE(new LineParticleType()),
    SPHERE(new SphereParticleType()),
    SPIRAL(new SpiralParticleType()),
    SQUARE(new SquareParticleType()),
    STAR(new StarParticleType()),
    TRIANGLE(new TriangleParticleType()),
    WAVE(new WaveParticleType()),
    TEXT(new TextParticleType()),
    IMAGE(new ImageParticleType());


    private final CustomParticleType type;

    ParticleType(CustomParticleType type) {
        this.type = type;
    }

    public CustomParticleType getType() {
        return type;
    }
}
