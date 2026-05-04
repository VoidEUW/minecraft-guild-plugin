package com.clanplugin.commands;

import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.clanplugin.ClanManager;
import com.clanplugin.Main;
import com.clanplugin.models.Clan;
import com.clanplugin.utils.CommandUtils;
import com.clanplugin.utils.Locale;

public class ClanCreateCommand implements SubCommand_I {
    private final Main plugin;

    public ClanCreateCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        // Only players should execute this command
        Player player = CommandUtils.getPlayer(sender);
        if (player == null)
            return;

        // Check if Argc is correct
        if (!CommandUtils.hasEnoughArgs(sender, args, 2, 2)) {
            CommandUtils.send(sender, Locale.CREATE_USAGE);
            return;
        }

        ClanManager manager = plugin.getClanManager();

        if (CommandUtils.hasClan(manager, player)) {
            CommandUtils.send(sender, Locale.CREATE_ALREADY_IN);
            return;
        }

        Clan clan;
        try {
            clan = manager.createClan(args[1], player.getUniqueId());
            if (clan == null) {
                throw new Exception();
            }
        } catch (Exception e) {
            CommandUtils.send(sender, "Error: " + e);
            return;
        }
        CommandUtils.send(sender, String.format(Locale.CREATE_SUCCESS, clan.getName()));
    }
}
