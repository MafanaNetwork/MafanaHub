package me.TahaCheji.serverSelecterData;

import me.TahaCheji.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServerSelectorGui {

    Player player;
    int i;

    public ServerSelectorGui(@NotNull Player owner) {
        player = owner;
    }

    Inventory gui;
    Itemstacks items = new Itemstacks();
    List<Integer> openSlots = Arrays.asList(0, 11, 12, 13, 14, 15, 20, 21, 22, 23, 24, 29, 30, 31, 32, 33, 38, 39, 40, 41, 42, 47, 48, 49, 50, 51);

    public void open() {
        gui = Bukkit.createInventory(player, 54, ChatColor.GREEN.toString() + ChatColor.BOLD + "Server Selector");
        gui.setItem(0, items.close());
        for (int i = 10; i < 43; i++) {
            if (i >= Main.getInstance().servers.size() + 10) {
                break;
            }
            gui.setItem(i, Main.getInstance().servers.get(i - 10).itemIcon());
        }
        List<String> lore = new ArrayList<>();
        ItemStack greystainedglass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta newmeta = greystainedglass.getItemMeta();
        newmeta.setDisplayName(ChatColor.GRAY + " ");
        newmeta.setLore(lore);
        greystainedglass.setItemMeta(newmeta);
        gui.setItem(0, greystainedglass);
        gui.setItem(1, greystainedglass);
        gui.setItem(2, greystainedglass);
        gui.setItem(3, greystainedglass);
        gui.setItem(4, greystainedglass);
        gui.setItem(5, greystainedglass);
        gui.setItem(6, greystainedglass);
        gui.setItem(7, greystainedglass);
        gui.setItem(8, greystainedglass);
        gui.setItem(17, greystainedglass);
        gui.setItem(26, greystainedglass);
        gui.setItem(35, greystainedglass);
        gui.setItem(45, greystainedglass);
        gui.setItem(53, greystainedglass);
        gui.setItem(52, greystainedglass);
        gui.setItem(51, greystainedglass);
        gui.setItem(50, greystainedglass);
        gui.setItem(48, greystainedglass);
        gui.setItem(47, greystainedglass);
        gui.setItem(46, greystainedglass);
        gui.setItem(44, greystainedglass);
        gui.setItem(45, greystainedglass);
        gui.setItem(36, greystainedglass);
        gui.setItem(27, greystainedglass);
        gui.setItem(18, greystainedglass);
        gui.setItem(9, greystainedglass);
        gui.setItem(49, items.close());
        player.openInventory(gui);
    }

    public void close() {
        player.closeInventory();
    }
}
