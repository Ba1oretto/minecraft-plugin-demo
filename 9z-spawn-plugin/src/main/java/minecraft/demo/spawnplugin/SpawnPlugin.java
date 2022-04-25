package minecraft.demo.spawnplugin;

import minecraft.demo.spawnplugin.commands.SetSpawnCommands;
import minecraft.demo.spawnplugin.commands.SpawnCommands;
import minecraft.demo.spawnplugin.listeners.SpawnListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();
        this.getCommand("setspawn").setExecutor(new SetSpawnCommands(this));
        this.getCommand("spawn").setExecutor(new SpawnCommands(this));
        this.getServer().getPluginManager().registerEvents(new SpawnListeners(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
