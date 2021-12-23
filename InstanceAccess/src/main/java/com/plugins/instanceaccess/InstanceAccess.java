package com.plugins.instanceaccess;

import com.plugins.instanceaccess.listeners.DeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class InstanceAccess extends JavaPlugin {

//    private static InstanceAccess plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
//        plugin = this;
        getServer().getPluginManager().registerEvents(new DeathListener(this), this);
    }

//    @Override
//    public void onDisable() {
//        // Plugin shutdown logic
//    }

//    public static InstanceAccess getPlugin() {
//        return plugin;
//    }
}
