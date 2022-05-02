package minecraft.demo.customenchantments;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public final class CustomEnchantments extends JavaPlugin {

    private static CustomEnchantments plugin;

    @Override
    public void onEnable() {
        plugin = this;
    }

    public static CustomEnchantments getPlugin() {
        return plugin;
    }
}
