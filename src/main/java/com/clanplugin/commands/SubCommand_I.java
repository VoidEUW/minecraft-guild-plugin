package com.clanplugin.commands;

import org.bukkit.command.CommandSender;

public interface SubCommand_I {
    void execute(CommandSender sender, String[] args);
}