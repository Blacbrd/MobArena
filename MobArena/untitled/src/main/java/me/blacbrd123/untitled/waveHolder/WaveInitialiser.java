package me.blacbrd123.untitled.waveHolder;

import me.blacbrd123.untitled.MobArena;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class WaveInitialiser {

    private final MobArena plugin;

    public WaveInitialiser(MobArena plugin) {
        this.plugin = plugin;
    }
    public void startMobWaves(Player player) {

        FileConfiguration waves = plugin.getWaves();

        Location location = player.getLocation();

        int currentWave = plugin.getCurrentWave();

        UUID playerUUID = player.getUniqueId();



        new BukkitRunnable(){

            @Override
            public void run(){

                if(currentWave >= 6){
                    player.sendTitle(ChatColor.GREEN + "WAVES COMPLETED ", "", 10, 20 * 3, 10);
                    plugin.setCurrentWave(1);
                    plugin.getPlayerKitChosen().remove(playerUUID);
                    return;
                }

                player.sendTitle(ChatColor.GREEN + "WAVE " + currentWave, "", 10, 20 * 3, 10);
            }

        }.runTaskLater(plugin, 20 * 2);

        new BukkitRunnable(){

            @Override
            public void run(){
                // Accesses config file, spawns in the mob and the amount of that mob
                for(String enemy : waves.getStringList("mobs" + String.valueOf(currentWave))) {

                    String[] splitEnemy = enemy.split(":");

                    for (int i = 0; i < Integer.parseInt(splitEnemy[1]); i++) {

                        EntityType mob = EntityType.valueOf(splitEnemy[0]);

                        // Check if it is a zombie or skeleton so you can give it items

                        location.getWorld().spawn(location, mob.getEntityClass());
                        plugin.getMobsAlive().add(mob);
                    }
                }

                player.sendMessage("You have accessed the config file!");

            }
        }.runTaskLater(plugin, 20 * 5);

    }
}
