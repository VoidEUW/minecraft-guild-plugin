package com.clanplugin.models;

import java.util.*;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ClanMember {
    private UUID uuid;
    private ClanRole role;

    public ClanMember(UUID uuid, ClanRole role) {
        this.uuid = uuid;
        this.role = role;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    public UUID getUuid() {
        return uuid;
    }

    public ClanRole getClanRole() {
        return role;
    }
}
