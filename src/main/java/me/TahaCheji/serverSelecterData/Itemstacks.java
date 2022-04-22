package me.TahaCheji.serverSelecterData;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;
import java.util.Arrays;

public class Itemstacks {
    ItemStack is;
    ItemMeta im;

    private ItemStack createStack(Material itemType, boolean isShiny, @Nullable String name, @Nullable String lore) {
        is = new ItemStack(itemType);
        im = is.getItemMeta();
        if (isShiny) {
            im.addEnchant(Enchantment.DURABILITY, 1, true);
            im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        if (name != null) {
            im.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + name);
        } else {
            im.setDisplayName("");
        }
        if (lore != null) {
            im.setLore(Arrays.asList(ChatColor.RED + lore));
        } else {
            im.getLore().clear();
        }
        is.setItemMeta(im);
        return is;
    }

    public ItemStack skyWizards() {
        return createStack(Material.ARROW, true, "Sky Wizards", "Battle to be the sky god!");
    }

    public ItemStack bridgeWizards() {
        return createStack(Material.RED_WOOL, true, "Bridge Wizards", "Fight along a narrow bridge!");
    }

    public ItemStack mmorpg() {
        return createStack(Material.PLAYER_HEAD, true, "MMORPG", "Role play!");
    }

    public ItemStack tagRun() {
        return createStack(Material.DIAMOND_BOOTS, true, "Tagger vs. Runner", "Tag! You're it!");
    }

    public ItemStack serverSelector() {
        return createStack(Material.STICK, true, "Server Selector", "Select your minigame!");
    }
    public ItemStack frame() {
        return createStack(Material.GRAY_STAINED_GLASS_PANE, false, null, null);
    }

    public ItemStack close() {
        return createStack(Material.BARRIER, false, "Close", "Close the GUI");
    }
}
