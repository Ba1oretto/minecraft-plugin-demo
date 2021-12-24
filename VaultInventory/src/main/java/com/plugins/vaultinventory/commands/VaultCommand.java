package com.plugins.vaultinventory.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class VaultCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            ItemStack itemStack = new ItemStack(Material.PAPER);
            Inventory inventory = Bukkit.createInventory(player, 18, "YOUR INVENTORY");
            TextComponent itemName = Component.text("test name");
            TextComponent itemLore = Component.text("test lore", TextColor.color(255, 192, 203));
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.displayName(itemName);
            List<Component> loreLists = new ArrayList<>();
            loreLists.add(itemLore);
            itemMeta.lore(loreLists);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(0, itemStack);
            player.openInventory(inventory);
            return true;
        }
        return false;
    }
}
