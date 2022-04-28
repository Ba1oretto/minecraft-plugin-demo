package minecraft.demo.launchpadplugin;

import minecraft.demo.launchpadplugin.listeners.FallDamageListener;
import minecraft.demo.launchpadplugin.listeners.PlayerMoveListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class LaunchPadPlugin extends JavaPlugin {

    private final List<Player> playerJumpList;

    {
        playerJumpList = new ArrayList<>();
    }

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveConfig();
        if (getConfig().getBoolean("enable")) getServer().getPluginManager().registerEvents(new PlayerMoveListener(this, playerJumpList), this);
        if (getConfig().getBoolean("disable-fall-damage")) getServer().getPluginManager().registerEvents(new FallDamageListener(playerJumpList), this);
    }

}
