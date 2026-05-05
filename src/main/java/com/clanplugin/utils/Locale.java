package com.clanplugin.utils;

public class Locale {
    // -------------------- General --------------------
    public static final String PLAYER_ONLY = "Only players can use this command.";
    public static final String UNKNOWN_COMMAND = "Unknown subcommand. Use /clan help.";
    public static final String HELP = "/clan create <name> | /clan invite <player>";
    public static final String WRONG_ARGS = "Invalid arguments. Use /clan help.";

    // -------------------- Clan List --------------------
    @Deprecated
    public static final String LIST_USAGE = "Usage: /clan list";

    public static final String NO_CLANS = "No clans exist yet";
    public static final String LIST_CLAN_CLANS = "Clan count: %s | Clans: %s";
    public static final String LIST_CLAN_MEMBERS = "Members: %s";

    // -------------------- Clan Create --------------------
    @Deprecated
    public static final String CREATE_USAGE = "Usage: /clan create <name>";

    public static final String CREATE_ALREADY_IN = "You are already part of a clan.";
    public static final String CREATE_SUCCESS = "Clan %s has been created!";

    // -------------------- Clan Invite --------------------
    @Deprecated
    public static final String INVITE_USAGE = "Usage: /clan invite <player>";

    public static final String INVITE_NOT_FOUND = "Player not found.";
    public static final String INVITE_SENT = "Invite sent to %s.";
    public static final String INVITE_RECEIVED = "You have been invited to join %s.";
    public static final String INVITE_ALREADY_INVITED = "You already invited this player before.";
    public static final String INVITE_ALREADY_CLAN = "%s is already in a clan";
    public static final String PLAYER_OFFLINE = "Player %s is offline. Please try again later";

    // -------------------- Clan join --------------------
    @Deprecated
    public static final String JOIN_USAGE = "Usage: /clan join <name>";

    public static final String JOIN_CLAN_NOT_FOUND = "Clan not found. | You cannot join";
    public static final String JOIN_CLAN_ALREADY_IN = "You are already part of a clan.";
    public static final String JOIN_NOT_INVITED = "You are not invited to join this clan.";
    public static final String JOIN_SUCCESS = "You have joined %s!";

    // -------------------- Clan Leave --------------------
    public static final String LEAVE_NO_CLAN = "You're not in a clan.";
    public static final String LEAVE_SUCCESS = "You have left the clan.";
    public static final String LEAVE_LEADER = "You must transfer leadership before leaving.";
}
