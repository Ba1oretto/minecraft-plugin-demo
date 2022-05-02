package minecraft.demo.tabcompletionwithcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MurderCommand implements TabExecutor {
    private final List<String> playerList;

    public MurderCommand() {
        playerList = new ArrayList<>();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;

        if (args.length == 0) {
            player.setHealth(0);
            return true;
        }

        if (args.length == 1) {
            String targetName = args[1];
            Player target = Bukkit.getServer().getPlayer(targetName);
            if (target == null) return false;
            target.setHealth(0.0);
            return true;
        }

        if (args.length == 2) {
            player.sendMessage("Nothing happened");
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            playerList.addAll(Bukkit.getOnlinePlayers().stream().map(HumanEntity::getName).toList());
            return playerList;
        }
        if (args.length == 2) {
            playerList.add("wwww");
            playerList.add("aaaa");
            playerList.add("cccc");
            playerList.add("bbbb");
            return playerList;
        }
        return null;
    }
}
