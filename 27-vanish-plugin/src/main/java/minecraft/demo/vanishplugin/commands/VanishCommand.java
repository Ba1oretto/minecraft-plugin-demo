package minecraft.demo.vanishplugin.commands;

import minecraft.demo.vanishplugin.VanishPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public record VanishCommand(VanishPlugin vanishPlugin, List<Player> invisiblePlayerList) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (!player.hasPermission(Permission.DEFAULT_PERMISSION.toString())) return false;

        Collection<? extends Player> onlinePlayers = vanishPlugin.getServer().getOnlinePlayers();

        if (invisiblePlayerList.contains(player)) {
            onlinePlayers.forEach(v -> v.showPlayer(vanishPlugin, player));
            invisiblePlayerList.remove(player);
            player.sendMessage("You are no longer invisible!");
            return true;
        }

        onlinePlayers.forEach(v -> v.hidePlayer(vanishPlugin, player));
        invisiblePlayerList.add(player);
        player.sendMessage("You now are invisible");

        return true;
    }
}
