package minecraft.demo.menumanagersystem.listeners;

import minecraft.demo.menumanagersystem.menus.MenuBase;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuListener implements Listener {
    @EventHandler
    public void onMenuClicked(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return;
        Player player = (Player) event.getWhoClicked();
        InventoryHolder holder = event.getClickedInventory().getHolder();
        if (!(holder instanceof MenuBase menuBase)) return;
        event.setCancelled(true);

        menuBase.handleMenu(event);
    }
}
