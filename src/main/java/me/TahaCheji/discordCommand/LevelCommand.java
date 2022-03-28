package me.TahaCheji.discordCommand;

import me.TahaCheji.levelData.PlayerLevels;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Objects;

public class LevelCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) {
            return;
        }
        if (e.getMessage().getContentRaw().contains("!Level")) {
            String[] args = e.getMessage().getContentRaw().split(" ");
            if (args.length == 1) {
                e.getChannel().sendMessage("Error: !Level [Player Name]").queue();
                return;
            }
            OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
            if (!player.hasPlayedBefore()) {
                e.getChannel().sendMessage("Error: That player does not exist").queue();
                return;
            }
            PlayerLevels playerLevels = new PlayerLevels(player);
            sendEmbed(e.getChannel(), player.getName() + "'s Level", "Level: " + String.valueOf(playerLevels.getLevel() + " XP: " + playerLevels.getXp()), "This is all logged in a database");
        }
    }

    public void sendEmbed(MessageChannel channel, String title, String description, String footer) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle(title);
        embed.setDescription(description);
        embed.setFooter(footer);
        channel.sendMessage(embed.build()).queue();
    }

}
