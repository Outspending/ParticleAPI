package me.outspending.particleapi.particles;

import me.outspending.particleapi.CustomParticle;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.function.Predicate;

public class ParticleHandlerImpl implements ParticleHandler {

    @Override
    public void sendParticle(@NotNull Location location, @NotNull CustomParticle particle) {
        for (Player player : Bukkit.getOnlinePlayers())
            sendParticle(location, player, particle);
    }

    @Override
    public void sendParticle(@NotNull Location location, @NotNull Player player, @NotNull CustomParticle particle) {
        particle.spawn(location, player);
    }

    @Override
    public void sendParticle(@NotNull Location location, @NotNull Set<Player> players, @NotNull CustomParticle particle) {
        for (Player player : players)
            sendParticle(location, player, particle);
    }

    @Override
    public void sendParticle(@NotNull Location location, @NotNull CustomParticle particle, @NotNull Predicate<Player> predicate) {
        for (Player player : Bukkit.getOnlinePlayers())
            if (predicate.test(player)) sendParticle(location, player, particle);
    }

}
