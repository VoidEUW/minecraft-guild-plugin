package com.clanplugin.events;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.clanplugin.Main;
import com.clanplugin.commands.ClanCreateCommand;
import com.clanplugin.commands.ClanListCommand;
import com.clanplugin.commands.ClanVersionCommand;
import com.clanplugin.commands.SubCommand_I;
import com.clanplugin.utils.CommandUtils;
import com.clanplugin.utils.Locale;

public class OnClanCommand implements CommandExecutor {

    private final Main plugin;
    private final Map<String, SubCommand_I> subCommands = new HashMap<>();

    public OnClanCommand(Main plugin) {
        this.plugin = plugin;
        subCommands.put("version", new ClanVersionCommand(plugin));
        subCommands.put("list", new ClanListCommand(plugin));
        subCommands.put("create", new ClanCreateCommand(plugin));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Check whether sender is a player
        Player player = CommandUtils.getPlayer(sender);
        if (player == null)
            return true;

        // When no arguments are given, send help message
        if (!CommandUtils.hasArgs(sender, args))
            return true;

        // Look through the arguments
        SubCommand_I sub = subCommands.get(args[0].toLowerCase());
        if (sub == null) {
            CommandUtils.send(sender, Locale.UNKNOWN_COMMAND);
            return true;
        }

        sub.execute(sender, args);
        return true;
    }
}
