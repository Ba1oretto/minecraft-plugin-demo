package minecraft.demo.alwaysdayandclearweather.tasks;

import minecraft.demo.alwaysdayandclearweather.AlwaysDayAndClearWeather;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class KeepDayTask extends BukkitRunnable {
    private final AlwaysDayAndClearWeather plugin;

    public KeepDayTask(AlwaysDayAndClearWeather plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        Bukkit.getServer().getWorld(plugin.getConfig().getString("vanilla-world")).setTime(18000L);
    }
}
