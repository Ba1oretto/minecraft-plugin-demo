package minecraft.demo.armorstandguipluginp3.listeners;

import minecraft.demo.armorstandguipluginp3.ArmorStandGUIPluginP3;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public record MenuListeners(ArmorStandGUIPluginP3 plugin) implements Listener {
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

        if (!title.equals(Component.text("Create a Armor Stand", TextColor.color(0, 128, 0)))) return;
        if (event.getCurrentItem() == null) return;

        Player player = (Player) event.getWhoClicked();

        if (!plugin.armorStands.containsKey(player)) {
            ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
            armorStand.setVisible(false);
            plugin.armorStands.put(player, armorStand);
        }

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
            case GREEN_WOOL -> {
                player.sendMessage("Create Armor Stand.");
                if (plugin.armorStands.containsKey(player)) {
                    ArmorStand armorStand = plugin.armorStands.get(player);
                    armorStand.setVisible(true);
                    plugin.armorStands.remove(player);
                }
                player.closeInventory();
            }
            case RED_WOOL -> {
                player.sendMessage("Delete Armor Stand.");
                if (plugin.armorStands.containsKey(player)) {
                    ArmorStand armorStand = plugin.armorStands.get(player);
                    armorStand.remove();
                    plugin.armorStands.remove(player);
                }
                player.closeInventory();
            }
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void onOptionMenuClicked(InventoryClickEvent event) {
        if (!event.getView().title().equals(Component.text("Confirm Option", TextColor.color(0, 128, 0)))) return;
        if (event.getCurrentItem() == null) return;
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory() == null) return;

        switch (event.getCurrentItem().getType()) {
            case GREEN_WOOL -> {
                player.sendMessage("Option Confirmed.");
                if (plugin.armorStands.containsKey(player)) {
                    ArmorStand armorStand = plugin.armorStands.get(player);

                    if (event.getClickedInventory().contains(Material.ARMOR_STAND)) {
                        armorStand.setArms(true);
                    } else if (event.getClickedInventory().contains(Material.BEACON)) {
                        armorStand.setGlowing(true);
                    } else if (event.getClickedInventory().contains(Material.STONE_SLAB)) {
                        armorStand.setBasePlate(true);
                    }

                }
                plugin.openCreateMenu(player);
            }
            case RED_WOOL -> {
                player.sendMessage("Option Canceled.");
                if (plugin.armorStands.containsKey(player)) {
                    ArmorStand armorStand = plugin.armorStands.get(player);

                    if (event.getClickedInventory().contains(Material.ARMOR_STAND)) {
                        armorStand.setArms(false);
                    } else if (event.getClickedInventory().contains(Material.BEACON)) {
                        armorStand.setGlowing(false);
                    } else if (event.getClickedInventory().contains(Material.STONE_SLAB)) {
                        armorStand.setBasePlate(false);
                    }

                }
                plugin.openCreateMenu(player);
            }
        }
        event.setCancelled(true);
    }
}
