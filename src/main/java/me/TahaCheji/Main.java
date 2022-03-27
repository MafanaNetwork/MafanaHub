package me.TahaCheji;

import me.TahaCheji.proxyData.SendPlayer;
import me.TahaCheji.proxyData.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
       instance = this;

        String packageName = getClass().getPackage().getName();
        for (Class<?> clazz : new Reflections(packageName, ".listeners").getSubTypesOf(Listener.class)) {
            try {
                Listener listener = (Listener) clazz.getDeclaredConstructor().newInstance();
                getServer().getPluginManager().registerEvents(listener, this);
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

    }

    public void test(Player player) {
        SendPlayer sendPlayer = new SendPlayer(player, Server.MAIN_HUB);
        sendPlayer.send();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }
}
