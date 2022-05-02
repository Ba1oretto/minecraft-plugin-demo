package minecraft.demo.tabcompletionwithcommands;

import minecraft.demo.tabcompletionwithcommands.commands.MurderCommand;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class TabCompletionWithCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginCommand murderCommand = getCommand("murder");
        if (murderCommand != null) {
            murderCommand.setExecutor(new MurderCommand());
        }
    }

}
