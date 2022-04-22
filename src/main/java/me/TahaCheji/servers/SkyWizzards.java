package me.TahaCheji.servers;
import me.TahaCheji.proxyData.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.Listener;

public class SkyWizzards extends ServerData implements Listener {

    public SkyWizzards() {
        super(ChatColor.GREEN + "SkyWizzards", Server.SKY_WARS_HUB, ServerType.PVP, Material.DIAMOND_SWORD, "Skywars ig");
        setServerNPC(getNPC());
    }

    public ServerNPC getNPC() {
        Location location = new Location(Bukkit.getWorld("world"), 53,105,23);
        ServerNPC serverNPC = new ServerNPC("SkyWizzards", "SKY_WIZZARDS", location, this);
        serverNPC.setSkin(new NPCSkin("Stone", "lUblrJ0c3k0fF36UFP1kcv8UEwJsd7qGZ6ge14kacY8hKuDtoOdlqBPYvKHy5d/PvGtAKFYNUAShMQ3hN3U+TfpSVCTqMqwyhB6ZLmiYbJQg+rD/V2X7Z9nGf1uFM1GvAf8P0V1+6aiw6PvSVhcCQu8beNSRroBTtn1L19j0G/hhrWONTEXAAoXudgPBeOq2glR0I1sDChR0QTjPF0EDEs7TgulF5Nf6gNsNZK5G+EUejGPcc3nML6ZGbgWGfWI6Mnn+lUWnVRulGH5tdQQjlDcBHujmR7DYdFBepZpepQro4l8C0yvYWBF/qkY9y4swfmoRUbY+b7BtMZRFbCsEHoV0utpaG0MH8kVOpTZ1hsGjgVELa1yfds/212aTZbF+71xD/kxZP+VjSWdphuI6l/M9FttjbkSC4H6nzlH6kNr92Ts3gzRRdC8KsqMeCH+qmfDHT7n0yrfmL5PGK3e7/Krl0SCCT47IlSvlHiYyfne6h1xv7ghlvwD8OTYPC6BoZFwaS5See/TJ6lhZ8BMkw8LDLFofjeNapCVcbdqiI8KKltOGfQiFnYioXG0rrB3oUOTbT/z1iuXTVY9GZITwyyPfjCJLE5RCNiuY6UpxYCbB1yNG4LbfxvHzC2JaPbIyYvVyd6ScRU2An0gEevB9BTnyNJs9SwSuSsIgz9cyQwg=",
                "ewogICJ0aW1lc3RhbXAiIDogMTU4ODc3NTY5NDI0MiwKICAicHJvZmlsZUlkIiA6ICJiMGQ3MzJmZTAwZjc0MDdlOWU3Zjc0NjMwMWNkOThjYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJPUHBscyIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9iZWFjNzg2MTExNTM0MjkxYzFiNGVjMzM0ZGVmYzRhYTU4MTlhMGFiZjAzNzk0MWEyYjBmODQzMjUyMmJhYWZkIgogICAgfQogIH0KfQ=="));
        return serverNPC;
    }

}
