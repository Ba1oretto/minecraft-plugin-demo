package minecraft.demo.commandmanagers;

import minecraft.demo.commandmanagers.commands.CommandManager;
import minecraft.demo.commandmanagers.commands.ExplodeCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandManagers extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("prank").setExecutor(new CommandManager(new ExplodeCommand()));
    }
}
