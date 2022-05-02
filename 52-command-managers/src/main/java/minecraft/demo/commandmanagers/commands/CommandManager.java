package minecraft.demo.commandmanagers.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager implements CommandExecutor {
    private final List<SubCommands> subCommands;

    public CommandManager(SubCommands ...commands) {
        subCommands = new ArrayList<>(Arrays.asList(commands));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) return true;
        subCommands.forEach(v -> {
            if (args[0].equalsIgnoreCase(v.getName())){
                v.perform((Player) sender, args[1]);
            }
        });

        return true;
    }
}
