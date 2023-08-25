package me.outspending.particleapi.renderer;

import me.outspending.particleapi.Particle;
import me.outspending.particleapi.ParticleOptions;
import me.outspending.particleapi.ParticleType;
import org.bukkit.Location;
import org.jetbrains.annotations.ApiStatus;

import java.util.concurrent.CompletableFuture;

public class ParticleRenderer {

    private Location location;
    private ParticleType type;
    private Particle particle;
    private ParticleOptions<? extends ParticleType> options;

    @Deprecated(forRemoval = true)
    public void render() {
        type.getType().render(location);
    }

    @ApiStatus.Experimental
    public CompletableFuture<Void> renderAsync() {
        return CompletableFuture.runAsync(this::render);
    }

    public void onRender() {};
    public void onRenderEnd() {};
}
