package minecraft.demo.holograms;

import minecraft.demo.holograms.commands.HologramCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Holograms extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("hologram").setExecutor(new HologramCommand());
    }

}
