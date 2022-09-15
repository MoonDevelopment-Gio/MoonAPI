package be.moondevelopment.moonapi.framework.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static String CC(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static List<String> CC(List<String> list) {
        List<String> returnVal = new ArrayList<>(list.size());
        list.forEach(s -> returnVal.add(CC(s)));
        return returnVal;
    }

    public static void ConsoleMSG(String s) {
        Bukkit.getConsoleSender().sendMessage(s);
    }

    public static void Broadcast(String s) {
        Bukkit.broadcastMessage(s);
    }

    public static void BroadcastPermissions(String s, String permission) {
        Bukkit.broadcast(s, permission);
    }

}
