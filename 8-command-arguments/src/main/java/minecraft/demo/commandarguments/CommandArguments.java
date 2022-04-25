package minecraft.demo.commandarguments;

import minecraft.demo.commandarguments.commands.RepeatCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandArguments extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("repeat").setExecutor(new RepeatCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
