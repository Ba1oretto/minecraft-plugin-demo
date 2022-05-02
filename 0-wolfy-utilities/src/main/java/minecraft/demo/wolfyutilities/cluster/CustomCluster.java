package minecraft.demo.wolfyutilities.cluster;

import me.wolfyscript.utilities.api.inventory.gui.GuiCluster;
import me.wolfyscript.utilities.api.inventory.gui.InventoryAPI;
import me.wolfyscript.utilities.api.inventory.gui.button.buttons.DummyButton;
import me.wolfyscript.utilities.util.NamespacedKey;
import minecraft.demo.wolfyutilities.cache.MyCache;
import minecraft.demo.wolfyutilities.window.CustomWindow;
import org.bukkit.Material;

public class CustomCluster extends GuiCluster<MyCache> {
    public static final String KEY = "your_cluster";

    public static final NamespacedKey CUSTOM_WINDOW = new NamespacedKey(KEY, "custom_window");

    public static final NamespacedKey CUSTOM_GLOBAL_BUTTON = new NamespacedKey(KEY, "custom_global_button");

    public CustomCluster (InventoryAPI<MyCache> inventoryAPI) {
        super(inventoryAPI, KEY);
    }

    @Override
    public void onInit() {
        // Called on initialization! Used to register GuiWindows and Buttons.
        registerGuiWindow(new CustomWindow(this));
        registerButton(new DummyButton(CUSTOM_GLOBAL_BUTTON.getKey(), Material.BARRIER));
    }

}
