package me.TahaCheji.serverSelecterData;

import de.tr7zw.nbtapi.NBTItem;
import me.TahaCheji.Main;
import me.TahaCheji.proxyData.ServerData;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ServerSelectorInventoryClick implements Listener {

    public boolean isEqual(String unknownText, String coloredText) {
        return unknownText.equals(ChatColor.translateAlternateColorCodes('&', coloredText));
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (isEqual(e.getView().getTitle(), ChatColor.GREEN.toString() + ChatColor.BOLD + "Server Selector") && e.getCurrentItem() != null) {
            if(e.getSlot() == 49) {
                e.getWhoClicked().closeInventory();
                return;
            }
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta() == null) {
                return;
            }
            if (!new NBTItem(e.getCurrentItem()).hasKey("uuid")) {
                return;
            }
            for (ServerData listing : Main.getInstance().servers) {
                if (new NBTItem(e.getCurrentItem()).getString("uuid").contains(listing.getUuid().toString())) {
                    Player player = (Player) e.getWhoClicked();
                    listing.onClick(player);
                }
            }

        }
    }
    }
