package minecraft.demo.banguiplugin;

import minecraft.demo.banguiplugin.commands.BanGUICommand;
import minecraft.demo.banguiplugin.listeners.BanInventoryListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class BanGUIPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("bangui").setExecutor(new BanGUICommand());
        getServer().getPluginManager().registerEvents(new BanInventoryListeners(), this);
    }

}
