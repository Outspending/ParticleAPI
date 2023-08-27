package me.outspending.particleapi;

import me.outspending.particleapi.renderer.ParticleRenderer;
import me.outspending.particleapi.types.CircleParticleType;
import me.outspending.particleapi.types.SphereParticleType;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        long start = System.currentTimeMillis();
        ParticleRenderer renderer = CustomParticleType.builder(new CircleParticleType())
                .editOption(ParticleOption.RADIUS, 15)
                .editOption(ParticleOption.DENSITY, 360)
                .build();

        renderer.render(e.getBlock().getLocation());
        long end = System.currentTimeMillis();
        Bukkit.broadcastMessage("Rendered in " + (end - start) + "ms");
    }
}
