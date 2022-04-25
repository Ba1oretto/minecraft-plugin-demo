package minecraft.demo.inventoriesanditems;

import minecraft.demo.inventoriesanditems.commands.MenuCommand;
import minecraft.demo.inventoriesanditems.listeners.MenuListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class InventoriesAndItems extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("menu").setExecutor(new MenuCommand());
        getServer().getPluginManager().registerEvents(new MenuListeners(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
