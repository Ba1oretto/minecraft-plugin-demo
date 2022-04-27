package minecraft.demo.vanishplugin;

import minecraft.demo.vanishplugin.commands.VanishCommand;
import minecraft.demo.vanishplugin.listeners.PlayerJoinListeners;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class VanishPlugin extends JavaPlugin {
    private final List<Player> invisiblePlayerList;

    {
        invisiblePlayerList = new ArrayList<>();
    }

    @Override
    public void onEnable() {
        getCommand("27-vanish").setExecutor(new VanishCommand(this, invisiblePlayerList));
        getServer().getPluginManager().registerEvents(new PlayerJoinListeners(this, invisiblePlayerList), this);
    }

}
