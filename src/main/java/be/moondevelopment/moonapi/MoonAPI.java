package be.moondevelopment.moonapi;

import be.moondevelopment.moonapi.framework.gui.GUIHolder;
import be.moondevelopment.moonapi.framework.gui.legacy.LegacyGUI;
import be.moondevelopment.moonapi.framework.utils.Utils;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.ApiVersion;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;
import org.bukkit.plugin.java.annotation.plugin.author.Authors;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

@Plugin(name = "MoonAPI", version = "1.0")
@Description("A Framework plugin with different features to use in your plugin!")
@Authors({
        @Author("MoonDevelopment")
})
@ApiVersion(ApiVersion.Target.v1_13)
public class MoonAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        Utils.ConsoleMSG(Utils.CC("&aLoaded &3&lMoon&b&lAPI"));
        Utils.ConsoleMSG(Utils.CC("&6Checking version..."));
        if (!checkVersion()) {
            Utils.ConsoleMSG(Utils.CC("&c&lIt looks like you can update to a new version!"));
            Utils.ConsoleMSG(Utils.CC("&cGo to the github to download the new version!"));
        }
        GUIHolder.init(this);
        LegacyGUI.init(this);
    }

    private boolean checkVersion() {
        try {
            Scanner s = new Scanner(new URL("https://raw.githubusercontent.com/MoonDevelopment-Gio/MoonAPI/main/VERSION").openStream(), "UTF-8").useDelimiter("\\a");
            String version = s.next();
            return version.equals(this.getDescription().getVersion());
        } catch (IOException ignored) {
            Utils.ConsoleMSG(Utils.CC("&cScanner error, Couldn't check the version!"));
            return false;
        }
    }
}
