package me.blacbrd123.untitled.waveKits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LumberjackKit extends Kit {

    @Override
    public ItemStack[] getItems() {

        ItemStack axe = new ItemStack(Material.WOODEN_AXE);
        ItemStack food = new ItemStack(Material.COOKED_PORKCHOP, 15);
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);

        return new ItemStack[]{axe, food, helmet};

    }

    @Override
    public void apply(Player player) {

        ItemStack[] items = getItems();

        player.getInventory().clear();

        player.getInventory().addItem(items);

        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));

        player.sendTitle(ChatColor.GREEN + "Lumberjack Kit", "Chop that axe!", 10, 40, 10);
    }
}
