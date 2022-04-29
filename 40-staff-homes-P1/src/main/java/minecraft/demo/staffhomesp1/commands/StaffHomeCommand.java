package minecraft.demo.staffhomesp1.commands;

import minecraft.demo.staffhomesp1.StaffHomesP1;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;

public record StaffHomeCommand(StaffHomesP1 plugin) implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (args.length != 1) {
            StringBuilder sb = new StringBuilder();
            plugin.getConfig().getStringList("message").forEach(v -> {
                String message = ChatColor.translateAlternateColorCodes('&', v);
                sb.append(message).append("\n");
            });
            String message = sb.toString().stripTrailing();
            player.sendMessage(message);
            return false;
        }

        if (args[0].equalsIgnoreCase("set")) {
            Location legacy = plugin.getConfig().getLocation("savedlocation." + player.getName());
            if (legacy != null) {
                player.sendMessage("Overriding a temporary home at X: " + ChatColor.GREEN + legacy.getBlockX() + ChatColor.GRAY + ", Y: " + ChatColor.GREEN + legacy.getBlockY() + ChatColor.GRAY + ", Z: " + ChatColor.GREEN + legacy.getBlockZ());
            }
            Location location = player.getLocation();
            plugin.getConfig().set("savedlocation." + player.getName(), location);
            plugin.saveConfig();
            player.sendMessage("Setting a temporary home at X: " + ChatColor.GREEN + location.getBlockX() + ChatColor.GRAY + ", Y: " + ChatColor.GREEN + location.getBlockY() + ChatColor.GRAY + ", Z: " + ChatColor.GREEN + location.getBlockZ());
            return true;
        }

        if (args[0].equalsIgnoreCase("return")) {
            Location location = plugin.getConfig().getLocation("savedlocation." + player.getName());
            if (location == null) {
                player.sendMessage("You do not have home");
                return false;
            }
            player.teleport(location);
            plugin.getConfig().set("savedlocation." + player.getName(), null);
            plugin.saveConfig();
            player.sendMessage("You are teleported to home");
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            plugin.reloadConfig();
            player.sendMessage(ChatColor.GRAY + "configuration reloaded.");
            return true;
        }

        if (!player.hasPermission(Permission.DEFAULT_PERMISSION.toString())) return false;

        String targetName = args[0];
        Player target = Bukkit.getPlayer(targetName);

        if (target == null) {
            player.sendMessage(ChatColor.GRAY + targetName + " is not a player");
            return false;
        }

        Location location = plugin.getConfig().getLocation("savedlocation." + target.getName());
        if (location == null) {
            player.sendMessage(ChatColor.GRAY + targetName + " does not have a home set.");
            return false;
        }

        player.teleport(location);
        player.sendMessage(ChatColor.GRAY + "teleport to temporary staff home(" + ChatColor.AQUA + targetName + ChatColor.GRAY + ") at X: " + ChatColor.GREEN + location.getBlockX() + ChatColor.GRAY + ", Y: " + ChatColor.GREEN + location.getBlockY() + ChatColor.GRAY + ", Z: " + ChatColor.GREEN + location.getBlockZ());

        return true;
    }
}
