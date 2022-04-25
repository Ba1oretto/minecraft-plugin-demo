package minecraft.demo.commandarguments.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class RepeatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 0) {
            StringBuilder stringBuffer = new StringBuilder();
            Arrays.stream(args).iterator().forEachRemaining(v -> stringBuffer.append(v).append(" "));
            String finalMessage = stringBuffer.toString().stripTrailing();
            if (sender instanceof Player player) {
                player.sendMessage("repeat: " + finalMessage);
            } else {
                sender.sendMessage("repeat: " + finalMessage);
            }
        } else {
            sender.sendMessage("Usage: /repeat [<command>...]");
            return false;
        }
        return true;
    }
}
