package com.clanplugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.clanplugin.models.Clan;

public class ClanManager {
    private final Map<String, Clan> clansByName = new HashMap<>();
    private final Map<UUID, Clan> clanByPlayer = new HashMap<>();

    public ClanManager() {
        // TODO for persistence load sqlite data
    }

    public Clan getClanByPlayer(UUID uuid) {
        return clanByPlayer.get(uuid);
    }

    public Clan createClan(String name, UUID leader) {
        Clan clan = new Clan(name, leader);
        clansByName.put(name, clan);
        clanByPlayer.put(leader, clan);
        return clan;
    }
}