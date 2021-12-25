package com.plugins.entities.events;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerOnJumpEvent implements Listener {

    @EventHandler
    public void onDamage(PlayerJumpEvent event) {
//        event.getPlayer().getWorld().spawnEntity(event.getPlayer().getLocation(), EntityType.LIGHTNING);
        Player player = event.getPlayer();
//        Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), -163, 86, 189), EntityType.LIGHTNING);
        Entity entity = Bukkit.getWorld("world").spawnEntity(player.getLocation(), EntityType.LIGHTNING);
        entity.setCustomName("ddf");
        entity.setCustomNameVisible(true);
        entity.setInvulnerable(true);
        entity.setGravity(false);
    }
}
