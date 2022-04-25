package minecraft.demo.targetingplayerswithcommandarguments;

import minecraft.demo.targetingplayerswithcommandarguments.commands.FartCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class TargetingPlayersWithCommandArguments extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("fart").setExecutor(new FartCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
