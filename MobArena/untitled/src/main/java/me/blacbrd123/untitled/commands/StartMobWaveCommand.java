package me.blacbrd123.untitled.commands;

import me.blacbrd123.untitled.MobArena;
import me.blacbrd123.untitled.guiButtons.ArcherKitBowButton;
import me.blacbrd123.untitled.guiButtons.KnightKitSwordButton;
import me.blacbrd123.untitled.guiButtons.LumberjackKitAxeButton;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class StartMobWaveCommand implements CommandExecutor {

    private final MobArena plugin;

    public StartMobWaveCommand(MobArena plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        // Checks if sender is player
        if (!(commandSender instanceof Player player)) {
            return true;
        }

        // Checks if command getting passed in is "startWave"
        if (!(command.getName().equalsIgnoreCase("startWave"))){
            return true;
        }

        KnightKitSwordButton knightKitSwordButton = new KnightKitSwordButton();
        ArcherKitBowButton archerKitBowButton = new ArcherKitBowButton();
        LumberjackKitAxeButton lumberjackKitAxeButton = new LumberjackKitAxeButton();

        // Creates the inventory that is displayed to the user
        Inventory kitChooserInventory = Bukkit.createInventory(player, 9, ChatColor.RED + "Choose your kit");

        // Buttons that appear in the menu
        ItemStack swordButton = knightKitSwordButton.createSwordButton();
        ItemStack bowButton = archerKitBowButton.createBowButton();
        ItemStack axeButton = lumberjackKitAxeButton.createAxeButton();
        ItemStack exit = new ItemStack(Material.BARRIER);

        // Places buttons into the menu
        kitChooserInventory.setItem(1, swordButton);
        kitChooserInventory.setItem(3, bowButton);
        kitChooserInventory.setItem(5, axeButton);
        kitChooserInventory.setItem(7, exit);

        // Player's UUID
        UUID playerUUID = player.getUniqueId();

        plugin.getPlayerHasKitInventoryOpen().put(playerUUID, Boolean.TRUE);

        player.openInventory(kitChooserInventory);

        return true;
    }
}
