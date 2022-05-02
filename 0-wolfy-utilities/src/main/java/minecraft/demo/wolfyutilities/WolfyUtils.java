package minecraft.demo.wolfyutilities;

import me.wolfyscript.utilities.api.WolfyUtilCore;
import me.wolfyscript.utilities.api.WolfyUtilities;
import me.wolfyscript.utilities.api.inventory.gui.InventoryAPI;
import me.wolfyscript.utilities.api.language.Language;
import me.wolfyscript.utilities.api.language.LanguageAPI;
import minecraft.demo.wolfyutilities.cache.MyCache;
import minecraft.demo.wolfyutilities.inventories.CustomInventory;
import org.bukkit.plugin.java.JavaPlugin;


public final class WolfyUtils extends JavaPlugin {


    private final WolfyUtilities api;

    public WolfyUtils() {
        super();
        api = WolfyUtilCore.getInstance().getAPI(this, false);
        api.setInventoryAPI(new InventoryAPI<>(this, api, MyCache.class));
        loadLanguage();
    }

    @Override
    public void onEnable() {
        api.initialize();

        saveDefaultConfig();

        getCommand("wu-open").setExecutor(new CustomInventory(api));
    }

    private void loadLanguage() {
        saveResource("lang/en_US.json", true);

        LanguageAPI languageAPI = this.api.getLanguageAPI();

        Language language = new Language(this, "en_US");
        languageAPI.registerLanguage(language);

        // saveResource("lang/zh_CN.json", true);
        // Language fallBackLanguage = new Language(this, "zh_CN");
        // languageAPI.registerLanguage(fallBackLanguage);

        // languageAPI.setActiveLanguage(language);
    }
}
