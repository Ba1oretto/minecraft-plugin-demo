package com.plugins.eventlisteners.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class ShearSheepListener implements Listener, Cancellable {

    @EventHandler
    public void onShearSheep(PlayerShearEntityEvent e) {
        Entity entity = e.getEntity();
        Player player = e.getPlayer();

        if (entity.getType() == EntityType.SHEEP) {
            player.sendMessage("this is a sheep. You can't do that");
            e.setCancelled(true);
        }else{
            player.sendMessage("This is not a sheep");
        }
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean cancel) {

    }
}
