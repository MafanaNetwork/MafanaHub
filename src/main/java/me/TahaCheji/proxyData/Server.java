package me.TahaCheji.proxyData;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.entity.Player;

public enum Server {

    MAIN_HUB("HUB", "Lobby"),
    SKY_WARS_HUB("SW", "Skywars"),
    BRIDGE_WIZZERDS_HUB("BW", "Bridge Wizards"),
    MAGIC_TAG_HUB("MT", "Magic Tag");

    private final String text;
    private final String name;

    Server(String text, String name) {
        this.text = text;
        this.name = name;
    }

    public ServerInfo getServer() {
        return ProxyServer.getInstance().getServerInfo(getText());
    }

    public static ServerInfo getServer(Player player) {
        ProxiedPlayer proxiedPlayer = (ProxiedPlayer) player;
        return proxiedPlayer.getServer().getInfo();
    }

    public String getText() {
        return text;
    }
    public String getName() { return name; }
    

}
