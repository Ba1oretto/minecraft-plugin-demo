package minecraft.demo.customevents;

import minecraft.demo.customevents.listeners.GameListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomEvents extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new GameListeners(), this);
        getCommand("32-gameover").setExecutor(new GameOverCommand());
    }

}
