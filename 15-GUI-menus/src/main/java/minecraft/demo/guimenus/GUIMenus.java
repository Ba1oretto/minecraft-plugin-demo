package minecraft.demo.guimenus;

import minecraft.demo.guimenus.commands.GUICommand;
import minecraft.demo.guimenus.listeners.GUIListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class GUIMenus extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("gui").setExecutor(new GUICommand());
        getServer().getPluginManager().registerEvents(new GUIListeners(), this);
    }
}
