package com.plugins.armorstands;

import com.plugins.armorstands.commands.ArmorStandsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArmorStands extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("spawnArmorStand").setExecutor(new ArmorStandsCommand());
    }

}
