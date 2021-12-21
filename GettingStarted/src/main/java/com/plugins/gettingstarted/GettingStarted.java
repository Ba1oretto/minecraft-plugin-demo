package com.plugins.gettingstarted;

import org.bukkit.plugin.java.JavaPlugin;

public final class GettingStarted extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("启动捏");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("结束捏");
    }
}
