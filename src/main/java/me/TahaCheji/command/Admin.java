package me.TahaCheji.command;

import me.TahaCheji.levelData.PlayerLevels;
import org.bukkit.Bukkit;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Admin implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(label.equalsIgnoreCase("mfhub")) {
            if (!(sender.isOp())) {
                return true;
            }
            if(args[0].equalsIgnoreCase("get")) {
                if(args.length == 1) {
                    sender.sendMessage("/mfhub get level/xp | /mfhub get level/xp [player-name]");
                    return true;
                }
                if(args[1].equalsIgnoreCase("level")) {
                }
                if(args[1].equalsIgnoreCase("xp")) {

                }
            }
            if(args[0].equalsIgnoreCase("set")) {
                if(args.length == 1) {
                    sender.sendMessage("/mfhub set level/xp int | /mfhub set level/xp int [player-name]");
                    return true;
                }
                if(args[1].equalsIgnoreCase("level")) {
                    if(args.length == 2) {
                        sender.sendMessage("/mfhub set level int | /mfhub set level int [player-name]");
                        return true;
                    } else if (args.length == 3) {
                        int s = Integer.parseInt(args[2]);
                        Player player = (Player) sender;
                        new PlayerLevels(player).setLevel(s);
                        sender.sendMessage("set lvl");
                        return true;
                    }
                    int s = Integer.parseInt(args[2]);
                    Player player = Bukkit.getPlayer(args[3]);
                    if(player == null) {
                        sender.sendMessage("player is null");
                        return true;
                    }
                    new PlayerLevels(player).setLevel(s);
                    sender.sendMessage("set lvl");
                }
                if(args[1].equalsIgnoreCase("xp")) {
                    if(args.length == 2) {
                        sender.sendMessage("/mfhub set level int | /mfhub set level int [player-name]");
                        return true;
                    } else if (args.length == 3) {
                        int s = Integer.parseInt(args[2]);
                        Player player = (Player) sender;
                        new PlayerLevels(player).setXp(s);
                        sender.sendMessage("set lvl");
                        return true;
                    }
                    int s = Integer.parseInt(args[2]);
                    Player player = Bukkit.getPlayer(args[3]);
                    if(player == null) {
                        sender.sendMessage("player is null");
                        return true;
                    }
                    new PlayerLevels(player).setLevel(s);
                    sender.sendMessage("set lvl");
                    return true;
                }
            }
        }

        return false;
    }
}
