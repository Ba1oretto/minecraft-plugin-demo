package minecraft.demo.launchpadplugin.listeners;

import minecraft.demo.launchpadplugin.LaunchPadPlugin;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.List;

public record PlayerMoveListener(LaunchPadPlugin plugin, List<Player> playerJumpList) implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        if (!location.getBlock().getType().equals(Material.valueOf(plugin.getConfig().getString("top-block")))) return;
        location.setY(location.getBlockY() - 1);
        if (!location.getBlock().getType().equals(Material.valueOf(plugin.getConfig().getString("under-block")))) return;
        player.setVelocity(player.getLocation().getDirection().multiply(plugin.getConfig().getInt("velocity-multiply")).setY(plugin.getConfig().getInt("y-velocity")));
        if (!playerJumpList.contains(player)) playerJumpList.add(player);
    }
}
