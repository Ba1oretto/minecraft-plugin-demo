package minecraft.demo.guimenus.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GUICommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            Inventory gui = Bukkit.createInventory(player, 9, Component.text("Custom GUI", TextColor.color(255, 192, 203)));

            ItemStack suicide = new ItemStack(Material.TNT);
            ItemStack feed = new ItemStack(Material.BREAD);
            ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);

            ItemMeta suicideMeta = suicide.getItemMeta();
            suicideMeta.displayName(Component.text("Suicide", TextColor.color(255, 0, 0)));
            List<Component> suicideLore = new ArrayList<>();
            suicideLore.add(Component.text("Kill yourself."));
            suicideMeta.lore(suicideLore);
            suicide.setItemMeta(suicideMeta);

            ItemMeta feedMeta = feed.getItemMeta();
            feedMeta.displayName(Component.text("Feed", TextColor.color(0, 255, 0)));
            List<Component> feedLore = new ArrayList<>();
            feedLore.add(Component.text("Hunger no more."));
            feedMeta.lore(feedLore);
            feed.setItemMeta(feedMeta);

            ItemMeta swordMeta = sword.getItemMeta();
            swordMeta.displayName(Component.text("Sword", TextColor.color(0, 0, 255)));
            List<Component> swordLore = new ArrayList<>();
            swordLore.add(Component.text("Get a sword."));
            swordMeta.lore(swordLore);
            sword.setItemMeta(swordMeta);

            gui.addItem(suicide, feed, sword);

            player.openInventory(gui);
        }
        return true;
    }
}