package me.outspending.particleapi;

import me.outspending.particleapi.renderer.ParticleRenderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Represents a set of options for a particle type.
 * <p>
 * This class is used to store the options for a particle type.
 *
 * @since 1.0
 * @see CustomParticleType
 */
public class ParticleOptions {

    private HashMap<ParticleOption, Object> options = new HashMap<>();


    /**
     * Checks if the particle type is the same class as the value
     *
     * @since 1.0
     * @param key
     * @param value
     * @return
     */
    private boolean isOptionCompatible(@NotNull ParticleOption key, @NotNull Object value) {
        return key.getClassType().isInstance(value);
    }

    /**
     * Sets an option for the particle type.
     *
     * @since 1.0
     * @param key
     * @param value
     * @return
     */
    private String getStringOption(@NotNull ParticleOption key, @NotNull Object value) {
        return String.valueOf(value);
    }

    /**
     * Checks if the particle type has an option.
     *
     * @since 1.0
     * @param key
     * @return
     */
    public boolean hasOption(@NotNull ParticleOption key) {
        return options.containsKey(key);
    }

    /**
     * Edits an existing option, if the option doesn't exist
     * this method will do nothing.
     *
     * @since 1.0
     * @param key
     * @param value
     */
    public void editOption(@NotNull ParticleOption key, @NotNull Object value) {
        if (hasOption(key) && isOptionCompatible(key, value))
            setOption(key, value);
    }

    /**
     * Gets an option for the particle type.
     *
     * @since 1.0
     * @param key
     * @return
     */
    public @Nullable Object getOption(@NotNull ParticleOption key) {
        return options.get(key);
    }

    /**
     * Gets an option for the particle type as a string.
     *
     * @since 1.0
     * @param key
     * @return
     */
    public @Nullable String getStringOption(@NotNull ParticleOption key) {
        Object value = options.get(key);
        return String.valueOf(value);
    }

    /**
     * Gets an option for the particle type as an integer.
     *
     * @since 1.0
     * @param key
     * @return
     */
    public int getIntegerOption(@NotNull ParticleOption key) {
        Object value = options.get(key);
        return Integer.parseInt(getStringOption(key, value));
    }

    /**
     * Gets an option for the particle type as a double.
     *
     * @since 1.0
     * @param key
     * @return
     */
    public double getDoubleOption(@NotNull ParticleOption key) {
        Object value = options.get(key);
        return Double.parseDouble(getStringOption(key, value));
    }

    /**
     * Gets an option for the particle type as a boolean.
     *
     * @since 1.0
     * @param key
     * @return
     */
    public boolean getBooleanOption(@NotNull ParticleOption key) {
        Object value = options.get(key);
        return Boolean.parseBoolean(getStringOption(key, value));
    }

    /**
     * Gets an option for the particle type as a long.
     *
     * @since 1.0
     * @param key
     * @return
     */
    public long getLongOption(@NotNull ParticleOption key) {
        Object value = options.get(key);
        return Long.parseLong(getStringOption(key, value));
    }

    /**
     * Gets an option for the particle type as a float.
     *
     * @since 1.0
     * @param key
     * @return
     */
    public float getFloatOption(@NotNull ParticleOption key) {
        Object value = options.get(key);
        return Float.parseFloat(getStringOption(key, value));
    }

    /**
     * Gets an option for the particle type as a byte.
     *
     * @since 1.0
     * @param key
     * @return
     */
    public byte getByteOption(@NotNull ParticleOption key) {
        Object value = options.get(key);
        return Byte.parseByte(getStringOption(key, value));
    }

    /**
     * Gets an option for the particle type as a short.
     *
     * @since 1.0
     * @param key
     * @return
     */
    public short getShortOption(@NotNull ParticleOption key) {
        Object value = options.get(key);
        return Short.parseShort(getStringOption(key, value));
    }

    /**
     * Gets an option for the particle type as a character.
     *
     * @since 1.0
     * @param key
     * @return
     */
    public char getCharOption(@NotNull ParticleOption key) {
        Object value = options.get(key);
        return getStringOption(key, value).charAt(0);
    }

    /**
     * Sets an option for the particle type.
     *
     * @since 1.0
     * @param key
     * @param value
     * @return
     */
    public @Nullable ParticleOptions setOption(@NotNull ParticleOption key, @NotNull Object value) {
        options.put(key, value);
        return this;
    }

    /**
     * Gets all the options for the particle type.
     *
     * @since 1.0
     * @return
     */
    public List<ParticleOption> getAllOptions() {
        return new ArrayList<>(options.keySet());
    }

    /**
     * Gets the default options for a particle type.
     *
     * @since 1.0
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static ParticleOptions getDefaults(Class<? extends CustomParticleType> clazz) {
        return clazz.cast(null).getOptions();
    }
}
