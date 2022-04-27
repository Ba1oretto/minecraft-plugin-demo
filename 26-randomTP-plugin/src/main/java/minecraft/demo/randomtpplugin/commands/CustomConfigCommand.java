package minecraft.demo.randomtpplugin.commands;

import minecraft.demo.randomtpplugin.utils.CustomConfigUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;

public class CustomConfigCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission(String.valueOf(Permission.DEFAULT_PERMISSION))) return false;
        CustomConfigUtils.reload();
        return true;
    }
}
