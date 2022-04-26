package minecraft.demo.customconfigfiles;

import minecraft.demo.customconfigfiles.commands.Message;
import minecraft.demo.customconfigfiles.commands.ReloadCommand;
import minecraft.demo.customconfigfiles.files.CustomConfig;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomConfigFiles extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        CustomConfig.setUp();
        CustomConfig.get().addDefault("message", "this is the default message.");
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();

        getCommand("message").setExecutor(new Message());
        getCommand("preload").setExecutor(new ReloadCommand());
    }

}
