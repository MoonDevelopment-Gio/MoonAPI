package be.moondevelopment.moonapi.framework.title;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.awt.*;

public class Reflection {

    public void sendPacket(Player player, Object packet) {
        try {
            Object handle = player.getClass().getMethod("getHandle").invoke(player);
            Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
            playerConnection.getClass().getMethod("sendPacket", getNMSClass("Packet")).invoke(playerConnection, packet);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public Class<?> getNMSClass(String name) {
        try {
            return Class.forName("net.minecraft.server."
                    + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + name);
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
        return null;
    }
}
