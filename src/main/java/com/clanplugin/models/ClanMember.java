package com.clanplugin.models;

import java.util.*;

public class ClanMember {
    private UUID uuid;
    private ClanRole role;

    public ClanMember(UUID uuid, ClanRole role) {
        this.uuid = uuid;
        this.role = role;
    }

    public UUID getUuid() {
        return uuid;
    }

    public ClanRole getClanRole() {
        return role;
    }
}
