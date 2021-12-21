package com.plugins.eventlisteners.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public class XPBottleBreakListener implements Listener {

    @EventHandler
    public void onXPBottleBreak(ExpBottleEvent e) {
        System.out.println(e.getHitBlock());
        e.setShowEffect(false);
    }
}
