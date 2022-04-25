package minecraft.demo.targetingplayerswithcommandarguments.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player player) {
                player.sendMessage("You are so nasty, you have just farted all over yourself. Get your self together man.");
                player.setHealth(0.0);
            } else {
                sender.sendMessage("Usage: /fart <player name>");
                return false;
            }
        } else if (args.length == 1) {
            String playerName = args[0];
            Player target = Bukkit.getServer().getPlayerExact(playerName);
            if (target == null) {
                sender.sendMessage("This player is not online");
                return false;
            }
            if (sender instanceof Player player) {
                target.sendMessage("You have just been farted on by " + player.getName() + ". How dose that make you feel?");
            } else {
                target.sendMessage("You have just been farted on. How dose that make you feel?");
            }
            target.setHealth(0.0);
            sender.sendMessage("You successfully farted on " + target.getName());
        } else {
            sender.sendMessage("Usage: /fart [<player name>]");
            return false;
        }
        return true;
    }
}
