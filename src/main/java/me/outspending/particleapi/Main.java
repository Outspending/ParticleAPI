package me.outspending.particleapi;

import me.outspending.particleapi.renderer.ParticleRenderer;
import me.outspending.particleapi.types.CircleParticleType;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.TimeUnit;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        ParticleRenderer renderer = CustomParticleType.builder(new CircleParticleType())
                .particleType(CustomParticle.dust(Color.RED, 1))
                .build();

        renderer.renderTimedAsync(e.getBlock().getLocation(), 5, TimeUnit.SECONDS);

//        new BukkitRunnable() {
//
//            private Location location = e.getBlock().getLocation();
//            private double number = 0;
//
//            @Override
//            public void run() {
//                renderer.editOption(ParticleOption.RADIUS, number);
//
//                long start = System.nanoTime();
//                renderer.render(location);
//                Bukkit.broadcastMessage("Rendered in " + (System.nanoTime() - start) + "ns");
//
//                if (number >= 10) cancel();
//                number += 0.5;
//            }
//        }.runTaskTimer(this, 1, 1);
    }

    public static JavaPlugin getPlugin() {
        return JavaPlugin.getPlugin(Main.class);
    }
}
