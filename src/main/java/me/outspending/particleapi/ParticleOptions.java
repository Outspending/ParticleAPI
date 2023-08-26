package me.outspending.particleapi;

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
 * @param <T>
 */
public class ParticleOptions<T extends CustomParticleType<?>> {

    private HashMap<String, Object> options = new HashMap<>();

    /**
     * Sets an option for the particle type.
     *
     * @since 1.0
     * @param key
     * @param value
     * @return
     */
    private String getStringOption(@NotNull String key, @NotNull Object value) {
        return String.valueOf(value);
    }

    /**
     * Checks if the particle type has an option.
     *
     * @since 1.0
     * @param key
     * @return
     */
    public boolean hasOption(@NotNull String key) {
        return options.containsKey(key);
    }

    /**
     * Gets an option for the particle type.
     *
     * @since 1.0
     * @param key
     * @return
     */
    public @Nullable Object getOption(@NotNull String key) {
        return options.get(key);
    }

    /**
     * Gets an option for the particle type as a string.
     *
     * @since 1.0
     * @param key
     * @return
     */
    public @Nullable String getStringOption(@NotNull String key) {
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
    public int getIntegerOption(@NotNull String key) {
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
    public double getDoubleOption(@NotNull String key) {
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
    public boolean getBooleanOption(@NotNull String key) {
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
    public long getLongOption(@NotNull String key) {
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
    public float getFloatOption(@NotNull String key) {
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
    public byte getByteOption(@NotNull String key) {
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
    public short getShortOption(@NotNull String key) {
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
    public char getCharOption(@NotNull String key) {
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
    @SuppressWarnings("unchecked")
    public ParticleOptions<T> setOption(@NotNull ParticleOption key, @NotNull Object value) {
        options.put(key.getOptionName(), value);
        return this;
    }

    /**
     * Gets all the options for the particle type.
     *
     * @since 1.0
     * @return
     */
    public List<String> getAllOptions() {
        return new ArrayList<>(options.keySet());
    }

    @SuppressWarnings("unchecked")
    public static <T extends CustomParticleType<? super T>> ParticleOptions<T> getDefaults(Class<T> clazz) {
        return (ParticleOptions<T>) clazz.cast(null).getOptions();
    }
}
