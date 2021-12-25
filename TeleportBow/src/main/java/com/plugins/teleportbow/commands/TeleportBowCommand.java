package com.plugins.teleportbow.commands;

import com.plugins.teleportbow.TeleportBow;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TeleportBowCommand implements CommandExecutor {

    private TeleportBow teleportBow;

    public TeleportBowCommand(TeleportBow teleportBow) {
        this.teleportBow = teleportBow;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player && player.hasPermission("testPlugins.getBow")) {
            teleportBow.setBow(player);
            return true;
        }
        return false;
    }
}
