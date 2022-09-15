package be.moondevelopment.moonapi.framework.utils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    private final Plugin plugin;

    public FileUtil(Plugin plugin) {
        this.plugin = plugin;
    }

    public FileConfiguration get(String file) {
        File jfile = new File(plugin.getDataFolder(), "messages.yml");
        if (!jfile.exists()) {
            Utils.ConsoleMSG(Utils.CC("&8» &c" + file + "not found, Creating file..."));
            jfile.getParentFile().mkdirs();
            plugin.saveResource(file, false);
            Utils.ConsoleMSG(Utils.CC("&8» &c" + file + "created..."));
        }

        FileConfiguration config = new YamlConfiguration();

        try {
            config.load(jfile);
            Utils.ConsoleMSG(Utils.CC("&8» &c" + file + " registered!"));
            return config;
        } catch (InvalidConfigurationException | IOException x) {
            Utils.ConsoleMSG(Utils.CC("&4Error whilst loading " + file + ": \n&c" + x.getMessage() + "\n &cCaused by: \n" + x.getCause()));
            return null;
        }
    }


}

