package com.plugins.instanceaccess.listeners;

import com.plugins.instanceaccess.InstanceAccess;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class DeathListener implements Listener {

    private final InstanceAccess instanceAccess;

    public DeathListener(InstanceAccess instanceAccess) {
        this.instanceAccess = instanceAccess;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent playerDeathEvent) {
        playerDeathEvent.getPlayer().sendMessage(ChatColor.RED + "你寄了");
        new BukkitRunnable() {
            @Override
            public void run() {
                System.out.println("测试延迟运行");
            }
        }.runTaskLater(instanceAccess, 20L);
    }
}