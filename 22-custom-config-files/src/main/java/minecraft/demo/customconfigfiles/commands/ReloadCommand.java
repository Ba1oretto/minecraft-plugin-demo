package minecraft.demo.customconfigfiles.commands;

import minecraft.demo.customconfigfiles.files.CustomConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        CustomConfig.reload();
        sender.sendMessage(ChatColor.AQUA + "reloaded!");
        return true;
    }
}
