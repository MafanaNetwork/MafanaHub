package me.TahaCheji;
import me.TahaCheji.discordCommand.LevelCommand;
import me.TahaCheji.events.MessageEvent;
import me.TahaCheji.proxyData.ServerData;
import me.TahaCheji.rankInfo.Ranks;
import me.TahaCheji.scoreboardData.Sideboard;
import me.neznamy.tab.api.Property;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import me.neznamy.tab.api.event.plugin.TabLoadEvent;
import me.neznamy.tab.shared.TabConstants;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.reflections.Reflections;

import javax.security.auth.login.LoginException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

public class Main extends JavaPlugin implements Listener {

    private static Main instance;
    public JDA builder = null;
    public List<ServerData> servers = new ArrayList<>();
    private static LuckPerms api;

    @Override
    public void onEnable() {
        instance = this;
        String token = "";
        try {
            builder = JDABuilder.createDefault(token).build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
        getServer().getPluginManager().getPlugin("Citizens").onLoad();
        if(getServer().getPluginManager().getPlugin("Citizens") == null || !Objects.requireNonNull(getServer().getPluginManager().getPlugin("Citizens")).isEnabled()) {
            getLogger().log(Level.SEVERE, "Citizens 2.0 not found or not enabled");
            getServer().getPluginManager().disablePlugin(this);
            return;
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
        for (Class<?> clazz : new Reflections(packageName).getSubTypesOf(ServerData.class)) {
            try {
                ServerData shopUtl = (ServerData) clazz.getDeclaredConstructor().newInstance();
                shopUtl.registerServer();
                shopUtl.getServerNPC().spawnNPC();
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            Main.api = provider.getProvider();
        }
        TabAPI.getInstance().getEventBus().register(TabLoadEvent.class, event -> new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            for(Player player : Bukkit.getOnlinePlayers()) {
                                User user = Main.getApi().getUserManager().getUser(player.getUniqueId());
                                TabPlayer tabPlayer = TabAPI.getInstance().getPlayer(player.getUniqueId());
                                Property propertyCustomTagName = tabPlayer.getProperty(TabConstants.Property.CUSTOMTAGNAME);
                                propertyCustomTagName.setTemporaryValue(Ranks.getRank(user.getPrimaryGroup()) + " " + player.getName());
                                TabAPI.getInstance().getTablistFormatManager().setName(tabPlayer, Ranks.getRank(user.getPrimaryGroup()) + " " + player.getName());
                            }
                        }
                    }, 20L); //20 Tick (1 Second) delay before run() is called
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.runTaskAsynchronously(Main.getInstance()));

    }

    @Override
    public void onDisable() {
        for(ServerData serverData : servers) {
            serverData.getServerNPC().getNpc().destroy();
        }
    }

    public static LuckPerms getApi() {
        return api;
    }

    public static Main getInstance() {
        return instance;
    }
}
