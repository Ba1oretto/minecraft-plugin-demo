package minecraft.demo.armorstandguipluginp2.listeners;

import minecraft.demo.armorstandguipluginp2.ArmorStandGUIPluginP2;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public record MenuListeners(ArmorStandGUIPluginP2 plugin) implements Listener {
    @EventHandler
    public void onMenuClicked(InventoryClickEvent event) {
        if (event.getView().title().equals(Component.text("Armor Stand GUI", TextColor.color(0, 0, 255)))) {
            Player player = (Player) event.getWhoClicked();
            if (event.getCurrentItem() == null) return;
            switch (event.getCurrentItem().getType()) {
                case ARMOR_STAND -> {
                    player.sendMessage("Opened Armor Stand Create Menu.");
                    plugin.openCreateMenu(player);
                }
                case BARRIER -> {
                    player.sendMessage("Closing Main Menu");
                    player.closeInventory();
                }
            }
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onCreateMenuClicked(InventoryClickEvent event) {
        Component title = event.getView().title();

        if (!title.equals(Component.text("Create a Armor Stand", TextColor.color(0,128,0)))) return;
        if (event.getCurrentItem() == null) return;

        Player player = (Player) event.getWhoClicked();

        switch (event.getCurrentItem().getType()) {
            case ARMOR_STAND -> {
                player.sendMessage("Add Arms?");
                plugin.openConfirmMenu(player, Material.ARMOR_STAND);
            }
            case BEACON -> {
                player.sendMessage("Add Glow?");
                plugin.openConfirmMenu(player, Material.BEACON);
            }
            case LEATHER_CHESTPLATE -> {
                player.sendMessage("Add Armor?");
                plugin.openConfirmMenu(player, Material.LEATHER_CHESTPLATE);
            }
            case STONE_SLAB -> {
                player.sendMessage("Add Base?");
                plugin.openConfirmMenu(player, Material.STONE_SLAB);
            }
        }
        event.setCancelled(true);
    }
}
