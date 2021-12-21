package com.plugins.eventlisteners.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class LeaveBedListener implements Listener {
    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event) {
//        event.getPlayer().banPlayer("no reason");
        Player player = event.getPlayer();
        player.setHealth(1);
        player.sendMessage("ddf");
    }
}
