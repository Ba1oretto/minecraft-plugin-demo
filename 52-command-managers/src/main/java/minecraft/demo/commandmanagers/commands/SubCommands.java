package minecraft.demo.commandmanagers.commands;

import org.bukkit.entity.Player;

public abstract class SubCommands {
    String name;
    String description;
    String syntax;

    abstract String getName();

    abstract String getDescription();

    abstract String getSyntax();

    abstract void perform(Player player, String ...args);
}
