package com.plugins.customcommands.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerMoveEvent implements Listener {

    @EventHandler
    public void onMove(org.bukkit.event.player.PlayerMoveEvent playerMoveEvent) {
        if (!playerMoveEvent.getPlayer().hasPermission("command.move")) {
            playerMoveEvent.setCancelled(true);
        }
    }
}
