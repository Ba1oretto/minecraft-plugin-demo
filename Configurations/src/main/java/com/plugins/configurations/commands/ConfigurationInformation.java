package com.plugins.configurations.commands;

import com.plugins.configurations.Configurations;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ConfigurationInformation implements CommandExecutor {

    private final Plugin plugin = Configurations.getPlugin(Configurations.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("getConfig")) {
            if (sender instanceof Player player) {
                String food = plugin.getConfig().getString("Food");
                String number = plugin.getConfig().getString("Number");
                String bl = plugin.getConfig().getString("Boolean");
                String foodList = plugin.getConfig().getString("FoodList");
                player.sendMessage(ChatColor.YELLOW + "The food directed to \"" + ChatColor.RED + food + ChatColor.YELLOW + "\" in config.yml\n" +
                        ChatColor.YELLOW + "The number directed to \"" + ChatColor.RED + number + ChatColor.YELLOW + "\" in config.yml\n" +
                        ChatColor.YELLOW + "The boolean directed to \"" + ChatColor.RED + bl + ChatColor.YELLOW + "\" in config.yml\n" +
                        ChatColor.YELLOW + "The foodList directed to \"" + ChatColor.RED + foodList + ChatColor.YELLOW + "\" in config.yml");
                return true;
            }
        }

        if (command.getName().equalsIgnoreCase("setFoodName")) {
            plugin.getConfig().set("Food", "Chocolate");
            return true;
        }

        return false;
    }
}
