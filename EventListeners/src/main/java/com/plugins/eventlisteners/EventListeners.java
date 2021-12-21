package com.plugins.eventlisteners;

import com.plugins.eventlisteners.listeners.JoinListener;
import com.plugins.eventlisteners.listeners.LeaveBedListener;
import com.plugins.eventlisteners.listeners.ShearSheepListener;
import com.plugins.eventlisteners.listeners.XPBottleBreakListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class EventListeners extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new LeaveBedListener(), this);
    }
}
