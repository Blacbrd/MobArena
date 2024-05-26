package me.blacbrd123.untitled.listeners;

import me.blacbrd123.untitled.MobArena;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.UUID;

public class PlayerDeathDuringWavesListener implements Listener {


    private final MobArena plugin;

    public PlayerDeathDuringWavesListener(MobArena plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeathDuringWaves(PlayerDeathEvent event){

        Player player = event.getEntity();

        UUID playerUUID = player.getUniqueId();


        if (plugin.getPlayerKitChosen().containsKey(playerUUID)){

            plugin.getPlayerKitChosen().remove(playerUUID);
            plugin.setCurrentWave(1);
        }


    }

}
