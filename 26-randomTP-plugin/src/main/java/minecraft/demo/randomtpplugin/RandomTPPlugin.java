package minecraft.demo.randomtpplugin;

import minecraft.demo.randomtpplugin.commands.CustomConfigCommand;
import minecraft.demo.randomtpplugin.commands.RandomTPCommand;
import minecraft.demo.randomtpplugin.utils.CustomConfigUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomTPPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();



        CustomConfigUtils.setup();
        CustomConfigUtils.get().addDefault("world-border", true);
        CustomConfigUtils.get().addDefault("cooldown", 10000L);
        CustomConfigUtils.get().addDefault("randomX", 200);
        CustomConfigUtils.get().addDefault("randomZ", 200);
        CustomConfigUtils.get().options().copyDefaults(true);
        CustomConfigUtils.save();

        getCommand("26-reload").setExecutor(new CustomConfigCommand());
        getCommand("26-randomTP").setExecutor(new RandomTPCommand());
    }

}
