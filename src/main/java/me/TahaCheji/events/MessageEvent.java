package me.TahaCheji.events;

import me.TahaCheji.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MessageEvent extends ListenerAdapter implements Listener {

    @EventHandler
    public void chatEvent(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        TextChannel textChannel = Main.getInstance().builder.getTextChannelById("881964872269697034");
        textChannel.sendMessage("**" + e.getPlayer().getName() + ":** " + message).queue();
    }

    @EventHandler
    public void joinEvent(PlayerJoinEvent e) {
        TextChannel textChannel = Main.getInstance().builder.getTextChannelById("881964872269697034");
        textChannel.sendMessage("**" + e.getPlayer().getName() + ":** " + "has joined the server").queue();
    }

    @EventHandler
    public void leaveEvent(PlayerQuitEvent e) {
        TextChannel textChannel = Main.getInstance().builder.getTextChannelById("881964872269697034");
        textChannel.sendMessage("**" + e.getPlayer().getName() + ":** " + "has left the server").queue();
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getAuthor().isBot() || event.isWebhookMessage()) return;
        String message = event.getMessage().getContentRaw();
        User user = event.getAuthor();
        Bukkit.broadcastMessage(ChatColor.GOLD + user.getName() + "#" + user.getDiscriminator() + ": §e" + message);
    }

    public void sendEmbed(MessageChannel channel, String title, String description, String footer) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle(title);
        embed.setDescription(description);
        embed.setFooter(footer);
        channel.sendMessage(embed.build()).queue();
    }
}
