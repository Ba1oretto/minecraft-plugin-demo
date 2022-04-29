package minecraft.demo.staffhomesp1;

import minecraft.demo.staffhomesp1.commands.StaffHomeCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaffHomesP1 extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        if (getConfig().getBoolean("enable")) {
            getCommand("staffhome").setExecutor(new StaffHomeCommand(this));
        }
    }

}
