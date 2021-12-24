package com.plugins.vaultinventory;

import com.plugins.vaultinventory.commands.VaultCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class VaultInventory extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("Vault").setExecutor(new VaultCommand());
    }

//    @Override
//    public void onDisable() {
//    }
}
