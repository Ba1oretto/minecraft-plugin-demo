package com.plugins.commandarguments.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayerKiller implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player && args.length == 0) {
            player.setHealth(0);
            player.sendMessage("Damn it you have just killed yourself");
            return true;
        }
        if (args.length != 0) {
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target != null) {
                target.setHealth(0);
                target.sendMessage(ChatColor.RED + "You just be killed bitch.");
                String targetFullName = String.valueOf(target);
                String targetName = targetFullName.substring(17, targetFullName.length() - 1);
                sender.sendMessage(ChatColor.BLUE + "Player \"" + targetName + "\" killed success");
            } else {
                sender.sendMessage("The Player does not exist");
            }
            return true;
        }
        return false;
    }
}
