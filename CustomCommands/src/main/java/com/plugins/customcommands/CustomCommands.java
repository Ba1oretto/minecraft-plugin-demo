package com.plugins.customcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class CustomCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("die")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.setHealth(0);
                p.sendMessage(ChatColor.RED + "you have opted fucking to die");
            } else if (sender instanceof ConsoleCommandSender) {
                System.out.println("the command was run by the console.");
            } else if (sender instanceof BlockCommandSender) {
                System.out.println("the command was run by the console block.");
            }
        }
        return true;
    }
}
