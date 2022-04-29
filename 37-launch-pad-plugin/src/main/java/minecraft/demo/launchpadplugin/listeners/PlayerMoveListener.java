package minecraft.demo.launchpadplugin.listeners;

import minecraft.demo.launchpadplugin.LaunchPadPlugin;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public record PlayerMoveListener(LaunchPadPlugin plugin) implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Location location = player.getLocation();
        if (!location.getBlock().getType().equals(Material.valueOf(plugin.getConfig().getString("top-block")))) return;
        location.setY(location.getBlockY() - 1);
        if (!location.getBlock().getType().equals(Material.valueOf(plugin.getConfig().getString("under-block")))) return;

        player.setVelocity(player.getLocation().getDirection().multiply(plugin.getConfig().getInt("velocity-multiply")).setY(plugin.getConfig().getInt("y-velocity")));
        plugin.getPlayerJumpList().add(player);
    }
}
