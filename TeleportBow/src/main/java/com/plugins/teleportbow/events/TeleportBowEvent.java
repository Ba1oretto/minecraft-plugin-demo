package com.plugins.teleportbow.events;

import com.plugins.teleportbow.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class TeleportBowEvent implements Listener{

    private final TeleportBow teleportBow;

    public TeleportBowEvent(TeleportBow teleportBow) {
        this.teleportBow = teleportBow;
    }

    @EventHandler
    public void onBowShoot(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow arrow) {
            Player player = (Player) event.getEntity().getShooter();
            Location arrowLocation = event.getEntity().getLocation();

            assert player != null;
            player.teleport(arrowLocation);
            player.sendMessage(ChatColor.GREEN + "Swoosh!");
            player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1.0F, 1.0F);
        }
    }

    @EventHandler
    public void onFirstJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPlayedBefore() && teleportBow.getConfig().getBoolean("give-on-first-join")) {
            teleportBow.setBow(event.getPlayer());
        }
    }
}
