package com.clanplugin.utils;

public class Locale {
    // General
    public static final String PLAYER_ONLY = "Only players can use this command.";
    public static final String UNKNOWN_COMMAND = "Unknown subcommand. Use /clan help.";
    public static final String HELP = "/clan create <name> | /clan invite <player>";

    // Clan List
    public static final String LIST_USAGE = "Usage: /clan list";
    public static final String NO_CLANS = "No clans exist yet";
    public static final String LIST_CLAN_SUCCESS = "Clan count: %s | Clans: %s";

    // Clan Create
    public static final String CREATE_USAGE = "Usage: /clan create <name>";
    public static final String CREATE_ALREADY_IN = "You are already part of a clan.";
    public static final String CREATE_SUCCESS = "Clan %s has been created!";

    // Clan Invite
    public static final String INVITE_USAGE = "Usage: /clan invite <player>";
    public static final String INVITE_NOT_FOUND = "Player not found.";
    public static final String INVITE_SENT = "Invite sent to %s.";
    public static final String INVITE_RECEIVED = "You have been invited to join %s.";

    // Clan Leave
    public static final String LEAVE_SUCCESS = "You have left the clan.";
    public static final String LEAVE_LEADER = "You must transfer leadership before leaving.";
}
