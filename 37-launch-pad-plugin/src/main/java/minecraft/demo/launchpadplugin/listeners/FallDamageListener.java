package minecraft.demo.launchpadplugin.listeners;

import minecraft.demo.launchpadplugin.LaunchPadPlugin;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public record FallDamageListener(LaunchPadPlugin plugin) implements Listener {
    @EventHandler
    public void onPlayerFallDamageEvent(EntityDamageEvent event) {
        if (!event.getCause().equals(EntityDamageEvent.DamageCause.FALL)) return;
        if (!event.getEntity().getType().equals(EntityType.PLAYER)) return;
        Player player = (Player) event.getEntity();
        if (!plugin.getPlayerJumpList().contains(player)) return;
        event.setCancelled(true);
        plugin.getPlayerJumpList().remove(player);
    }
}
