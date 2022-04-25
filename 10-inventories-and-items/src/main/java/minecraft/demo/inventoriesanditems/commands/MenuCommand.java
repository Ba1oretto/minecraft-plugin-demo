package minecraft.demo.inventoriesanditems.commands;

import net.kyori.adventure.text.Component;
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

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;
        Inventory playerInventory = Bukkit.createInventory(player, 9,
                Component.text("Potato Time", TextColor.color(255, 192, 203)));
        player.openInventory(playerInventory);

        ItemStack itemHoe = new ItemStack(Material.DIAMOND_HOE, 1);
        ItemMeta itemHoeMeta = itemHoe.getItemMeta();
        itemHoeMeta.displayName(Component.text("Click Me.", TextColor.color(0, 255, 0)));
        itemHoe.setItemMeta(itemHoeMeta);

        ItemStack itemBeef = new ItemStack(Material.BEEF, 16);

        ItemStack itemFlower = new ItemStack(Material.POPPY, 16);
        ItemMeta itemFlowerMeta = itemFlower.getItemMeta();
        itemFlowerMeta.displayName(Component.text("Sexy Flower"));
        List<Component> flowerFlore = new ArrayList<>();
        flowerFlore.add(Component.text("This is the "));
        flowerFlore.add(Component.text("coolest flower "));
        flowerFlore.add(Component.text("on the planet."));
        itemFlowerMeta.lore(flowerFlore);
        itemFlowerMeta.addEnchant(Enchantment.DURABILITY, 3, false);
        itemFlower.setItemMeta(itemFlowerMeta);

        playerInventory.addItem(itemHoe, itemBeef, itemFlower);

        player.openInventory(playerInventory);
        return true;
    }
}
