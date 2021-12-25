package com.plugins.teleportbow;

import com.plugins.teleportbow.commands.TeleportBowCommand;
import com.plugins.teleportbow.events.TeleportBowEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

import static net.kyori.adventure.text.Component.text;

public final class TeleportBow extends JavaPlugin {
    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new TeleportBowEvent(this), this);
        getCommand("getTpBow").setExecutor(new TeleportBowCommand(this));
    }

    public void setBow(Player player) {
        ItemStack teleportBow = new ItemStack(Material.BOW);
        teleportBow.addEnchantment(Enchantment.ARROW_INFINITE, 1);

        ItemMeta bowMeta = teleportBow.getItemMeta();
        List<Component> lore = new ArrayList<>();
        for (String loreString : getConfig().getStringList("lore")) {
            TextComponent loreComponent = text(ChatColor.translateAlternateColorCodes('&', loreString));
            lore.add(loreComponent);
        }
        bowMeta.lore(lore);

        TextComponent displayName = text(
                ChatColor.translateAlternateColorCodes('&', getConfig().getString("bow-name")));
        bowMeta.displayName(displayName);

        bowMeta.setUnbreakable(true);

        teleportBow.setItemMeta(bowMeta);

        player.getInventory().addItem(teleportBow);
    }
}
