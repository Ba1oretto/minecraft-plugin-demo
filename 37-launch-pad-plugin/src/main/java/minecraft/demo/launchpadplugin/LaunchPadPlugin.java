package minecraft.demo.launchpadplugin;

import minecraft.demo.launchpadplugin.listeners.FallDamageListener;
import minecraft.demo.launchpadplugin.listeners.PlayerMoveListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public final class LaunchPadPlugin extends JavaPlugin {

    private final Set<Player> playerJumpList = new HashSet<>();

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveConfig();
        if (getConfig().getBoolean("enable")) getServer().getPluginManager().registerEvents(new PlayerMoveListener(this), this);
        if (getConfig().getBoolean("disable-fall-damage")) getServer().getPluginManager().registerEvents(new FallDamageListener(this), this);
    }

    public Set<Player> getPlayerJumpList() {
        return playerJumpList;
    }
}
