package be.moondevelopment.moonapi.framework.database;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite {

    private Plugin plugin;

    public SQLite(Plugin plugin) {
        this.plugin = plugin;
    }

    @Getter
    private final String DATABASE_PATH = plugin.getDataFolder().getAbsolutePath() + File.separator + "data.db";

    @Getter
    private Connection connection;

    public void connect()  {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:sqlite:"
                    + getDATABASE_PATH());
        } catch (SQLException x) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Error whilst connecting to the database: \n&c" + x.getMessage()));
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                getConnection().close();
            } catch (SQLException x) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Error whilst connecting to the database: \n&c" + x.getMessage()));
            }
        }
    }
}
