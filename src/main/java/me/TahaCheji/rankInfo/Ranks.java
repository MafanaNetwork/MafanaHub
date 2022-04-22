package me.TahaCheji.rankInfo;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public enum Ranks {

    DEFAULT("default", ChatColor.GRAY + "[Default]"),
    ADMIN("admin", ""),
    BUFF("buff", ""),
    BUILDER("builder", ""),
    DESIGNER("designer", ""),
    DEVELOPER("developer", ""),
    FRIENDS("friends", ""),
    HAWK("hawk", ""),
    MANAGER("manager", ""),
    MOD("mod", ""),
    OWNER("owner", ""),
    STAFF("staff", ""),
    YOUTUBE("youtube", "");

    private final String text;
    private final String name;

    Ranks(String text, String name) {
        this.text = text;
        this.name = name;
    }

    public static String getRank(String x) {
       for(Ranks ranks : Ranks.values()){
           if(ranks.getText().equalsIgnoreCase(x)) {
               return ranks.getName();
           }
       }
       return null;
    }

    public String getText() {
        return text;
    }
    public String getName() { return name; }
}
