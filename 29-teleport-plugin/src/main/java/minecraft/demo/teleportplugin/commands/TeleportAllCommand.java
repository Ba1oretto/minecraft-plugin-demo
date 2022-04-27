package minecraft.demo.teleportplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;

public class TeleportAllCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (!player.hasPermission(Permission.DEFAULT_PERMISSION.toString())) return false;
        Bukkit.getServer().getOnlinePlayers().forEach(v -> v.teleport(player));
        player.sendMessage(ChatColor.GREEN + "Teleport all players to your position");
        return true;
    }
}
