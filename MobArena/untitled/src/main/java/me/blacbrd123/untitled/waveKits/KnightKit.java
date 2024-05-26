package me.blacbrd123.untitled.waveKits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class KnightKit extends Kit {

    @Override
    public ItemStack[] getItems() {

        ItemStack sword = new ItemStack(Material.WOODEN_SWORD);
        ItemStack leatherArmorChest = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack shield = new ItemStack(Material.SHIELD);
        ItemStack food = new ItemStack(Material.COOKED_BEEF, 10);

        return new ItemStack[]{sword, leatherArmorChest, shield, food};
    }

    @Override
    public void apply(Player player) {

        ItemStack[] items = getItems();

        player.getInventory().clear();

        player.getInventory().addItem(items);

        player.sendTitle(ChatColor.GREEN + "Knight Kit", "Swing that sword!", 10, 40, 10);

    }
}
