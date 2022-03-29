package me.TahaCheji;

import me.TahaCheji.command.Admin;
import me.TahaCheji.discordCommand.LevelCommand;
import me.TahaCheji.events.MessageEvent;
import me.TahaCheji.events.PlayerJoin;
import me.TahaCheji.mysqlData.MySQL;
import me.TahaCheji.mysqlData.PlayerLevelSQLGetter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import javax.security.auth.login.LoginException;
import java.lang.management.MemoryUsage;
import java.lang.reflect.InvocationTargetException;

public class Main extends JavaPlugin implements Listener {

    private static Main instance;
    public JDA builder = null;

    @Override
    public void onEnable() {
        instance = this;
        String token = "";
        try {
            builder = JDABuilder.createDefault(token).build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
        builder.addEventListener(new MessageEvent());
        builder.addEventListener(new LevelCommand());
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getCommand("mfhub").setExecutor(new Admin());
    }

    @Override
    public void onDisable() {
    }


    public static Main getInstance() {
        return instance;
    }
}
