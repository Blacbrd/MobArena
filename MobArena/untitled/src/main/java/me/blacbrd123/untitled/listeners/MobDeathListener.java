package me.blacbrd123.untitled.listeners;

import me.blacbrd123.untitled.MobArena;
import me.blacbrd123.untitled.waveHolder.WaveInitialiser;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.UUID;

public class MobDeathListener implements Listener {

    private final MobArena plugin;

    private final WaveInitialiser waveInitialiser;

    public MobDeathListener(MobArena plugin, WaveInitialiser waveInitialiser) {
        this.plugin = plugin;
        this.waveInitialiser = waveInitialiser;
    }

    @EventHandler
    public void onMobDeath(EntityDeathEvent event){

        Player player = event.getEntity().getKiller();

        UUID playerUUID = player.getUniqueId();

        if (!(plugin.getPlayerKitChosen().containsKey(playerUUID))){
            return;
        }

        EntityType mob = event.getEntityType();

        if(plugin.getMobsAlive().contains(mob)){
            plugin.getMobsAlive().remove(mob);
        }
        else{
            return;
        }

        if(plugin.getMobsAlive().isEmpty()){

            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10, 10);
            player.sendTitle("Wave complete!","",10, 20 * 3, 10);

           int waveIncrementer = plugin.getCurrentWave();
           waveIncrementer++;
           plugin.setCurrentWave(waveIncrementer);

            waveInitialiser.startMobWaves(player);

        }

    }
}
