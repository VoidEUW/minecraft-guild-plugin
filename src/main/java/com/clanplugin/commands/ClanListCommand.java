package com.clanplugin.commands;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

        if (!CommandUtils.hasEnoughArgs(sender, args, 1, 2)) {
            return;
        }

        ClanManager manager = plugin.getClanManager();
        ArrayList<Clan> clans = manager.getAllClans();

        // Maybe noone has created a clan yet or none exist after deleting all
        if (clans.isEmpty()) {
            CommandUtils.send(sender, Locale.NO_CLANS);
            return;
        }

        // TODO Improve listing
        if (args.length > 1) {
            Clan clan = manager.getClanbyName(args[1]);
            // If there are no clans this shouldn't work
            if (clan == null) {
                CommandUtils.send(sender, Locale.NO_CLANS);
            }

            String output = stringifyClanMembers(clan);
            CommandUtils.send(sender, String.format(Locale.LIST_CLAN_MEMBERS, output));
        } else {
            String output = stringifyClans(clans);
            CommandUtils.send(sender, String.format(Locale.LIST_CLAN_CLANS, clans.size(), output));
        }
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

    private String stringifyClanMembers(Clan clan) {
        return clan.getMembers().values().stream()
                .map(member -> {
                    Player player = member.getPlayer();
                    return player != null ? player.getName() : member.getUuid().toString();
                })
                .collect(Collectors.joining(", "));
    }

}
