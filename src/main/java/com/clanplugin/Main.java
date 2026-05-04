package com.clanplugin;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import com.clanplugin.events.OnClanCommand;

public class Main extends JavaPlugin {
    private ClanManager clanManager;

    public ClanManager getClanManager() {
        return clanManager;
    }

    @Override
    public void onEnable() {
        getLogger().info("Plugin started!");

        // If something went wrong with the clan manager, then it would
        // stop instead of throwing errors when being used.
        try {
            this.clanManager = new ClanManager();
        } catch (Exception e) {
            getLogger().severe("Failed to initialize ClanManager!");
        }

        // Register commands
        registerCommand("clan", new OnClanCommand(this));
    }

    private void registerCommand(String name, CommandExecutor executor) {
        getCommand(name).setExecutor(executor);
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin stopped.");
    }
}