package minecraft.demo.wolfyutilities.inventories;

import me.wolfyscript.utilities.api.WolfyUtilities;
import me.wolfyscript.utilities.api.inventory.gui.InventoryAPI;
import minecraft.demo.wolfyutilities.cache.MyCache;
import minecraft.demo.wolfyutilities.cluster.CustomCluster;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CustomInventory implements CommandExecutor {
    private final InventoryAPI<MyCache> inventoryAPI;

    public CustomInventory(WolfyUtilities api) {
        this.inventoryAPI = api.getInventoryAPI(MyCache.class);
    }

    public void createInventory() {
        inventoryAPI.registerCluster(new CustomCluster(inventoryAPI));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        createInventory();

        inventoryAPI.openCluster(player, CustomCluster.KEY);
        return true;
    }
}
