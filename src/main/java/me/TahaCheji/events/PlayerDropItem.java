package me.TahaCheji.events;

import me.TahaCheji.serverSelecterData.ServerSelectorInventoryClick;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItem implements Listener {

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {
        if (new ServerSelectorInventoryClick().isEqual(e.getItemDrop().getItemStack().getItemMeta().getDisplayName(),
                ChatColor.GREEN.toString() + ChatColor.BOLD + "Server Selector")) {
            e.setCancelled(true);
        }
    }
}
