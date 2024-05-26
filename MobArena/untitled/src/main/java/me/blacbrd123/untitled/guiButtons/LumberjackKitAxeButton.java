package me.blacbrd123.untitled.guiButtons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class LumberjackKitAxeButton {

    public ItemStack createAxeButton(){

        ItemStack axeButton = new ItemStack(Material.WOODEN_AXE);
        ItemMeta axeButtonMeta = axeButton.getItemMeta();


        assert axeButtonMeta != null;
        axeButtonMeta.setDisplayName(ChatColor.RED + "Lumberjack");

        ArrayList<String> axeButtonLore = new ArrayList<>();
        axeButtonLore.add("Equip the Archer class");
        axeButtonLore.add(ChatColor.DARK_PURPLE + "Player receives an axe");

        axeButtonMeta.setLore(axeButtonLore);

        axeButton.setItemMeta(axeButtonMeta);


        return axeButton;

    }


}
