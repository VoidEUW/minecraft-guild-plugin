package com.clanplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.clanplugin.ClanManager;

public class CommandUtils {
    private static final String PREFIX = "§dClan §r";

    // -------------------- Player --------------------
    public static Player getPlayer(CommandSender sender) {
        if (!(sender instanceof Player player)) {
            CommandUtils.send(sender, Locale.PLAYER_ONLY);
            return null;
        }
        return player;
    }

    public static Player getOnlinePlayer(String name, CommandSender sender) {
        return Bukkit.getPlayer(name);
    }

    public static boolean isOnline(Player player) {
        // TODO
        return false;
    }

    public static boolean hasPermission(CommandSender sender, String permission) {
        // TODO implement permission checking
        return true;
    }

    @Deprecated
    // Use methods from ClanManager instead
    public static boolean hasClan(ClanManager manager, Player player) {
        if (manager.getClanByPlayer(player.getUniqueId()) == null) {
            return false;
        }
        return true;
    }

    // -------------------- Arguments --------------------
    public static boolean hasEnoughArgs(CommandSender sender, String[] args, int minArgs, int maxArgs) {
        if (args.length == 0) {
            CommandUtils.send(sender, Locale.HELP);
            return false;
        }
        if (args.length < minArgs || args.length > maxArgs) {
            CommandUtils.send(sender, Locale.WRONG_ARGS);
            return false;
        }
        return true;
    }

    @Deprecated
    // No longer needed because hasEnoughArgs handles this
    public static boolean hasArgs(CommandSender sender, String[] args) {
        if (args.length == 0) {
            CommandUtils.send(sender, Locale.HELP);
            return false;
        }
        return true;
    }

    // -------------------- Messages --------------------
    @Deprecated
    public static void send(CommandSender sender, String message) {
        sender.sendMessage(PREFIX + message);
    }
}
