package minecraft.demo.cooldowns;

import minecraft.demo.cooldowns.commands.FartCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Cooldowns extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("fartcooldown").setExecutor(new FartCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
