package com.plugins.flystyle;

import com.plugins.flystyle.commands.FlyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class FlyStyle extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("fly").setExecutor(new FlyCommand(this));
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

//    @Override
//    public void onDisable() {
//    }
}
