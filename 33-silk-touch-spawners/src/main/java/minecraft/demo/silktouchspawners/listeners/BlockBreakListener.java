package minecraft.demo.silktouchspawners.listeners;

import minecraft.demo.silktouchspawners.events.SpawnerBreakEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.permissions.Permission;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block eventBlock = event.getBlock();

        if (!eventBlock.getType().equals(Material.SPAWNER) || !event.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) || !event.getPlayer().hasPermission(Permission.DEFAULT_PERMISSION.toString())) return;

        Bukkit.getServer().getPluginManager().callEvent(new SpawnerBreakEvent(event.getPlayer(), eventBlock));
    }
}
