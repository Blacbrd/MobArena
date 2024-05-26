package me.blacbrd123.untitled.waveKits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArcherKit extends Kit {

    @Override
    public ItemStack[] getItems() {
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();

        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, Boolean.TRUE);

        bow.setItemMeta(bowMeta);

        ItemStack arrow = new ItemStack(Material.ARROW);
        ItemStack food = new ItemStack(Material.BAKED_POTATO, 10);

        return new ItemStack[]{bow, arrow, food};
    }

    @Override
    public void apply(Player player) {

        ItemStack[] items = getItems();

        player.getInventory().clear();

        player.getInventory().addItem(items);

        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));

        player.sendTitle(ChatColor.GREEN + "Archer Kit", "Shoot that bow!", 10, 40, 10);


    }
}
