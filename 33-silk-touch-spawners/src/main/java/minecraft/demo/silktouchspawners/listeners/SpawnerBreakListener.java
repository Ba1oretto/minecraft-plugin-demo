package minecraft.demo.silktouchspawners.listeners;

import minecraft.demo.silktouchspawners.events.SpawnerBreakEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

public class SpawnerBreakListener implements Listener {
    @EventHandler
    public void onSpawnerBreak(SpawnerBreakEvent event) {
        CreatureSpawner creatureSpawner = (CreatureSpawner) event.getSpawner().getState();

        ItemStack currentCreature = new ItemStack(Material.SPAWNER);
        BlockStateMeta creatureMeta = (BlockStateMeta) currentCreature.getItemMeta();

        CreatureSpawner spawnerBlockState = (CreatureSpawner) creatureMeta.getBlockState();
        spawnerBlockState.setSpawnedType(creatureSpawner.getSpawnedType());

        creatureMeta.setBlockState(spawnerBlockState);
        currentCreature.setItemMeta(creatureMeta);

        event.getBreaker().sendMessage(ChatColor.GREEN + "You have silk touched this spawner");
        event.getBreaker().getInventory().addItem(currentCreature);
    }
}
