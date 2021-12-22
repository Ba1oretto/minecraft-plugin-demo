package com.plugins.customcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player p) {
            p.setFoodLevel(20);
            p.setSaturation(20);
            p.sendMessage(ChatColor.YELLOW + "Food set to max. Bon appétit");
            return true;
        }
        return false;
    }
}
