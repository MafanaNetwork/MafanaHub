package me.TahaCheji.proxyData;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.entity.Player;

public class SendPlayer {

    public final Player player;
    public final Server server;

    public SendPlayer(Player player, Server server) {
        this.player = player;
        this.server = server;
    }

    public void send() {
        ServerInfo target = ProxyServer.getInstance().getServerInfo(server.getText());
        ProxiedPlayer proxiedPlayer = (ProxiedPlayer) player;
        proxiedPlayer.connect(target);
    }

    public Player getPlayer() {
        return player;
    }

    public Server getServer() {
        return server;
    }

}
