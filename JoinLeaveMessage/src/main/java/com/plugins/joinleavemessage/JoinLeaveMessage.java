package com.plugins.joinleavemessage;

import org.bukkit.plugin.java.JavaPlugin;

public final class JoinLeaveMessage extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new JoinLeaveListeners(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
