package com.plugins.flystyle.commands;

import com.plugins.flystyle.FlyStyle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FlyCommand implements CommandExecutor {

    private final FlyStyle flyStyle;
    private final List<Player> playerList = new ArrayList<>();

    public FlyCommand(FlyStyle flyStyle) {
        this.flyStyle = flyStyle;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0 && sender instanceof Player player && player.hasPermission("flyPermission.getFly")) {
            if (playerList.contains(player)) {
                player.setAllowFlight(false);
                playerList.remove(player);
                player.sendMessage(
                        ChatColor.translateAlternateColorCodes('&', flyStyle.getConfig().getString("self-turn-off")));

            } else {
                playerList.add(player);
                player.setAllowFlight(true);
                player.sendMessage(
                        ChatColor.translateAlternateColorCodes('&', flyStyle.getConfig().getString("self-turn-on")));
            }
            return true;

        } else if (sender.hasPermission("flyPermission.setFly")) {
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target != null) {
                if (playerList.contains(target)) {
                    target.setAllowFlight(false);
                    target.sendMessage(ChatColor.GREEN + target.getName() +
                            ChatColor.translateAlternateColorCodes('&', flyStyle.getConfig().getString("turn-off")));
                } else {
                    playerList.add(target);
                    target.setAllowFlight(true);
                    target.sendMessage(ChatColor.GREEN + target.getName() +
                            ChatColor.translateAlternateColorCodes('&', flyStyle.getConfig().getString("turn-on")));
                }

            } else {
                sender.sendMessage(
                        ChatColor.translateAlternateColorCodes('&', flyStyle.getConfig().getString("on-miss")));
            }
            return true;
        }
        return false;
    }
}