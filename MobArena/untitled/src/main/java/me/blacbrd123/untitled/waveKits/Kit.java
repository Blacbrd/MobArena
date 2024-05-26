package me.blacbrd123.untitled.waveKits;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

// Use kit manager to loop through kits!!
// Loop through kits (loop through the listener
// Abstract as much as possible

public abstract class Kit {

    public abstract ItemStack[] getItems();
    public abstract void apply(Player player);

    public void giveItems(Player player){

        ItemStack[] items = getItems();

        player.getInventory().addItem(items);

    }

}
