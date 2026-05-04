package com.clanplugin.commands;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;

import com.clanplugin.ClanManager;
import com.clanplugin.Main;
import com.clanplugin.models.Clan;
import com.clanplugin.utils.CommandUtils;
import com.clanplugin.utils.Locale;

public class ClanListCommand implements SubCommand_I {
    private final Main plugin;

    public ClanListCommand(Main plugin) {
        this.plugin = plugin;
    }

	@Override
	public void execute(CommandSender sender, String[] args) {
        // Players and console can use that command

        if (!CommandUtils.hasEnoughArgs(sender, args, 1, 1)) {
            CommandUtils.send(sender, Locale.LIST_USAGE);
            return;
        }
        
        ClanManager manager = plugin.getClanManager();
        ArrayList<Clan> clans = manager.getAllClans();

        // Maybe noone has created a clan yet or none exist after deleting all
        if (clans.isEmpty()) {
            CommandUtils.send(sender, Locale.NO_CLANS);
            return;
        }

        String clansString = stringifyClans(clans);
        CommandUtils.send(sender, String.format(Locale.LIST_CLAN_SUCCESS, clans.size(), clansString));
	}

    private String stringifyClans(ArrayList<Clan> clans) {
        String clansString = "";

        for (Clan clan : clans) {
            clansString += clan.getName();
            if (clans.getLast() == clan) {
                return clansString;
            }
            clansString += ", ";
        }
        return clansString;
    }

}
