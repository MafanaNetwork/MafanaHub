package me.TahaCheji.events;

import me.TahaCheji.serverSelecterData.ServerSelectorGui;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener {
    ServerSelectorGui gui;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Action action = e.getAction();
        if ((action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)) {
            if(e.getItem() == null) {
                return;
            }
            if(e.getItem().getItemMeta() == null) {
                return;
            }
            if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Server Selector")) {
                gui = new ServerSelectorGui(e.getPlayer());
                gui.open();
            }
        }
    }
}
