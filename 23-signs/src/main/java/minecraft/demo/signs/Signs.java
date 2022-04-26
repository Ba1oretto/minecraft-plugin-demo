package minecraft.demo.signs;

import minecraft.demo.signs.commands.CustomSign;
import org.bukkit.plugin.java.JavaPlugin;

public final class Signs extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("sign").setExecutor(new CustomSign());
    }

}
