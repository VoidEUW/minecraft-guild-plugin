package com.clanplugin.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.clanplugin.ClanManager;
import com.clanplugin.models.Clan;

public class CommandUtils {
    private static final String PREFIX = "§8[§6Clan§8] §r";

    public static Player getPlayer(CommandSender sender) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Locale.PLAYER_ONLY);
            return null;
        }
        return player;
    }

    public static boolean hasArgs(CommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Locale.HELP);
            return false;
        }
        return true;
    }

    public static boolean hasEnoughArgs(CommandSender sender, String[] args, int minArgs, int maxArgs) {
        if (args.length < minArgs || args.length > maxArgs) {
            return true;
        }
        return false;
    }

    public static boolean hasClan(ClanManager manager, Player player) {
        if (manager.getClanByPlayer(player.getUniqueId()) == null) {
            return false;
        }
        return true;
    }

    public static void send(CommandSender sender, String message) {
        sender.sendMessage(PREFIX + message);
    }
}
