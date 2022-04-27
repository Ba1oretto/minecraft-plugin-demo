package minecraft.demo.usingapis.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListeners implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        String joinText = "%player_name% &ajoined the server!";

        joinText = PlaceholderAPI.setPlaceholders(event.getPlayer(), joinText);
        System.out.println("joinText: " + joinText);

        event.joinMessage(Component.text(joinText));
    }
}
