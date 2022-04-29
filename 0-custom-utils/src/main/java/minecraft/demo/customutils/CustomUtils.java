package minecraft.demo.customutils;

import minecraft.demo.customutils.listeners.ReloadCommandListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomUtils extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ReloadCommandListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
