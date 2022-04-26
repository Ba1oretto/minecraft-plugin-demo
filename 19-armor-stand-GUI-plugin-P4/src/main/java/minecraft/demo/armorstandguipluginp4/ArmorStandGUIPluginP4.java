package minecraft.demo.armorstandguipluginp4;

import minecraft.demo.armorstandguipluginp4.commands.ArmorStandCommand;
import minecraft.demo.armorstandguipluginp4.listeners.MenuListeners;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ArmorStandGUIPluginP4 extends JavaPlugin {
    public final Map<Player, ArmorStand> armorStands = new HashMap<>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MenuListeners(this), this);
        getCommand("armorstand").setExecutor(new ArmorStandCommand(this));
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    public void openMainMenu(Player player) {
        Inventory mainMenu = Bukkit.createInventory(player, 9, Component.text("Armor Stand GUI", TextColor.color(0, 0, 255)));

        ItemStack create = new ItemStack(Material.ARMOR_STAND);

        ItemMeta createMeta = create.getItemMeta();
        createMeta.displayName(Component.text("create", TextColor.color(0, 128, 0)));
        List<Component> createLore = new ArrayList<>();
        createLore.add(Component.text("Create a new armor stand.", TextColor.color(255, 192, 203)));
        createMeta.lore(createLore);
        create.setItemMeta(createMeta);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.displayName(Component.text("close", TextColor.color(255, 0, 0)));
        close.setItemMeta(closeMeta);

        mainMenu.setItem(0, create);
        mainMenu.setItem(8, close);

        player.openInventory(mainMenu);
    }

    public void openCreateMenu(Player player) {
        Inventory createMenu = Bukkit.createInventory(player, 9, Component.text("Create a Armor Stand", TextColor.color(0, 128, 0)));

        ItemStack arms = new ItemStack(Material.ARMOR_STAND);
        ItemMeta armsMeta = arms.getItemMeta();
        armsMeta.displayName(Component.text("Arms", TextColor.color(255, 255, 0)));
        arms.setItemMeta(armsMeta);

        ItemStack glow = new ItemStack(Material.BEACON);
        ItemMeta glowMeta = glow.getItemMeta();
        glowMeta.displayName(Component.text("Glow"));
        glow.setItemMeta(glowMeta);

        ItemStack armor = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta armorMeta = armor.getItemMeta();
        armorMeta.displayName(Component.text("Armor", TextColor.color(212, 242, 231)));
        armor.setItemMeta(armorMeta);

        ItemStack base = new ItemStack(Material.STONE_SLAB);
        ItemMeta baseMeta = base.getItemMeta();
        baseMeta.displayName(Component.text("Base", TextColor.color(255, 215, 0)));
        base.setItemMeta(baseMeta);

        ItemStack confirm = new ItemStack(Material.GREEN_WOOL);
        ItemMeta confirmMeta = confirm.getItemMeta();
        confirmMeta.displayName(Component.text("Confirm & Create", TextColor.color(0, 128, 0)));
        confirm.setItemMeta(confirmMeta);

        ItemStack cancel = new ItemStack(Material.RED_WOOL);
        ItemMeta cancelMeta = cancel.getItemMeta();
        cancelMeta.displayName(Component.text("Cancel Creation", TextColor.color(255, 0, 0)));
        cancel.setItemMeta(cancelMeta);

        createMenu.addItem(arms, glow, armor, base);
        createMenu.setItem(7, confirm);
        createMenu.setItem(8, cancel);

        player.openInventory(createMenu);
    }

    public void openConfirmMenu(Player player, Material optionItem) {
        Inventory options = Bukkit.createInventory(player, 27, Component.text("Confirm Option", TextColor.color(0, 128, 0)));

        ItemStack option = new ItemStack(optionItem);
        ItemMeta optionMeta = option.getItemMeta();

        optionMeta.displayName(
                optionItem == Material.ARMOR_STAND ? Component.text("Get Arms?", TextColor.color(255, 255, 0)) :
                        optionItem == Material.BEACON ? Component.text("Get Glow?", TextColor.color(255, 255, 0)) :
                                        optionItem == Material.STONE_SLAB ? Component.text("Get Base?", TextColor.color(255, 255, 0)) :
                                                optionItem == Material.DIAMOND_HELMET ? Component.text("Get Helmet?", TextColor.color(255, 255, 0)) :
                                                        optionItem == Material.DIAMOND_CHESTPLATE ? Component.text("Get Chestplate?", TextColor.color(255, 255, 0)) :
                                                                optionItem == Material.DIAMOND_LEGGINGS ? Component.text("Get Leggings?", TextColor.color(255, 255, 0)) :
                                                                        optionItem == Material.DIAMOND_BOOTS ? Component.text("Get Boots?", TextColor.color(255, 255, 0)) : null
        );

        option.setItemMeta(optionMeta);

        ItemStack yes = new ItemStack(Material.GREEN_WOOL);
        ItemMeta yesMeta = yes.getItemMeta();
        yesMeta.displayName(Component.text("YES", TextColor.color(0, 128, 0)));
        yes.setItemMeta(yesMeta);

        ItemStack no = new ItemStack(Material.RED_WOOL);
        ItemMeta noMeta = no.getItemMeta();
        noMeta.displayName(Component.text("NO", TextColor.color(255, 0, 0)));
        no.setItemMeta(noMeta);

        options.setItem(13, option);
        options.setItem(11, yes);
        options.setItem(15, no);

        player.openInventory(options);
    }

    public void openArmorMenu(Player player) {
        Inventory armorOption = Bukkit.createInventory(player, 9, Component.text("Choose some Armor", TextColor.color(0, 0, 255)));

        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);

        ItemStack confirm = new ItemStack(Material.GREEN_WOOL);
        ItemMeta confirmMeta = confirm.getItemMeta();
        confirmMeta.displayName(Component.text("Down", TextColor.color(0, 128, 0)));
        confirm.setItemMeta(confirmMeta);

        armorOption.addItem(helmet, chestplate, leggings, boots);
        armorOption.setItem(8, confirm);

        player.openInventory(armorOption);
    }
}
