package me.outspending.particleapi;

import me.outspending.particleapi.custom.CustomParticle;
import me.outspending.particleapi.custom.CustomParticleType;
import me.outspending.particleapi.renderer.ParticleRenderer;
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
        ParticleRenderer renderer = CustomParticleType.builder(ParticleType.WAVE)
                .particleType(CustomParticle.dust(Color.RED, 1))
                .editOption(ParticleOption.RADIUS, (short) 5)
                .editOption(ParticleOption.DENSITY, (short) 250)
                .editOption(ParticleOption.HEIGHT, 5L)
                .editOption(ParticleOption.ROTATION_Y, (short) 65)
                .editOption(ParticleOption.ROTATION_Z, (short) 65)
                .build();

        renderer.renderTimed(e.getBlock().getLocation(), TimeUnit.SECONDS, 5);

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
