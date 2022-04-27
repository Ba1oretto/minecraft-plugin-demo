package minecraft.demo.randomtpplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomConfigUtils {
    private static File file;
    private static FileConfiguration configuration;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("26-randomTP-plugin").getDataFolder(), "custom-config.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Couldn't create file");
            }
        }

        configuration = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return configuration;
    }

    public static void save() {
        try {
            configuration.save(file);
        } catch (IOException e) {
            System.out.println("Couldn't save file");
        }
    }

    public static void reload() {
        configuration = YamlConfiguration.loadConfiguration(file);
    }
}
