package minecraft.demo.customevents;

import minecraft.demo.customevents.events.GameEndEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GameOverCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (args.length == 1) {
            String loserName = args[0];
            Player loser = Bukkit.getServer().getPlayer(loserName);
            if (loser == null) return false;
            Bukkit.getServer().getPluginManager().callEvent(new GameEndEvent(player, loser, 4));
        }
        return true;
    }
}
