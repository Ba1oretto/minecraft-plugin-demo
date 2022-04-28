package minecraft.demo.motdplugin.listeners;

import minecraft.demo.motdplugin.MotdPlugin;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public record PlayerJoinListener(MotdPlugin plugin) implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        StringBuilder sb = new StringBuilder();
        plugin.getConfig().getList("motd-message").forEach(v -> {
            String words = ChatColor.translateAlternateColorCodes('&', v.toString());
            sb.append(words).append("\n");
        });
        String message = sb.toString().stripTrailing();
        event.getPlayer().sendMessage(message);
    }
}
