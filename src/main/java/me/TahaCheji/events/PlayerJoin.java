package me.TahaCheji.events;

import me.TahaCheji.Levels;
import me.TahaCheji.mysqlData.PlayerLevelSQLGetter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        PlayerLevelSQLGetter levelSQLGetter = new PlayerLevelSQLGetter(Levels.getInstance());
        levelSQLGetter.createPlayer(player);
    }

}
