package me.blacbrd123.untitled.listeners;

import me.blacbrd123.untitled.MobArena;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.UUID;

public class OnKitInventoryCloseListener implements Listener {

    private final MobArena plugin;

    public OnKitInventoryCloseListener(MobArena plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onKitInventoryClose(InventoryCloseEvent event){

        Player player = (Player) event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        if(plugin.getPlayerHasKitInventoryOpen().containsKey(playerUUID)){

            plugin.getPlayerHasKitInventoryOpen().remove(playerUUID);

        }


    }
}
