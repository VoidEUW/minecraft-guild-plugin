package com.clanplugin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.clanplugin.ClanManager;
import com.clanplugin.Main;
import com.clanplugin.models.Clan;
import com.clanplugin.utils.CommandUtils;
import com.clanplugin.utils.Locale;
import com.clanplugin.utils.MessageUtils;

public class ClanInviteCommand implements SubCommand_I {
    private final Main plugin;

    public ClanInviteCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        // Only players should execute this command
        Player player = CommandUtils.getPlayer(sender);
        if (player == null)
            return;

        // Check if argc is correct
        if (!CommandUtils.hasEnoughArgs(sender, args, 2, 2))
            return;

        // Can the player invite a person?
        // TODO

        ClanManager manager = plugin.getClanManager();

        // Try to get person, if not
        Player receiver = CommandUtils.getOnlinePlayer(args[1], sender);
        if (receiver == null) {
            CommandUtils.send(sender, Locale.INVITE_NOT_FOUND);
            return;
        }

        // Check if the player is in a clan
        if (manager.hasClan(receiver)) {
            CommandUtils.send(sender, String.format(Locale.INVITE_ALREADY_CLAN, receiver.getName()));
            return;
        }

        // Invite the player to the clan
        Clan clan = manager.getClanByPlayer(player.getUniqueId());

        // Check if the player already has been invited by the same clan
        if (manager.hasInvite(clan, player.getUniqueId())) {
            return;
        }

        manager.addInvite(clan, receiver.getUniqueId());
        CommandUtils.send(sender, String.format(Locale.INVITE_SENT, receiver.getName()));
        MessageUtils.sendInviteMessage(receiver, clan);
    }

}
