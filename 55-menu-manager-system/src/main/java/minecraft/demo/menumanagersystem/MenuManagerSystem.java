package minecraft.demo.menumanagersystem;

import minecraft.demo.menumanagersystem.commands.SuicideCommand;
import minecraft.demo.menumanagersystem.listeners.MenuListener;
import minecraft.demo.menumanagersystem.menus.PlayerMenuUtility;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class MenuManagerSystem extends JavaPlugin {
    private static final Map<Player, PlayerMenuUtility> playerMenuMap;

    static {
        playerMenuMap = new HashMap<>();
    }

    @Override
    public void onEnable() {
        getCommand("suicide").setExecutor(new SuicideCommand());
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
    }

    public static PlayerMenuUtility getPlayerMenuMap(Player player) {
        if (playerMenuMap.containsKey(player)) return playerMenuMap.get(player);

        PlayerMenuUtility playerMenu = new PlayerMenuUtility(player);
        playerMenuMap.put(player, playerMenu);

        return playerMenu;
    }
}
