package minecraft.demo.spawnplugin.commands;

import minecraft.demo.spawnplugin.SpawnPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public record SpawnCommands(SpawnPlugin plugin) implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Location spawnLocation = plugin.getConfig().getLocation("spawn");
        if (sender instanceof Player player) {
            if (spawnLocation == null) {
                sender.sendMessage("There is no spawn point set. Use /setspawn to set it.");
                return false;
            }
            player.teleport(spawnLocation);
            player.sendMessage("You have been teleported to the spawn point.");
        } else {
            sender.sendMessage("You are not a entity in server!");
            return false;
        }
        return true;
    }
}