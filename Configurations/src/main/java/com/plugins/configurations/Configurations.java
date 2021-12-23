package com.plugins.configurations;

import com.plugins.configurations.commands.ConfigurationInformation;
import org.bukkit.plugin.java.JavaPlugin;

public final class Configurations extends JavaPlugin{

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("getConfig").setExecutor(new ConfigurationInformation());
        getCommand("setFoodName").setExecutor(new ConfigurationInformation());
    }
}
