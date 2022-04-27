package minecraft.demo.teleportplugin;

import minecraft.demo.teleportplugin.commands.TeleportAllCommand;
import minecraft.demo.teleportplugin.commands.TeleportCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class TeleportPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("29-teleport").setExecutor(new TeleportCommand());
        getCommand("29-teleportAll").setExecutor(new TeleportAllCommand());
    }

}
