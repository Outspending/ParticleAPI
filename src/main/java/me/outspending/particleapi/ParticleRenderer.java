package me.outspending.particleapi;

import org.bukkit.Location;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ParticleRenderer {

    private Location location;
    private ParticleType type;
    private Particle particle;
    private ParticleOptions<? extends ParticleType> options;

    public void render() {
        type.getType().render(location, options);
    }

    @ApiStatus.Experimental
    public CompletableFuture<Void> renderAsync() {
        return CompletableFuture.runAsync(this::render);
    }

    public void onRender() {};
    public void onRenderEnd() {};
}
