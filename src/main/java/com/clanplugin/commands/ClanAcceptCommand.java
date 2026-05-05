package com.clanplugin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.clanplugin.ClanManager;
import com.clanplugin.Main;
import com.clanplugin.models.Clan;
import com.clanplugin.utils.CommandUtils;
import com.clanplugin.utils.Locale;
import com.clanplugin.utils.MessageUtils;

public class ClanAcceptCommand implements SubCommand_I {
    private final Main plugin;

    public ClanAcceptCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        // Only players should do this command
        Player player = CommandUtils.getPlayer(sender);
        if (player == null)
            return;

        // Check if argc is correct
        if (!CommandUtils.hasEnoughArgs(sender, args, 2, 2))
            return;

        ClanManager manager = plugin.getClanManager();

        // Only players without clans can join a clan
        if (manager.hasClan(player)) {
            CommandUtils.send(sender, Locale.JOIN_CLAN_ALREADY_IN);
            return;
        }

        // fetch the clan to later join
        Clan clan = manager.getClanbyName(args[1]);

        // if clan doesn't exist
        if (clan == null) {
            CommandUtils.send(sender, Locale.JOIN_CLAN_NOT_FOUND);
            return;
        }

        // if clan is closed or full, send error message
        if (clan.isClosed() || clan.isFull()) {
            CommandUtils.send(sender, Locale.JOIN_NOT_INVITED);
            return;
        }

        // After checks are done, add the player to the clan
        manager.addMember(clan, player.getUniqueId());
        MessageUtils.send(sender, String.format(Locale.JOIN_SUCCESS, clan.getName()));
        // TODO let others know you joined
    }
}
