package minecraft.demo.teleportplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;

public class TeleportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (!player.hasPermission(Permission.DEFAULT_PERMISSION.toString())) return false;

        if (args.length < 1 || args.length > 2) {
            player.sendMessage("You need to provide an available argument");
            return false;
        }

        String targetName = args[0];
        Player target = player.getServer().getPlayer(targetName);
        if (target == null) {
            player.sendMessage("Please provide an exist player");
            return false;
        }

        if (args.length == 1) {
            player.teleport(target);
            player.sendMessage("teleport " + ChatColor.GREEN + player.getName() + ChatColor.WHITE +  " to " + ChatColor.GREEN + targetName);
            return true;
        }

        String toTargetName = args[1];
        Player toTarget = player.getServer().getPlayer(toTargetName);

        if (toTarget == null) {
            player.sendMessage("There are no available players that can teleport.");
            return false;
        }

        target.teleport(toTarget);
        player.sendMessage("teleport " + ChatColor.GREEN + targetName + ChatColor.WHITE +  " to " + ChatColor.GREEN + toTargetName);
        return true;
    }
}
