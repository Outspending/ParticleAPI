package me.outspending.particleapi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class ParticleOptions<T> {

    private HashMap<String, Object> options = new HashMap<>();

    private String getStringOption(@NotNull String key, @NotNull Object value) {
        return String.valueOf(value);
    }

    public boolean hasOption(@NotNull String key) {
        return options.containsKey(key);
    }

    public @Nullable Object getOption(@NotNull String key) {
        return options.get(key);
    }

    public @Nullable String getStringOption(@NotNull String key) {
        Object value = options.get(key);
        return String.valueOf(value);
    }

    public int getIntegerOption(@NotNull String key) {
        Object value = options.get(key);
        return Integer.parseInt(getStringOption(key, value));
    }

    public double getDoubleOption(@NotNull String key) {
        Object value = options.get(key);
        return Double.parseDouble(getStringOption(key, value));
    }

    public boolean getBooleanOption(@NotNull String key) {
        Object value = options.get(key);
        return Boolean.parseBoolean(getStringOption(key, value));
    }

    public long getLongOption(@NotNull String key) {
        Object value = options.get(key);
        return Long.parseLong(getStringOption(key, value));
    }

    public float getFloatOption(@NotNull String key) {
        Object value = options.get(key);
        return Float.parseFloat(getStringOption(key, value));
    }

    public byte getByteOption(@NotNull String key) {
        Object value = options.get(key);
        return Byte.parseByte(getStringOption(key, value));
    }

    public short getShortOption(@NotNull String key) {
        Object value = options.get(key);
        return Short.parseShort(getStringOption(key, value));
    }

    public char getCharOption(@NotNull String key) {
        Object value = options.get(key);
        return getStringOption(key, value).charAt(0);
    }

    public void setOption(@NotNull String key, @NotNull Object value) {
        options.put(key, value);
    }
}
