package me.blacbrd123.untitled.guiButtons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class KnightKitSwordButton {

    public ItemStack createSwordButton(){

        ItemStack swordButton = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta swordButtonMeta = swordButton.getItemMeta();


        assert swordButtonMeta != null;
        swordButtonMeta.setDisplayName(ChatColor.BLUE + "Knight");

        ArrayList<String> swordButtonLore = new ArrayList<>();
        swordButtonLore.add("Equip the Knight class");
        swordButtonLore.add(ChatColor.DARK_PURPLE + "Player receives sword and shield");

        swordButtonMeta.setLore(swordButtonLore);

        swordButton.setItemMeta(swordButtonMeta);


        return swordButton;

    }

}
