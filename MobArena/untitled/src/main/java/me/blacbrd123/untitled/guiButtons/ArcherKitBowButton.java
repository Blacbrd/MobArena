package me.blacbrd123.untitled.guiButtons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ArcherKitBowButton {

    public ItemStack createBowButton(){

        ItemStack bowButton = new ItemStack(Material.BOW);
        ItemMeta bowButtonMeta = bowButton.getItemMeta();


        assert bowButtonMeta != null;
        bowButtonMeta.setDisplayName(ChatColor.GREEN + "Archer");

        ArrayList<String> bowButtonLore = new ArrayList<>();
        bowButtonLore.add("Equip the Archer class");
        bowButtonLore.add(ChatColor.DARK_PURPLE + "Player receives a bow and arrow");

        bowButtonMeta.setLore(bowButtonLore);

        bowButton.setItemMeta(bowButtonMeta);


        return bowButton;

    }


}
