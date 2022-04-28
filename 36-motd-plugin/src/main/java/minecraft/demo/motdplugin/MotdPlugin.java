package minecraft.demo.motdplugin;

import minecraft.demo.motdplugin.listeners.GoodWeatherListener;
import minecraft.demo.motdplugin.listeners.PlayerJoinListener;
import minecraft.demo.motdplugin.tasks.KeepDayTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class MotdPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new GoodWeatherListener(), this);
        new KeepDayTask(this).runTaskTimer(this, 0L, 100L);
        getConfig().options().copyDefaults();
        saveDefaultConfig();


        if (getConfig().getBoolean("motd")) getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);

    }

}
