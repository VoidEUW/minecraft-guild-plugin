package com.clanplugin.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.clanplugin.models.Clan;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;

public class MessageUtils {
    private static final String PREFIX = "§dClan §r";

    public static void sendInviteMessage(Player receiver, Clan clan) {
        Component message = Component.text()
            .append(Component.text(PREFIX, NamedTextColor.LIGHT_PURPLE))
            .append(Component.text("You have been invited to join "))
            .append(Component.text(clan.getName(), NamedTextColor.GREEN))
            .append(Component.text(" "))
            .append(Component.text("[Accept]", NamedTextColor.GREEN)
                    .clickEvent(ClickEvent.runCommand("/clan accept " + clan.getName()))
                    .hoverEvent(net.kyori.adventure.text.event.HoverEvent.showText(
                            Component.text("Click to accept the invite"))))
            .append(Component.text(" "))
            .append(Component.text("[Decline]", NamedTextColor.RED)
                    .clickEvent(ClickEvent.runCommand("/clan decline " + clan.getName()))
                    .hoverEvent(net.kyori.adventure.text.event.HoverEvent.showText(
                            Component.text("Click to decline the invite"))))
            .build();
        receiver.sendMessage(message);
    }

    public static void send(CommandSender sender, String message) {
        sender.sendMessage(PREFIX + message);
    }

}
