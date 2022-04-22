package me.TahaCheji.scoreboardData;

import me.TahaCheji.Main;
import me.TahaCheji.levelData.LevelsXpTo;
import me.TahaCheji.levelData.PlayerLevels;
import me.TahaCheji.rankInfo.Ranks;
import me.clip.placeholderapi.PlaceholderAPI;
import net.luckperms.api.model.user.User;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class Sideboard {

    public int TaskId;
    public Scoreboard board;

    public void setLobbyScoreBoard(Player player) {
        board = Bukkit.getScoreboardManager().getNewScoreboard();
        User user = Main.getApi().getUserManager().getUser(player.getUniqueId());
        Objective obj = board.registerNewObjective("MafanaNetwork", "dummy", ChatColor.GRAY + "♧" + ChatColor.GOLD + "Mafana Network" + ChatColor.GRAY + "♧");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score name = obj.getScore(ChatColor.GOLD + "=-=-=-=-=-=-=-=-=-=-=-=-");
        name.setScore(16);

        Score emptyText1 = obj.getScore(" ");
        emptyText1.setScore(15);


        Team levels = board.registerNewTeam("Levels");
        levels.addEntry(ChatColor.GOLD + "" + ChatColor.GOLD);
        levels.setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Level: " + new PlayerLevels(player).getLevel());
        obj.getScore(ChatColor.GOLD + "" + ChatColor.GOLD).setScore(14);


        Team xp = board.registerNewTeam("Xp");
        xp.addEntry(ChatColor.GREEN + "" + ChatColor.GOLD);
        xp.setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Xp: " + LevelsXpTo.getXpTo(player).getXp() + "/" + new PlayerLevels(player).getXp());
        obj.getScore(ChatColor.GREEN + "" + ChatColor.GOLD).setScore(13);

        Score emptyText2 = obj.getScore("       ");
        emptyText2.setScore(12);

        Team playerInfo = board.registerNewTeam("Rank");
        playerInfo.addEntry(ChatColor.BLACK + "" + ChatColor.GREEN);
        playerInfo.setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Rank: " + Ranks.getRank(user.getPrimaryGroup()));
        obj.getScore(ChatColor.BLACK + "" + ChatColor.GREEN).setScore(10);

        Score emptyText3 = obj.getScore("              ");
        emptyText3.setScore(9);

        Team online = board.registerNewTeam("Online");
        online.addEntry(ChatColor.AQUA + "" + ChatColor.GOLD);
        online.setPrefix(ChatColor.GRAY + ">> " + ChatColor.GRAY + ">> " + ChatColor.GOLD + "Online-Players: " + Bukkit.getOnlinePlayers().size()); //todo
        obj.getScore(ChatColor.AQUA + "" + ChatColor.GOLD).setScore(8);

        Score emptyText4 = obj.getScore("   ");
        emptyText4.setScore(7);


        Score stats = obj.getScore(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Current-Sever: " + "");
        stats.setScore(6);

        Score emptyText5 = obj.getScore("     ");
        emptyText5.setScore(5);

        Score score7 = obj.getScore(ChatColor.GOLD + "-=-=-=-Mafana.us.to-=-=-=-");
        score7.setScore(4);
        String regionName = PlaceholderAPI.setPlaceholders(player, "%luckperms_prefix%");
        Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
        Team t = sb.getTeam(player.getName());
        if (t == null)
            t = sb.registerNewTeam(player.getName());
        t.setPrefix(ChatColor.GOLD + "[" + regionName + ChatColor.GOLD + "]");
        if(!t.hasPlayer(player))
            t.addPlayer(player);

        player.getPlayer().setScoreboard(board);
    }

    public void updateScoreBoard(Player player) {
        User user = Main.getApi().getUserManager().getUser(player.getUniqueId());
        TaskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                if(!player.isOnline()) {
                    stopUpdating();
                    return;
                }
                Scoreboard newBoard = board;
                newBoard.getTeam("Online").setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "OnlinePlayers: " + Bukkit.getOnlinePlayers().size());
                newBoard.getTeam("Rank").setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Rank: " + Ranks.getRank(user.getPrimaryGroup()));
                newBoard.getTeam("Levels").setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Level: " + new PlayerLevels(player).getLevel());
                newBoard.getTeam("Xp").setPrefix(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Xp: " + LevelsXpTo.getXpTo(player).getXp() + "/" + new PlayerLevels(player).getXp());
            }
        }, 0, 5);
    }

    public void stopUpdating() {
        Bukkit.getScheduler().cancelTask(TaskId);
    }

    public int getTaskId() {
        return TaskId;
    }

}
