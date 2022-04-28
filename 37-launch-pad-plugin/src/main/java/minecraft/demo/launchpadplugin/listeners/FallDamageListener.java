package minecraft.demo.launchpadplugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;

public record FallDamageListener(List<Player> playerJumpList) implements Listener {
    @EventHandler
    public void onPlayerFallDamageEvent(EntityDamageEvent event) {
        if (!event.getCause().equals(EntityDamageEvent.DamageCause.FALL)) return;
        Player player = (Player) event.getEntity();
        if (!playerJumpList.contains(player)) return;
        event.setCancelled(true);
        playerJumpList.remove(player);
    }
}
