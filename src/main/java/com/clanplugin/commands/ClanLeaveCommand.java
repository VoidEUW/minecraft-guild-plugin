package com.clanplugin.commands;

import java.util.UUID;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.clanplugin.ClanManager;
import com.clanplugin.Main;
import com.clanplugin.models.Clan;
import com.clanplugin.utils.CommandUtils;
import com.clanplugin.utils.Locale;
import com.clanplugin.utils.MessageUtils;

public class ClanLeaveCommand implements SubCommand_I {
    private final Main plugin;

    public ClanLeaveCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        // Only players should execute this command
        Player player = CommandUtils.getPlayer(sender);
        if (player == null) {
            MessageUtils.send(sender, Locale.PLAYER_ONLY);
            return;
        }

        // No other args needed
        if (!CommandUtils.hasEnoughArgs(sender, args, 1, 1))
            return;

        ClanManager manager = plugin.getClanManager();
        UUID pUUID = player.getUniqueId();
        Clan clan = manager.getClanByPlayer((pUUID));

        // Only players with a clan can leave a clan
        if (clan == null) {
            MessageUtils.send(sender, Locale.LEAVE_NO_CLAN);
            return;
        }

        // Only if you're not leader you can leave
        if (clan.getLeader() == pUUID) {
            MessageUtils.send(sender, Locale.LEAVE_LEADER);
            return;
        }

        manager.removeMember(clan, player.getUniqueId());
        MessageUtils.send(sender, Locale.LEAVE_SUCCESS);
        // TODO Let others know person left
    }

}
