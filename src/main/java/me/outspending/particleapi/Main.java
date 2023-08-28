package me.outspending.particleapi;

import me.outspending.particleapi.particles.NormalParticleType;
import me.outspending.particleapi.renderer.ParticleRenderer;
import me.outspending.particleapi.types.CircleParticleType;
import me.outspending.particleapi.types.CylinderParticleType;
import me.outspending.particleapi.types.SphereParticleType;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Set;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        ParticleRenderer renderer = CustomParticleType.builder(new SphereParticleType())
                .particleType(CustomParticle.dust(Color.BLUE, 1))
                .editOption(ParticleOption.RADIUS, 5D)
                .editOption(ParticleOption.DENSITY, 200)
                .build();

        long start = System.nanoTime();
        renderer.renderAsync(e.getBlock().getLocation());
        Bukkit.broadcastMessage("Rendered in " + (System.nanoTime() - start) + "ns");

//        new BukkitRunnable() {
//
//            private Location location = e.getBlock().getLocation();
//            private int number = 0;
//
//            @Override
//            public void run() {
//                long start = System.nanoTime();
//                renderer.render(location);
//                Bukkit.broadcastMessage("Rendered in " + (System.nanoTime() - start) + "ns");
//
//                if (number >= 10) cancel();
//                number++;
//            }
//        }.runTaskTimer(this, 1, 1);
    }
}
