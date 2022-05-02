package minecraft.demo.menumanagersystem.commands;

import minecraft.demo.menumanagersystem.MenuManagerSystem;
import minecraft.demo.menumanagersystem.menus.MenuBase;
import minecraft.demo.menumanagersystem.menus.SuicideConfirmMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SuicideCommand implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;

        SuicideConfirmMenu suicideConfirmMenu =
                new SuicideConfirmMenu(MenuManagerSystem.getPlayerMenuMap(player));

        suicideConfirmMenu.open();

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return null;
    }
}
