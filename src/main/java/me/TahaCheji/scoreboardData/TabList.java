package me.TahaCheji.scoreboardData;

import me.TahaCheji.Main;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;

public class TabList {

    public int TaskId;

    public void getTab(PlayerJoinEvent e) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
        try {
            e.getPlayer().setPlayerListHeaderFooter(ChatColor.GOLD + "Welcome, " + e.getPlayer().getDisplayName() +
                            ChatColor.GOLD + ", to the " + ChatColor.RESET + ChatColor.GRAY + ChatColor.BOLD + "\nMAFANA Network!\n \n" +
                            ChatColor.RESET + ChatColor.GOLD + "You are playing: \n" +
                            //ChatColor.RESET + ChatColor.GRAY + ChatColor.BOLD + Server.getServer(player).getName() + "\n ", //todo
                            ChatColor.RESET + ChatColor.GRAY + ChatColor.BOLD + "<SERVERNAME>" + "\n ",
                    "\n " + ChatColor.GOLD + "Do you like the server?" +
                            "\nType " +
                            ChatColor.RESET + ChatColor.GRAY + ChatColor.BOLD + "/discord" +
                            ChatColor.RESET + ChatColor.GOLD + " to join the discord.");
        } catch (NullPointerException i) {
            e.getPlayer().setPlayerListHeaderFooter(ChatColor.GOLD + "Welcome, " + e.getPlayer().getDisplayName() +
                            ChatColor.GOLD + ", to the " + ChatColor.RESET + ChatColor.GRAY + ChatColor.BOLD + "\nMAFANA Network!\n \n" +
                            ChatColor.RESET + ChatColor.GOLD + "You are playing: \n" +
                            ChatColor.RESET + ChatColor.GRAY + ChatColor.BOLD + "<SERVERNAME>\n ",
                    "\n " + ChatColor.GOLD + "Do you like the server?" +
                            "\nType " +
                            ChatColor.RESET + ChatColor.GRAY + ChatColor.BOLD + "/discord" +
                            ChatColor.RESET + ChatColor.GOLD + " to join the discord.");
        }
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
