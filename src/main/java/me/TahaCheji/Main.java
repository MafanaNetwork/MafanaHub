package me.TahaCheji;

import me.TahaCheji.command.Admin;
import me.TahaCheji.discordCommand.LevelCommand;
import me.TahaCheji.events.MessageEvent;
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
        String token = "OTU4MDg2MzAzMzQ4NTg0NDg5.YkINZw.bxryCB76r0Up3LBPrWfWaehDcgA";
        try {
            builder = JDABuilder.createDefault(token).build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
        builder.addEventListener(new MessageEvent());
        builder.addEventListener(new LevelCommand());
        String packageName = getClass().getPackage().getName();
        for (Class<?> clazz : new Reflections(packageName, ".listeners").getSubTypesOf(Listener.class)) {
            try {
                Listener listener = (Listener) clazz.getDeclaredConstructor().newInstance();
                getServer().getPluginManager().registerEvents(listener, this);
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        getCommand("mfhub").setExecutor(new Admin());
    }

    @Override
    public void onDisable() {
    }


    public static Main getInstance() {
        return instance;
    }
}
