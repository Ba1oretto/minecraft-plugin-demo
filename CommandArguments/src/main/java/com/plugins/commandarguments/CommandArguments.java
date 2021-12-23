package com.plugins.commandarguments;

import com.plugins.commandarguments.commands.PlayerKiller;
import com.plugins.commandarguments.commands.SendMessage;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandArguments extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("send").setExecutor(new SendMessage());
        getCommand("kill").setExecutor(new PlayerKiller());
    }

//    @Override
//    public void onDisable() {
//        // Plugin shutdown logic
//    }
}
