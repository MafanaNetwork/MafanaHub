package me.TahaCheji.proxyData;

import me.TahaCheji.Main;
import me.TahaCheji.util.NBTUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ServerData {

    public final String name;
    public final Server server;
    public final ServerType serverType;
    public final Material icon;
    public final List<String> description;
    public final UUID uuid;
    public ServerNPC serverNPC;

    public ServerData(String name, Server server, ServerType serverType, Material icon, String... description) {
        this.name = name;
        this.server = server;
        this.serverType = serverType;
        this.icon = icon;
        this.description = Arrays.asList(description);
        UUID ewUUID = UUID.randomUUID();
        this.uuid = ewUUID;
    }

    public ServerData(String name, Server server, ServerType serverType, Material icon, List<String> description, UUID uuid, ServerNPC serverNPC) {
        this.name = name;
        this.server = server;
        this.serverType = serverType;
        this.icon = icon;
        this.description = description;
        this.uuid = uuid;
        this.serverNPC = serverNPC;
    }

    public ItemStack itemIcon() {
        ItemStack is = new ItemStack(icon);
        ItemMeta im = is.getItemMeta();
        im.addEnchant(Enchantment.DURABILITY, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.setDisplayName(ChatColor.BOLD + name);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_GRAY + serverType.string);
        lore.add("");
        for (String string : description) {
            lore.add(ChatColor.GRAY + string);
        }
        lore.add("");
        lore.add(ChatColor.GOLD + "Click to join!");
        lore.add(ChatColor.GOLD + "Players Online: " ); //TODO
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        im.addItemFlags(ItemFlag.HIDE_DESTROYS);
        im.setLore(lore);
        is.setItemMeta(im);
        is = NBTUtils.setString(is, "uuid", getUuid().toString());
        return is;
    }

    public ServerNPC getServerNPC() {
        return serverNPC;
    }

    public void setServerNPC(ServerNPC serverNPC) {
        this.serverNPC = serverNPC;
    }

    public void registerServer() {
        Main.getInstance().servers.add(this);
    }

    public void onClick(Player player) {
        player.sendMessage("worked " + server.getText());
    }

    public ServerType getServerType() {
        return serverType;
    }

    public String getName() {
        return name;
    }

    public Server getServer() {
        return server;
    }

    public Material getIcon() {
        return icon;
    }

    public List<String> getDescription() {
        return description;
    }

    public UUID getUuid() {
        return uuid;
    }
}
