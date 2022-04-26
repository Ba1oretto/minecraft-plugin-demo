package minecraft.demo.armorstandguipluginp4.commands;

import minecraft.demo.armorstandguipluginp4.ArmorStandGUIPluginP4;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public record ArmorStandCommand(ArmorStandGUIPluginP4 plugin) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            plugin.openMainMenu(player);
        }
        return true;
    }

}
