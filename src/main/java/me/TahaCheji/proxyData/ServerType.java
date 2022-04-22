package me.TahaCheji.proxyData;

public enum ServerType {

    PVP("PVP Game"),
    SURVIVAL("Survival Game"),
    MMORPG("MMO Game"),
    MINIGAME("Mini-Game");

    public final String string;


    ServerType(String string) {
        this.string = string;
    }
}
