package me.TahaCheji.proxyData;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.MemoryNPCDataStore;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.citizensnpcs.npc.skin.Skin;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class ServerNPC {

    public String name;
    public String id;
    public Location spawnLocation;
    public ServerData server;
    public NPC npc;
    public NPCSkin skin;
    public final NPCRegistry registry = CitizensAPI.createAnonymousNPCRegistry(new MemoryNPCDataStore());

    public ServerNPC(String name, String id, Location spawnLocation, ServerData server) {
        this.name = name;
        this.id = id;
        this.spawnLocation = spawnLocation;
        this.server = server;
    }

    public NPC getNPC() {
        NPC npc = registry.createNPC(EntityType.PLAYER, id);
        npc.setName(ChatColor.GOLD + "[" + name + ChatColor.GOLD + "] - Right Click To Join!");
        npc.setProtected(true);
        npc.getOrAddTrait(SkinTrait.class).setSkinPersistent(skin.getUniqueId(), skin.getSignature(), skin.getTexture());
        this.npc = npc;
        return npc;
    }

    public void spawnNPC() {
        getNPC().spawn(spawnLocation);
    }

    public void despawnNPC() {
        getNPC().despawn();
    }

    public void onClick(Player player) {
        player.sendMessage("test");
    }

    public NPCSkin getSkin() {
        return skin;
    }

    public void setSkin(NPCSkin skin) {
        this.skin = skin;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Location getSpawnLocation() {
        return spawnLocation;
    }

    public ServerData getServer() {
        return server;
    }

    public NPC getNpc() {
        return npc;
    }
}
