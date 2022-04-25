package minecraft.demo.armorstandguipluginp1;

import minecraft.demo.armorstandguipluginp1.commands.ArmorStandCommand;
import minecraft.demo.armorstandguipluginp1.listeners.MenuListeners;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class ArmorStandGUIPluginP1 extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("armorstand").setExecutor(new ArmorStandCommand(this));
        getServer().getPluginManager().registerEvents(new MenuListeners(), this);
    }

    public void openMainMenu(Player player) {
        Inventory mainMenu = Bukkit.createInventory(player, 9, Component.text("Armor Stand GUI", TextColor.color(0, 0, 255)));

        ItemStack create = new ItemStack(Material.ARMOR_STAND);

        ItemMeta createMeta = create.getItemMeta();
        createMeta.displayName(Component.text("create", TextColor.color(0, 255, 0)));
        List<Component> createLore = new ArrayList<>();
        createLore.add(Component.text("Create a new armor stand.", TextColor.color(255, 192, 203)));
        createMeta.lore(createLore);
        create.setItemMeta(createMeta);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.displayName(Component.text("close", TextColor.color(255, 0 ,0)));
        close.setItemMeta(closeMeta);

        mainMenu.setItem(4, create);
        mainMenu.setItem(8, close);

        player.openInventory(mainMenu);
    }
}
