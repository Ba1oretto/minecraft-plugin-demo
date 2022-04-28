package minecraft.demo.silktouchspawners;

import minecraft.demo.silktouchspawners.listeners.BlockBreakListener;
import minecraft.demo.silktouchspawners.listeners.SpawnerBreakListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SilkTouchSpawners extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new SpawnerBreakListener(), this);
    }

}
