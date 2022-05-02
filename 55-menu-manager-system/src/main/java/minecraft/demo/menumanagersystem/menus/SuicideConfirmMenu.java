package minecraft.demo.menumanagersystem.menus;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SuicideConfirmMenu extends MenuBase {
    public SuicideConfirmMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Confirm: Kill yourself?";
    }

    @Override
    public int getSlots() {
        return 9;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        if (event.getCurrentItem() == null) return;
        HumanEntity player = event.getWhoClicked();
        switch (event.getCurrentItem().getType()) {
            case GREEN_WOOL -> player.setHealth(0.0);
            case RED_WOOL -> {
                player.sendMessage("Changed your mind? Awww...");
                player.closeInventory();
            }
        }
    }

    @Override
    public void setMenuItems() {
        ItemStack yes = new ItemStack(Material.GREEN_WOOL);
        ItemMeta yesItemMeta = yes.getItemMeta();
        yesItemMeta.displayName(Component.text("Yes", NamedTextColor.GREEN));
        yes.setItemMeta(yesItemMeta);

        ItemStack no = new ItemStack(Material.RED_WOOL);
        ItemMeta noItemMeta = no.getItemMeta();
        noItemMeta.displayName(Component.text("No", NamedTextColor.RED));
        no.setItemMeta(noItemMeta);

        inventory.setItem(3, yes);
        inventory.setItem(5, no);
    }
}
