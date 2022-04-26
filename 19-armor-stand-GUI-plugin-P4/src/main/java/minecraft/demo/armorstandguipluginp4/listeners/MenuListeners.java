package minecraft.demo.armorstandguipluginp4.listeners;

import minecraft.demo.armorstandguipluginp4.ArmorStandGUIPluginP4;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public record MenuListeners(ArmorStandGUIPluginP4 plugin) implements Listener {
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
                plugin.openArmorMenu(player);
            }
            case STONE_SLAB -> {
                player.sendMessage("Add Base?");
                plugin.openConfirmMenu(player, Material.STONE_SLAB);
            }
            case GREEN_WOOL -> {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("create-message"))));
                if (plugin.armorStands.containsKey(player)) {
                    ArmorStand armorStand = plugin.armorStands.get(player);
                    armorStand.setVisible(true);
                    plugin.armorStands.remove(player);
                }
                player.closeInventory();
            }
            case RED_WOOL -> {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("delete-message"))));
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
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("confirm-option"))));
                if (plugin.armorStands.containsKey(player)) {
                    ArmorStand armorStand = plugin.armorStands.get(player);
                    EntityEquipment armorStandEquipment = armorStand.getEquipment();

                    if (event.getClickedInventory().contains(Material.ARMOR_STAND)) {
                        armorStand.setArms(true);
                    } else if (event.getClickedInventory().contains(Material.BEACON)) {
                        armorStand.setGlowing(true);
                    } else if (event.getClickedInventory().contains(Material.STONE_SLAB)) {
                        armorStand.setBasePlate(true);
                    } else if (event.getClickedInventory().contains(Material.DIAMOND_HELMET)) {
                        armorStandEquipment.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                        plugin.openArmorMenu(player);
                        return;
                    } else if (event.getClickedInventory().contains(Material.DIAMOND_CHESTPLATE)) {
                        armorStandEquipment.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                        plugin.openArmorMenu(player);
                        return;
                    } else if (event.getClickedInventory().contains(Material.DIAMOND_LEGGINGS)) {
                        armorStandEquipment.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                        plugin.openArmorMenu(player);
                        return;
                    } else if (event.getClickedInventory().contains(Material.DIAMOND_BOOTS)) {
                        armorStandEquipment.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                        plugin.openArmorMenu(player);
                        return;
                    }

                }
                plugin.openCreateMenu(player);
            }
            case RED_WOOL -> {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("cancel-option"))));
                if (plugin.armorStands.containsKey(player)) {
                    ArmorStand armorStand = plugin.armorStands.get(player);
                    EntityEquipment armorStandEquipment = armorStand.getEquipment();

                    if (event.getClickedInventory().contains(Material.ARMOR_STAND)) {
                        armorStand.setArms(false);
                    } else if (event.getClickedInventory().contains(Material.BEACON)) {
                        armorStand.setGlowing(false);
                    } else if (event.getClickedInventory().contains(Material.STONE_SLAB)) {
                        armorStand.setBasePlate(false);
                    } else if (event.getClickedInventory().contains(Material.DIAMOND_HELMET)) {
                        armorStandEquipment.setHelmet(null);
                        plugin.openArmorMenu(player);
                        return;
                    } else if (event.getClickedInventory().contains(Material.DIAMOND_CHESTPLATE)) {
                        armorStandEquipment.setChestplate(null);
                        plugin.openArmorMenu(player);
                        return;
                    } else if (event.getClickedInventory().contains(Material.DIAMOND_LEGGINGS)) {
                        armorStandEquipment.setLeggings(null);
                        plugin.openArmorMenu(player);
                        return;
                    } else if (event.getClickedInventory().contains(Material.DIAMOND_BOOTS)) {
                        armorStandEquipment.setBoots(null);
                        plugin.openArmorMenu(player);
                        return;
                    }

                }
                plugin.openCreateMenu(player);
            }
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void onArmorMenuClicked(InventoryClickEvent event) {
        if (!event.getView().title().equals(Component.text("Choose some Armor", TextColor.color(0, 0, 255)))) return;
        if (event.getCurrentItem() == null) return;

        Player player = (Player) event.getWhoClicked();

        if (!plugin.armorStands.containsKey(player)) return;
        if (event.getClickedInventory() == null) return;

        switch (event.getCurrentItem().getType()) {
            case DIAMOND_HELMET -> plugin.openConfirmMenu(player, Material.DIAMOND_HELMET);
            case DIAMOND_CHESTPLATE -> plugin.openConfirmMenu(player, Material.DIAMOND_CHESTPLATE);
            case DIAMOND_LEGGINGS -> plugin.openConfirmMenu(player, Material.DIAMOND_LEGGINGS);
            case DIAMOND_BOOTS -> plugin.openConfirmMenu(player, Material.DIAMOND_BOOTS);
            case GREEN_WOOL -> plugin.openCreateMenu(player);
        }

        event.setCancelled(true);
    }
}
