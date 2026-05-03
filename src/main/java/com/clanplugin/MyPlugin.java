package com.clanplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class MyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin gestartet!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin gestoppt.");
    }
}