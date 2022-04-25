package minecraft.demo.customutils;

import minecraft.demo.customutils.listeners.CommandListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomUtils extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new CommandListeners(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
