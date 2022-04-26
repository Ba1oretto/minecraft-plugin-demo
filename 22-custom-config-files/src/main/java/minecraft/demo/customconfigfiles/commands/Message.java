package minecraft.demo.customconfigfiles.commands;

import minecraft.demo.customconfigfiles.files.CustomConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Message implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return true;

        String message = CustomConfig.get().getString("message");
        if (message == null) return false;

        player.sendMessage(message);

        return true;
    }
}
