package com.clanplugin.models;

public class ClanRole {
    private String name;
    private boolean isManager;
    private boolean isLeader;

    public ClanRole(String name, boolean isManager, boolean isLeader) {
        this.name = name;
        this.isManager = isManager;
        if (isLeader) {
            this.isLeader = true;
        } else {
            this.isLeader = false;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isManager() {
        return isManager;
    }

    public boolean isLeader() {
        return isLeader;
    }
}
