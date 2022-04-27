package minecraft.demo.banguiplugin.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BanMenuUtils {

    public static void openBanMenu(Player player, ItemMeta targetMeta) {

        Inventory confirmMenu = Bukkit.createInventory(player, 27, Component.text("Ban", TextColor.color(255, 0, 0)));

        ItemStack target = new ItemStack(Material.PLAYER_HEAD);
        target.setItemMeta(targetMeta);

        ItemStack confirm = new ItemStack(Material.GREEN_WOOL);
        ItemMeta confirmMeta = confirm.getItemMeta();
        confirmMeta.displayName(Component.text("confirm", TextColor.color(0, 128, 0)));
        confirm.setItemMeta(confirmMeta);

        ItemStack cancel = new ItemStack(Material.RED_WOOL);
        ItemMeta cancelMeta = cancel.getItemMeta();
        cancelMeta.displayName(Component.text("cancel", TextColor.color(255, 0, 0)));
        cancel.setItemMeta(cancelMeta);

        confirmMenu.setItem(11, confirm);
        confirmMenu.setItem(13, target);
        confirmMenu.setItem(15, cancel);

        player.openInventory(confirmMenu);
    }

    public static void openPlayerList(Player player) {
        Collection<? extends Player> playerList = player.getServer().getOnlinePlayers();
        Inventory gui = Bukkit.createInventory(player, 45, Component.text("Player List", TextColor.color(0, 0, 255)));
        playerList.forEach(v -> {
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
            ItemMeta playerHeadMeta = playerHead.getItemMeta();
            playerHeadMeta.displayName(v.displayName());
            List<Component> lore = new ArrayList<>();
            lore.add(Component.text("Player Health: ", TextColor.color(255,215,0)).append(Component.text(v.getHealth(), TextColor.color(255, 0, 0))));
            lore.add(Component.text("Player Exp: ", TextColor.color(255,215,0)).append(Component.text(v.getExp(), TextColor.color(212, 242, 231))));
            playerHeadMeta.lore(lore);
            playerHead.setItemMeta(playerHeadMeta);
            gui.addItem(playerHead);
        });
        player.openInventory(gui);
    }
}
