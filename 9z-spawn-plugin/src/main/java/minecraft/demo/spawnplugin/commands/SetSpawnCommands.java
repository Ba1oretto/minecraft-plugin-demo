package minecraft.demo.spawnplugin.commands;

import minecraft.demo.spawnplugin.SpawnPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public record SetSpawnCommands(SpawnPlugin plugin) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            Location playerLocation = player.getLocation();
            plugin.getConfig().set("spawn", playerLocation);
            plugin.saveConfig();
            player.sendMessage("Spawn location set!");
        } else {
            sender.sendMessage("Bruh get yo ass on the server");
            return false;
        }
        return true;
    }
}
