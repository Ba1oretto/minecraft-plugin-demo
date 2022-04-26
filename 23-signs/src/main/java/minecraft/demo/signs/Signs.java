package minecraft.demo.signs;

import minecraft.demo.signs.commands.CustomSign;
import minecraft.demo.signs.listeners.SignListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class Signs extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("sign").setExecutor(new CustomSign());
        getServer().getPluginManager().registerEvents(new SignListeners(), this);
    }

}
