package minecraft.demo.motdplugin.tasks;

import minecraft.demo.motdplugin.MotdPlugin;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class KeepDayTask extends BukkitRunnable {
    private final MotdPlugin plugin;

    public KeepDayTask(MotdPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        Bukkit.getServer().getWorld(plugin.getConfig().getString("vanilla-world")).setTime(18000L);
    }
}
