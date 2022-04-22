package me.TahaCheji.events;

import me.TahaCheji.Main;
import me.TahaCheji.proxyData.ServerData;
import net.citizensnpcs.api.event.NPCClickEvent;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NPCRightClick implements Listener {


    @EventHandler
    public void NPCRightClickEvent(NPCRightClickEvent e) {
        for (ServerData serverData : Main.getInstance().servers) {
            System.out.println(1);
            if(e.getNPC() == null) {
                continue;
            }
            System.out.println(2);
            if(!(e.getNPC().getId() == serverData.getServerNPC().getNpc().getId())) {
                continue;
            }
            System.out.println(3);
            serverData.getServerNPC().onClick(e.getClicker());
        }
    }
}
