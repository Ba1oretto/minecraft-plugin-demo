package minecraft.demo.customutils.listeners;

import minecraft.demo.customutils.CustomUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public record ReloadCommandListener(CustomUtils customUtils) implements Listener {
    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        if (event.getMessage().startsWith("/reload")) {
            event.setCancelled(true);
            customUtils.getServer().reload();
            event.getPlayer().sendMessage(Component.text("reloaded", TextColor.color(0, 255, 0)));
        }
    }
}
