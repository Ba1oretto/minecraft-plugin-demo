package minecraft.demo.armorstandguipluginp1.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListeners implements Listener {
    @EventHandler
    public void onMenuClicked(InventoryClickEvent event) {
        if (event.getView().title().equals(Component.text("Armor Stand GUI", TextColor.color(0, 0, 255)))) {
            Player player = (Player) event.getWhoClicked();
            if (event.getCurrentItem() == null) return;
            switch (event.getCurrentItem().getType()) {
                case ARMOR_STAND -> {
                    player.sendMessage("Opened Armor Stand Create Menu.");
                    player.closeInventory();
                }
                case BARRIER -> {
                    player.sendMessage("Closing Main Menu");
                    player.closeInventory();
                }
            }
            event.setCancelled(true);
        }
    }
}
