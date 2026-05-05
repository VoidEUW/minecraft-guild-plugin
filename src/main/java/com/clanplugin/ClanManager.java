package com.clanplugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

import com.clanplugin.models.Clan;
import com.clanplugin.models.ClanMember;

public class ClanManager {
    private final Map<String, Clan> clansByName = new HashMap<>();
    private final Map<UUID, Clan> clanByPlayer = new HashMap<>();
    private final Map<UUID, ArrayList<UUID>> clanInvites = new HashMap<>();

    public ClanManager() {
        // TODO for persistence load sqlite data
    }

    // -------------------- Player --------------------
    public Clan getClanbyName(String name) {
        return clansByName.get(name);
    }

    public Clan getClanByPlayer(UUID uuid) {
        return clanByPlayer.get(uuid);
    }

    public boolean hasClan(Player player) {
        if (this.getClanByPlayer(player.getUniqueId()) == null) {
            return false;
        }
        return true;
    }

    // -------------------- Clan --------------------
    public Clan createClan(String name, UUID leader) {
        // TODO Check if clan with that String already exists
        Clan clan = new Clan(name, leader);
        clansByName.put(name, clan);
        clanByPlayer.put(leader, clan);
        return clan;
    }

    public void disbandClan(Clan clan) {
        clanByPlayer.remove(clan.getLeader());
        clansByName.remove(clan.getID());
    }

    public ArrayList<Clan> getAllClans() {
        return new ArrayList<>(clansByName.values());
    }

    // -------------------- Members --------------------
    public void addMember(Clan clan, UUID uuid) {
        // TODO Test whether member can join
        clan.addMember(uuid);
        this.clanByPlayer.put(uuid, clan);
    }

    public void removeMember(Clan clan, UUID uuid) {
        // TODO Test whether user wants to leave or leader kicks them out
        clan.removeMember(uuid);
        this.clanByPlayer.remove(uuid);
    }

    public Collection<ClanMember> getMembers(Clan clan) {
        // TODO Implement get clan members
        return null;
    }

    // -------------------- Invites --------------------
    public void addInvite(Clan clan, UUID receiver) {
        // Because List can be empty
        clanInvites
                .computeIfAbsent(receiver, k -> new ArrayList<>())
                .add(UUID.fromString(clan.getID()));
    }

    public List<UUID> getInvites(UUID receiver) {
        return clanInvites.getOrDefault(receiver, new ArrayList<>());
    }

    public void removeInvite(Clan clan, UUID receiver) {
        List<UUID> list = clanInvites.get(receiver);
        if (list != null) {
            list.remove(UUID.fromString(clan.getID()));
        }
    }

    public boolean hasInvite(Clan clan, UUID receiver) {
        List<UUID> list = clanInvites.get(receiver);
        return list != null && list.contains(UUID.fromString(clan.getID()));
    }
}