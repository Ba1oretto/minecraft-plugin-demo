package minecraft.demo.vanishplugin.listeners;

import minecraft.demo.vanishplugin.VanishPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public record PlayerJoinListeners(VanishPlugin vanishPlugin, List<Player> invisiblePlayerList) implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        invisiblePlayerList.forEach(v -> event.getPlayer().hidePlayer(vanishPlugin, v));
    }
}
