package minecraft.demo.spawnplugin.listeners;

import minecraft.demo.spawnplugin.SpawnPlugin;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public record SpawnListeners(SpawnPlugin plugin) implements Listener {

    @EventHandler
    public void onPlayerJoined(PlayerJoinEvent playerJoinEvent) {
        Location spawnLocation = plugin.getConfig().getLocation("spawn");
        if (spawnLocation == null) return;
        if (playerJoinEvent.getPlayer().hasPlayedBefore()) return;
        playerJoinEvent.getPlayer().teleport(spawnLocation);
        // spawnLocation
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent playerRespawnEvent) {
        Location spawnLocation = plugin.getConfig().getLocation("spawn");
        if (spawnLocation == null) return;
        playerRespawnEvent.setRespawnLocation(spawnLocation);
    }
}
