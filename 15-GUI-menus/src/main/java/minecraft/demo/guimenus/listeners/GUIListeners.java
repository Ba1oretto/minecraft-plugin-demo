package minecraft.demo.guimenus.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class GUIListeners implements Listener {
    @EventHandler
    public void onPlayerClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getView().title().equals(Component.text("Custom GUI", TextColor.color(255, 192, 203)))) {
            if (event.getCurrentItem() == null) return;
            switch (event.getCurrentItem().getType()) {
                case TNT -> {
                    player.closeInventory();
                    player.setHealth(0.0);
                    player.sendMessage("You just kill yourself.");
                }
                case BREAD -> {
                    player.closeInventory();
                    player.setFoodLevel(20);
                    player.sendMessage("Yum!");
                }
                case NETHERITE_SWORD -> {
                    player.closeInventory();
                    player.getInventory().addItem(new ItemStack(Material.NETHERITE_SWORD));
                    player.sendMessage("Don't slice yourself.");
                }
            }
            event.setCancelled(true);
        }
    }
}
