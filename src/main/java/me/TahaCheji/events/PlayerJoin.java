package me.TahaCheji.events;

import me.TahaCheji.Levels;
import me.TahaCheji.Main;
import me.TahaCheji.mysqlData.PlayerLevelSQLGetter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        new PlayerLevelSQLGetter(Levels.getInstance()).createPlayer(player);
    }

}
