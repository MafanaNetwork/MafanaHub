package me.TahaCheji;

import me.TahaCheji.command.Admin;
import me.TahaCheji.mysqlData.MySQL;
import me.TahaCheji.mysqlData.PlayerLevelSQLGetter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

public final class Main extends JavaPlugin implements Listener {

    private static Main instance;
    public MySQL mySQL;
    public PlayerLevelSQLGetter data;

    @Override
    public void onEnable() {
        instance = this;
        this.mySQL = new MySQL();
        this.data = new PlayerLevelSQLGetter(this);
        mySQL.connect();
        if(mySQL.isConnected()) {
            data.createTable();
        }
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
        mySQL.disconnect();
        // Plugin shutdown logic
    }

    public MySQL getMySQL() {
        return mySQL;
    }

    public static Main getInstance() {
        return instance;
    }
}
