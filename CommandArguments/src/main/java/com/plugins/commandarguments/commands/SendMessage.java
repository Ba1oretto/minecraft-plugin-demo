package com.plugins.commandarguments.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SendMessage implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (args.length != 0) {
                if (args[0].equalsIgnoreCase("garbage")) {
                    player.sendMessage("you are fucking garbage");
                }
                player.sendMessage(args[0]);
            } else {
                player.sendMessage(ChatColor.RED + "You need to give the command an argument\n" +
                        ChatColor.YELLOW + "/send <messages>");
            }
            return true;
        }
        return false;
    }
}
