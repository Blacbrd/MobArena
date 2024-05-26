package me.blacbrd123.untitled.listeners;

import me.blacbrd123.untitled.MobArena;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitySpawnListener implements Listener {

    MobArena plugin;

    public EntitySpawnListener(MobArena plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onBossWaveSpawn(EntitySpawnEvent event){
        event.getEntity();


    }


}
