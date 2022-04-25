package minecraft.demo.inventoriesanditems.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListeners implements Listener {
    @EventHandler
    public void onMenuOpened(InventoryClickEvent event) {
        Component inventoryTitle = event.getView().title();
        if (inventoryTitle.equals(Component.text("Potato Time", TextColor.color(255, 192, 203)))) {
            if (event.getCurrentItem() == null) return;
            Material materialType = event.getCurrentItem().getType();
            HumanEntity eventPlayer = event.getView().getPlayer();
            if (materialType == Material.POPPY) {
                eventPlayer.sendMessage("You clicked a poppy!");
            } else if (materialType == Material.BEEF) {
                eventPlayer.sendMessage("you clicked the beef!");
            } else {
                eventPlayer.sendMessage("You clicked something else!");
            }
            event.setCancelled(true);
        }
    }
}
