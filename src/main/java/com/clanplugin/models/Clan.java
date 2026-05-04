package com.clanplugin.models;

import java.util.*;

public class Clan {
    private final String id;
    private String name;
    private String tag;
    private UUID leader;
    private Map<String, ClanRole> roles = new HashMap<>();
    private Map<UUID, ClanMember> members = new HashMap<>();

    public Clan(String name, UUID leader) {
        this.id = UUID.randomUUID().toString();

        // Defining name and leader first
        this.name = name;
        this.leader = leader;

        // Adding the default roles to prevent errors
        this.roles.put("leader", new ClanRole("Leader", true, true));
        this.roles.put("member", new ClanRole("Member", false, false));
        this.members.put(leader, new ClanMember(leader, this.roles.get("leader")));
    }

    public String getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public UUID getLeader() {
        return this.leader;
    }

    public void addMember(UUID uuid) {
        members.put(uuid, new ClanMember(uuid, roles.get("member")));
    }

    public void removeMember(UUID uuid) {
        members.remove(uuid);
    }

    public boolean isMember(UUID uuid) {
        return members.containsKey(uuid);
    }

    public Map<UUID, ClanMember> getMembers() {
        return members;
    }
}
