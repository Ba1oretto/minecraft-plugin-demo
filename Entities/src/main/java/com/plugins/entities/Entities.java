package com.plugins.entities;

import com.plugins.entities.events.PlayerOnJumpEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Entities extends JavaPlugin {

    @Override
    public void onEnable() {
        //do not use this nearby your home in minecraft!!!
        getServer().getPluginManager().registerEvents(new PlayerOnJumpEvent(), this);
    }

}
