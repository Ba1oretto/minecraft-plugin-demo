package minecraft.demo.alwaysdayandclearweather;

import minecraft.demo.alwaysdayandclearweather.listeners.GoodWeatherListener;
import minecraft.demo.alwaysdayandclearweather.tasks.KeepDayTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class AlwaysDayAndClearWeather extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new GoodWeatherListener(), this);
        new KeepDayTask(this).runTaskTimer(this, 0L, 100L);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

}
