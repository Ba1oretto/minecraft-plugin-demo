package minecraft.demo.banguiplugin.listeners;

import minecraft.demo.banguiplugin.utils.BanMenuUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class BanInventoryListeners implements Listener {
    @EventHandler
    public void onGUIClicked(InventoryClickEvent event) {
        if (!event.getView().title().equals(Component.text("Player List", TextColor.color(0, 0, 255)))) return;
        if (event.getCurrentItem() == null) return;

        Player admin = (Player) event.getWhoClicked();
        ItemMeta playerShouldBanedMeta = event.getCurrentItem().getItemMeta();

        if (admin.getServer().getPlayerExact(ChatColor.stripColor(playerShouldBanedMeta.getDisplayName())) == null) return;

        BanMenuUtils.openBanMenu(admin, playerShouldBanedMeta);

        event.setCancelled(true);
    }

    @EventHandler
    public void onMenuClicked(InventoryClickEvent event) {
        if (!event.getView().title().equals(Component.text("Ban", TextColor.color(255, 0, 0)))) return;
        if (event.getCurrentItem() == null) return;

        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem().getType().equals(Material.GREEN_WOOL)) {
            String targetName = event.getClickedInventory().getItem(13).getItemMeta().getDisplayName();
            player.getServer().getBanList(BanList.Type.NAME).addBan(targetName, "Because I said so", null, null);
            player.getServer().getPlayer(targetName).kick(Component.text("Because I said so", TextColor.color(255, 0, 0)));
            player.sendMessage("Banned Player!");
        } else if (event.getCurrentItem().getType().equals(Material.RED_WOOL)) {
            BanMenuUtils.openPlayerList(player);
        }
        event.setCancelled(true);
    }
}
