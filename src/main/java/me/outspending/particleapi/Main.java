package me.outspending.particleapi;

import me.outspending.particleapi.particles.NormalParticleType;
import me.outspending.particleapi.renderer.ParticleRenderer;
import me.outspending.particleapi.types.CircleParticleType;
import me.outspending.particleapi.types.SphereParticleType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        long start = System.currentTimeMillis();

        ParticleRenderer renderer = CustomParticleType.builder(new CircleParticleType())
                .particleType(CustomParticle.normal(Particle.CLOUD, false))
                .build();

        new BukkitRunnable() {

            private Location location = e.getBlock().getLocation();
            private double number = 0;

            @Override
            public void run() {
                renderer.editOption(ParticleOption.RADIUS, number);
                renderer.renderAsync(location);

                if (number >= 10) cancel();
                number += 0.1;
            }
        }.runTaskTimer(this, 1, 1);

        long end = System.currentTimeMillis();
        Bukkit.broadcastMessage("Rendered in " + (end - start) + "ms");
    }
}
