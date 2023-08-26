package me.outspending.particleapi;

public enum ParticleOption {
    RADIUS("radius"),
    SIZE("size"),
    DENSITY("density"),
    HEIGHT("height"),
    ROTATION("rotation"),
    HOLLOW("hollow"),
    ROTATION_X("rotationX"),
    ROTATION_Y("rotationY"),
    ROTATION_Z("rotationZ"),
    IMAGE("image"),
    WIDTH("width"),
    PIXEL_SIZE("pixelSize"),
    TEXT("text"),
    FONT("font"),
    LENGTH("length");

    private final String optionName;

    ParticleOption(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionName() {
        return optionName;
    }
}
