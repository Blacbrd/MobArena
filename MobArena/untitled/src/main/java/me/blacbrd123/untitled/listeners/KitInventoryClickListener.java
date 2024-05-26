package me.blacbrd123.untitled.listeners;

import me.blacbrd123.untitled.MobArena;
import me.blacbrd123.untitled.waveHolder.WaveInitialiser;
import me.blacbrd123.untitled.waveKits.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.UUID;

// You have to find a way to loop through kits
// Find a way to loop through classes without knowing what class it's going to be

public class KitInventoryClickListener implements Listener {

    private final MobArena plugin;

    private final WaveInitialiser waveInitialiser;

    private final KitManager kitManager;

    public KitInventoryClickListener(MobArena plugin, WaveInitialiser waveInitialiser, KitManager kitManager){
        this.plugin = plugin;
        this.waveInitialiser = waveInitialiser;
        this.kitManager = kitManager;
    }

    @EventHandler
    public void onKitInventoryClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        UUID playerUUID = player.getUniqueId();


        if(!(plugin.getPlayerHasKitInventoryOpen().containsKey(playerUUID))){
            return;
        }

        // Prevents player from picking up the item
        event.setCancelled(true);

        if(event.getCurrentItem().getType().equals(Material.BARRIER)){

            player.closeInventory();

            plugin.getPlayerHasKitInventoryOpen().remove(playerUUID);
            return;

        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Knight")) {

            KnightKit knightKit = kitManager.getKnightKit();

            knightKit.apply(player);

            plugin.getPlayerKitChosen().put(playerUUID, "Knight");
        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Archer")){

            ArcherKit archerKit = kitManager.getArcherKit();

            archerKit.apply(player);

            plugin.getPlayerKitChosen().put(playerUUID, "Archer");

        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Lumberjack")){

            LumberjackKit lumberjackKit = kitManager.getLumberjackKit();

            lumberjackKit.apply(player);

            plugin.getPlayerKitChosen().put(playerUUID, "Lumberjack");
        }

        waveInitialiser.startMobWaves(player);

        plugin.getPlayerHasKitInventoryOpen().remove(playerUUID);
        player.closeInventory();
    }

}
