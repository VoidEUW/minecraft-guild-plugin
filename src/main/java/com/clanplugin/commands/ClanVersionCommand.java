package com.clanplugin.commands;

import org.bukkit.command.CommandSender;

import com.clanplugin.Main;
import com.clanplugin.utils.CommandUtils;

public class ClanVersionCommand implements SubCommand_I {
    private final Main plugin;

    public ClanVersionCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        String version = plugin.getPluginMeta().getVersion();
        String author = plugin.getPluginMeta().getAuthors().get(0);

        CommandUtils.send(sender, "ClanPlugin v" + version + " by " + author);
    }

}
