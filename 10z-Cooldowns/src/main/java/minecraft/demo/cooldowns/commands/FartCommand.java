package minecraft.demo.cooldowns.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FartCommand implements CommandExecutor {
    private final Map<UUID, Long> cooldownMap;

    public FartCommand() {
        this.cooldownMap = new HashMap<>();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (!cooldownMap.containsKey(player.getUniqueId())) {
                cooldownMap.put(player.getUniqueId(), System.currentTimeMillis());
                player.sendMessage("You farted! Oopsies");
            } else {
                long timeElapsed = System.currentTimeMillis() - cooldownMap.get(player.getUniqueId());
                if (timeElapsed >= 10000L) {
                    cooldownMap.replace(player.getUniqueId(), System.currentTimeMillis());
                    player.sendMessage("You farted! Oopsies");
                } else {
                    player.sendMessage("You can't fart again for another " + (10000L - timeElapsed) + " milliseconds");
                }
            }
        }
        return true;
    }
}
