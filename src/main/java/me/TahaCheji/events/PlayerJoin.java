package me.TahaCheji.events;

import me.TahaCheji.Levels;
import me.TahaCheji.Main;
import me.TahaCheji.mysqlData.PlayerLevelSQLGetter;
import me.TahaCheji.rankInfo.Ranks;
import me.TahaCheji.scoreboardData.Sideboard;
import me.TahaCheji.scoreboardData.TabList;
import me.TahaCheji.serverSelecterData.Itemstacks;
import me.TahaCheji.servers.SkyWizzards;
import me.neznamy.tab.api.Property;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import me.neznamy.tab.api.event.plugin.TabLoadEvent;
import me.neznamy.tab.shared.TabConstants;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        PlayerLevelSQLGetter levelSQLGetter = new PlayerLevelSQLGetter(Levels.getInstance());
        levelSQLGetter.createPlayer(player);
        e.getPlayer().getInventory().clear();
        e.getPlayer().getInventory().setItem(0, new Itemstacks().serverSelector());
        new SkyWizzards().getNPC().spawnNPC();
        new TabList().getTab(e);
        Sideboard lobbyScoreBoard = new Sideboard();
        lobbyScoreBoard.setLobbyScoreBoard(player);
        lobbyScoreBoard.updateScoreBoard(player);
    }

}
